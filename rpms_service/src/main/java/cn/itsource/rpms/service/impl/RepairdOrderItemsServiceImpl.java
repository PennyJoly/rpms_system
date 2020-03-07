package cn.itsource.rpms.service.impl;

import cn.itsource.basic.service.impl.BaseServiceImpl;
import cn.itsource.rpms.common.domain.RepairdOrderItems;
import cn.itsource.rpms.mapper.RepairdOrderItemsMapper;
import cn.itsource.rpms.service.IRepairdOrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class RepairdOrderItemsServiceImpl extends BaseServiceImpl<RepairdOrderItems> implements IRepairdOrderItemsService {

    @Autowired
    private RepairdOrderItemsMapper repairdOrderItemsMapper;
    @Override
    public void removeByMainId(Serializable id) {
        repairdOrderItemsMapper.removeByMainId(id);
    }
}