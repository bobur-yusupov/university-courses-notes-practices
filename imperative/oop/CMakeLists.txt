cmake_minimum_required(VERSION 3.13)
project(gtest_example)

# Add Google Test as a subdirectory
add_subdirectory(googletest)

# Link your executable to Google Test
add_executable(gtest_example main.cpp)
target_link_libraries(gtest_example gtest gtest_main)