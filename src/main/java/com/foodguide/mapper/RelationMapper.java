package com.foodguide.mapper;

import com.foodguide.pojo.Relation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface RelationMapper {

    @Select("select *from relation where userid=#{id}")
    List<Relation> selectRelByuserid(int id);

    @Select("select *from relation where fansid=#{id}")
    List<Relation> selectRelByfansid(int id);

    @Insert("insert into relation(userid,fansid) values(#{userid},#{fansid})")
    int addfans(int userid,int fansid);

    @Delete("delete from Favorite where menuid=#{menuid} and userid=#{userid})")
    int delfans(int userid,int fansid);

}
