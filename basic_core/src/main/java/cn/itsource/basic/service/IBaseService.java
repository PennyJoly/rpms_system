package cn.itsource.basic.service;

import cn.itsource.basic.query.BaseQuery;
import cn.itsource.basic.util.PageList;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<T> {
    //保存
    void save(T t);

    //修改
    void update(T t);

    //删除
    void delete(Serializable id);

    //批量删除
    void batchDelete(Serializable[] ids);

    //查询所有
    List<T> findAll();

    //查询单个
    T findOne(Serializable id);

    PageList<T> query(BaseQuery basicQuery);
}
