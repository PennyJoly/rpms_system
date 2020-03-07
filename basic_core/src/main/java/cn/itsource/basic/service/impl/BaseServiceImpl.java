package cn.itsource.basic.service.impl;

import cn.itsource.basic.mapper.BaseMapper;
import cn.itsource.basic.query.BaseQuery;
import cn.itsource.basic.service.IBaseService;
import cn.itsource.basic.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class BaseServiceImpl<T> implements IBaseService<T> {

    @Autowired
    private BaseMapper<T> baseMapper;

    @Override
    @Transactional
    public void save(T t) {
        baseMapper.save(t);
    }

    @Override
    @Transactional
    public void update(T t) {
        baseMapper.update(t);
    }

    @Override
    @Transactional
    public void delete(Serializable id) {
        baseMapper.delete(id);
    }

    @Override
    public void batchDelete(Serializable[] ids) {
        baseMapper.batchDelete(ids);
    }

    @Override
    public List<T> findAll() {
        return baseMapper.findAll();
    }

    @Override
    public T findOne(Serializable id) {
        return baseMapper.findOne(id);
    }

    @Override
    public PageList<T> query(BaseQuery baseQuery) {
        //总条数
        Long total = baseMapper.queryCount(baseQuery);

        //分页后数据
        List<T> rows = baseMapper.queryData(baseQuery);

        return new PageList<T>(total,rows);

    }
}
