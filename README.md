# Appkit

1. 列表排序SortView控件用法：

   Add it in your root build.gradle at the end of repositories:
    allprojects {
     repositories {
      ...
      maven { url 'https://www.jitpack.io' }
     }
    }
    Add the dependency
    dependencies {
            implementation 'com.github.plplum:Appkit:v1.0.0'
    }

 (1) 
 <com.christ.sortview.SortView  
 
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:paddingStart="20dp"
        app:layout_constraintBottom_toBottomOf="@id/textview"
        app:title_background_color = "@color/white"
        app:title_text="价格"
        app:title_text_color="@color/gray_515457"
        app:title_text_size="14">
        
    </com.christ.sortview.SortView>
 
 （2）设置属性
 
      	app:title_background_color = "@color/white"
      	app:title_text="价格"
      	app:title_text_color="@color/gray_515457"
    	  app:title_text_size="14"


（3）实现SortView.OnSortListener接口中的onSort方法

     @Override
    public void onSort(View view, int sortType) {
        switch (view.getId()){
            case R.id.sortview_price:
                Collections.sort(mList, new OrderPriceComparator(sortType));
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.sortview_time:
                Collections.sort(mList, new OrderDateComparator(sortType));
                mAdapter.notifyDataSetChanged();
                break;
        }
    }
