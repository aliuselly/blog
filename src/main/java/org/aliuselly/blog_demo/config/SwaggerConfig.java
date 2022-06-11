package org.aliuselly.blog_demo.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

//    不能加 @Bean 注解，干，会空指针异常的
//    http://localhost:8080/swagger-ui/index.html
    public Docket createRestApi()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.aliuselly.blog_demo"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo()
    {
        return new ApiInfoBuilder()
                .title("aliuselly 个人博客 RESTful APIs")
                .description("个人博客 API 说明")
//                这个是服务条款的 url
                .termsOfServiceUrl("http://localhost")
                .contact(new Contact("aliuselly", "http://localhost", "aliuselly@gmail.com"))
                .version("1.0")
                .build();
    }
}
