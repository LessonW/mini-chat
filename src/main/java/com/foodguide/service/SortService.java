package com.foodguide.service;

import com.foodguide.mapper.SortMapper;
import com.foodguide.pojo.Menu;
import com.foodguide.pojo.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SortService {
    @Autowired
     SortMapper sortMapper;

    public Sort findBysortid(long id){
        return sortMapper.findOne(id);
    }


    public Sort findOne(String id){
        return sortMapper.findmainsort(id);
    }

    public List<Map<String,Object>> selectAllsort(){return sortMapper.selectAllsort();}

    public List<Menu> findByid(long id){
        return sortMapper.findByid(id);
    }


}
