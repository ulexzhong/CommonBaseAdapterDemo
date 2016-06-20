package com.example.apps.commonbaseadapterdemo.test.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.apps.commonbaseadapterdemo.R;
import com.example.apps.commonbaseadapterdemo.libs.CommonItemView;
import com.example.apps.commonbaseadapterdemo.test.entity.ButtonRenderEntity;

public class ButtonItemView implements CommonItemView<ButtonRenderEntity> {
    private Button button;
    private View view;

    public ButtonItemView(ViewGroup parent) {
        initView(parent);
    }

    private void initView(ViewGroup parent) {
        this.view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_button_layout, parent, false);
        button = (Button) view.findViewById(R.id.item_button);
    }

    @Override
    public void render(ButtonRenderEntity renderEntity) {
        button.setText(renderEntity.getButtonText());
        button.setBackgroundColor(renderEntity.getBackagegroundColor());
    }

    @Override
    public View getView() {
        return view;
    }
}
