package Listener;


import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: 02
 * @description: 踢人案例
 * @author: Mr.Wang
 * @create: 2020-03-24 18:45
 **/
@SuppressWarnings("all")
@WebListener
public class listenerDemo8 implements HttpSessionAttributeListener {
    public listenerDemo8() {
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        System.out.println("加入新的属性");
        //得到context对象，看看context对象是否有容器装载Session
        ServletContext context = sbe.getSession().getServletContext();
        //如果没有，就创建一个呗
        Map userMap = (Map) context.getAttribute("map");
        if (userMap == null) {
            userMap = new HashMap();
            context.setAttribute("map", userMap);
        }
        userMap.forEach((keys, s) -> {
            System.out.println(keys + ":" + s);
        });
        //得到Session属性的值
        Object o = sbe.getValue();
        //判断属性的内容是否是User对象
        if (o instanceof User) {
            User user = (User) o;
            userMap.put(user.getName(), sbe.getSession());
        }
        userMap.forEach((keys, s) -> {
            System.out.println(keys + ":" + s);
        });
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {

    }

}
