package org.liuchang.bean.finance;

/**
 * 查询相关参数
 * Created by liuchang on 2016/4/7.
 */
public class SearchData {

    private String startTime;
    private String endTime;
    private String type;
    private String name;
    private String page_type;
    private String is_search;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPage_type() {
        return page_type;
    }

    public void setPage_type(String page_type) {
        this.page_type = page_type;
    }

    public String getIs_search() {
        return is_search;
    }

    public void setIs_search(String is_search) {
        this.is_search = is_search;
    }
}
