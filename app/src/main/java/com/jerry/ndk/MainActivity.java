package com.jerry.ndk;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RxPermissions rxPermissions = new RxPermissions(this);
        disposable = rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) {
                        setEvent();
                    }
                });
    }

    private void setEvent() {
        findViewById(R.id.sample_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputPath = Environment.getExternalStorageDirectory() + File.separator + "DCIM" + File.separator + "Camera" + File.separator + "demo.mp4";
                String outputPath = Environment.getExternalStorageDirectory() + File.separator + "DCIM" + File.separator + "Camera" + File.separator + "demo1.mp4";
                File file = new File(inputPath);
                Log.e("log", inputPath + "   " + file.exists());
                FFmpegUtil.decode(inputPath, outputPath);
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
        super.onDestroy();
    }
}