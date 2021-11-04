package com.windsoftandroidlivestream;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.image.ImageResizeMode;
import com.facebook.react.views.image.ReactImageView;
import com.facebook.react.views.text.ReactTextView;
import com.facebook.react.views.view.ReactViewGroup;

import java.util.Map;

public class ReactCameraManager extends SimpleViewManager<CameraView> {
    public static final String REACT_CLASS = "RCTCameraAndroid";
    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @NonNull
    @Override
    protected CameraView createViewInstance(@NonNull ThemedReactContext reactContext) {
        CameraView v = new CameraView(reactContext);
        return v;
    }
    @ReactProp(name = "text")
    public void hello(CameraView view, @Nullable String sources) {
//        view.setText(sources);
//        System.out.println("sources"+sources);
    }



}
