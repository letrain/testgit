package com.website.service;

import com.website.entity.CpHistory;

/**
 * Created by letrain on 2017/11/18.
 */
public interface CpHisService {
    CpHistory insert(CpHistory cpHistory);

    CpHistory findOne(String No,Integer typeid);
}
