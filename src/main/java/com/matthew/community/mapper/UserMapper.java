package com.matthew.community.mapper;

import com.matthew.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/9/8 10:00
 * @Version 1.0
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
    //如果传入的值不是对象要加@Param才能使用#{}
    @Select("select * from user where token = #{token}")
    User fingByToken(@Param("token") String token);
}
