package com.chanbar.backend133_chanbar.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private ErrorsType errorsType;
    private String ofStatic;

    public String errorMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append(errorsType.getMessage());

        if (ofStatic != null) {
            builder.append(" : " + ofStatic);
        }
        return builder.toString();
    }
}
