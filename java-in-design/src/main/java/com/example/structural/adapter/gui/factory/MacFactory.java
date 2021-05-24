package com.example.structural.adapter.gui.factory;

import com.example.structural.adapter.gui.GUIFactory;
import com.example.structural.adapter.gui.button.Button;
import com.example.structural.adapter.gui.button.CheckBox;
import com.example.structural.adapter.gui.button.MacButton;
import com.example.structural.adapter.gui.button.MacCheckBox;

public class MacFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}
