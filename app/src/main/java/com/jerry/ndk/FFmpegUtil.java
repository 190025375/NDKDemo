package com.jerry.ndk;

/**
 * Author Jerry
 * Created on 2018-09-19.
 */
public class FFmpegUtil {

    static {
        System.loadLibrary("avutil-54");
        System.loadLibrary("swresample-1");
        System.loadLibrary("avcodec-56");
        System.loadLibrary("avfilter-5");
        System.loadLibrary("swscale-3");
        System.loadLibrary("avdevice-56");
        System.loadLibrary("avformat-56");
        System.loadLibrary("ffmpegutil");
    }

    public static native void decode(String input_path, String output_path);

}
