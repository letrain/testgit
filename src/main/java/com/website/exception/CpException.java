package com.website.exception;

import com.website.enums.CodeEnums;
import lombok.Getter;

/**
 * Created by letrain on 2017/11/18.
 */
@Getter
public class CpException extends RuntimeException{
    private Integer code;

    public CpException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public CpException(CodeEnums codeEnums) {
        super(codeEnums.getMsg());
        this.code = codeEnums.getCode();
    }
}
