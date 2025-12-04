package com.bayraksamet.exception;

import lombok.Getter;

@Getter
public enum MessageType {

    NO_RECORD_EXISTS("1001"," kayıt bulunamadı"),
    GENERAL_EXCEPTION("9999"," Genel hata oluştu"),;

    private String  message;
    private String  code;

    MessageType(String code, String message) {
        this.message = message;
        this.code = code;
    }



}
