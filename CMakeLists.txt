cmake_minimum_required(VERSION 3.17)
project(_algorithm)

# 配置 clang
set(CMAKE_C_COMPILER "/usr/bin/clang")
set(CMAKE_CXX_COMPILER "/usr/bin/clang++")
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_FLAGS
        -std=c++17
        )

include_directories(
        src/include
)

# 遍历项目根目录下所有的 .cpp 文件
file(GLOB_RECURSE FILES *.cpp)
foreach (file ${FILES})
    file(RELATIVE_PATH exe ${CMAKE_CURRENT_SOURCE_DIR} ${file}) # 获取相对路径
    string(REGEX REPLACE "/" "." exe ${exe})
    #    string(REGEX REPLACE ".+/(.+)\\..*" "\\1" exe ${file})
    add_executable(${exe} ${file} src/top.chenqwwq/leetcode/daily/_20220623/substring-with-concatenation-of-all-words.cpp)
    message(\ \ \ \ --\ src/${exe}.cpp\ will\ be\ compiled\ to\ bin/${exe})
endforeach ()
