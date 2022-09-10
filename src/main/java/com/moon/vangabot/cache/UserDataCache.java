package com.moon.vangabot.cache;

import com.moon.vangabot.botapi.BotState;
import com.moon.vangabot.botapi.handlers.fillingprofile.UserProfileData;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class UserDataCache implements DataCache {

    private Map<Long, BotState> usersBotStates = new HashMap<>();
    private Map<Long, UserProfileData> usersProfileData = new HashMap<>();

    @Override
    public void setUsersCurrentBotState(long userId, BotState botState) {
        usersBotStates.put(userId, botState);
    }

    @Override
    public BotState getUsersCurrentBotState(long userId) {
        BotState botState = usersBotStates.get(userId);
        if (botState == null) {
            botState = BotState.ASK_DESTINY;
        }

        return botState;
    }

    @Override
    public UserProfileData getUserProfileData(long userId) {
        UserProfileData userProfileData = usersProfileData.get(userId);
        if (userProfileData == null) {
            userProfileData = new UserProfileData();
        }
        return userProfileData;
    }

    @Override
    public void saveUserProfileData(long userId, UserProfileData userProfileData) {
        usersProfileData.put(userId, userProfileData);
    }
}