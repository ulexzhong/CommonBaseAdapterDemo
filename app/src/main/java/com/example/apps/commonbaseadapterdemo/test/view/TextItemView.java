package com.example.apps.commonbaseadapterdemo.test.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apps.commonbaseadapterdemo.R;
import com.example.apps.commonbaseadapterdemo.libs.CommonItemView;
import com.example.apps.commonbaseadapterdemo.test.entity.TextRenderEntity;

public class TextItemView implements CommonItemView<TextRenderEntity> {
    private TextView textView;
    private View view;

    public TextItemView(ViewGroup parent) {
        initView(parent);
    }

    private void initView(ViewGroup parent) {
        this.view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text_layout, parent, false);
        textView = (TextView) view.findViewById(R.id.item_text);
    }

    @Override
    public void render(TextRenderEntity renderEntity) {
       textView.setText(renderEntity.getText());
    }

    @Override
    public View getView() {
        return view;
    }
}
