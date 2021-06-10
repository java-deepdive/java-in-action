package com.example.behavioral.state.status;

import com.example.behavioral.state.context.DeliveryContext;

public interface PackageState
{
    public void updateState(DeliveryContext ctx);
}
