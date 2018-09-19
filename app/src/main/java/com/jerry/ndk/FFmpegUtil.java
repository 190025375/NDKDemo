package com.jerry.ndk;

/**
 * Author Jerry
 * Created on 2018-09-19.
 */
public class FFmpegUtil {

    public static native void decode(String input_path, String output_path);

}
