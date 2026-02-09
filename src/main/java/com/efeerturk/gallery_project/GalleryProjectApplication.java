package com.efeerturk.gallery_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.efeerturk.gallery_project"})
@EntityScan(basePackages = {"com.efeerturk.gallery_project"})
@EnableJpaRepositories(basePackages = {"com.efeerturk.gallery_project"})
@SpringBootApplication
public class GalleryProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(GalleryProjectApplication.class, args);
    }

}
