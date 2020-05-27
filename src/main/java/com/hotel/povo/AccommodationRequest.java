package com.hotel.povo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import java.util.Date;
import java.util.List;

@Data
public class AccommodationRequest {
    private String name;
    private String phone;
    private String room;
    private Integer sex;
    private List<Date> date;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dates;
    private String  idnumber;

}
