package com.dao;

import com.entity.Mainposts;
import com.entity.MainpostsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MainpostsMapper {
    long countByExample(MainpostsExample example);

    int deleteByExample(MainpostsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Mainposts record);

    int insertSelective(Mainposts record);

    List<Mainposts> selectByExampleWithBLOBs(MainpostsExample example);

    List<Mainposts> selectByExample(MainpostsExample example);

    Mainposts selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mainposts record, @Param("example") MainpostsExample example);

    int updateByExampleWithBLOBs(@Param("record") Mainposts record, @Param("example") MainpostsExample example);

    int updateByExample(@Param("record") Mainposts record, @Param("example") MainpostsExample example);

    int updateByPrimaryKeySelective(Mainposts record);

    int updateByPrimaryKeyWithBLOBs(Mainposts record);

    int updateByPrimaryKey(Mainposts record);
}