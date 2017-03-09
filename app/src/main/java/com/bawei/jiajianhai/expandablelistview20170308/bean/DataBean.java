package com.bawei.jiajianhai.expandablelistview20170308.bean;

import java.util.List;

/**
 * Created by my on 2017/3/9.
 */
public class DataBean {
    /**
     * datas : [{"add_time":"2016-12-10 14:54:58","cart_id":"445162","house_id":"1","msg":"购买渠道:大陆国行","price":500,"type_name":"苹果 iPhone 6（白金色）","type_sn_id":"ggh"},{"add_time":"2016-12-10 14:55:18","cart_id":"445163","house_id":"1","msg":"购买渠道:水货无锁","price":1000,"type_name":"苹果 iPhone 7 （亮黑色）","type_sn_id":"tgg"}]
     * title : 苹果
     * title_id : 59280
     */

    private String title;
    private String title_id;
    private List<DatasBean> datas;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_id() {
        return title_id;
    }

    public void setTitle_id(String title_id) {
        this.title_id = title_id;
    }

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }
}
