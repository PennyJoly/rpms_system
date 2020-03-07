package cn.itsource.rpms.common.domain;

import cn.itsource.basic.domain.BaseDomain;

public class Resource extends BaseDomain {
    //资源名称
    public String name;
    //资源地址 访问地址
    public String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
