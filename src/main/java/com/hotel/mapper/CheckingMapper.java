package com.hotel.mapper;

import com.hotel.domain.Checking;
import com.hotel.povo.ChekingVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CheckingMapper extends Mapper<Checking> {
    @Select("select status, count(0) num from checking where eid = #{eid} group by status order by status asc")
    public List<ChekingVo> getCheking(@Param("eid") Integer eid);
}