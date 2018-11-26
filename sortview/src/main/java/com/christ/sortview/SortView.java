package com.christ.sortview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * 简述：自定义排序控件
 * 作者：Chenxp
 * 时间：2017/9/28
 * 版本：V1.0.0
 */
public class SortView extends LinearLayout {

    private boolean isAsc = true;

    private LinearLayout mLinearLayout;

    private TextView mTextTitle;

    private ImageView mImageView;

    private OnSortListener onSortListener;

    //0升序 1降序
    private int sortType = 0;

    public SortView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_sortview, this, true);
        mLinearLayout = (LinearLayout)findViewById(R.id.sort_layout);
        mTextTitle = (TextView) findViewById(R.id.title_bar_left);
        mImageView = (ImageView) findViewById(R.id.imageview);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.SortView);
        if (attributes != null) {
            int titleBarBackGround = attributes.getResourceId(R.styleable.SortView_title_background_color, Color.GREEN);
            setBackgroundResource(titleBarBackGround);
            String title = attributes.getString(R.styleable.SortView_title_text);
            mTextTitle.setText(title);
            int titleColor = attributes.getColor(R.styleable.SortView_title_text_color, Color.GRAY);
            mTextTitle.setTextColor(titleColor);
            float size = attributes.getFloat(R.styleable.SortView_title_text_size, 14);
            mTextTitle.setTextSize(size);
            attributes.recycle();
        }

        mLinearLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                setImageSrc();
                if (sortType == 1){
                    sortType = 0;
                }else {
                    sortType = 1;
                }
                if (onSortListener!=null)
                    onSortListener.onSort(SortView.this, sortType);
            }
        });
    }


    public void setImageSrc(){
        if (isAsc){
            mImageView.setBackgroundResource(R.drawable.common_arrow_top);
            isAsc = false;
        }else {
            mImageView.setBackgroundResource(R.drawable.common_arrow_down);
            isAsc = true;
        }
    }

    public OnSortListener getOnSortListener() {
        return onSortListener;
    }

    public void setOnSortListener(OnSortListener onSortListener) {
        this.onSortListener = onSortListener;
    }

    public interface OnSortListener {
         void onSort(View view, int sortType);
    }

}