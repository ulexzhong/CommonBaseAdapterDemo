package com.example.apps.commonbaseadapterdemo.test.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.apps.commonbaseadapterdemo.R;
import com.example.apps.commonbaseadapterdemo.libs.CommonItemView;
import com.example.apps.commonbaseadapterdemo.test.entity.ImageViewRenderEntity;

public class ImageItemView implements CommonItemView<ImageViewRenderEntity> {
    private ImageView imageView;
    private View view;

    public ImageItemView(ViewGroup parent) {
        initView(parent);
    }

    private void initView(ViewGroup parent) {
        this.view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_imageview_layout, parent, false);
        imageView = (ImageView)view.findViewById(R.id.item_imageview);
    }

    @Override
    public void render(ImageViewRenderEntity renderEntity) {
        imageView.setImageResource(renderEntity.getRes());
    }

    @Override
    public View getView() {
        return view;
    }
}
