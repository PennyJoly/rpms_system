package cn.itsource.rpms.common.domain;

import cn.itsource.basic.domain.BaseDomain;

public class Permission extends BaseDomain {
    //权限名称
    private String name;
    //资源地址
    private String sn;
    //关联的menu对象  菜单的名称
    private Menu mn;
    //前台传过来的
    private Long menu;

    public Long getMenu() {
        return menu;
    }
    public void setMenu(Long menu) {
        this.menu = menu;
    }

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


    public Menu getMn() {
        return mn;
    }

    public void setMn(Menu mn) {
        this.mn = mn;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "name='" + name + '\'' +
                ", sn='" + sn + '\'' +
                ", mn=" + mn +
                '}';
    }
}
