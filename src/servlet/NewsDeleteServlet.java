package servlet;

import dao.DeleteRecord;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by MSI on 2018/7/31.
 */
@WebServlet( "/NewsDeleteServlet")
public class NewsDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        DeleteRecord deleteRecord = new DeleteRecord();
        deleteRecord.DeleteRecord((req.getParameter("id")));
        //此处数据类型需要进行测试

        req.setAttribute("currentPage", req.getParameter("currentPage"));
        req.getRequestDispatcher("NewsManagementServlet").forward(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
