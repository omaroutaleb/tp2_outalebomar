package ma.emsi.outalebomar.tp2_outaleb_omar.test;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import java.time.Duration;

public class test1 {
    public static void main(String[] args) {
        String apiKey = System.getenv("GEMINIKEY");


        ChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-2.0-flash")
                .temperature(0.8)
                .timeout(Duration.ofSeconds(60))
                .build();

        String response = model.chat("Explique-moi simplement ce qu'est LangChain4j.");
        System.out.println("Réponse : " + response);
    }
}
