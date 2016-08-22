package com.stone.card;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * 这是一个锁定宽高比的RelativeLayout
 * Created by xmuSistone on 2016/7/16.
 */
public class AutoScaleRelativeLayout extends RelativeLayout {

    private float widthHeightRate = 0.35f;

    public AutoScaleRelativeLayout(Context context) {
        this(context, null);
    }

    public AutoScaleRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AutoScaleRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.card, 0, 0);
        widthHeightRate = a.getFloat(R.styleable.card_widthHeightRate, widthHeightRate);
        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        // 调整高度
        int width = getMeasuredWidth();
        int height = (int) (width * widthHeightRate);
        ViewGroup.LayoutParams lp = getLayoutParams();
        lp.height = height;
        setLayoutParams(lp);
    }
}
