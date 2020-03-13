package com.foodguide.service;

import com.foodguide.mapper.UserMapper;
import com.foodguide.pojo.User;
import com.foodguide.pojo.User2;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class UserService {

    @Autowired
    private  UserMapper userMapper;

    public List<User2> findAll(){
        return userMapper.findAll();
    }

    public User findOne(long id){ return userMapper.findOne(id);}

    public int addUser(User user){
        userMapper.addUser(user);
        return 1;
    }
    public User selectByopenid(String id){

        return userMapper.selectByopenid(id);
    }

}
