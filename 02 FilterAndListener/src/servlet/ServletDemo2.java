package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

// 转义处理
@WebServlet("/Servlet2")
public class ServletDemo2 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //以下是数据压缩
        /*String str = "网页压缩数据hncuhdncu网页压缩数据hncuh数据hncuhdncu网页压缩数据hncuh数据hncuhdncu网页压缩数据hncuhdncu网页压缩数据hncuhdncu";
        System.out.println(response.getClass().getName());
        System.out.println("原大小:" + str.getBytes("utf-8").length);

        System.out.println("这是字节输出");
        OutputStream out = response.getOutputStream();
        out.write(str.getBytes("utf-8"));

        System.out.println("这是字符输出");
        //System.out.println("原大小:" + str.getBytes("utf-8").length);
        PrintWriter out = response.getWriter();
        out.println(str);
        out.close();*/

        // 获取用户输入的内容
        String username = request.getParameter("username");
        String message = request.getParameter("message");
        response.getWriter().write("您上次的留言是：<br/>" + username + message);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
