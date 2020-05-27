package com.hotel.mapper;

import com.hotel.domain.Bill;
import com.hotel.povo.BillVo;
import com.hotel.povo.SexVo;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BillMapper extends Mapper<Bill> {
    @Select("select *\n" +
            " from bill\n" +
            " where DATEDIFF(time,NOW()) = 0")
     List<Bill> findAllByDate();

    @Select("select *\n" +
            " from bill\n" +
            " where time > DATE_SUB(CURDATE(), INTERVAL 4 MONTH)")
    List<Bill> findAllByQuarter();

    @Select(" select * from bill where time>DATE_SUB(CURDATE(), INTERVAL 1 YEAR) ")
    List<Bill> findAllByYear();


    @Select(" select\n" +
            "       day(time) day,\n" +
            "       sum(income) sum\n" +
            " from bill\n" +
            " where DATEDIFF(time,NOW()) >=  -7\n" +
            " group by year(time),\n" +
            "         month(time),\n" +
            "         day(time)")
    List<BillVo> findBySum();

    @Select("select sex , count(0) num from passenger group by sex")
    List<SexVo> findSex();
}