package ssodamproject.server.chatbot;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ssodamproject.server.chatbot.dto.ChatbotDto;
import ssodamproject.server.chatbot.dto.ChatbotListDto;
import ssodamproject.server.common.api.ApiResponseDto;
import ssodamproject.server.common.api.SuccessResponse;
import ssodamproject.server.user.service.UserService;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chatbot")
public class ChatbotController {
    private final ChatbotService chatbotService;
    private final UserService userService;

    @GetMapping("")
    public ApiResponseDto<List<ChatbotDto>> readChatbotList() {
        return chatbotService.readChatbotList();
    }

    @PostMapping("/like/{chatbotId}")
    public ApiResponseDto<SuccessResponse> createHeart(HttpServletRequest request, @PathVariable("chatbotId") Long chatbotId) {
        String clientIp = userService.getClientIP(request);
        return chatbotService.createHeart(clientIp, chatbotId);
    }
}