package Decorator;

import Serialization.Serialization;

public abstract class Decorator extends Serialization implements DecoratorService {
    protected Serialization serialization;

    public Serialization getSerialization() {
        return serialization;
    }

    public void setSerialization(Serialization serialization) {
        this.serialization = serialization;
    }
}
