package com.ssafy.edu.vue;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.edu.vue.interceptor.JwtInterceptor;
@SpringBootApplication
@EnableTransactionManagement
public class SSAFYApplication implements WebMvcConfigurer {
    // 이것을 실행시키면 레스트풀 메인 시작
	public static void main(String[] args) {
		SpringApplication.run(SSAFYApplication.class, args);
	}
	
	@Autowired
    private JwtInterceptor jwtInterceptor;

//    JWTInterceptor를 설치한다.
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/user/**") // 기본 적용 경로
                .excludePathPatterns(Arrays.asList("/user/confirm/**", "/board/list"));// 적용 제외 경로
    }

//    Interceptor를 이용해서 처리하므로 전역의 Cross Origin 처리를 해준다.
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .exposedHeaders("auth-token");
    }
}
//http://localhost:8297/happyhouse/swagger-ui.html