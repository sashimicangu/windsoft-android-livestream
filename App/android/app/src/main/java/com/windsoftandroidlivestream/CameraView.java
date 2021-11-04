package com.windsoftandroidlivestream;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.pedro.encoder.input.video.CameraHelper;
import com.pedro.rtplibrary.rtmp.RtmpCamera1;
import com.pedro.rtplibrary.util.FpsListener;

import net.ossrs.rtmp.ConnectCheckerRtmp;

public class CameraView extends LinearLayout implements SurfaceHolder.Callback, ConnectCheckerRtmp, View.OnTouchListener {
    private static final String TAG = "CameraView";
    private View rootView;
    private TextView txtView;
    private Button btnOnClick;
    private SurfaceView surfaceView;
    private RtmpCamera1 rtmpCamera;
    private Button goLiveButton;
    private Button changeCameraButton;
    private Button btnOnGoLive;
    private TextView bitrateLabel;
    private TextView fpsLabel;
    private  Context mcontext;
    private Boolean liveDesired = false;

    public CameraView(Context context) {
        super(context);
        init(context);
        mcontext = context;
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
        // Stop the preview if it's running
        rtmpCamera.stopPreview();

        // Re-constrain the layout a little if the rotation of the application has changed
//        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        ConstraintLayout.LayoutParams l = (ConstraintLayout.LayoutParams) surfaceView.getLayoutParams();
//        switch (rotation) {
//            case Surface.ROTATION_90:
//            case Surface.ROTATION_270:
//                l.dimensionRatio = "w,16:9";
//                break;
//            default:
//                l.dimensionRatio = "h,9:16";
//                break;
//        }
        surfaceView.setLayoutParams(l);

        // Re-start the preview, which will also reset the rotation of the preview
        rtmpCamera.startPreview(1920, 1080);
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

        //Setup the camera
        rtmpCamera = new RtmpCamera1(surfaceView ,this );
        rtmpCamera.setReTries(1000); // Effectively retry forever


        changeCameraButton = rootView.findViewById(R.id.changeCameraButton);
        changeCameraButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                changeCameraClicked(view);
            }
        });

        btnOnGoLive = rootView.findViewById(R.id.btnOnGoLive);
        btnOnGoLive.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
//                goLiveClicked(view);
            }
        });



    }
    public void setText(String text){
        Log.d(TAG, "setText: " + text);
//        txtView.setText(text);
    }

    @Override
    public void onConnectionSuccessRtmp() {
        Log.d(TAG, "onConnectionSuccessRtmp: ");
    }

    @Override
    public void onConnectionFailedRtmp(@NonNull String reason) {
        Log.d(TAG, "onConnectionFailedRtmp: ");
    }

    @Override
    public void onNewBitrateRtmp(long bitrate) {
        Log.d(TAG, "onNewBitrateRtmp: ");
    }

    @Override
    public void onDisconnectRtmp() {
        Log.d(TAG, "onDisconnectRtmp: ");
    }

    @Override
    public void onAuthErrorRtmp() {
        Log.d(TAG, "onAuthErrorRtmp: ");
    }

    @Override
    public void onAuthSuccessRtmp() {
        Log.d(TAG, "onAuthSuccessRtmp: ");
    }

    public void changeCameraClicked(View view) {
        Log.i(TAG, "Change Camera Button tapped");
        rtmpCamera.switchCamera();
    }
//    public void goLiveClicked(View view) {
//        Log.i(TAG, "Go Live Button tapped");
//
//        if (liveDesired) {
//            // Calling the "stopStream" function can take a while, so this happens on a new thread.
//            goLiveButton.setText("Stopping...");
//            new Thread(new Runnable() {
//                public void run() {
//                    rtmpCamera.stopStream();
//                    BroadcastActivity.this.runOnUiThread(new Runnable() {
//                        public void run() {
//                            goLiveButton.setText("Go Live!");
//                        }
//                    });
//                }
//            }).start();
//            liveDesired = false;
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED); // Unlock orientation
//        } else {
//
//            // Lock orientation to the current orientation while stream is active
//            int rotation = getWindowManager().getDefaultDisplay().getRotation();
//            switch (rotation) {
//                case Surface.ROTATION_90:
//                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//                    break;
//                case Surface.ROTATION_180:
//                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
//                    break;
//                case Surface.ROTATION_270:
//                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
//                    break;
//                default:
//                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//                    break;
//            }
//
//            // Configure the stream using the configured preset
//            rtmpCamera.prepareVideo(
//                    preset.width,
//                    preset.height,
//                    preset.frameRate,
//                    preset.bitrate,
//                    2, // Fixed 2s keyframe interval
//                    CameraHelper.getCameraOrientation(this)
//            );
//            rtmpCamera.prepareAudio(
//                    128 * 1024, // 128kbps
//                    48000, // 48k
//                    true // Stereo
//            );
//
//            // Start the stream!
//            rtmpCamera.startStream(rtmpEndpoint + streamKey);
//            liveDesired = true;
//            goLiveButton.setText("Connecting... (Cancel)");
//        }
//    }
}
