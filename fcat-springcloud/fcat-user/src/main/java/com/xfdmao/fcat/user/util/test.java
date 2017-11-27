package com.xfdmao.fcat.user.util;

import java.io.IOException;

import com.xfdmao.fcat.common.util.GeneratorUtil;

public class test {
	public static void main(String[] args) throws IOException {
		String modelPath = "E:/workspaces/xfdmao-fcat/fcat-grid/src/main/java/com/xfdmao/fcat/grid/entity/";
		GeneratorUtil.generatorBiz(modelPath);
		GeneratorUtil.generatorRest(modelPath);
	}
}
