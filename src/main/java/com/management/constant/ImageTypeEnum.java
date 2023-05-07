package com.management.constant;

public enum ImageTypeEnum {

    PNG("png"),
    JPEG("jpeg"),
    GIF("gif");

    String value;
    ImageTypeEnum(String value){
        this.value = value;
    }

}
