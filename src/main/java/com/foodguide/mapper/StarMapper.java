package com.foodguide.mapper;

import com.foodguide.pojo.Favorite;
import com.foodguide.pojo.Star;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StarMapper {
    @Select("select *from star where menuid={id}")
    public List<Star> selectStarBymenuid(int id);

    @Select("select *from star where menuid={menuid} and userid={userid}")
    List<Star> selectStarBymenuidAnduserid(int menuid, int userid);

    @Select("select *from star where userid={id}")
    public List<Star> selectStarByuserid(int id);

    @Insert("insert into star(menuid,userid) values(#{menuid},#{userid})")
    int addstar(int menuid,int userid);

    @Delete("delete from Favorite where menuid=#{menuid} and userid=#{userid})")
    int delstar(int menuid,int userid);
}
