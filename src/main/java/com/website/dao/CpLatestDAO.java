package com.website.dao;

import com.website.entity.Cplatest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by letrain on 2017/11/18.
 */
@Repository
public interface CpLatestDAO extends JpaRepository<Cplatest,Integer> {
    Cplatest findByNoAndTypeid(String No,Integer typeid);
}
