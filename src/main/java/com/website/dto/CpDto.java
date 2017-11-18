package com.website.dto;

import lombok.Data;

import java.io.PrintWriter;

/**
 * Created by letrain on 2017/11/18.
 */
@Data
public class CpDto {
    /**
     * 彩种code
     */
    private String code;
    /**
     * 彩种开奖期号
     */
    private String expect;

    /**
     * 开奖号码
     */
    private String opencode;

    /**
     * 开奖时间
     */
    private String opentime;
}
