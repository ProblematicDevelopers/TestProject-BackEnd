package com.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                    "http://localhost:5173",      // Vite 개발 서버
                    "http://localhost:3000",      // 기타 로컬
                    "http://52.79.176.109",       // EC2 Frontend
                    "http://52.79.176.109:80",    // EC2 Frontend (명시적)
                    "http://52.79.176.109:3000"   // EC2 Frontend (포트 3000)
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
