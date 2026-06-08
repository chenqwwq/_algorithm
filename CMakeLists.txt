cmake_minimum_required(VERSION 3.17)

# 配置 clang
set(CMAKE_OSX_SYSROOT /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk)
set(CMAKE_C_COMPILER "/opt/homebrew/opt/llvm/bin/clang")
set(CMAKE_CXX_COMPILER "/opt/homebrew/opt/llvm/bin/clang++")

project(algo-grind C CXX)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_C_STANDARD 17)
set(CMAKE_C_STANDARD_REQUIRED ON)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_FLAGS
        -std=c++17
        )
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/bin)

include_directories(${PROJECT_SOURCE_DIR}/src/include)

# 遍历 C++ 解题目录
file(GLOB_RECURSE FILES CONFIGURE_DEPENDS
        ${PROJECT_SOURCE_DIR}/src/cpp/*.cc
        ${PROJECT_SOURCE_DIR}/src/cpp/*.cpp
        ${PROJECT_SOURCE_DIR}/src/cpp/*.cxx
        )
foreach (file ${FILES})
    file(RELATIVE_PATH exe ${CMAKE_CURRENT_SOURCE_DIR} ${file}) # 获取相对路径
    string(REGEX REPLACE "/" "." exe ${exe})
    add_library(obj.${exe} OBJECT ${file})
    add_executable(${exe} EXCLUDE_FROM_ALL ${file})
    message(STATUS "${exe} will be compiled as obj.${exe}")
endforeach ()
