package cn.itsource.rpms.mapper;

import cn.itsource.basic.mapper.BaseMapper;
import cn.itsource.rpms.common.domain.Menu;

import java.util.List;

/*
*  菜单模块
* */
public interface MenuMapper extends BaseMapper<Menu> {
    //查询所有菜单分页
    List<Menu> findAllMenu();
    //查询所有的父菜单
    List<Menu> parent();
    //删除父菜单对应的中间表
    void deleteBetween(Long id);
    //删除父菜单对应的permission
    void deletePermission(Long id);
    //删除父菜单对应的子菜单
    void deleteChildren(Long id);
    //动态路由
    StringBuilder findAllByPermission();
}
