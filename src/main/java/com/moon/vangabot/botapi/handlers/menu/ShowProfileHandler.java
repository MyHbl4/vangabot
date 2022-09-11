package com.moon.vangabot.botapi.handlers.menu;

import com.moon.vangabot.botapi.BotState;
import com.moon.vangabot.botapi.InputMessageHandler;
import com.moon.vangabot.botapi.handlers.fillingprofile.UserProfileData;
import com.moon.vangabot.cache.UserDataCache;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class ShowProfileHandler implements InputMessageHandler {

    private UserDataCache userDataCache;

    public ShowProfileHandler(UserDataCache userDataCache) {
        this.userDataCache = userDataCache;
    }

    @Override
    public SendMessage handle(Message message) {
        final long userId = message.getFrom().getId();
        final UserProfileData profileData = userDataCache.getUserProfileData(userId);

        userDataCache.setUsersCurrentBotState(userId, BotState.SHOW_MAIN_MENU);
        return new SendMessage(String.valueOf(message.getChatId()), String.format(
            "%s%n -------------------%nИмя: %s%nВозраст: %d%nПол: %s%nЛюбимая цифра: %d%n" +
                "Цвет: %s%nФильм: %s%nПесня: %s%n", "Данные по вашей анкете", profileData.getName(),
            profileData.getAge(), profileData.getGender(), profileData.getNumber(),
            profileData.getColor(), profileData.getMovie(), profileData.getSong()));
    }

    @Override
    public BotState getHandlerName() {
        return BotState.SHOW_USER_PROFILE;
    }
}