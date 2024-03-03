package ssodamproject.server.GPT.dto;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GPTCompletionChatRequest {

    private String model;

    private String role1;

    private String message1;

    private String role2;

    private String message2;

    private Integer max_tokens;

    private Double top_n;

    private Double temperature;
    private Double frequency_penalty;


    public static ChatCompletionRequest of(GPTCompletionChatRequest request) {
        return ChatCompletionRequest.builder()
                .model(request.getModel())
                .frequencyPenalty(request.getFrequency_penalty())
                .messages(convertChatMessages(request))
                .maxTokens(request.getMax_tokens())
                .temperature(request.getTemperature())
                .topP(request.getTop_n())
                .build();
    }

    private static List<ChatMessage> convertChatMessages(GPTCompletionChatRequest request) {
        ChatMessage message1 = new ChatMessage(request.getRole1(), request.getMessage1());
        ChatMessage message2 = new ChatMessage(request.getRole2(), request.getMessage2());
        return List.of(message1, message2);
    }
}