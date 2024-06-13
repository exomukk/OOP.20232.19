package org.oop.oanquan.model;

public class userSetting {
    private static userSetting instance;
    private String musicSetting;

    private userSetting() {
    }

    public static userSetting getInstance() {
        if (instance == null) {
            instance = new userSetting();
        }
        return instance;
    }

    public String getMusicSetting() {
        return musicSetting;
    }

    public void setMusicSetting(String musicSetting) {
        System.out.println(musicSetting + "user setting");
        this.musicSetting = musicSetting;
    }
}
