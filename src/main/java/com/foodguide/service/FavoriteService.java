package com.foodguide.service;

import com.foodguide.mapper.FavoriteMapper;
import com.foodguide.pojo.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FavoriteService {
    @Autowired
    FavoriteMapper favoriteMapper;

    public List<Favorite> selectfavBymenuid(int id){ return favoriteMapper.selectfavBymenuid(id); }

    public List<Favorite> selectfavBymenuidAnduserid(int menuid,int userid){return favoriteMapper.selectfavBymenuidAnduserid(menuid,userid);}

    public List<Favorite> selectfavByuserid(int userid){ return favoriteMapper.selectfavByuserid(userid); }

    public int addFav(int menuid,int userid){
        return favoriteMapper.addFav(menuid,userid);
    }
    public int delFav(int menuid,int userid){
        return favoriteMapper.delFav(menuid,userid);
    }
}
