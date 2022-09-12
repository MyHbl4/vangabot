package com.moon.vangabot.service;

import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class PredictionService {
    private final Random random = new Random();
    private ReplyMessagesService messagesService;

    public PredictionService(ReplyMessagesService messagesService) {
        this.messagesService = messagesService;
    }

    public String getPrediction() {
        int predictionNumber = random.nextInt(5);
        String replyMessagePropertie = String.format("%s%d", "reply.prediction", predictionNumber);
        return messagesService.getReplyText(replyMessagePropertie);
    }
}
