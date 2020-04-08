package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//禁用 web 缓存和编码过滤器
@SuppressWarnings("all")
//@WebFilter("/*")
public class FilterDemo2 implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        //让Web资源不缓存，很简单，设置http中response的请求头即可了！
        //我们使用的是http协议，ServletResponse并没有能够设置请求头的方法，所以要强转成HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
      /*  System.out.println("设置禁用浏览器动态缓存");
        response.setDateHeader("Expires", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");*/
        System.out.println("设置编码");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //放行目标资源的response已经设置成不缓存的了
        filterChain.doFilter(request, response);

    }
}
