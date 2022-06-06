package com.example.nenne.api.Service;

import com.example.nenne.api.Dao.CarwashDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarwashService {

    @Autowired
    CarwashDAO carwashDAO;

    public int getTestValue(){
        return carwashDAO.getTestValue();
    }
}
