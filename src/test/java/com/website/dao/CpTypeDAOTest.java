package com.website.dao;

import com.website.entity.CpType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by letrain on 2017/11/18.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CpTypeDAOTest {
    @Autowired
    private CpTypeDAO cpTypeDAO;
    @Test
    public void findByTypename() throws Exception {
        CpType cpType = new CpType();
        cpType.setTypeid(555);
        cpType.setTypename("喔喔");
        cpType.setId(555);
        Object o = cpTypeDAO.save(cpType);
        Assert.assertNotNull(o);
    }

}