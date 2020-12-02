package com.github.saphyra;

import com.github.saphyra.menu.MainMenu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {
    @Autowired
    private MainMenu mainMenu;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Application started");
        mainMenu.enterMenu();
        log.info("Exiting...");
    }
}
