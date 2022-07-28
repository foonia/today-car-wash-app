package com.example.nenne.api.Mapper;

import com.example.nenne.api.Dao.ImageVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageVO,Integer> {
}
