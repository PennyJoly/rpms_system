package cn.itsource.rpms.common.query;


import cn.itsource.basic.query.BaseQuery;

public class RepairdOrderQuery extends BaseQuery {
    //车牌号
    private String carNum;

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }
}
