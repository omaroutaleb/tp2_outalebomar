package ma.emsi.outalebomar.tp2_outaleb_omar.test;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;

public class test6 {
    // Interface pour l'assistant qui peut utiliser l'outil météo
    interface AssistantMeteo {
        String chat(String message);
    }

    public static void main(String[] args) {
        String apiKey = System.getenv("GEMINIKEY");


        // Création du modèle de chat
        ChatModel modele = GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .temperature(0.2)
                .modelName("gemini-2.0-flash")
                .logRequestsAndResponses(true)  // Active le logging pour voir l'utilisation de l'outil
                .build();

        // Création de l'assistant avec l'outil météo
        AssistantMeteo assistant = AiServices.builder(AssistantMeteo.class)
                .chatModel(modele)
                .tools(new MeteoTool())  // Ajout de l'outil
                .build();

        // Questions à tester
        String question1 = "J'ai prévu d'aller aujourd'hui à Rabat. Est-ce que tu me conseilles de prendre un parapluie ?";
        String reponse1 = assistant.chat(question1);
        System.out.println("\nQuestion : " + question1);
        System.out.println("Réponse : " + reponse1);

        // Autre question
        String question2 = "Quel temps fait-il à Paris ?";
        String reponse2 = assistant.chat(question2);
        System.out.println("\nQuestion : " + question2);
        System.out.println("Réponse : " + reponse2);

        // Question sans rapport avec la météo
        String question3 = "Quelle est la capitale de la France ?";
        String reponse3 = assistant.chat(question3);
        System.out.println("\nQuestion : " + question3);
        System.out.println("Réponse : " + reponse3);
    }
}