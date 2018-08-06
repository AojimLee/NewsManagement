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


        //获取前端访问后台记录的页数
        page.setCurrentPage(Integer.parseInt(req.getParameter("currentPage")));
        //访问数据库，计算出总的分页页面
        page.setPageAmount(caculatePage.CaculatePage());
        //判断访问页面数是否在正确范围内
        if(page.getCurrentPage()<1){
            page.setCurrentPage(1);
        }else if(page.getCurrentPage()>page.getPageAmount()){
            page.setCurrentPage(page.getPageAmount());
        }
        //将访问内容存取到list中
        list = showPage.ShowPage(page.getCurrentPage());
        //将值传到前台
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
