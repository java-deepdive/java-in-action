package com.example.flyweight;

public class UnsharedConcreteFlyweight implements Flyweight {

  private Object state;

  public UnsharedConcreteFlyweight(Object state) {
    this.state = state;
  }

  public void operation(Object extrinsicState) {

  }

  public Object getState() {
    return state;
  }
}
