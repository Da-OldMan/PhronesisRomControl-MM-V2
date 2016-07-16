package com.wubydax.romcontrol.v2.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.wubydax.romcontrol.v2.R;

/**
 * Created by Anna Berkovitch on 19/06/2016.
 */
public class RebootView extends FrameLayout {
    public RebootView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RebootView);
        String text = typedArray.getString(R.styleable.RebootView_rebootText);
        int color = typedArray.getColor(R.styleable.RebootView_rebootColor, Color.WHITE);
        init(text, color);
    }

    private void init(String text, int color) {
        inflate(getContext(), R.layout.reboot_item, this);
        ((TextView) findViewById(R.id.rebootText)).setText(text);
        findViewById(R.id.rebootFab).setBackgroundTintList(ColorStateList.valueOf(color));

    }


}
