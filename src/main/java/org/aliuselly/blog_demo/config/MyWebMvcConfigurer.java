package org.aliuselly.blog_demo.config;

import org.aliuselly.blog_demo.interceptor.ForeInterceptor;
import org.aliuselly.blog_demo.interceptor.BackstageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    /**
     * 这个方法是设置响应体的返回类型的，原作者并没有做什么有意义的设置，因此，这里就不设置了
     * @param configurer
     */
//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//
//    }

    /**
     * 和上面那个方法是一起的，确实，是我考虑不周了
     * 像这些配置的类，应该先放在 ioc 中维护更好
     * @return
     */
    @Bean
    public HttpMessageConverter<String> responseBodyConverter()
    {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }

    /**
     * 将编码改为 UTF-8 httpMessage
     * 听作者说，配置文件那边的设置是设置 Get 请求的
     * 这里呢，是设置 post 请求的
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(responseBodyConverter());
    }

    /**
     * 以前要访问一个页面需要先创建个Controller控制类，在写方法跳转到页面
     * 在这里配置后就不需要那么麻烦了，直接访问http://10.2.3.235:80/toLogin就跳转到login.html页面了
     *
     * 不过，这里要先做好映射路径
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/toLogin")
                .setViewName("login");
//        由于这里使用了 thy 了因此呢，默认视图的名字啥的变了，但是呢，重定向是可以直接访问静态资源的
        registry.addViewController("/index")
                .setViewName("redirect:/index.html");
    }

    @Bean
    public HandlerInterceptor getForeInterceptor()
    {
        return new ForeInterceptor();
    }

    @Bean
    public HandlerInterceptor getBackstageInterceptor()
    {
        return new BackstageInterceptor();
    }

    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        为了测试，先关闭
        registry.addInterceptor(getBackstageInterceptor())
                .addPathPatterns("/swagger-ui/**")
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/toLogin", "/admin/login");

        registry.addInterceptor(getForeInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/toLogin", "/admin/**", "/js/**", "/css/**", "/img/**");
    }

//    这个就是替换 Filter 那边的，而且呢，貌似那边的 Filter 并没有进行引用
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping()
//                .
//    }
}
