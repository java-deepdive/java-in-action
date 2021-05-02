package com.example.adapter.gui;

import com.example.adapter.gui.factory.WinFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest {

    @DisplayName("윈도우 애플리케이션 테스트")
    @Test
    void testCase1() {
        Application application = new Application(new WinFactory());
        application.createUI();
        application.paint();
    }

}
