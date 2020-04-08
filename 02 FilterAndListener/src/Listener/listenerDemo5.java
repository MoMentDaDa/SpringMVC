package Listener;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @program: 02
 * @description: 监听对象属性变化，需要JavaEE6才能实现
 * @author: Mr.Wang
 * @create: 2020-03-24 18:45
 **/
@SuppressWarnings("all")
//@WebListener
public class listenerDemo5 implements HttpSessionBindingListener {
    private String name;

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println(name + "被加到session中了");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println(name + "被session踢出来了");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public listenerDemo5(String name) {
        this.name = name;
    }
}
