package com.moon.vangabot.botapi.handlers.menu;

import com.moon.vangabot.botapi.BotState;
import com.moon.vangabot.botapi.InputMessageHandler;
import com.moon.vangabot.service.MainMenuService;
import com.moon.vangabot.service.ReplyMessagesService;
import com.moon.vangabot.utils.Emojis;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;


@Component
public class HelpMenuHandler implements InputMessageHandler {

    private MainMenuService mainMenuService;
    private ReplyMessagesService messagesService;

    public HelpMenuHandler(MainMenuService mainMenuService, ReplyMessagesService messagesService) {
        this.mainMenuService = mainMenuService;
        this.messagesService = messagesService;
    }

    @Override
    public SendMessage handle(Message message) {
        return mainMenuService.getMainMenuMessage(message.getChatId(),
            messagesService.getReplyText("reply.showHelpMenu", Emojis.MAGE));
    }

    @Override
    public BotState getHandlerName() {
        return BotState.SHOW_HELP_MENU;
    }
}
