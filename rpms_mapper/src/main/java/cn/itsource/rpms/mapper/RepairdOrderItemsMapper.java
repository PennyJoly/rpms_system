package cn.itsource.rpms.mapper;

import cn.itsource.basic.mapper.BaseMapper;
import cn.itsource.rpms.common.domain.RepairdOrderItems;

import java.io.Serializable;

public interface RepairdOrderItemsMapper extends BaseMapper<RepairdOrderItems> {
    /**
     * 根据 维修单号 mainId，删除关联的明细
     */
    void removeByMainId(Serializable id);

}
