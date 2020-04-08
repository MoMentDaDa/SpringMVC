package Listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.*;

/**
 * @program: 02
 * @description: 自定义Session扫描器
 * @author: Mr.Wang
 * @create: 2020-03-24 18:45
 **/
@SuppressWarnings("all")
//@WebListener
public class listenerDemo7 implements ServletContextListener, HttpSessionListener {
    //服务器一启动，就应该创建容器。我们使用的是LinkList(涉及到增删)。容器也应该是线程安全的。
    List<HttpSession> list = Collections.synchronizedList(new LinkedList<HttpSession>());
    //定义一把锁（Session添加到容器和扫描容器这两个操作应该同步起来）
    private Object lock = 1;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Timer timer = new Timer();
        //执行我想要的任务，0秒延时，每10秒执行一次
        timer.schedule(new MyTask(list, lock), 0, 10 * 1000);

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //只要Session一创建了，就应该添加到容器中
        synchronized (lock) {
            list.add(se.getSession());
        }
        System.out.println("Session被创建啦");
        //获取得到Context对象，使用Context域对象保存用户在线的个数
        ServletContext context = se.getSession().getServletContext();
        //直接判断Context对象是否存在这个域，如果存在就人数+1,如果不存在，那么就将属性设置到Context域中
        Integer num = (Integer) context.getAttribute("num");
        if (num == null) {
            context.setAttribute("num", 1);
        } else {
            num++;
            context.setAttribute("num", num);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session被销毁啦。");
        ServletContext context = se.getSession().getServletContext();
        Integer num = (Integer) se.getSession().getAttribute("num");
        if (num == null) {
            context.setAttribute("num", 1);
        } else {
            num--;
            context.setAttribute("num", num);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    //在任务中应该扫描容器，容器在监听器上，只能传递进来了。 要想得到在监听器上的锁，也只能是传递进来
    class MyTask extends TimerTask {
        private List<HttpSession> sessions;
        private Object lock;

        public MyTask(List<HttpSession> sessions, Object lock) {
            this.sessions = sessions;
            this.lock = lock;
        }
        @Override
        public void run() {
            synchronized (lock) {
                //遍历容器
                for (HttpSession session : sessions) {
                    //只要15秒没人使用，我就移除它啦
                    if (System.currentTimeMillis() - session.getLastAccessedTime() > (1000 * 15)) {
                        session.invalidate();
                        sessions.remove(session);
                    }

                }
            }
        }
    }

}
