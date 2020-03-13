package com.foodguide.service;

import com.foodguide.mapper.RelationMapper;
import com.foodguide.pojo.Relation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationService {
    @Autowired
    private RelationMapper relationMapper;

    public List<Relation> selectRelByuserid(int id){
        return relationMapper.selectRelByuserid(id);
    }

    public List<Relation> selectRelByfansid(int id){
        return  relationMapper.selectRelByfansid(id);
    }


    public int addfans(int userid,int fansid){
        return relationMapper.addfans(userid,fansid);
    }
    public int delfans(int userid,int fansid){
        return relationMapper.delfans(userid,fansid);
    }
}
