package FactoryDesign.SimpleFactory.Factories;

import FactoryDesign.SimpleFactory.Dao.FactoryModes;
import FactoryDesign.SimpleFactory.Dao.Operation;
import FactoryDesign.SimpleFactory.Impl.Sub;

@SuppressWarnings("all")
public class SubFactory implements FactoryModes {

    @Override
    public Operation createOperation() {
        System.out.println("减法运算");
        return new Sub();
    }
}
