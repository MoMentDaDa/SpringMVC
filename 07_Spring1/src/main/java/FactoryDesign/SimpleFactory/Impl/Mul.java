package FactoryDesign.SimpleFactory.Impl;

import FactoryDesign.SimpleFactory.Dao.Operation;

@SuppressWarnings("all")
public class Mul implements Operation {
    // 乘法计算
    @Override
    public double getResult(double numberA, double numberB) {
        return numberA * numberB;
    }
}
