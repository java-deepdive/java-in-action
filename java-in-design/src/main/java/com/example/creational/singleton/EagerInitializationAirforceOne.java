package com.example.creational.singleton;

public class EagerInitializationAirforceOne {

    // The sole instance of the class
    private static EagerInitializationAirforceOne onlyInstance = new EagerInitializationAirforceOne();

    // Make the constructor private so its only accessible to
    // members of the class.
    private EagerInitializationAirforceOne() {
    }

    // Create a static method for object creation
    public static EagerInitializationAirforceOne getInstance() {

        // Only instantiate the object when needed.
        if (onlyInstance == null) {
            onlyInstance = new EagerInitializationAirforceOne();
        }

        return onlyInstance;
    }

    public void fly() {
        System.out.println("Airforce one is flying...");
    }
}
