package com.liyo.demon.dao;

import com.liyo.demon.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Mapper
@Component
public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    @Insert("INSERT INTO `user` (`id`, `name`, `password`, `sex`, `age`, `email`, `register_time`) VALUES (#{id}, #{name}, #{password}, #{sex},  #{age}, #{email},  #{registerTime})")
    int insert(User record);

    int insertSelective(User record);

    @Select("select * from user where id = #{id}")
    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}