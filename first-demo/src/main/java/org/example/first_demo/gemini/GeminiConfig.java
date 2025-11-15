package org.example.first_demo.gemini;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeminiConfig {

    @Value("${spring.ai.gemini.base-url}")
    private String baseUrl;

    @Value("${spring.ai.gemini.completions-path}")
    private String completionsPath;

    @Value("${spring.ai.openai.api-key}")
    private String apiKey;

    @Value("${spring.ai.chat.options.model}")
    private String model;

    @Bean
    public OpenAiChatModel geminiChatModel() {
        OpenAiApi geminiApi = OpenAiApi.builder()
                .baseUrl(baseUrl)
                .completionsPath(completionsPath)
                .apiKey(apiKey)
                .build();

        return OpenAiChatModel.builder()
                .openAiApi(geminiApi)
                .defaultOptions(OpenAiChatOptions.builder().model(model).build())
                .build();
    }
}
