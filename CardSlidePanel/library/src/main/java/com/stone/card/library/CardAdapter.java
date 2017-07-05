package com.stone.card.library;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;

/**
 * Created by xmuSistone on 2017/7/5.
 */

public abstract class CardAdapter {

    private final DataSetObservable mDataSetObservable = new DataSetObservable();

    /**
     * layout文件ID，调用者必须实现
     */
    public abstract int getLayoutId();

    /**
     * item数量，调用者必须实现
     */
    public abstract int getCount();

    /**
     * View与数据绑定回调，可重载
     */
    public abstract void bindView(View view, int index);


    public boolean shouldCapture(int posX, int posY) {
        return true;
    }


    public void registerDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.registerObserver(observer);
    }

    public void unregisterDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.unregisterObserver(observer);
    }

    public void notifyDataSetChanged() {
        mDataSetObservable.notifyChanged();
    }
}
