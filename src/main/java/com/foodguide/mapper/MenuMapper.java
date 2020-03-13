package com.foodguide.mapper;

import com.foodguide.pojo.Menu;
import com.foodguide.pojo.Tip;
import com.foodguide.pojo.JsonTypeHandler;
import org.apache.ibatis.annotations.*;

import java.util.*;

@Mapper
public interface MenuMapper {

    //查询全部菜谱
    @Select("select *from menu m,user u,sort s where m.userid=u.id and m.sortid=s.id  ORDER BY RAND() LIMIT 50")
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
    List<Menu> selectMenu();

    //按 id查询全部菜谱
    @Select("select *from menu m,user u,sort s where m.userid=u.id and m.sortid=s.id and m.id=#{id}")
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
    Menu selectOneMenu( long id);

    //模糊查询菜谱
    @Select("select *from menu m,user u,sort s where m.userid=u.id and m.sortid=s.id  and m.title like '%${title}%' ")
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
    List<Menu> selectMenuBytitle(String title);

    //按用户 userid 查询菜谱
    @Select("select *from menu m,user u,sort s where m.userid=u.id and m.sortid=s.id  and m.userid=#{id} ")
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
    List<Menu> selectMenuByuserid(int id);

    //按分类 sortid 查询菜谱
    @Select("select *from menu m,user u,sort s " +
            "where m.userid=u.id and m.sortid=s.id  and m.sort=#{id} ")
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
    List<Menu> selectMenuBysortid(int id);

    //发表菜谱
    @Insert("insert into menu (title,userid,step,material,sortid,img)" +
            "values(#{title},#{userid},#{step},#{material},#{sortid},#{img} )")
    int insertMenu(Menu menu);

    //删除菜谱
    @Delete("delete from menu where menuid=#{id}")
    int delMenu(int id);

    //热门标签
    @Select("SELECT s.secondsort, m.sortid, count( * ) AS count\n" +
            "FROM menu m,sort s WHERE m.sortid=s.id\n" +
            "GROUP BY sortid\n" +
            "ORDER BY count DESC\n" +
            "LIMIT 10")
    List<HashMap<String,Object>> tip();
}