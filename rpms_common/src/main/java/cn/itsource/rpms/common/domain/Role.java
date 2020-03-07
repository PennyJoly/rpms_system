package cn.itsource.rpms.common.domain;

import cn.itsource.basic.domain.BaseDomain;

import java.util.ArrayList;
import java.util.List;

/*
*  角色模块
* */
public class Role extends BaseDomain {
    //角色名字
    private String name;
    //角色编号
    private String sn;
    //关联的permission
    private List<Permission> permissions=new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
