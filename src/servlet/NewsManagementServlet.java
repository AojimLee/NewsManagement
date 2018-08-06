package servlet;

import entity.Page;
import entity.Record;
import util.CaculatePage;
import util.ShowPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MSI on 2018/7/30.
 */
@WebServlet(urlPatterns = "/NewsManagementServlet")
public class NewsManagementServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        Page page = new Page();
        CaculatePage caculatePage = new CaculatePage();
        List<Record> list = new ArrayList<Record>();
        ShowPage showPage = new ShowPage();


        //��ȡǰ�˷��ʺ�̨��¼��ҳ��
        page.setCurrentPage(Integer.parseInt(req.getParameter("currentPage")));
        //�������ݿ⣬������ܵķ�ҳҳ��
        page.setPageAmount(caculatePage.CaculatePage());
        //�жϷ���ҳ�����Ƿ�����ȷ��Χ��
        if(page.getCurrentPage()<1){
            page.setCurrentPage(1);
        }else if(page.getCurrentPage()>page.getPageAmount()){
            page.setCurrentPage(page.getPageAmount());
        }
        //���������ݴ�ȡ��list��
        list = showPage.ShowPage(page.getCurrentPage());
        //��ֵ����ǰ̨
        req.setAttribute("list", list);
        req.setAttribute("currentPage", page.getCurrentPage());
        req.setAttribute("pageAmount", page.getPageAmount());
        req.getRequestDispatcher("management.jsp").forward(req, resp);
}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
