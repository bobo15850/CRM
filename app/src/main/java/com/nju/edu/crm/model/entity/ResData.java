package com.nju.edu.crm.model.entity;

/**
 * Created by 张波波 on 2016-06-22.
 */
public class ResData {
    private int resultcode = -1;
    private String resultdesc = "失败";
    private int recordcount;
    private int currentcount;
    private int pagesize;
    private int pagecount;
    private int currentpage;

    public int getResultcode() {
        return resultcode;
    }

    public void setResultcode(int resultcode) {
        this.resultcode = resultcode;
    }

    public String getResultdesc() {
        return resultdesc;
    }

    public void setResultdesc(String resultdesc) {
        this.resultdesc = resultdesc;
    }

    public int getRecordcount() {
        return recordcount;
    }

    public void setRecordcount(int recordcount) {
        this.recordcount = recordcount;
    }

    public int getCurrentcount() {
        return currentcount;
    }

    public void setCurrentcount(int currentcount) {
        this.currentcount = currentcount;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getPagecount() {
        return pagecount;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }

    public int getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(int currentpage) {
        this.currentpage = currentpage;
    }

    @Override
    public String toString() {
        return "ResData{" +
                "resultcode=" + resultcode +
                ", resultdesc='" + resultdesc + '\'' +
                ", recordcount=" + recordcount +
                ", currentcount=" + currentcount +
                ", pagesize=" + pagesize +
                ", pagecount=" + pagecount +
                ", currentpage=" + currentpage +
                '}';
    }
}
