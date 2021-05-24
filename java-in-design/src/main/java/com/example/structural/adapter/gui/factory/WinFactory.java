package com.example.structural.adapter.gui.factory;

import com.example.structural.adapter.gui.GUIFactory;
import com.example.structural.adapter.gui.button.Button;
import com.example.structural.adapter.gui.button.CheckBox;
import com.example.structural.adapter.gui.button.WinButton;
import com.example.structural.adapter.gui.button.WinCheckBox;

public class WinFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WinCheckBox();
    }
}
