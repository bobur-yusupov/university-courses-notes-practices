import ctypes
import os
import platform

lib = ctypes.CDLL("/arithmetic.dll")


# Define function argument & return types
lib.add.argtypes = [ctypes.c_int, ctypes.c_int]
lib.add.restype = ctypes.c_int

lib.subtract.argtypes = [ctypes.c_int, ctypes.c_int]
lib.subtract.restype = ctypes.c_int

lib.multiply.argtypes = [ctypes.c_int, ctypes.c_int]
lib.multiply.restype = ctypes.c_int

lib.divide.argtypes = [ctypes.c_int, ctypes.c_int]
lib.divide.restype = ctypes.c_double  # Return type must be double for division

# Test the functions
x, y = 10, 5
print(f"Addition: {lib.add(x, y)}")
print(f"Subtraction: {lib.subtract(x, y)}")
print(f"Multiplication: {lib.multiply(x, y)}")
print(f"Division: {lib.divide(x, y)}")

