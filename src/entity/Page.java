package entity;

/**
 * Created by MSI on 2018/7/29.
 */
public class Page {
    //�ܼ�¼��
    private int recordNum;
    //ҳ��洢��������
    public int pageSize = 10;
    //��ҳ��
    private int pageAmount;
    //��ǰҳ����
    private int currentPage =1;

    public int getRecordNum() {return recordNum;}

    public void setRecordNum(int recordNum) {this.recordNum = recordNum;}

    public int getPageAmount() {return pageAmount;}

    public void setPageAmount(int pageAmount) {this.pageAmount = pageAmount;}

    public int getCurrentPage() {return currentPage;}

    public void setCurrentPage(int currentPage) {this.currentPage = currentPage;}
}
