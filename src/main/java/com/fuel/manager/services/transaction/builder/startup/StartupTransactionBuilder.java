package com.fuel.manager.services.transaction.builder.startup;

public interface StartupTransactionBuilder {

    int startBuildingTransaction();
    void addEquipment(int tr, String eq);
    void addOperator(int tr, String op);
    void setFuelingPosition(int tr, int hn);
    void buildTransactionFromStartupTransaction(int trId);

}
