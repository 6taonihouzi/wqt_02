package zzgs.entity;

import java.util.List;

public class Pagebean<T> {
    private int totalCount;//总数据
    private int totalpage; //总页码数
    private List<T> list;//返回的每页数据
    private int rows;//每页显示的数据数
    private int currentpage;//当前页码

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(int currentpage) {
        this.currentpage = currentpage;
    }

    @Override
    public String toString() {
        return "Pagebean{" +
                "totalCount=" + totalCount +
                ", totalpage=" + totalpage +
                ", list=" + list +
                ", rows=" + rows +
                ", currentpage=" + currentpage +
                '}';
    }
}
