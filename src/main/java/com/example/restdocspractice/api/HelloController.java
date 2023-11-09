package com.example.restdocspractice.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public Hello hello() {
        return new Hello("hello", HelloEnum.A);
    }

    public static class Hello {
        public String message;
        public HelloEnum helloEnum;

        public Hello(String message, HelloEnum helloEnum) {
            this.message = message;
            this.helloEnum = helloEnum;
        }

        public String getMessage() {
            return message;
        }

        public HelloEnum getHelloEnum() {
            return helloEnum;
        }
    }

}
