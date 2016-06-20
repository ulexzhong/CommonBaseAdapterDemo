# CommonBaseAdapterDemo
1、创建一个通用的CommonBaseAdapter类，适用于所有ListView 或者 RecyclerView ,避免每次使用list的时候都重复写类似的adapter代码<br>
2、同时，在这个项目的基础上提供一种分离Model层和View层的方式，将Model 和 View 彻底分离出来

##该项目分为两部分
libs最终提供的公共库<br>
test测试用例<br>

##主要类介绍
**CommonBaseAdaper.java**公共的Adapter类，支持多种viewType<br>
**CommonItemView.java**公共的itemView类，使用时所有的itemview实现该接口<br>
**renderEntity.java**公共entity类，所有itemview的entity需实现该接口<br>

###CommonBaseAdapter.java
   ```java
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
    }
  ```
  提供两种构造方法，区别在于，itemView 是否要支持多种样式，缺省默认只有一种itemview，直接说第二个构造方法，第一个参数及实现了**RenderEntity**的Entity列表，第二个参数为Entity类的数组

###RenderEntity.java
   ```java
   public interface RenderEntity {
    CommonItemView createView(ViewGroup parent);
}
```
###CommonItemView.java
   ```java
   public interface CommonItemView<T extends RenderEntity> {

    void render(T renderEntity);

    View getView();
}
```
##使用介绍
entity.java
   ```java
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
   ```
itemView.java
   ```java
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
   ```
最终使用时，
   ```java
    ArrayList<RenderEntity> dataList = initData();
    Class[] classes = {TextRenderEntity.class, ImageViewRenderEntity.class, ButtonRenderEntity.class};
    CommonBaseAdapter adapter = new CommonBaseAdapter(dataList, classes);
    listView.setAdapter(adapter);
   ```
