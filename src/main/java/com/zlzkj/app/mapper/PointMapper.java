package com.zlzkj.app.mapper;

import com.zlzkj.app.model.Point;

public interface PointMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Point record);

    int insertSelective(Point record);

    Point selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Point record);
    
    int updateByPrimaryKey(Point record);
}