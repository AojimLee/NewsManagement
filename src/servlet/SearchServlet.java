package servlet;

import entity.Record;
import util.ShowNews;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MSI on 2018/8/2.
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String search = req.getParameter("search");

        String sql = "select * from news where author like '%" + search +
                "%' or time like '%" + search + "%' or content like '%" + search +
                "%' or title like '%" + search + "%'";
        ShowNews showNews = new ShowNews();
        List<Record> list = new ArrayList<Record>();
        list = showNews.ShowNews(sql);

        req.setAttribute("list", list);
        req.getRequestDispatcher("showNews.jsp").forward(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
