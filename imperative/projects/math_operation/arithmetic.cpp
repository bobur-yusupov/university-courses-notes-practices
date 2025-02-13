#include <pybind11/pybind11.h>

namespace py = pybind11;

int add(int a, int b) {
    return a + b;
}

int subtract(int a, int b) {
    return a - b;
}

int multiply(int a, int b) {
    return a * b;
}

double divide(int a, int b) {
    if (b == 0) {
        throw std::runtime_error("Cannot divide by zero");
    }
    return static_cast<double>(a) / b;
}

PYBIND11_MODULE(arithmetic, m) {
    m.def("add", &add, "Add two numbers");
    m.def("subtract", &subtract, "Subtract two numbers");
    m.def("multiply", &multiply, "Multiply two numbers");
    m.def("divide", &divide, "Divide two numbers");
}
