package servlet;

import entity.Manager;
import util.ManagerLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by MSI on 2018/8/2.
 */
@WebServlet("/ManagerLoginServlet")
public class ManagerLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        Manager manager = new Manager();
        ManagerLogin managerLogin = new ManagerLogin();

        manager.setEmail(req.getParameter("email"));
        manager.setPassword(req.getParameter("password"));

        if(managerLogin.ManagerLogin(manager.getEmail(),manager.getPassword())){
            manager.setName(managerLogin.GetName(manager.getEmail()));
            req.setAttribute("name",manager.getName());
            req.getRequestDispatcher("managerLoginSuccessTip.jsp").forward(req, resp);
        }else{
            String wrongWarning = "您输入的账号或密码不正确";
            req.setAttribute("wrongWarning", wrongWarning);
            req.getRequestDispatcher("managerLogin.jsp").forward(req, resp);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
