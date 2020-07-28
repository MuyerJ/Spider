package com.muyer.httpclient.model;

/**
 * Description:
 *  博客园实体
 * <br/>
 * date: 2020/7/28 23:54<br/>
 *
 * @author MuyerJ<br   />
 */
public class CnBlogModel {
    //博主名字
    private String name;

    //博客地址
    private String url;

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
        return "CnBlogModel{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
