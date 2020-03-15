package com.foodguide.mapper;

import com.foodguide.pojo.Menu;
import com.foodguide.pojo.Relation;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface RelationMapper {

    @Select("select *from relation where userid=#{id}")
    List<Relation> selectRelByuserid(int id);

    @Select("select  *from relation r,menu m where r.fansid=#{id} and r.userid=m.userid ")
    @Results({
            @Result(property = "menuid", column = "m.id", id = true),
            @Result(property = "title", column = "title"),
            @Result(property = "userid", column = "userid"),
            @Result(property = "step", column = "step"),
            @Result(property = "material", column = "material"),
            @Result(property = "sortid", column = "sortid"),
            @Result(property = "m_ctime", column = "m.ctime"),
            @Result(property = "m_mtime", column = "m.mtime"),
            @Result(property = "m_img", column = "m.img"),
            @Result(property = "m_state", column = "m.state"),
            @Result(property = "user", column = "userid",
                    one = @One(select = "com.foodguide.mapper.UserMapper.findOne")),
            @Result(property = "sort", column = "sortid",
                    one = @One(select = "com.foodguide.mapper.SortMapper.findOne")),
    })
    List<Menu> selectRelByfansid(int id);

    @Insert("insert into relation(userid,fansid) values(#{userid},#{fansid})")
    int addfans(int userid,int fansid);

    @Delete("delete from Favorite where menuid=#{menuid} and userid=#{userid})")
    int delfans(int userid,int fansid);

}
