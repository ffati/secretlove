package com.ff.util.common;

/**
 * @ClassName FileType
 * @Description TODO
 * @Author ff
 * @Date 2020/2/26 14:37
 * @ModifyDate 2020/2/26 14:37
 * @Version 1.0
 */

public enum FileType {

    IMG_JPEG("image/jpeg"),
    IMG_PNG("image/png"),
    IMG_SVG("image/svg"),

    AUDIO_MPEG("audio/mpeg"),
    AUDIO_REAlAudio("audio/aiff"),
    AUDIO_AIFF("audio/aiff"),

    VIDEO_MPEG("video/mpeg"),
    VIDEO_AVI("video/avi"),
    VIDEO_3GP("video/3gp"),
    VIDEO_FLV("video/flv"),
    VIDEO_ASF("video/asf");


/*    DOC("application/msword"),
    PPT("application/vnd.ms-powerpoint"),
    DOCX("application/vnd.openxmlformats-officedocument.wordprocessingml.document"),

    CSS("text/css"),
    HTML("text/html"),
    C("text/x-csrc");*/

    public String value;

    FileType(String value) {
       this.value = value;
    }
}
