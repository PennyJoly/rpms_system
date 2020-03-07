package cn.itsource.rpms.service;


import cn.itsource.basic.query.BaseQuery;
import cn.itsource.basic.service.IBaseService;
import cn.itsource.basic.util.PageList;
import cn.itsource.rpms.common.domain.SettledOrder;

public interface ISettledOrderService extends IBaseService<SettledOrder> {
    void updateStatusAndSave(SettledOrder settledOrder);
}
