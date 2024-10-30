
package com.sujal.livepaste.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173","https://livepaste.sujalbhavsar.in","https://live-paste-frontend.vercel.app","https://livepaste.netlify.app","https://livepaste.vercel.app")
                .allowedMethods("GET", "POST", "PUT")
                .allowCredentials(true);
    }
}
