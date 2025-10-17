package com.chanbar.backend133_chanbar.exceptions;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
//@AllArgsConstructor
public class BaseException extends RuntimeException{
    public BaseException(ErrorsType noDataFound, String message) {

    }
    public BaseException(ErrorMessage errorMessage) {
        super(errorMessage.errorMessage());
    }
}
