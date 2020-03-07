package cn.itsource.rpms.common.domain;

import cn.itsource.basic.domain.BaseDomain;

public class PayType extends BaseDomain{
    //支付方式名
     private  String payTypeName;

    public String getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }

    @Override
    public String toString() {
        return "PayType{" +
                "payTypeName='" + payTypeName + '\'' +
                ", id=" + id +
                '}';
    }
}
