package com.example.app.config;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/12/3
 * Time: 22:30
 * To change this template use File | Settings | File Templates.
 **/
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class UploadFilePathConfig extends WebMvcConfigurerAdapter{

    @Value("${file.staticAccessPath}")
    private String staticAccessPath;
    @Value("${file.uploadFolder}")
    private String uploadFolder;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(staticAccessPath).addResourceLocations("file:///" + uploadFolder);
        super.addResourceHandlers(registry);
    }

}
