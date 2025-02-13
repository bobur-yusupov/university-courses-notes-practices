cmake_minimum_required(VERSION 3.14)
project(math_operation)

# Set the C++ standard to C++11 (or higher)
set(CMAKE_CXX_STANDARD 11)

# Find pybind11 installed via pip
find_package(pybind11 REQUIRED)

# Find Python and set paths
find_package(Python3 REQUIRED)
include_directories(${Python3_INCLUDE_DIRS})

# Create the shared library with pybind11
pybind11_add_module(arithmetic MODULE arithmetic.cpp)

# Link Python libraries
target_link_libraries(arithmetic PRIVATE ${Python3_LIBRARIES})
