package com.website.dao;

import com.website.entity.CpHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by letrain on 2017/11/18.
 */
@Repository
public interface CpHisDAO extends JpaRepository<CpHistory,Integer> {
    CpHistory findByNoAndTypeid(String No,Integer typeid);
}
