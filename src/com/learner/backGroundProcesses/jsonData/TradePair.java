package com.learner.backGroundProcesses.jsonData;

public class TradePair implements ApiType {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
