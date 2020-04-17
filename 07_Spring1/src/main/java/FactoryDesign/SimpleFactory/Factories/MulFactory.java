package FactoryDesign.SimpleFactory.Factories;

import FactoryDesign.SimpleFactory.Dao.FactoryModes;
import FactoryDesign.SimpleFactory.Dao.Operation;
import FactoryDesign.SimpleFactory.Impl.Mul;

@SuppressWarnings("all")
public class MulFactory implements FactoryModes {

    @Override
    public Operation createOperation() {
        System.out.println("乘法运算");
        return new Mul();
    }
}
