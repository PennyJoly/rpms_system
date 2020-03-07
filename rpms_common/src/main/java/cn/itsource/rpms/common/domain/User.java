package cn.itsource.rpms.common.domain;

import cn.itsource.basic.domain.BaseDomain;

/**
 * 用户domain
 */
public class User extends BaseDomain {
    //用户名
    private String name;
    //登陆密码
    private String password;
    //头像
    private String imgUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", id=" + id +
                '}';
    }
}
