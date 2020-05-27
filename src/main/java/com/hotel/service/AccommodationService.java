package com.hotel.service;

import com.hotel.domain.*;
import com.hotel.mapper.*;
import com.hotel.povo.AccommodationRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class AccommodationService {

    @Resource
    private AccommodationMapper accommodationMapper;

    @Resource
    private PassengerMapper passengerMapper;

    @Resource
    private RoomMapper roomMapper;

    @Resource
    private RoomTypeMapper roomTypeMapper;

    @Resource
    private BillMapper billMapper;

    public void add(AccommodationRequest request) {
        //添加旅客信息
        System.out.println(request);
        Example example = new Example(Passenger.class);
        example.and().andEqualTo("idnumber", request.getIdnumber());
        Passenger passenger = null;
        passenger = passengerMapper.selectOneByExample(example);
        if (passenger == null) {
            passenger = new Passenger();
            passenger.setName(request.getName());
            passenger.setPhone(request.getPhone());
            passenger.setIdnumber(request.getIdnumber());
            passenger.setRoomId(Integer.parseInt(request.getRoom()));
            passenger.setSex(request.getSex());
            passengerMapper.insert(passenger);
        }

        //处理信息写进住宿表
        Accommodation accommodation = new Accommodation();
        accommodation.setRoomId(Integer.parseInt(request.getRoom()));
        accommodation.setPids(passenger.getPid() + "");
        accommodation.setRoomType("标间");
        accommodation.setPassengerType("国内");
//        String[] split = request.getDate().split("--");
//        try {
//            accommodation.setPutuptime(new SimpleDateFormat("yyyy-MM-dd").parse(split[0]));
//            accommodation.setPutdowntime(new SimpleDateFormat("yyyy-MM-dd").parse(split[1]));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        Room room = roomMapper.selectByPrimaryKey(request.getRoom());
        room.setState(2);
        if (request.getDate() != null&&request.getDate().size() != 0){
            accommodation.setPutuptime(request.getDate().get(0));
            accommodation.setPutdowntime(request.getDate().get(1));
        }else {
            room.setState(3);
            accommodation.setPutuptime(request.getDates());
            request.getDates().setDate(request.getDates().getDate()+1);
            accommodation.setPutdowntime(request.getDates());
        }
        accommodationMapper.insert(accommodation);
        //修改房间状态

        roomMapper.updateByPrimaryKeySelective(room);


    }

    public List<Accommodation> findAll(){
        List<Accommodation> accommodations = accommodationMapper.selectAll();

        for (Accommodation accommodation : accommodations) {
            accommodation.setRoom(roomMapper.selectByPrimaryKey(accommodation.getRoomId()));
            accommodation.setPassenger(passengerMapper.selectByPrimaryKey(accommodation.getPids()));
            RoomType roomType = roomTypeMapper.selectByPrimaryKey(accommodation.getRoomId());
            accommodation.setPrice(roomType.getPrice());
        }
        return accommodations;
    }

    public void editRoomId(Accommodation accommodation){
        //查询原来的对象 把状态修改回空房
        Accommodation accommodation1 = accommodationMapper.selectByPrimaryKey(accommodation);
        Room room = roomMapper.selectByPrimaryKey(accommodation1.getRoomId());
        room.setState(1);
        roomMapper.updateByPrimaryKeySelective(room);
        //查询但前对象修改为满房
        Room room1 = roomMapper.selectByPrimaryKey(accommodation.getRoomId());
        room1.setState(2);
        roomMapper.updateByPrimaryKeySelective(room1);
        //更新
        accommodationMapper.updateByPrimaryKeySelective(accommodation);
    }


    public void checkOut(Integer id){
        Accommodation accommodation1 = accommodationMapper.selectByPrimaryKey(id);
        Room room = roomMapper.selectByPrimaryKey(accommodation1.getRoomId());
        room.setState(1);
        roomMapper.updateByPrimaryKeySelective(room);

        accommodationMapper.deleteByPrimaryKey(id);
    }

    public void check(Integer aid){
        Accommodation accommodation = accommodationMapper.selectByPrimaryKey(aid);
        accommodation.setCheckOut(1);
        accommodationMapper.updateByPrimaryKeySelective(accommodation);

        Room room = roomMapper.selectByPrimaryKey(accommodation.getRoomId());
        RoomType roomType = roomTypeMapper.selectByPrimaryKey(room.getRoomtypeId());

        Bill bill = new Bill();
        bill.setIncome(roomType.getPrice());
        bill.setTime(new Date());
        bill.setDesc("旅客结账");
        billMapper.insertSelective(bill);
    }
}
