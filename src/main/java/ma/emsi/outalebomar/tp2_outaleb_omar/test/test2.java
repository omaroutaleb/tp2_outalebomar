package ma.emsi.outalebomar.tp2_outaleb_omar.test;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.input.PromptTemplate;

import java.time.Duration;
import java.util.Map;

public class test2 {
    public static void main(String[] args) {
        String apiKey = System.getenv("GEMINIKEY");

        ChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-2.0-flash")
                .temperature(0.2)
                .timeout(Duration.ofSeconds(30))
                .build();


        PromptTemplate template = PromptTemplate.from(
                "Traduis le texte suivant en (one time)  {{langue}} : {{texte}}"
        );

        // Application des valeurs au template
        Prompt prompt = template.apply(Map.of(
                "texte", "Bonjour tout le monde, comment allez-vous ?",
                "langue", "anglais"
        ));

        // Génération de la réponse avec le prompt
        String traduction = model.chat(prompt.text());

        System.out.println("Traduction : " + traduction);


//        PromptTemplate template = PromptTemplate.from("Traduis le texte suivant en anglais : {texte}");
//        Prompt prompt = template.apply(Map.of("texte", "Bonjour tout le monde, comment allez-vous ?"
//        ));
//        String traduction = model.chat(prompt.text());
//
//        System.out.println("Traduction : " + traduction);
    }
}