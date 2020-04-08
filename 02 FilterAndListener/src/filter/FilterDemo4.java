package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.*;
import java.util.zip.GZIPOutputStream;

// 全站资源压缩过滤器
@SuppressWarnings("all")
//@WebFilter("/*")
public class FilterDemo4 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("增强过滤器");
        // 把增强版的resp放行到servlet中去用(让后台把数据写到 baout中 )
        MyResponse myResp = new MyResponse((HttpServletResponse) response);
        //System.out.println("开始放行");
        chain.doFilter(request, myResp);// 放行--让后台去写，回来直接开始执行后面的语句。
        // System.out.println("已放行");
        // 从增强版的resp的baout中(存放的是源字节数据)，把数据取出来进行压缩，然后再压缩后的数据用原生的response输出到客户端
        ByteArrayOutputStream baout = myResp.getBaout();
        byte bs[] = baout.toByteArray();// 源字节数据
        System.out.println("压缩前大小:" + bs.length);
        ByteArrayOutputStream baout2 = new ByteArrayOutputStream();
        GZIPOutputStream gout = new GZIPOutputStream(baout2);
        gout.write(bs);// 把数据压缩到baout中
        gout.close();
        bs = baout2.toByteArray();
        System.out.println("压缩后大小:" + bs.length);
        // 输出之前告诉客户端:我们的数据是gzip格式，调用原有的response 输出
        HttpServletResponse httpResp = (HttpServletResponse) response;
        //System.out.println(httpResp.getClass().getName());
        httpResp.setHeader("Content-Encoding", "gzip");
        httpResp.setContentLength(bs.length);
        OutputStream out = httpResp.getOutputStream();
        out.write(bs);
    }

    class MyResponse extends HttpServletResponseWrapper {
        public MyResponse(HttpServletResponse response) {
            super(response);
        }

        // 字节数组流，用于存储写出的数据
        private ByteArrayOutputStream baout = new ByteArrayOutputStream();

        //重写获取字节输出流的方法
        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            return new MyOutputStream(baout);
        }

        //从后台响应的Resp 的缓存中取出数据并返回
        public ByteArrayOutputStream getBaout() {
            if (pw != null) {
                pw.flush();
                //这里很重要，如果不flush或close，不把字符流刷出去，baout中是不会有数据的.
            }
            return baout;
        }

        //字符输出
        private PrintWriter pw;

        //重写字符输出的放阿飞
        @Override
        public PrintWriter getWriter() throws IOException {
            pw = new PrintWriter(new OutputStreamWriter(baout, "utf-8"), true);
            return pw;
        }
    }

    //  返回我自己定义的 MyOutputStream，字节输出方法
    class MyOutputStream extends ServletOutputStream {
        //字节数组流
        private ByteArrayOutputStream baout = null;

        public MyOutputStream(ByteArrayOutputStream baout) {
            this.baout = baout;
        }

        //重写write 方法，将数据写入到自己定义的数组里面，即 baout
        @Override
        public void write(int b) throws IOException {
            baout.write(b);
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
