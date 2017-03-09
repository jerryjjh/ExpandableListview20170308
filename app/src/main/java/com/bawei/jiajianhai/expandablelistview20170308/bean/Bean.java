package com.bawei.jiajianhai.expandablelistview20170308.bean;

import java.util.List;

/**
 * Created by my on 2017/3/9.
 */

public class Bean {

    /**
     * code : 200
     * data : [{"datas":[{"add_time":"2016-12-10 14:54:58","cart_id":"445162","house_id":"1","msg":"购买渠道:大陆国行","price":500,"type_name":"苹果 iPhone 6（白金色）","type_sn_id":"ggh"},{"add_time":"2016-12-10 14:55:18","cart_id":"445163","house_id":"1","msg":"购买渠道:水货无锁","price":1000,"type_name":"苹果 iPhone 7 （亮黑色）","type_sn_id":"tgg"}],"title":"苹果","title_id":"59280"},{"datas":[{"add_time":"2016-12-10 14:54:58","cart_id":"445162","house_id":"1","msg":"边框背板:全新未使用","price":50,"type_name":"小米4s (白金色)","type_sn_id":"ggh"},{"add_time":"2016-12-10 14:55:18","cart_id":"445163","house_id":"1","msg":"屏幕性能:色差/亮点/轻微发黄","price":100,"type_name":"小米5s （亮黑色）","type_sn_id":"tgg"}],"title":"小米","title_id":"59279"},{"datas":[{"add_time":"2016-12-10 14:54:58","cart_id":"445162","house_id":"1","msg":"边框背板:全新未使用","price":50,"type_name":"三星 (白金色)","type_sn_id":"ggh"},{"add_time":"2016-12-10 14:55:18","cart_id":"445163","house_id":"1","msg":"屏幕性能:色差/亮点/轻微发黄","price":100,"type_name":"三星 （亮黑色）","type_sn_id":"tgg"}],"title":"三星","title_id":"59279"},{"datas":[{"add_time":"2016-12-10 14:54:58","cart_id":"445162","house_id":"1","msg":"边框背板:全新未使用","price":50,"type_name":"华为 (白金色)","type_sn_id":"ggh"},{"add_time":"2016-12-10 14:55:18","cart_id":"445163","house_id":"1","msg":"屏幕性能:色差/亮点/轻微发黄","price":100,"type_name":"华为 （亮黑色）","type_sn_id":"tgg"},{"add_time":"2016-12-10 4:55:28","cart_id":"445164","house_id":"1","msg":"屏幕性能:色差/亮点/轻微发黄","price":150,"type_name":"华为 （纯黑色）","type_sn_id":"hgg"}],"title":"华为","title_id":"59279"}]
     * flag : Success
     * msg : 描述
     */

    private String code;
    private String flag;
    private String msg;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }
}
