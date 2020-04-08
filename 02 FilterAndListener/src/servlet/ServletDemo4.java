package servlet;


import Listener.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

// 监听器演示
@SuppressWarnings("all")
@WebServlet("/Servlet4")
public class ServletDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     /*   HttpSession session = req.getSession();
        //往session域对象中添加属性
        session.setAttribute("aa", "bb");
        //替换session域对象中aa属性的值
        session.setAttribute("aa", "xx");
        //移除session域对象中aa属性
        session.removeAttribute("aa");

        //往request域对象中添加属性
        req.setAttribute("aa", "bb");
        //替换request域对象中aa属性的值
        req.setAttribute("aa", "xx");
        //移除request域对象中aa属性
        req.removeAttribute("aa");*/

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        // 处理登录，得到传递过来的数据
        String username = req.getParameter("username");
        User user = new User();
        user.setName(username);
        //标记该用户登陆了！
        req.getSession().setAttribute("user", user);
        //提供界面，告诉用户登陆是否成功
        resp.getWriter().write(username + "登录成功。欢迎光临");
    }
}
