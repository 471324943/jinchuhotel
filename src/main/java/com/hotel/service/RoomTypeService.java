package com.hotel.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotel.domain.Goods;
import com.hotel.domain.Room;
import com.hotel.domain.RoomType;
import com.hotel.mapper.RoomMapper;
import com.hotel.povo.PagePramas;
import com.hotel.povo.PageResult;
import com.hotel.utils.CodeUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.hotel.mapper.RoomTypeMapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class RoomTypeService {

    @Resource
    private RoomTypeMapper roomTypeMapper;

    @Resource
    private RoomMapper roomMapper;

    public List<RoomType> findAllRoomType() {
        return roomTypeMapper.selectAll();
    }

    public List<Room> findAllRoom() {
        List<Room> rooms = roomMapper.selectAll();
        for (Room room : rooms) {
           room.setRoomType( roomTypeMapper.selectByPrimaryKey(room.getRoomtypeId()));
        }
        return rooms;
    }

        public PageResult findAll(PagePramas pagePramas){
                //开启分页
                PageHelper.startPage(pagePramas.getPage(),pagePramas.getRows());
                //创建关联查询对象
                Example example = new Example(RoomType.class);
                Example.Criteria criteria = example.createCriteria();

                //判断模糊查询姓名
                criteria.andLike("roomName","%"+(pagePramas.getKey()==null?"":pagePramas.getKey()).trim()+"%");
                //查询结果
            List<RoomType> roomTypes = roomTypeMapper.selectByExample(example);
            //封装分页
                PageInfo<RoomType> pageInfo = new PageInfo<>(roomTypes);
                return new PageResult(CodeUtils.OK,"成功",pageInfo.getList(),pageInfo.getTotal());
            }

    public List<RoomType> findByPage() {
        PageHelper.startPage(0, 7);
        List<RoomType> roomTypes = roomTypeMapper.selectAll();
        for (RoomType roomType : roomTypes) {
            roomType.setSurplus(roomTypeMapper.getNum(roomType.getRoomId()) + "");
        }
        return roomTypes;
    }

    public RoomType findById(String id) {
        RoomType roomType = roomTypeMapper.selectByPrimaryKey(id);
        roomType.setSurplus(roomTypeMapper.getNum(roomType.getRoomId()) + "");
        return roomType;
    }

    public List<Room> usableList() {
        Example example = new Example(Room.class);
        example.and().andEqualTo("state", "1");
        return roomMapper.selectByExample(example);
    }


    public void deleted(String id) {
        roomMapper.deleteByPrimaryKey(id);
    }

    public void updata(Room room) {
        roomMapper.updateByPrimaryKeySelective(room);
    }

    public void add(Room room) {
        roomMapper.insert(room);
    }


    public void typeDeleted(String id) {
        roomTypeMapper.deleteByPrimaryKey(id);
    }

    public void typeUpdata(RoomType room) {
        roomTypeMapper.updateByPrimaryKeySelective(room);
    }

    public void typeAdd(RoomType room) {
        roomTypeMapper.insert(room);
    }
}
