package com.ff.vo;

/**
 * @ClassName SongEntity
 * @Description TODO
 * @Author ff
 * @Date 2020/4/14 14:16
 * @ModifyDate 2020/4/14 14:16
 * @Version 1.0
 */


public class SongEntity {

    private String musicName;
    private String musicId;
    private String singer;

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

}
