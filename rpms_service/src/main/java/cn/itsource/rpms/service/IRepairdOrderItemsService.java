package cn.itsource.rpms.service;


import cn.itsource.basic.service.IBaseService;
import cn.itsource.rpms.common.domain.RepairdOrderItems;

import java.io.Serializable;

public interface IRepairdOrderItemsService extends IBaseService<RepairdOrderItems> {

    /**
     * 根据 维修单号 mainId，删除关联的明细
     */
    void removeByMainId(Serializable id);
}
