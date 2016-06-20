package com.example.apps.commonbaseadapterdemo.test;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListView;

import com.example.apps.commonbaseadapterdemo.R;
import com.example.apps.commonbaseadapterdemo.libs.CommonBaseAdapter;
import com.example.apps.commonbaseadapterdemo.libs.RenderEntity;
import com.example.apps.commonbaseadapterdemo.test.entity.ButtonRenderEntity;
import com.example.apps.commonbaseadapterdemo.test.entity.ImageViewRenderEntity;
import com.example.apps.commonbaseadapterdemo.test.entity.TextRenderEntity;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        renderView();
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.listView);
    }

    private ArrayList<RenderEntity> initData() {
        ArrayList<RenderEntity> dataList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            if (i % 3 == 0) {
                dataList.add(new TextRenderEntity("TextRender..." + i));
            } else if (i % 3 == 1) {
                dataList.add(new ButtonRenderEntity("ButtonRender..." + i, Color.CYAN + i));
            } else {
                dataList.add(new ImageViewRenderEntity(R.drawable.ic_launcher));
            }
        }
        return dataList;
    }

    private void renderView() {
        ArrayList<RenderEntity> dataList = initData();
        Class[] classes = {TextRenderEntity.class, ImageViewRenderEntity.class, ButtonRenderEntity.class};
        CommonBaseAdapter adapter = new CommonBaseAdapter(dataList, classes);
        listView.setAdapter(adapter);
    }
}
