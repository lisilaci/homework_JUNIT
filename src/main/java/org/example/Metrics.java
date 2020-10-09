package org.example;

public enum Metrics {

    mm(1),
    cm(10),
    dm(100),
    m(1000),
    km(1000000);

    private int scale;

    Metrics(int scale) {
        this.scale = scale;
    }

    public int getScale() {
        return scale;
    }
}
