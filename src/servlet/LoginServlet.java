package servlet;

import com.sun.deploy.net.HttpResponse;
import entity.User;
import util.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by MSI on 2018/7/31.
 */

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        Login login = new Login();
        if(login.Login(req.getParameter("email"),req.getParameter("password"))){
            System.out.println("---------"+login.getName(req.getParameter("email")));
            req.setAttribute("name", login.getName(req.getParameter("email")));
            req.getRequestDispatcher("/IndexServlet").forward(req, resp);
        }else{
            String wrongWarning = "您输入的账号或密码不正确";
            req.setAttribute("wrongWarning", wrongWarning);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
