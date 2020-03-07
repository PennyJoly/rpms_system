package cn.itsource.rpms.common.query;


import cn.itsource.basic.query.BaseQuery;

public class SettledOrderQuery extends BaseQuery {

    private String custormer;

    private Boolean status=false;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getCustormer() {
        return custormer;
    }

    public void setCustormer(String custormer) {
        this.custormer = custormer;
    }
}
