package servlet;

import dao.AlterRecord;
import entity.Record;
import util.GetTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by MSI on 2018/8/1.
 */
@WebServlet("/NewsAlterServlet")
public class NewsAlterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        Record record = new Record();
        GetTime getTime = new GetTime();

        record.setId(Integer.parseInt(req.getParameter("id")));//获取序列号作为索引，不及进行修改操作
        record.setType(req.getParameter("type"));
        record.setAuthor(req.getParameter("author"));
        record.setTitle(req.getParameter("title"));
        record.setAlterTime(getTime.GetTime());

        AlterRecord alter = new AlterRecord();
        alter.AlterRecord(record);

        req.getRequestDispatcher("alterSuccessTip.jsp").forward(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
