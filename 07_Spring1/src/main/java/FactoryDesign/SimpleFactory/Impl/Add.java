package FactoryDesign.SimpleFactory.Impl;

import FactoryDesign.SimpleFactory.Dao.Operation;

@SuppressWarnings("all")
public class Add implements Operation {
    // 加法计算
    @Override
    public double getResult(double numberA, double numberB) {
        return numberA + numberB;
    }
}

