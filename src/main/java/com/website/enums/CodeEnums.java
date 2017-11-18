package com.website.enums;

import lombok.Getter;

/**
 * Created by letrain on 2017/11/18.
 */
@Getter
public enum  CodeEnums {
    GET_CP_RESULT_ERROR(78,"获取API开奖结果异常")
    ;
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;

    CodeEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
