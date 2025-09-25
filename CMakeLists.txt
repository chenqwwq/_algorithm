cmake_minimum_required(VERSION 3.17)
project(_algorithm)

# 配置 clang
set(CMAKE_OSX_SYSROOT /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk)
set(CMAKE_C_COMPILER "/opt/homebrew/opt/llvm/bin/clang")
set(CMAKE_CXX_COMPILER "/opt/homebrew/opt/llvm/bin/clang++")
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_FLAGS
        -std=c++17
        )

include_directories(${PROJECT_SOURCE_DIR}/src/include)

# 遍历项目根目录下所有的 .cpp 文件
file(GLOB_RECURSE FILES *.cpp)
foreach (file ${FILES})
    file(RELATIVE_PATH exe ${CMAKE_CURRENT_SOURCE_DIR} ${file}) # 获取相对路径
    string(REGEX REPLACE "/" "." exe ${exe})
    add_executable(${exe} ${file})
    message(\ \ \ \ --\ src/${exe}.cpp\ will\ be\ compiled\ to\ bin/${exe})
endforeach ()
