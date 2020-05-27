package com.hotel.mapper;

import com.hotel.domain.RoomType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface RoomTypeMapper extends Mapper<RoomType> {
    @Select("select count(0) from  hotel.room where state = 1 and  room.room_id = #{roomId}")
    public Integer getNum(@Param("roomId") Integer roomId);
}