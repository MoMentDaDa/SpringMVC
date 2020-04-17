package FactoryDesign.SimpleFactory;

import FactoryDesign.SimpleFactory.Dao.EasyFactory;
import FactoryDesign.SimpleFactory.Dao.FactoryModes;
import FactoryDesign.SimpleFactory.Dao.Operation;
import org.junit.Test;

@SuppressWarnings("all")
public class testDemo {

    // 简单工厂演示
    @Test
    public void test1() throws Exception {
        Operation add = EasyFactory.createOperation("+");
        Operation sub = EasyFactory.createOperation("-");
        Operation mul = EasyFactory.createOperation("*");
        Operation div = EasyFactory.createOperation("/");

        System.out.println(add.getResult(1, 1));
        System.out.println(sub.getResult(1, 1));
        System.out.println(mul.getResult(1, 1));
        System.out.println(div.getResult(1, 1));
    }

    // 工厂模式演示
    @Test
    public void test2() throws Exception {

        // 使用反射机制实例化工厂对象，因为字符串是可以通过变量改变的
        FactoryModes addFactory = (FactoryModes) Class.forName("FactoryDesign.SimpleFactory.Factories.AddFactory").newInstance();
        FactoryModes subFactory = (FactoryModes) Class.forName("FactoryDesign.SimpleFactory.Factories.SubFactory").newInstance();

        // 通过工厂对象创建相应的实例对象
        Operation add = addFactory.createOperation();
        Operation sub = subFactory.createOperation();

        System.out.println(add.getResult(1, 1));
        System.out.println(sub.getResult(1, 1));
    }
}


