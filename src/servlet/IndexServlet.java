package servlet;

import entity.Img;
import entity.Record;
import util.IndexShowImg;
import util.IndexShowNews;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MSI on 2018/8/3.
 */
//进入页面时首先访问IndexServlet，访问数据库，向index页面传入存有图片的list1和无图片的list2
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String name;
        name = req.getAttribute("name").toString();

        List<Img> list1 = new ArrayList<Img>();
        List<Record> list2 = new ArrayList<Record>();

        IndexShowImg indexShowImg = new IndexShowImg();
        IndexShowNews indexShowNews = new IndexShowNews();

        list1 = indexShowImg.IndexShowImg();
        list2 = indexShowNews.IndexShowNews();

        req.setAttribute("list1", list1);
        req.setAttribute("list2", list2);
        req.setAttribute("name",name);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
