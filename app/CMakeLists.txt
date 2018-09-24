# Sets the minimum version of CMake required to build the native
# library. You should either keep the default value or only pass a
# value of 3.4.0 or lower.

cmake_minimum_required(VERSION 3.4.1)

add_library( ffmpegutil
             SHARED
             src/main/cpp/ffmpegutil.c )

find_library( log-lib
              log )

set(distribution_DIR ${CMAKE_SOURCE_DIR}/../../../../libs)

add_library( avutil-54
             SHARED
             IMPORTED )

set_target_properties( avutil-54
                       PROPERTIES IMPORTED_LOCATION
                       ../../../../libs/armeabi-v7a/libavutil-54.so )

add_library( swresample-1
             SHARED
             IMPORTED )
set_target_properties( swresample-1
                       PROPERTIES IMPORTED_LOCATION
                       ../../../../libs/armeabi-v7a/libswresample-1.so )
add_library( avcodec-56
             SHARED
             IMPORTED )
set_target_properties( avcodec-56
                       PROPERTIES IMPORTED_LOCATION
                       ../../../../libs/armeabi-v7a/libavcodec-56.so )
add_library( avfilter-5
             SHARED
             IMPORTED)
set_target_properties( avfilter-5
                       PROPERTIES IMPORTED_LOCATION
                       ../../../../libs/armeabi-v7a/libavfilter-5.so )
add_library( swscale-3
             SHARED
             IMPORTED)
set_target_properties( swscale-3
                       PROPERTIES IMPORTED_LOCATION
                       ../../../../libs/armeabi-v7a/libswscale-3.so )
add_library( avdevice-56
             SHARED
             IMPORTED)
set_target_properties( avdevice-56
                       PROPERTIES IMPORTED_LOCATION
                       ../../../../libs/armeabi-v7a/libavdevice-56.so )
add_library( avformat-56
             SHARED
             IMPORTED)
set_target_properties( avformat-56
                       PROPERTIES IMPORTED_LOCATION
                       ../../../../libs/armeabi-v7a/libavformat-56.so )

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

include_directories(libs/include)

#target_include_directories(native-lib PRIVATE libs/include)

target_link_libraries( ffmpegutil avutil-54 swresample-1 avcodec-56 avfilter-5 swscale-3 avdevice-56 avformat-56
                       ${log-lib} )
