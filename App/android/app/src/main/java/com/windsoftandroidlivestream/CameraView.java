package com.windsoftandroidlivestream;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.pedro.rtplibrary.rtmp.RtmpCamera1;
import com.pedro.rtplibrary.util.FpsListener;

import net.ossrs.rtmp.ConnectCheckerRtmp;

public class CameraView extends LinearLayout implements SurfaceHolder.Callback,  View.OnTouchListener {
    private static final String TAG = "CameraView";
    private View rootView;
    private TextView txtView;
    private Button btnOnClick;
    private SurfaceView surfaceView;
    private RtmpCamera1 rtmpCamera;
    private Button goLiveButton;
    private TextView bitrateLabel;
    private TextView fpsLabel;

    public CameraView(Context context) {
        super(context);
        init(context);
    }

    public CameraView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CameraView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    private void init(Context context){
        rootView =inflate(context,R.layout.layout_camera,this);
        btnOnClick = rootView.findViewById(R.id.btnOnGoLive);

        // Init the Surface View for the camera preview
        surfaceView = findViewById(R.id.surfaceView);
        surfaceView.getHolder().addCallback(this);

        // Bind to labels and buttons
        goLiveButton = (Button) findViewById(R.id.btnOnGoLive);
        bitrateLabel = (TextView) findViewById(R.id.bitrateLabel);
        fpsLabel = (TextView) findViewById(R.id.fpslabel);

        // Setup the camera
//        rtmpCamera = new RtmpCamera1(surfaceView , (ConnectCheckerRtmp) this);
//        rtmpCamera.setReTries(1000); // Effectively retry forever

    }
    public void setText(String text){
        Log.d(TAG, "setText: " + text);
//        txtView.setText(text);
    }

}
