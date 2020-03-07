package cn.itsource.rpms.common.domain;

import cn.itsource.basic.domain.BaseDomain;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 结算工单明细domain
 */
public class SettledOrder extends BaseDomain {
    private String custormer;
    //结算时间
    private Date settedTime = new Date();
    //应付金额
    private BigDecimal re_amount;
    //实付金额
    private BigDecimal pay_amout;
    //地址
    private String address;
    //维修工单
    private RepairdOrder main;
    //支付方式
    private PayType pay;

    @JsonFormat(pattern="yyyy-MM-dd")
    public Date getSettedTime() {
        return settedTime;
    }

    public void setSettedTime(Date settedTime) {
        this.settedTime = settedTime;
    }

    public String getCustormer() {
        return custormer;
    }

    public void setCustormer(String custormer) {
        this.custormer = custormer;
    }

    public BigDecimal getRe_amount() {
        return re_amount;
    }

    public void setRe_amount(BigDecimal re_amount) {
        this.re_amount = re_amount;
    }

    public BigDecimal getPay_amout() {
        return pay_amout;
    }

    public void setPay_amout(BigDecimal pay_amout) {
        this.pay_amout = pay_amout;
    }

    public RepairdOrder getMain() {
        return main;
    }

    public void setMain(RepairdOrder main) {
        this.main = main;
    }

    public PayType getPay() {
        return pay;
    }

    public void setPay(PayType pay) {
        this.pay = pay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SettledOrder{" +
                "custormer='" + custormer + '\'' +
                ", settedTime=" + settedTime +
                ", re_amount=" + re_amount +
                ", pay_amout=" + pay_amout +
                ", address='" + address + '\'' +
                ", main=" + main +
                ", pay=" + pay +
                ", id=" + id +
                '}';
    }
}
