package com.xfdmao.fcat.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public class GeneratorUtil {
	
	private final static String MODEL_DIRECTORY_NAME = "entity";
	
	private final static String MAPPER_DIRECTORY_NAME = "mapper";
	
	private final static String BIZ_DIRECTORY_NAME = "service";
	
	private final static String REST_DIRECTORY_NAME = "controller";
	
	
	/**
	 * 生成Biz文件
	 * @param modelPath 实体类目录
	 * @param includeList	如果要指定生成文件，则在后面加入参数
	 */
	public static void generatorBiz(String modelPath,String ...includeList){
		System.out.println("start generate service file:");
		System.out.println("========================================================");
		String bizPath = modelPath.replace(MODEL_DIRECTORY_NAME, BIZ_DIRECTORY_NAME);
		List<String> fileNameList = srcFile(modelPath);
		for (String fileName : fileNameList) {
			boolean generateFlag = false;
			if(includeList != null && includeList.length != 0){
				for (String includeFileName : includeList) {
					if(fileName.equals(includeFileName)){
						generateFlag = true;
					}
				}
			}else{
				generateFlag = true;
			}
			if(!generateFlag) continue;
			File bizFile = createFile(bizPath, fileName,"Biz");
			if(bizFile != null){
				String generatorContent = generatorBizContent(bizPath, modelPath, fileName);
				writeContentToFile(bizFile, generatorContent);
				System.out.println(fileName + "Biz success");
				continue;
			}
		}
		System.out.println();
	}
	
	/**
	 * 生成Biz文件
	 * @param modelPath 实体类目录
	 * @param includeList	如果要指定生成文件，则在后面加入参数
	 */
	public static void generatorRest(String modelPath,String ...includeList){
		System.out.println("start generate controller file:");
		System.out.println("========================================================");
		String restPath = modelPath.replace(MODEL_DIRECTORY_NAME + "/", REST_DIRECTORY_NAME + "/");
		List<String> fileNameList = srcFile(modelPath);
		for (String fileName : fileNameList) {
			boolean generateFlag = false;
			//查看是否指定创建文件
			if(includeList != null && includeList.length != 0){
				for (String includeFileName : includeList) {
					if(fileName.equals(includeFileName)){
						generateFlag = true;
					}
				}
			}else{
				generateFlag = true;
			}
			if(!generateFlag) continue;
			File bizFile = createFile(restPath, fileName,"Controller");
			if(bizFile != null){
				String generatorContent = generatorRestContent(restPath, modelPath, fileName);
				writeContentToFile(bizFile, generatorContent);
				System.out.println(fileName + "Controller success");
				continue;
			}
		}
	}
	
	/**
	 * 读取model文件名称
	 * 
	 * @param modelPath
	 * @return
	 */
	public static List<String> srcFile(String modelPath) {
		File modelDir = new File(modelPath);
		if (!modelDir.exists())
			return null;
		File[] listFiles = modelDir.listFiles();
		List<String> fileNameList = new ArrayList<String>();
		for (File modelFile : listFiles) {
			fileNameList.add(modelFile.getName().replace(".java", ""));
		}
		return fileNameList;
	}
	

	public static File createFile(String path, String name,String suffix){
		File dirctory = new File(path);
		if (!dirctory.exists()) {
			if (!dirctory.mkdirs()) {
				System.out.println("directory is not exist and create fail!");
				return null;
			}
		}
		if (!dirctory.isDirectory()) {
			System.err.println("path is not a directory");
			return null;
		}
		String fileName = name + suffix;
		File file = new File(path + fileName + ".java");
		try {
			if (file.exists()) {
				System.out.println(fileName + suffix + " exist  pass generate.....");
				return null;
			} else {
				file.createNewFile();
			}
		} catch (Exception e) {
			System.err.println("file create fail:" + file.getAbsolutePath());
		}
		return file;
		
	}
	
	public static void writeContentToFile(File file,String content){
		OutputStream out = null;
		try {
			out = new FileOutputStream(file);
			out.write(content.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static String generatorBizContent(String bizPath,String modelPath,String fileName){
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("package %s;\n\n", getProjectPackage(bizPath)));
		builder.append("import com.xfdmao.fcat.common.service.BaseBiz;\n");
		builder.append("import org.springframework.stereotype.Service;\n");
		String entityPackage = getProjectPackage(modelPath);
		String mapperPath = entityPackage.replace(MODEL_DIRECTORY_NAME, MAPPER_DIRECTORY_NAME);
		builder.append(String.format("import %s.%sMapper;\n",mapperPath,fileName));
		builder.append(String.format("import %s.%s;\n\n",entityPackage,fileName));
		builder.append("@Service\n");
		builder.append(String.format("public class %sBiz extends BaseBiz<%sMapper,%s> {\n\n}",fileName,fileName,fileName));
		return builder.toString();
	}
	
	private static String generatorRestContent(String restPath,String modelPath,String fileName){
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("package %s;\n\n", getProjectPackage(restPath)));
		//builder.append("import org.springframework.stereotype.Service;\n");
		builder.append("import org.springframework.web.bind.annotation.RequestMapping;\n");
		builder.append("import org.springframework.web.bind.annotation.RestController;\n\n");
		builder.append("import com.xfdmao.fcat.common.controller.BaseController;\n");
		String entityPackage = getProjectPackage(modelPath);
		String bizPackage = entityPackage.replace(MODEL_DIRECTORY_NAME,BIZ_DIRECTORY_NAME);
		builder.append(String.format("import %s.%sBiz;\n",bizPackage,fileName));
		builder.append(String.format("import %s.%s;\n\n",entityPackage,fileName));
		builder.append("@RestController\n");
		String fcatstCharToLowerCase = fcatstCharToLowerCase(fileName);
		builder.append(String.format("@RequestMapping(\"%s\")\n", fcatstCharToLowerCase));
		builder.append(String.format("public class %sController extends BaseController<%sBiz,%s> {\n\n}",fileName,fileName,fileName));
		return builder.toString();
	}
	
	private static String fcatstCharToLowerCase(String str){
		if(StringUtils.isEmpty(str)){
			return str;
		}else{
			String firstChar = str.substring(0,1);
			String lowerCase = firstChar.toLowerCase();
			return lowerCase + str.substring(1,str.length());
		}
	}
	/**
	 * 
	 * @param bizPath D:/sts_workspace/xfdmao-fcat/fcat-check/src/main/java/com/xfdmao/fcat/check/entity/
	 * @return com.xfdmao.fcat.check.entity
	 */
	private static String getProjectPackage(String bizPath){
		Integer start = bizPath.indexOf("/src/main/java/");
		if(start < 0) return null;
		String packageStr = bizPath.substring(start + 15,bizPath.length()).replace("/", ".");
		if(packageStr.endsWith(".") ){
			packageStr = packageStr.substring(0, packageStr.length()-1);
		}
		return packageStr;
	}
	

	public static void main(String[] args) throws IOException {
		String modelPath = "D:/sts_workspace/xfdmao-fcat/fcat-check/src/main/java/com/xfdmao/fcat/check/entity/";
		generatorBiz(modelPath,"DefectDesc");
		generatorRest(modelPath,"DefectDesc");
	}
}
