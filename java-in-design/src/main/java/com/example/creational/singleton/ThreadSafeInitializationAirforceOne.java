package com.example.creational.singleton;

public class ThreadSafeInitializationAirforceOne {

    // The sole instance of the class
    private static ThreadSafeInitializationAirforceOne onlyInstance;

    // Make the constructor private so its only accessible to
    // members of the class.
    private ThreadSafeInitializationAirforceOne() {
    }

    // Create a static method for object creation
    public synchronized static ThreadSafeInitializationAirforceOne getInstance() {

        // Only instantiate the object when needed.
        if (onlyInstance == null) {
            onlyInstance = new ThreadSafeInitializationAirforceOne();
        }

        return onlyInstance;
    }

    public void fly() {
        System.out.println("Airforce one is flying...");
    }
}
