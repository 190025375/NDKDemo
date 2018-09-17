cmake_minimum_required(VERSION 3.4.1)

add_library( native-lib
             SHARED
             src/main/cpp/native-lib.cpp )

find_library( log-lib
              log )

set(distribution_DIR ../../../../libs)

add_library( avutil
             SHARED
             IMPORTED)

set_target_properties( avutil
                       PROPERTIES IMPORTED_LOCATION
                       ${distribution_DIR}/${ANDROID_ABI}/libavutil-54.so)

add_library( avcodec
             SHARED
             IMPORTED)

set_target_properties( avcodec
                       PROPERTIES IMPORTED_LOCATION
                       ${distribution_DIR}/${ANDROID_ABI}/libavcodec-56.so)

add_library( avfilter
             SHARED
             IMPORTED)

set_target_properties( avfilter
                       PROPERTIES IMPORTED_LOCATION
                       ${distribution_DIR}/${ANDROID_ABI}/libavfilter-5.so)

add_library( avformat
             SHARED
             IMPORTED)

set_target_properties( avformat
                       PROPERTIES IMPORTED_LOCATION
                       ${distribution_DIR}/${ANDROID_ABI}/libavformat-56.so)

add_library( avdevice
             SHARED
             IMPORTED)

set_target_properties( avdevice
                       PROPERTIES IMPORTED_LOCATION
                       ${distribution_DIR}/${ANDROID_ABI}/libavdevice-56.so)

add_library( postproc
             SHARED
             IMPORTED)

set_target_properties( postproc
                       PROPERTIES IMPORTED_LOCATION
                       ${distribution_DIR}/${ANDROID_ABI}/libpostproc-53.so)

add_library( swresample
             SHARED
             IMPORTED)

set_target_properties( swresample
                       PROPERTIES IMPORTED_LOCATION
                       ${distribution_DIR}/${ANDROID_ABI}/libswresample-1.so)

add_library( swscale
             SHARED
             IMPORTED)

set_target_properties( swscale
                       PROPERTIES IMPORTED_LOCATION
                       ${distribution_DIR}/${ANDROID_ABI}/libswscale-3.so)

#set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=qnu++11")
include_directories(libs/include)
include_directories(src/main/cpp)

target_link_libraries( native-lib
                       avutil
                       avcodec
                       avfilter
                       avformat
                       avdevice
                       postproc
                       swresample
                       swscale
                       ${log-lib} )