package servlet;

import dao.EditorStep1;
import entity.Record;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;

/**
 * Created by MSI on 2018/8/3.
 */
@WebServlet("/EditorStep1Servlet")
public class EditorStep1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String  id= req.getParameter("id");
        EditorStep1 editorStep1 = new EditorStep1();
        Record record = new Record();
        record = editorStep1.EditorStep1(id);
        System.out.println("--------"+record.toString());

        req.setAttribute("record",record);
        req.setAttribute("id",id);
        req.getRequestDispatcher("editorNews.jsp").forward(req,resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
