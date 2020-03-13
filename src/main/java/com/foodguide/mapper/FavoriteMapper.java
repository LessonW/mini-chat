package com.foodguide.mapper;

import com.foodguide.pojo.Favorite;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
@Mapper
public interface FavoriteMapper {
    @Select("select *from favorite where menuid={id}")
    public List<Favorite> selectfavBymenuid(int id);

    @Select("select *from favorite where menuid={menuid} and userid={userid}")
        List<Favorite> selectfavBymenuidAnduserid(int menuid,int userid);

    //按 userid 查询
    @Select("select *from favorite where  userid={userid}")
    List<Favorite> selectfavByuserid(int userid);

    @Insert("insert into Favorite(menuid,userid) values(#{menuid},#{userid})")
    int addFav(int menuid,int userid);

    @Delete("delete from Favorite where menuid=#{menuid} and userid=#{userid})")
    int delFav(int menuid,int userid);
}
