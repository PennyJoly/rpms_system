package cn.itsource.rpms.common.domain;

import cn.itsource.basic.domain.BaseDomain;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class RepairPerson extends BaseDomain {
    //维修员名字
    private String optName;
    //年龄
    private Integer age;
    //邮箱
    private String email;
    //雇佣日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date hireDate = new Date();

    public String getOptName() {
        return optName;
    }

    public void setOptName(String optName) {
        this.optName = optName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
