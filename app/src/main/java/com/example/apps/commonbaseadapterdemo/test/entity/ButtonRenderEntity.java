package com.example.apps.commonbaseadapterdemo.test.entity;

import android.view.ViewGroup;

import com.example.apps.commonbaseadapterdemo.libs.CommonItemView;
import com.example.apps.commonbaseadapterdemo.libs.RenderEntity;
import com.example.apps.commonbaseadapterdemo.test.view.ButtonItemView;

public class ButtonRenderEntity implements RenderEntity {

    private final String buttonText;
    private final int backagegroundColor;

    public ButtonRenderEntity(String buttonText, int backagegroundColor) {
        this.buttonText = buttonText;
        this.backagegroundColor = backagegroundColor;
    }

    public String getButtonText() {
        return buttonText;
    }

    public int getBackagegroundColor() {
        return backagegroundColor;
    }

    @Override
    public CommonItemView createView(ViewGroup parent) {
        return new ButtonItemView(parent);
    }
}
