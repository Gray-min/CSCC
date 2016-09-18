package com.zlzkj.app.mapper;

import com.zlzkj.app.model.Location;

public interface LocationMapper {
    int insert(Location record);

    int insertSelective(Location record);
}