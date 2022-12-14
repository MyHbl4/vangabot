package com.moon.vangabot.botapi.handlers.menu;

import com.moon.vangabot.botapi.BotState;
import com.moon.vangabot.botapi.InputMessageHandler;
import com.moon.vangabot.cache.UserDataCache;
import com.moon.vangabot.model.UserProfileData;
import com.moon.vangabot.service.UsersProfileDataService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class ShowProfileHandler implements InputMessageHandler {

    private UserDataCache userDataCache;
    private UsersProfileDataService profileDataService;

    public ShowProfileHandler(UserDataCache userDataCache,
        UsersProfileDataService profileDataService) {
        this.userDataCache = userDataCache;
        this.profileDataService = profileDataService;
    }

    @Override
    public SendMessage handle(Message message) {
        SendMessage userReply;
        final long userId = message.getFrom().getId();
        final UserProfileData profileData = profileDataService.getUserProfileData(
            message.getChatId());

        userDataCache.setUsersCurrentBotState(userId, BotState.SHOW_MAIN_MENU);
        if (profileData != null) {
            userReply = new SendMessage(String.valueOf(message.getChatId()),
                String.format("%s%n-------------------%n%s", "Данные по вашей анкете:",
                    profileData.toString()));
        } else {
            userReply = new SendMessage(String.valueOf(message.getChatId()),
                "Такой анкеты в БД не существует !");
        }

        return userReply;
    }

    @Override
    public BotState getHandlerName() {
        return BotState.SHOW_USER_PROFILE;
    }
}
