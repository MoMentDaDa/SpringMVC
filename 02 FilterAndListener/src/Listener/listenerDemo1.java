package Listener;

import org.junit.jupiter.api.Test;

/**
 * @program: 02
 * @description: 模拟监听器
 * @author: Mr.Wang
 * @create: 2020-03-24 18:45
 **/
@SuppressWarnings("all")
public class listenerDemo1 {
    @Test
    public void test1() {
        Person person = new Person();
        //注册监听器()
        person.registerLister(new listenerDemo1() {
            public void doEat(Event event) {
            }
            public void doSleep(Event event) {
            }
        });
        //当调用eat方法时，触发事件，将事件对象传递给监听器，最后监听器获得事件源，对事件源进行操作
        person.Eat();
    }

    private void doEat(Event event) {
        Person person1 = event.getResource();
        System.out.println(person1 + "正在吃饭呢！");

    }

    private void doSleep(Event event) {
        Person person1 = event.getResource();
        System.out.println(person1 + "正在睡觉呢！");
    }

    class Person {
        //在成员变量定义一个监听器对象
        private listenerDemo1 personListener;
        //在事件源中定义两个方法
        public void Eat() {
            //当事件源调用了Eat方法时，应该触发监听器的方法，调用监听器的方法并把事件对象传递进去
            personListener.doEat(new Event(this));
        }

        public void sleep() {
            //当事件源调用了Eat方法时，应该触发监听器的方法，调用监听器的方法并把事件对象传递进去
            personListener.doSleep(new Event(this));
        }

        //注册监听器，该类没有监听器对象啊，那么就传递进来吧。
        public void registerLister(listenerDemo1 personListener) {
            this.personListener = personListener;
        }

    }

    class Event {
        private Person person;
        public Event() {
        }

        public Event(Person person) {
            this.person = person;
        }

        public Person getResource() {
            return person;
        }

    }

}
