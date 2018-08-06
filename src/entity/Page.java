package entity;

/**
 * Created by MSI on 2018/7/29.
 */
public class Page {
    //总记录数
    private int recordNum;
    //页面存储数据条数
    public int pageSize = 10;
    //总页数
    private int pageAmount;
    //当前页面数
    private int currentPage =1;

    public int getRecordNum() {return recordNum;}

    public void setRecordNum(int recordNum) {this.recordNum = recordNum;}

    public int getPageAmount() {return pageAmount;}

    public void setPageAmount(int pageAmount) {this.pageAmount = pageAmount;}

    public int getCurrentPage() {return currentPage;}

    public void setCurrentPage(int currentPage) {this.currentPage = currentPage;}
}
