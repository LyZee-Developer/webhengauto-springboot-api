package api.hgseviceweb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class StaticResourceConfig implements WebMvcConfigurer{
    @Value("${file.upload-img-dir}")
    private String imageServerLocation;
    @Value("${file.upload-img-client}")
    private String imageClientLocation;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // registry
        //     .addResourceHandler("/upload/**")
        //     .addResourceLocations("file:upload/");
        registry.addResourceHandler(imageClientLocation)
        .addResourceLocations("file:"+imageServerLocation);
            
    }
}
