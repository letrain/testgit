package com.website.dao;

import com.website.entity.CpType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by letrain on 2017/11/18.
 */
@Repository
public interface CpTypeDAO extends JpaRepository<CpType,Integer> {
    CpType findByTypename(String typename);
}
