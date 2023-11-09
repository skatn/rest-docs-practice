package com.example.restdocspractice.api;

import com.example.restdocspractice.common.DocsEnumType;

public enum HelloEnum implements DocsEnumType {
    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E");

    private final String description;

    HelloEnum(String description) {
        this.description = description;
    }

    @Override
    public String getType() {
        return this.name();
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
