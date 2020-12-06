package com.github.saphyra.config;

import com.github.saphyra.Application;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.github.saphyra")
@EntityScan(basePackageClasses = Application.class)
public class DatabaseConfiguration {

}
