package cn.itsource.rpms.common.query;

import cn.itsource.basic.query.BaseQuery;

public class PayTypeQuery extends BaseQuery {
    private   String payTypeName;

    public String getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }
}
