package com.example.restdocspractice.api;

import com.example.restdocspractice.document.utils.DocumentLinkGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.example.restdocspractice.document.utils.DocumentLinkGenerator.DocUrl.HELLO;
import static com.example.restdocspractice.document.utils.DocumentLinkGenerator.generateLinkCode;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(HelloController.class)
@ExtendWith(RestDocumentationExtension.class)
class HelloControllerTest {

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void beforeEach(WebApplicationContext context, RestDocumentationContextProvider restDocumentationContextProvider) {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(documentationConfiguration(restDocumentationContextProvider)
                        .operationPreprocessors()
                        .withRequestDefaults(prettyPrint())
                        .withResponseDefaults(prettyPrint()))
                .alwaysDo(print())
                .build();
    }

    @Test
    void hello() throws Exception {
        mockMvc.perform(get("/api/hello"))
                .andDo(document("hello",
                        responseFields(
                                fieldWithPath("message").description("메세지"),
                                fieldWithPath("helloEnum").description(generateLinkCode(HELLO))
                        )
                ));
    }

}