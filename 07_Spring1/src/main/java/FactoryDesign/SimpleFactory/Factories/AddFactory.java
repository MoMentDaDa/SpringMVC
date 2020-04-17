package FactoryDesign.SimpleFactory.Factories;

import FactoryDesign.SimpleFactory.Dao.FactoryModes;
import FactoryDesign.SimpleFactory.Dao.Operation;
import FactoryDesign.SimpleFactory.Impl.Add;


@SuppressWarnings("all")
public class AddFactory implements FactoryModes {

    @Override
    public Operation createOperation() {
        System.out.println("加法运算");
        return new Add();
    }
}
