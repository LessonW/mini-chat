package com.foodguide.mapper;

import com.foodguide.pojo.Menu;
import com.foodguide.pojo.Sort;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Mapper
public interface SortMapper {
    //按主分类
    @Select("select *from menu m,user u where sortid=#{id} and m.userid=u.id")
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
                    one = @One(select = "com.foodguide.mapper.UserMapper.findOne"))
    })
    public List<Menu> findByid(long id);
    //按主分类
    @Select("select *from sort where mainsort=#{mainsort}")
    public Sort findmainsort(String mainsort);

    @Select("select *from sort where id=#{id}")
    public Sort findOne(long id);

    @Select("select distinct mainsort from sort")
    @Results({
            @Result(property = "mainsort", column = "mainsort"),
            @Result(property = "sortlist", column = "mainsort",
                    one = @One(select = "com.foodguide.mapper.SortMapper.findmainsort")),
    })
    List<Map<String,Object>> selectAllsort();


}
