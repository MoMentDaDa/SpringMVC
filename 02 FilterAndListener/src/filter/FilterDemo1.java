package filter;

import javax.servlet.*;
import java.io.IOException;

/*@SuppressWarnings("all")
@WebFilter("/*")            //访问所有资源之前，都会执行该过滤器
@WebFilter("/index.jsp")    //1. 具体资源路径： /index.jsp   只有访问index.jsp资源时，过滤器才会被执行
@WebFilter("/user/*")       //2. 拦截目录： /user/*	访问/user下的所有资源时，过滤器都会被执行
@WebFilter("*.jsp")         //3. 后缀名拦截： *.jsp		访问所有后缀名为jsp资源时，过滤器都会被执行*/


/*//浏览器直接请求index.jsp资源时，该过滤器会被执行
@WebFilter(value="/index.jsp",dispatcherTypes = DispatcherType.REQUEST)
//只有转发访问index.jsp时，该过滤器才会被执行
@WebFilter(value="/index.jsp",dispatcherTypes = DispatcherType.FORWARD)

//浏览器直接请求index.jsp或者转发访问index.jsp。该过滤器才会被执行
@WebFilter(value="/*",dispatcherTypes ={ DispatcherType.FORWARD,DispatcherType.REQUEST})*/

/**
 * 认识过滤器
 *
 * @author MoMent
 */
@SuppressWarnings("all")
//@WebFilter("/*")
public class FilterDemo1 implements Filter {
    //在服务器启动后，会创建Filter对象，然后调用init方法。只执行一次。用于加载资源
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("拦截器初始化 init....");
        filterConfig.getInitParameter("name");

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        //对request对象请求消息增强
        System.out.println("filterDemo 执行了....");
        //放行
        filterChain.doFilter(req, resp);
        //对response对象的响应消息增强
        System.out.println("filterDemo 回来了...");

    }

    // 在服务器关闭后，Filter对象被销毁。如果服务器是正常关闭，则会执行destroy方法。只执行一次。用于释放资源
    @Override
    public void destroy() {
        System.out.println("拦截器被destroy....");

    }
}
