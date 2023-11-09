package com.example.restdocspractice.document.api;

import com.example.restdocspractice.api.HelloEnum;
import com.example.restdocspractice.common.DocsEnumType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class EnumViewController {

    @GetMapping("/enums")
    public ResponseEntity<?> enums() {
        return ResponseEntity.ok(
                new EnumDocsResponse(getDocs(HelloEnum.values()))
        );
    }


    private Map<String, String> getDocs(DocsEnumType[] enumTypes) {
        return Arrays.stream(enumTypes)
                .collect(Collectors.toMap(DocsEnumType::getType, DocsEnumType::getDescription));
    }
}
