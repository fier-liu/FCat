package com.xfdmao.fcat.user.config;

import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration extends WebMvcConfigurerAdapter implements EnvironmentAware {
	private String basePackage;
	private String creatName;
	private String serviceName;
	private RelaxedPropertyResolver propertyResolver;
	private String description;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars*")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}


	
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage(this.basePackage))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(this.serviceName+" Restful APIs")
				.description(this.description)
				.contact(this.creatName).version("1.0").build();
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.propertyResolver = new RelaxedPropertyResolver(environment, null);
		this.basePackage = propertyResolver.getProperty("swagger.basepackage");
		this.creatName = propertyResolver.getProperty("swagger.service.developer");
		this.serviceName = propertyResolver.getProperty("swagger.service.name");
		this.description = propertyResolver.getProperty("swagger.service.description");
	}
}
