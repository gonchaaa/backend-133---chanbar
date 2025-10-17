package com.chanbar.backend133_chanbar.exceptions;

import lombok.Getter;

@Getter
public enum ErrorsType {

    NO_DATA_FOUND("1001","data yoxdur"),
    NO_AUTHORIZATION("1002","Sisteme giris etmemisiniz"),
    INVALID_DATA("1005","Datalar duzgun daxil edilmeyib");

    private  String code;
    private  String message;

    ErrorsType(String code, String message) {
        this.code=code;
        this.message=message;
    }

}
