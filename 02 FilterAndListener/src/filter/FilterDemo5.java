package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

// 敏感词过滤器
@SuppressWarnings("all")
//@WebFilter("/*")
public class FilterDemo5 implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //将request和response强转成http协议的
        System.out.println("这是敏感词过滤器");
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        MyDirtyRequest dirtyRequest = new MyDirtyRequest(httpServletRequest);
        //传送给目标资源的是被增强后的request对象
        chain.doFilter(dirtyRequest, httpServletResponse);
    }

    class MyDirtyRequest extends HttpServletRequestWrapper {
        HttpServletRequest request;
        //定义一堆敏感词汇
        private List<String> list = Arrays.asList("傻b", "尼玛", "操蛋");

        public MyDirtyRequest(HttpServletRequest request) {
            super(request);
            this.request = request;
        }

        @Override
        public String getParameter(String name) {
            String value = this.request.getParameter(name);
            if (value == null) {
                return null;
            }

            //遍历list集合，看看获取得到的数据有没有敏感词汇
            for (String s : list) {

                if (s.equals(value)) {
                    value = "*****";
                }
            }
            return value;
        }
    }
}
