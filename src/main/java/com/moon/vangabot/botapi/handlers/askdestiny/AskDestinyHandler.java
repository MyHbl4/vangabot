package com.moon.vangabot.botapi.handlers.askdestiny;

import com.moon.vangabot.botapi.BotState;
import com.moon.vangabot.botapi.InputMessageHandler;
import com.moon.vangabot.cache.UserDataCache;
import com.moon.vangabot.service.ReplyMessagesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Slf4j
@Component
public class AskDestinyHandler implements InputMessageHandler {

    private UserDataCache userDataCache;
    private ReplyMessagesService messagesService;

    public AskDestinyHandler(UserDataCache userDataCache,
        ReplyMessagesService messagesService) {
        this.userDataCache = userDataCache;
        this.messagesService = messagesService;
    }

    @Override
    public SendMessage handle(Message message) {
        return processUsersInput(message);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.ASK_DESTINY;
    }

    private SendMessage processUsersInput(Message inputMsg) {
        long userId = inputMsg.getFrom().getId();
        long chatId = inputMsg.getChatId();

        SendMessage replyToUser = messagesService.getReplyMessage(chatId, "reply.askDestiny");
        userDataCache.setUsersCurrentBotState(userId, BotState.FILLING_PROFILE);

        return replyToUser;
    }
}



