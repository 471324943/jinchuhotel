package com.hotel.service;

import com.hotel.domain.Checking;
import com.hotel.domain.Employee;
import com.hotel.mapper.CheckingMapper;
import com.hotel.povo.ChekingVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.hotel.mapper.EmployeeMapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    @Resource
    private CheckingMapper checkingMapper;

    public Employee login(String employeeName) {
        Example example = new Example(Employee.class);
        example.createCriteria().andEqualTo("jobNumber", employeeName);
        List<Employee> adminList = employeeMapper.selectByExample(example);
        return adminList.size() > 0 ? adminList.get(0) : null;
    }

    public List<Employee> findAll() {
        List<Employee> employees = employeeMapper.selectAll();
        for (Employee employee : employees) {
            List<ChekingVo> cheking = checkingMapper.getCheking(employee.getEmployeeId());
            for (ChekingVo chekingVo : cheking) {
                switch (chekingVo.getStatus()) {
                    case 1:
                        employee.setChecking(chekingVo.getNum());
                        break;
                    case 2:
                        employee.setHoliday(chekingVo.getNum());
                        break;
                    case 3:
                        employee.setStadium(chekingVo.getNum());
                        break;
                }
            }
            employee.setChecking(employee.getChecking()==null?0:employee.getChecking());
            employee.setHoliday(employee.getHoliday()==null?0:employee.getHoliday());
            employee.setStadium(employee.getStadium()==null?0:employee.getStadium());
        }
        return employees;
    }

    public void deleted(String id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    public void updata(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public void add(Employee employee) {
        employeeMapper.insert(employee);
    }
}

