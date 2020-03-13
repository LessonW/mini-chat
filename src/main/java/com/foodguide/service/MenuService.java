package com.foodguide.service;

import com.foodguide.mapper.MenuMapper;
import com.foodguide.pojo.Menu;
import com.foodguide.pojo.Tip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class MenuService {
    @Autowired
     MenuMapper menuMapper;

    public Menu selectOneMenu(long id) {
        return menuMapper.selectOneMenu(id);
    }

    public List<Menu> selectMenu(){
        return menuMapper.selectMenu();
    }

    public List<Menu> selectMenuBytitle(String title) {
        return menuMapper.selectMenuBytitle(title);
    }

    public List<Menu> selectMenuByuserid(int id){return menuMapper.selectMenuByuserid(id);}

    public List<Menu> selectMenuBysortid(int id){return menuMapper.selectMenuBysortid(id);}

    public int insertMenu(Menu menu) {
        menuMapper.insertMenu(menu);
        return (int) menu.getId();
    }
    public int delMenu(int id){
        menuMapper.delMenu(id);
        return id;
    }

    public List<HashMap<String,Object>> tip(){
        return menuMapper.tip();
    }


}
