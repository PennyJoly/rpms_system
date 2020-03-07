package cn.itsource.rpms.service.impl;

import cn.itsource.basic.query.BaseQuery;
import cn.itsource.basic.service.impl.BaseServiceImpl;
import cn.itsource.basic.util.PageList;
import cn.itsource.rpms.common.domain.SettledOrder;
import cn.itsource.rpms.mapper.SettledOrderMapper;
import cn.itsource.rpms.service.ISettledOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SettledOrderServiceImpl extends BaseServiceImpl<SettledOrder> implements ISettledOrderService {

    @Autowired
    private SettledOrderMapper settledOrderMapper;

    @Override
    public void updateStatusAndSave(SettledOrder settledOrder) {
        //更新维修工单状态
        settledOrderMapper.updateStatus(settledOrder);
        //保存
        settledOrder.setSettedTime(new Date());
        super.save(settledOrder);
    }


}
