package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

// 缓存过滤器,数据缓存到内存
@SuppressWarnings("all")
//@WebFilter("/*")
public class FilterDemo8 implements Filter {
    //定义一个Map集合，key为页面的地址，value为内存的缓存
    private Map<String, byte[]> map = new HashMap<String, byte[]>();

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //得到客户端想要请求的资源
        String uri = request.getRequestURI();
        byte[] bytes = map.get(uri);
        //如果有缓存，直接返回给浏览器就行了，就不用执行目标资源了
        if (bytes != null) {
            response.getOutputStream().write(bytes);
            return;
        }
        //如果没有缓存，就让目标执行
        MyResponse myResponse = new MyResponse(response);
        chain.doFilter(request, myResponse);
        //得到目标资源想要发送给浏览器的数据
        byte[] b = myResponse.getBuffer();
        System.out.println(b);
        //把数据存到集合中
        map.put(uri, b);
        map.forEach((key, value) -> {
            System.out.println(key + ":" + value.toString());
        });
        //把数据返回给浏览器
        response.getOutputStream().write(b);
    }

    class MyResponse extends HttpServletResponseWrapper {
        private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        private PrintWriter printWriter;
        private HttpServletResponse response;

        public MyResponse(HttpServletResponse response) {
            super(response);
            this.response = response;
        }


        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            //这个的ServletOutputSteam对象调用write()方法的时候，把数据是写在byteArrayOutputSteam上的
            return new MyServletOutputStream(byteArrayOutputStream);
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            printWriter = new PrintWriter(new OutputStreamWriter(byteArrayOutputStream, this.response.getCharacterEncoding()));
            return printWriter;
        }

        public byte[] getBuffer() {
            try {
                //防止数据在缓存中，要刷新一下！
                if (printWriter != null) {
                    printWriter.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }


    //增强ServletOutputSteam，让writer方法不把数据直接返回给浏览器
    class MyServletOutputStream extends ServletOutputStream {
        private ByteArrayOutputStream byteArrayOutputStream;

        public MyServletOutputStream(ByteArrayOutputStream byteArrayOutputStream) {
            this.byteArrayOutputStream = byteArrayOutputStream;
        }

        //当调用write()方法的时候，其实是把数据写byteArrayOutputSteam上
        @Override
        public void write(int b) throws IOException {
            this.byteArrayOutputStream.write(b);
        }

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setWriteListener(WriteListener writeListener) {

        }
    }

}
