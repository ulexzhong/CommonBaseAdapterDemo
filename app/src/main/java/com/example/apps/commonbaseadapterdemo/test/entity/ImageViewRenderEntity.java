package com.example.apps.commonbaseadapterdemo.test.entity;

import android.view.ViewGroup;

import com.example.apps.commonbaseadapterdemo.libs.CommonItemView;
import com.example.apps.commonbaseadapterdemo.libs.RenderEntity;
import com.example.apps.commonbaseadapterdemo.test.view.ImageItemView;

public class ImageViewRenderEntity implements RenderEntity {
    private final int res;

    public ImageViewRenderEntity(int res) {
        this.res = res;
    }

    public int getRes() {
        return res;
    }

    @Override
    public CommonItemView createView(ViewGroup parent) {
        return new ImageItemView(parent);
    }
}
