package com.foodguide.mapper;

import com.foodguide.pojo.User;
import com.foodguide.pojo.User2;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select *from user2")
    public List<User2> findAll();
    @Select("select *from user where id=#{id}")
    public User findOne(long id);
    @Insert("insert into user(nickname,avatar,openid)" +
            "values(#{nickname},#{avatar},#{openid})")
    public int addUser(User user);
    @Select("select *from user where openid=#{openid}")
    public User selectByopenid(String id);
}
