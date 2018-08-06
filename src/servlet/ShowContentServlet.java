package servlet;

import entity.Record;
import util.ShowContent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by MSI on 2018/8/2.
 */
@WebServlet("/ShowContentServlet")
public class ShowContentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String id= req.getParameter("id");
        Record record = new Record();
        ShowContent showContent = new ShowContent();

        record = showContent.ShowContent(id);

        req.setAttribute("record",record);
        req.getRequestDispatcher("showContent.jsp").forward(req,resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
