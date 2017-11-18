package com.website.service;

import com.website.entity.Cplatest;

/**
 * Created by letrain on 2017/11/18.
 */
public interface CpLatestService {
    Cplatest insert (Cplatest cplatest);

    Cplatest findOne(String No, Integer typeid);
}
