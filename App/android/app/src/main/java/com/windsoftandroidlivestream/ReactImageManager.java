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

import java.util.Map;

public class ReactImageManager extends SimpleViewManager<ReactTextView> {

    public MyLog logg = new MyLog();

    public static final String REACT_CLASS = "RCTMyImageView";

    ReactApplicationContext mCallerContext;

    public ReactImageManager(ReactApplicationContext reactContext) {
        mCallerContext = reactContext;
    }

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @NonNull
    @Override
    protected ReactTextView createViewInstance(@NonNull ThemedReactContext reactContext) {
        ReactTextView v = new ReactTextView(reactContext);
        v.setText("Hello");
        System.out.printf("anh tu la %d con ga",1);
        logg.logHello("tudoi");
        return v;
    }

    @ReactProp(name = "src")
    public void setSrc(ReactTextView view, @Nullable String sources) {
        logg.logHello(sources);
//        view.setSource(sources);
    }

    @ReactProp(name = "borderRadius", defaultFloat = 0f)
    public void setBorderRadius(ReactTextView view, float borderRadius) {
//        view.setBorderRadius(borderRadius);
    }

    @ReactProp(name = ViewProps.RESIZE_MODE)
    public void setResizeMode(ReactTextView view, @Nullable String resizeMode) {
//        view.setScaleType(ImageResizeMode.toScaleType(resizeMode));
    }


}
