package com.kgc.mapper;

import com.kgc.pojo.Greens;
import com.kgc.pojo.GreensExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GreensMapper {
    long countByExample(GreensExample example);

    int deleteByExample(GreensExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Greens record);

    int insertSelective(Greens record);

    List<Greens> selectByExample(GreensExample example);

    Greens selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Integer record, @Param("example") GreensExample example);

    int updateByExample(@Param("record") Greens record, @Param("example") GreensExample example);

    int updateByPrimaryKeySelective(Greens record);

    int updateByPrimaryKey(Greens record);
}