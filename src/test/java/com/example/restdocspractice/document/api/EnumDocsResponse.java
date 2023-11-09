package com.example.restdocspractice.document.api;

import java.util.Map;

public class EnumDocsResponse {
    Map<String, String> hello;

    public EnumDocsResponse() {
    }

    public EnumDocsResponse(Map<String, String> hello) {
        this.hello = hello;
    }

    public Map<String, String> getHello() {
        return hello;
    }
}
