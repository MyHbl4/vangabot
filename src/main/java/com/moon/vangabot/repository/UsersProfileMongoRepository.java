package com.moon.vangabot.repository;

import com.moon.vangabot.model.UserProfileData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersProfileMongoRepository extends MongoRepository<UserProfileData, String> {

    UserProfileData findByChatId(long chatId);

    void deleteByChatId(long chatId);
}
