package com.foodguide.service;

import com.foodguide.mapper.StarMapper;
import com.foodguide.pojo.Star;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarService {
    @Autowired
    StarMapper starMapper;

    public List<Star> selectStarBymenuid(int id){
        return starMapper.selectStarBymenuid(id);
    }

    public List<Star> selectStarBymenuidAnduserid(int menuid, int userid){
        return starMapper.selectStarBymenuidAnduserid(menuid,userid);
    }

    public List<Star> selectStarByuserid(int id){
        return starMapper.selectStarByuserid(id);
    }


    public int addstar(int menuid,int userid){
        return starMapper.addstar(menuid,userid);
    }
    public int delstar(int menuid,int userid){
        return starMapper.delstar(menuid,userid);
    }

}
