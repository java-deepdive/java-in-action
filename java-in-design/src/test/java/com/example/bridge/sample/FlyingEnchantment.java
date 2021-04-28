package com.example.bridge.sample;

public class FlyingEnchantment implements Enchantment {

  @Override
  public void onActivate() {
    System.out.println("The item begins to glow faintly.");
  }

  @Override
  public void apply() {
    System.out.println("The item flies and strikes the enemies finally returning to owner's hand.");
  }

  @Override
  public void onDeactivate() {
    System.out.println("The item's glow fades.");
  }
}
