package servlet;

import dao.AddRecord;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by MSI on 2018/7/31.
 */
@WebServlet("/NewsAddServlet")
public class NewsAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String type = req.getParameter("type");
        String author = req.getParameter("author");
        String content = req.getParameter("content");
        String title = req.getParameter("title");

        AddRecord add = new AddRecord();
        add.AddRecord(author,type,content,title);

        req.getRequestDispatcher("alterSuccessTip.jsp").forward(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
