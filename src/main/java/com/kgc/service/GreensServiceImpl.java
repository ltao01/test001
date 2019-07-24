package com.kgc.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.mapper.GreensMapper;
import com.kgc.pojo.Greens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreensServiceImpl implements IGreensService {


    @Autowired
   private GreensMapper  mapper;
    @Override
    public PageInfo<Greens> selectAll(Integer pageNum) {

          PageHelper.startPage(pageNum,4);
//        GreensExample e = new GreensExample();
//        GreensExample.Criteria c = e.createCriteria();



        List<Greens> greens = mapper.selectByExample(null);
        System.out.println(greens);
        return new PageInfo<Greens>(greens);
    }

    @Override
    public int add(Greens greens) {

        return  mapper.insertSelective(greens);
    }

    @Override
    public int delete(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Greens greens) {

        return mapper.updateByPrimaryKeySelective(greens);
    }

    @Override
    public Greens selectById(Integer id) {

        return  mapper.selectByPrimaryKey(id);
    }
}
