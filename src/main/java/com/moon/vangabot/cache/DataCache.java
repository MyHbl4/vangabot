package com.moon.vangabot.cache;

import com.moon.vangabot.botapi.BotState;
import com.moon.vangabot.botapi.handlers.fillingprofile.UserProfileData;

public interface DataCache {

    void setUsersCurrentBotState(long userId, BotState botState);

    BotState getUsersCurrentBotState(long userId);

    UserProfileData getUserProfileData(long userId);

    void saveUserProfileData(long userId, UserProfileData userProfileData);
}