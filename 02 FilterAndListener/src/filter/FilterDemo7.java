package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Html转义过滤器

@SuppressWarnings("all")
//@WebFilter("/*")
public class FilterDemo7 implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        //进行强转
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        // 给后台传递一个增强后的request
        MyHtmlRequest myrequest = new MyHtmlRequest(request);
        System.out.println("这是转义过滤器");
        chain.doFilter(myrequest, response);

    }

    class MyHtmlRequest extends HttpServletRequestWrapper {
        private HttpServletRequest request;

        public MyHtmlRequest(HttpServletRequest request) {
            super(request);
            this.request = request;
        }

        @Override
        public String getParameter(String name) {
            String value = this.request.getParameter(name);
            return this.Filter(value);

        }

        public String Filter(String message) {
            if (message == null) {
                return (null);
            }
            char content[] = new char[message.length()];
            message.getChars(0, message.length(), content, 0);
            StringBuffer result = new StringBuffer(content.length + 50);
            for (int i = 0; i < content.length; i++) {
                switch (content[i]) {
                    case '<':
                        result.append("&lt;");
                        break;
                    case '>':
                        result.append("&gt;");
                        break;
                    case '&':
                        result.append("&amp;");
                        break;
                    case '"':
                        result.append("&quot;");
                        break;
                    default:
                        result.append(content[i]);
                }
            }
            return (result.toString());
        }

    }
}
