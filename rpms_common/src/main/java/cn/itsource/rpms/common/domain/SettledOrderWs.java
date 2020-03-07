package cn.itsource.rpms.common.domain;

import cn.itsource.basic.domain.BaseDomain;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户可查询的结算单domain
 */
public class SettledOrderWs extends BaseDomain {
    //客户姓名
    private String custormer;
    //支付金额
    private BigDecimal pay_amout;
    //结算时间
    private Date settedTime;
    //送车地址
    private String address;

    //维修单id
    private Long mainid;

    public Long getMainid() {
        return mainid;
    }

    public void setMainid(Long mainid) {
        this.mainid = mainid;
    }

    public String getCustormer() {
        return custormer;
    }

    public void setCustormer(String custormer) {
        this.custormer = custormer;
    }

    public BigDecimal getPay_amout() {
        return pay_amout;
    }

    public void setPay_amout(BigDecimal pay_amout) {
        this.pay_amout = pay_amout;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date getSettedTime() {
        return settedTime;
    }

    public void setSettedTime(Date settedTime) {
        this.settedTime = settedTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SettledOrderWs{" +
                "custormer='" + custormer + '\'' +
                ", pay_amout=" + pay_amout +
                ", settedTime=" + settedTime +
                ", address='" + address + '\'' +
                ", mainid=" + mainid +
                "} ";
    }
}
