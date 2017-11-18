package com.website.service.impl;

import com.website.dao.CpHisDAO;
import com.website.dao.CpLatestDAO;
import com.website.entity.CpHistory;
import com.website.entity.Cplatest;
import com.website.service.CpHisService;
import com.website.service.CpLatestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by letrain on 2017/11/18.
 */
@Service
public class CpLatestServiceImpl implements CpLatestService {
    @Autowired
    private CpLatestDAO cpLatestDAO;
    @Override
    public Cplatest insert(Cplatest cplatest) {
       return cpLatestDAO.save(cplatest);
    }

    @Override
    public Cplatest findOne(String No, Integer typeid) {
        return cpLatestDAO.findByNoAndTypeid(No, typeid);
    }
}
