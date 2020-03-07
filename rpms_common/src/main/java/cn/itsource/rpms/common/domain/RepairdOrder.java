package cn.itsource.rpms.common.domain;

import cn.itsource.basic.domain.BaseDomain;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class RepairdOrder extends BaseDomain {
    //客户名称
    private String custormer;
    //车牌号
    private String carNum;
    //维修单创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    //维修单状态
    private Boolean status;
    //客户地址
    private String address;
    //维修人员外键
    private RepairPerson repairPerson;
    //维修单明细
    private List<RepairdOrderItems> repairdOrderItems;

    public List<RepairdOrderItems> getRepairdOrderItems() {
        return repairdOrderItems;
    }

    public void setRepairdOrderItems(List<RepairdOrderItems> repairdOrderItems) {
        this.repairdOrderItems = repairdOrderItems;
    }

    public String getCustormer() {
        return custormer;
    }

    public void setCustormer(String custormer) {
        this.custormer = custormer;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RepairPerson getRepairPerson() {
        return repairPerson;
    }

    public void setRepairPerson(RepairPerson repairPerson) {
        this.repairPerson = repairPerson;
    }

    @Override
    public String toString() {
        return "RepairdOrder{" +
                "custormer='" + custormer + '\'' +
                ", carNum='" + carNum + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                ", address='" + address + '\'' +
                ", repairPerson=" + repairPerson +
                ", repairdOrderItems=" + repairdOrderItems +
                ", id=" + id +
                '}';
    }
}
