package com.hotel.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(generator = "JDBC")
    private Integer employeeId;

    /**
     * 员工名
     */
    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "job_number")
    private String jobNumber;

    @Column(name = "`password`")
    private String password;

    /**
     * 性别
     */
    @Column(name = "sex")
    private Integer sex;

    /**
     * 出生年月
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthday")
    private Date birthday;

    /**
     * 1.一般服务员 2.总台服务员 3.部门 4.经理 5.总经理
     */
    @Column(name = "operating_post")
    private Integer operatingPost;

    /**
     * 工作时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "working_time")
    private Date workingTime;

    /**
     * 考勤
     */
    @Transient
    private Integer checking;

    /**
     * 休假
     */
    @Transient
    private Integer holiday;

    /**
     * 病假
     */
    @Transient
    private Integer stadium;


    public Integer getChecking() {
        return checking;
    }

    public void setChecking(Integer checking) {
        this.checking = checking;
    }

    public Integer getHoliday() {
        return holiday;
    }

    public void setHoliday(Integer holiday) {
        this.holiday = holiday;
    }

    public Integer getStadium() {
        return stadium;
    }

    public void setStadium(Integer stadium) {
        this.stadium = stadium;
    }

    /**
     * @return employee_id
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * 获取员工名
     *
     * @return employee_name - 员工名
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * 设置员工名
     *
     * @param employeeName 员工名
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * @return job_number
     */
    public String getJobNumber() {
        return jobNumber;
    }

    /**
     * @param jobNumber
     */
    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取出生年月
     *
     * @return birthday - 出生年月
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置出生年月
     *
     * @param birthday 出生年月
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取1.一般服务员 2.总台服务员 3.部门 4.经理 5.总经理
     *
     * @return operating_post - 1.一般服务员 2.总台服务员 3.部门 4.经理 5.总经理
     */
    public Integer getOperatingPost() {
        return operatingPost;
    }

    /**
     * 设置1.一般服务员 2.总台服务员 3.部门 4.经理 5.总经理
     *
     * @param operatingPost 1.一般服务员 2.总台服务员 3.部门 4.经理 5.总经理
     */
    public void setOperatingPost(Integer operatingPost) {
        this.operatingPost = operatingPost;
    }

    /**
     * 获取工作时间
     *
     * @return working_time - 工作时间
     */
    public Date getWorkingTime() {
        return workingTime;
    }

    /**
     * 设置工作时间
     *
     * @param workingTime 工作时间
     */
    public void setWorkingTime(Date workingTime) {
        this.workingTime = workingTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", employeeId=").append(employeeId);
        sb.append(", employeeName=").append(employeeName);
        sb.append(", jobNumber=").append(jobNumber);
        sb.append(", password=").append(password);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", operatingPost=").append(operatingPost);
        sb.append(", workingTime=").append(workingTime);
        sb.append("]");
        return sb.toString();
    }
}