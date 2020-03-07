package cn.itsource.rpms.common.query;


import cn.itsource.basic.query.BaseQuery;

public class RepairdOrderItemsQuery extends BaseQuery {
    //根据维修单id动态加载维修单明细数据
    private Long mainId;

    public Long getMainId() {
        return mainId;
    }

    public void setMainId(Long mainId) {
        this.mainId = mainId;
    }
}
