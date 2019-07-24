package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.pojo.Greens;

public interface IGreensService {
    PageInfo<Greens> selectAll(Integer pageNum);

    int add(Greens greens);

    int delete(Integer id);

    int update(Greens greens);

    Greens selectById(Integer id);
}
