package org.example.first_demo.gemini;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class GeminiChat implements ApplicationRunner {
    @Autowired
    private OpenAiChatModel geminiChatModel;

    @Override
    public void run(ApplicationArguments args)  {
        System.out.println("プログラムを実行中...");

        // チャットクライアントを作成
        ChatClient geminiClient = ChatClient.builder(geminiChatModel).build();

        final String message = "まずは自己紹介をしてください。次に、あなたとChat-GPTの違いを3行で簡潔に教えてください。";
        System.out.println("> " + message);
        // APIを呼び出し
        String result = geminiClient
                .prompt()
                .user(message)
                .call()
                .content();

        System.out.println(result);
        System.out.println("プログラムを終了します...");
    }
}
