package com.back_end_android.back_end;


import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableMongock
@EnableSwagger2
public class SpringBootAndroid {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAndroid.class, args);
    }
}
