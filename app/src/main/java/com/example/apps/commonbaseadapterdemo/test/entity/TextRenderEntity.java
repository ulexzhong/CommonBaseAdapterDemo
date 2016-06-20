package com.example.apps.commonbaseadapterdemo.test.entity;

import android.view.ViewGroup;

import com.example.apps.commonbaseadapterdemo.libs.CommonItemView;
import com.example.apps.commonbaseadapterdemo.libs.RenderEntity;
import com.example.apps.commonbaseadapterdemo.test.view.TextItemView;

public class TextRenderEntity implements RenderEntity {
    private final String text;

    public TextRenderEntity(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public CommonItemView createView(ViewGroup parent) {
        return new TextItemView(parent);
    }
}
