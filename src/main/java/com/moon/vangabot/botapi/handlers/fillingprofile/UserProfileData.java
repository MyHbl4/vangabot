package com.moon.vangabot.botapi.handlers.fillingprofile;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfileData {

    String name;
    String gender;
    String color;
    String movie;
    String song;
    int age;
    int number;

    @Override
    public String toString() {
        return "\nИмя: " + name + '\n' +
            "Возраст: " + age + '\n' +
            "Пол: " + gender + '\n' +
            "Число: " + number + '\n' +
            "Цвет: " + color + '\n' +
            "Фильм: " + movie + '\n' +
            "Песня: " + song
            ;
    }
}