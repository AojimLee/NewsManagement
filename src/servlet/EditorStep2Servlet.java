package servlet;

import dao.EditorStep2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by MSI on 2018/8/3.
 */
@WebServlet("/EditorStep2Servlet")
public class EditorStep2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String id = req.getParameter("id");
        String content = req.getParameter("content");
        String type = req.getParameter("type");
        String author = req.getParameter("author");
        String title = req.getParameter("title");

        EditorStep2 editorStep2 = new EditorStep2();
        editorStep2.EditorStep2(id,content,author,title,type);

        req.getRequestDispatcher("alterSuccessTip.jsp").forward(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
