package servlet;


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
@WebServlet("/Servlet5")
public class ServletDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        //得到装载所有的Session的容器
        Map map = (Map) this.getServletContext().getAttribute("map");
        //通过名字得到Session
        HttpSession httpSession = (HttpSession) map.get(username);
        httpSession.invalidate();
        map.remove(username);
        //摧毁完Session后，返回列出在线用户页面
        request.getRequestDispatcher("/listUser.jsp").forward(request, response);

    }
}
