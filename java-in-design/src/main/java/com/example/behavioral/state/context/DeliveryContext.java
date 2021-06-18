package com.example.behavioral.state.context;

import com.example.behavioral.state.status.Acknowledged;
import com.example.behavioral.state.status.PackageState;

public class DeliveryContext {

    private final String packageId;
    private PackageState currentState;

    public DeliveryContext(PackageState currentState, String packageId) {
        super();
        this.currentState = currentState;
        this.packageId = packageId;

        if (currentState == null) {
            this.currentState = Acknowledged.instance();
        }
    }

    public void setCurrentState(PackageState currentState) {
        this.currentState = currentState;
    }

    public void update() {
        currentState.updateState(this);
    }
}
