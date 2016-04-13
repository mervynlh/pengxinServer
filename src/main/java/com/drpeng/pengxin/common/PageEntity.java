package com.drpeng.pengxin.common;
public class PageEntity {
    private int page = 1;
    private int pageSize = 10;
    private int prePage = 1;
    private int nextPage = 2;
    private int startRow = 1;
    private int maxPage = Integer.MAX_VALUE;

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        if(page <= 0) page=1;
        if(page > maxPage) page = maxPage;
        this.page = page;

        prePage = this.page==1?1:this.page-1;
        nextPage = this.page==maxPage?maxPage:this.page+1;
        startRow = (this.page-1)*pageSize + 1;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        if(pageSize < 3) pageSize = 3;
        if(pageSize > 100) pageSize = 100;
        this.pageSize = pageSize;

        setPage(this.page);
    }
    public int getPrePage() {
        return prePage;
    }
    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }
    public int getNextPage() {
        return nextPage;
    }
    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
    public int getStartRow() {
        return startRow;
    }
    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }
    public int getMaxPage() {
        return maxPage;
    }
    public void setMaxPage(int maxPage) {
        if(maxPage<=0) maxPage = 1;
        this.maxPage = maxPage;
        setPage(page);
    }

}
