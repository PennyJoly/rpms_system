package cn.itsource.rpms.mapper;


import cn.itsource.basic.mapper.BaseMapper;
import cn.itsource.basic.query.BaseQuery;
import cn.itsource.basic.util.PageList;
import cn.itsource.rpms.common.domain.RepairdOrder;
import cn.itsource.rpms.common.domain.SettledOrder;
import cn.itsource.rpms.common.query.SettledOrderQuery;

/**
 * 结算工单明细mapper
 */
public interface SettledOrderMapper extends BaseMapper<SettledOrder> {
    void updateStatus(SettledOrder settledOrder);
}
