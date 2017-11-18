package com.website.service.impl;

import com.website.dao.CpHisDAO;
import com.website.entity.CpHistory;
import com.website.service.CpHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by letrain on 2017/11/18.
 */
@Service
public class CpHisServiceImpl implements CpHisService {
    @Autowired
    private CpHisDAO cpHisDAO;
    @Override
    public CpHistory insert(CpHistory cpHistory) {
       return cpHisDAO.save(cpHistory);
    }

    @Override
    public CpHistory findOne(String No, Integer typeid) {
        return cpHisDAO.findByNoAndTypeid(No, typeid);
    }
}
