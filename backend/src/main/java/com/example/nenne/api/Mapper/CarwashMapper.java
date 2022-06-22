package com.example.nenne.api.Mapper;

import java.util.List;

import com.example.nenne.api.Entity.CarwashEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CarwashMapper {
    @Select("select idx,name,address,latitude,longtitude,type,(6371*acos(cos(radians(#{latitude}))*cos(radians(LATITUDE))*cos(radians(LONGTITUDE)-radians(#{longtitude})) \n" +
            "+sin(radians(#{latitude}))*sin(radians(LATITUDE)))) AS distance\n" +
            "from carwash\n" +
            "having distance < 10\n" +
            "order by distance DESC;")
    CarwashEntity getCarwash(@Param("latitude") String latitude, @Param("longtitude") String longtitude);

    @Select("select idx,name,address,latitude,longtitude,type,(6371*acos(cos(radians(#{latitude}))*cos(radians(LATITUDE))*cos(radians(LONGTITUDE)-radians(#{longtitude})) \n" +
            "+sin(radians(#{latitude}))*sin(radians(LATITUDE)))) AS DISTANCE\n" +
            "from carwash\n" +
            "having DISTANCE < #{distance}\n" +
            "order by distance DESC;")
    List<CarwashEntity> getCarwashList(@Param("latitude") String latitude, @Param("longtitude") String longtitude, @Param("distance") String distance);

  /*  @Insert("INSERT INTO Carwash VALUES(#{id}, #{name}, #{phone}, #{address})")
    int insertCarwash(@Param("id") String id, @Param("name") String name, @Param("phone") String phone, @Param("address") String address);

    @Update("UPDATE Carwash SET name=#{name}, phone=#{phone}, address=#{address} WHERE id=#{id}")
    int updateCarwash(@Param("id") String id, @Param("name") String name, @Param("phone") String phone, @Param("address") String address);

    @Delete("DELETE FROM Carwash WHERE id=#{id}")
    int deleteCarwash(@Param("id") String id);*/
}