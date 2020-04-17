package FactoryDesign.SimpleFactory.Dao;


import FactoryDesign.SimpleFactory.Impl.Add;
import FactoryDesign.SimpleFactory.Impl.Div;
import FactoryDesign.SimpleFactory.Impl.Mul;
import FactoryDesign.SimpleFactory.Impl.Sub;

/**
 * @program: JavaWeb
 * @description: 简单工厂类，工厂会根据用户 Dao 自动创建所需的对象并返回，同时也可以在创建的时候加入简单地业务逻辑
 * @author: Mr.Wang
 * @create: 2020-04-11 14:02
 **/
@SuppressWarnings("all")
public class EasyFactory {


    private static Operation operationObj = null;

    private static Operation add() {
        System.out.println("加法运算");
        return new Add();
    }

    private static Operation sub() {
        System.out.println("减法运算");
        return new Sub();
    }

    private static Operation mul() {
        System.out.println("乘法运算");
        return new Mul();
    }

    private static Operation div() {
        System.out.println("除法运算");
        return new Div();
    }

    // 简单工厂，根据字符串创建相应的对象,
    public static Operation createOperation(String name) {
        switch (name) {
            case "+":
                operationObj = add();
                break;
            case "-":
                operationObj = sub();
                break;
            case "*":
                operationObj = mul();
                break;
            case "/":
                operationObj = div();
                break;
        }
        return operationObj;
    }
}

