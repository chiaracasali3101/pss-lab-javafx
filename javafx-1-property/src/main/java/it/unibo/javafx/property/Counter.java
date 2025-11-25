package it.unibo.javafx.property;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Counter {
    private final IntegerProperty value; //value è la property

    public Counter() {
        this.value = new SimpleIntegerProperty(0);
    }

    public void increment() {
        this.value.set(this.value.get() + 1); //si setta al valore +1
    }

    public void decrement() {
        this.value.set(this.value.get() - 1);
    }

    public IntegerProperty counterProperty() {
        return this.value;
    }
}
