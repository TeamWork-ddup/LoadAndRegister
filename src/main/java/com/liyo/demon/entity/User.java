package com.liyo.demon.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    private Integer id;

    private String name;

    private String password;

    private String sex;

    private String age;

    private String email;

    private String registerTime;

    private static final long serialVersionUID = 1L;
}