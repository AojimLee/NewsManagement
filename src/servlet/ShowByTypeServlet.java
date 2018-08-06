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
@WebServlet("/ShowByTypeServlet")
public class ShowByTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String type = req.getParameter("type");
        String sql = "select * from news where type ='" + type + "'";

        List<Record> list = new ArrayList<Record>();
        ShowNews showNews = new ShowNews();
        list = showNews.ShowNews(sql);

        req.setAttribute("list", list);
        req.getRequestDispatcher("showNews.jsp").forward(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
