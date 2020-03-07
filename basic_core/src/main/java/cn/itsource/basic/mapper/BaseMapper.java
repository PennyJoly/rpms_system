package cn.itsource.basic.mapper;


import cn.itsource.basic.query.BaseQuery;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<T> {

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

    //查询总页数
    Long queryCount(BaseQuery basicQuery);

    //查询分页的所有数据
    List<T> queryData(BaseQuery basicQuery);
}
