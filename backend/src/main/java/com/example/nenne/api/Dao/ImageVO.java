package com.example.nenne.api.Dao;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "image")
@Entity
public class ImageVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String mimetype;
    private String original_name;
    private String saved_name;
    private String saved_path;
    private String created;
    private byte[] bytes;

    @Builder
    public ImageVO(Integer id, String name, String mimetype, String original_name, String saved_name, String saved_path, byte[] bytes,  String created){
        this.id = id;
        this.name = name;
        this.mimetype = mimetype;
        this.original_name = original_name;
        this.saved_name = saved_name;
        this.saved_path = saved_path;
        this.bytes = bytes;
        this.created = created;
    }

}
