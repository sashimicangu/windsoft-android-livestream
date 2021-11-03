package com.windsoftandroidlivestream;

import android.graphics.Color;
import android.view.View;

import androidx.annotation.NonNull;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

public class NativeView extends SimpleViewManager<View> {
    public static final String REACT_CLASS = "NativeView";
    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @NonNull
    @Override
    protected View createViewInstance(@NonNull ThemedReactContext reactContext) {
        View v = new View(reactContext);
        v.setBackgroundColor(Color.RED);
        return v;
    }
}
