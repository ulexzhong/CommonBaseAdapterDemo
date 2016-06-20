package com.example.apps.commonbaseadapterdemo.libs;

import android.view.View;

public interface CommonItemView<T extends RenderEntity> {

    void render(T renderEntity);

    View getView();
}