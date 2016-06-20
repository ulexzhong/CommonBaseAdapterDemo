package com.example.apps.commonbaseadapterdemo.libs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonBaseAdapter<T extends RenderEntity> extends BaseAdapter {

    protected final List<T> entityList;
    private Map<Class, Integer> classMapViewType = new HashMap<>(10);

    public CommonBaseAdapter(List<T> entityList) {
        this(entityList, null);
    }

    public CommonBaseAdapter(List<T> entityList, Class<? extends RenderEntity>[] classArr) {
        this.entityList = entityList;
        for (int i = 0; classArr != null && i < classArr.length; i++) {
            classMapViewType.put(classArr[i], i);
        }
    }

    @Override
    public int getCount() {
        return entityList.size();
    }

    @Override
    public Object getItem(int position) {
        return entityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        Integer viewType = classMapViewType.get(entityList.get(position).getClass());
        return viewType == null ? 0 : viewType;
    }

    @Override
    public int getViewTypeCount() {
        return classMapViewType.size() == 0 ? 1 : classMapViewType.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CommonItemView itemView;
        RenderEntity renderEntity = entityList.get(position);
        if (convertView == null) {
            itemView = renderEntity.createView(parent);
            convertView = itemView.getView();
            convertView.setTag(itemView);
        } else {
            itemView = (CommonItemView) convertView.getTag();
        }
        itemView.render(renderEntity);
        return convertView;
    }
}