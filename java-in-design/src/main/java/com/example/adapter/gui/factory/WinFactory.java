package com.example.adapter.gui.factory;

import com.example.adapter.gui.GUIFactory;
import com.example.adapter.gui.button.Button;
import com.example.adapter.gui.button.CheckBox;
import com.example.adapter.gui.button.WinButton;
import com.example.adapter.gui.button.WinCheckBox;

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
