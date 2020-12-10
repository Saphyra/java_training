package com.github.saphyra.controller;

import com.github.saphyra.request.UsernameRequest;
import com.github.saphyra.response.UsernameResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class InputController {
    private String username;

    @PostMapping("/api/input")
    public void upload(@RequestBody UsernameRequest request) {
        log.info("upload request: {}", request);
        username = request.getUsername();
    }

    @GetMapping("/api/input")
    public UsernameResponse download(){
        log.info("download...");
        return new UsernameResponse(username);
    }
}
