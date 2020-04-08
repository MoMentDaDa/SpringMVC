package Listener;


import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/**
 * @program: 02
 * @description: 监听对象属性变化，需要JavaEE6才能实现
 * @author: Mr.Wang
 * @create: 2020-03-24 18:45
 **/
@SuppressWarnings("all")
//@WebListener
public class listenerDemo6 implements HttpSessionActivationListener, Serializable {


    private static final long serialVersionUID = 7589841135210272124L;
    private String name;

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {

        System.out.println(name + "和session一起被序列化(钝化)到硬盘了，session的id是：" + se.getSession().getId());
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println(name + "和session一起从硬盘反序列化(活化)回到内存了，session的id是：" + se.getSession().getId());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public listenerDemo6(String name) {
        this.name = name;
    }
}
