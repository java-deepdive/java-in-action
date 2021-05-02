package com.example.adapter.gui.factory;

import com.example.adapter.gui.GUIFactory;
import com.example.adapter.gui.button.Button;
import com.example.adapter.gui.button.CheckBox;
import com.example.adapter.gui.button.MacButton;
import com.example.adapter.gui.button.MacCheckBox;

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
