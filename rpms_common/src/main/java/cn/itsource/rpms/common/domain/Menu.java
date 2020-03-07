package cn.itsource.rpms.common.domain;

import cn.itsource.basic.domain.BaseDomain;
/*
*  系统菜单
* */
public class Menu extends BaseDomain {
    //菜单编号
    private String sn;
    //菜单名称
    private String name;
    //图标
    private String icon;
    //地址
    private String url;
    //上级菜单
    private Menu parent_id;
    //简介
    private String intro;
    public Menu(Long id){
        super.setId(id);
    }
    public Menu(){}
    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Menu getParent_id() {
        return parent_id;
    }

    public void setParent_id(Menu parent_id) {
        this.parent_id = parent_id;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", url='" + url + '\'' +
                ", parent_id=" + parent_id +
                ", intro='" + intro + '\'' +
                '}';
    }
}
