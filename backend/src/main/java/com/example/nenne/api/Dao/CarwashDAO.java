package com.example.nenne.api.Dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarwashDAO {

    @Autowired
    private SqlSession SqlSession;

    public int getTestValue() {
        return SqlSession.selectOne("com.world.therapy.userCount");
    }
}