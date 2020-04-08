package myProxy;

/**
 * @program: 02
 * @description: 真实厂家
 * @author: Mr.Wang
 * @create: 2020-03-22 16:17
 **/
public class Lenovo implements SaleComputer {

    @Override
    public String sale(double money) {
        System.out.println("花了" + money + "元买了一台联想电脑...");
        return "联想电脑";
    }

    @Override
    public void show() {
        System.out.println("展示电脑....");
    }
}
