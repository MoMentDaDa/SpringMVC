package FactoryDesign.SimpleFactory.Factories;


import FactoryDesign.SimpleFactory.Dao.FactoryModes;
import FactoryDesign.SimpleFactory.Dao.Operation;
import FactoryDesign.SimpleFactory.Impl.Div;

@SuppressWarnings("all")
public class DivFactory implements FactoryModes {

    @Override
    public Operation createOperation() {
        System.out.println("除法运算");
        return new Div();
    }
}
