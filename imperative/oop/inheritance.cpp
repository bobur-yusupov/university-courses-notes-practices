#include <iostream>
#include <string>

typedef std::string String;

// Base Shape class

class Shape {
    protected:
        String color;
    
    public:
        // setColor member method to set color to protected data
        void setColor(String _color) {
            color = _color;
        }

        // Create private abstract classes
        virtual float area() const = 0;
};

// Circle class that inherits from Shape

class Circle: public Shape {
    // Create private abstract classes
    private:
        int radius;

    public:
        void setRadius(int _radius) {
            if (_radius <= 0) throw std::invalid_argument("Radius must be positive!");

            radius = _radius;
        }

        // Calculates the area of a shape
        float area() const override {
            if (radius == 0) {
                throw std::domain_error("Radius cannot be zero!");
            }
            const float pi = 3.14;
            return pi * radius * radius;
        }
};

/*
    Rectangle class with inheritance from Shape abstract class
*/
class Rectangle: public Shape {
    private:
        int width;
        int height;
    
    public:
        // Sets the width of the rectangle
        void setWidth(int _width) {
            if (_width <= 0) {
                throw std::invalid_argument("Width must be positive!");
            }
            width = _width;
        }

        // Sets the height of the rectangle
        void setHeight(int _height) {
            if (_height <= 0) {
                throw std::invalid_argument("Height must be positive!");
            }
            height = _height;
        }

    

        // Calculates the area of the rectangle

        float area() const override {
            float area = width * height;

            return area;
        }
};

int main() {
    Circle circle;
    Rectangle rectangle;

    try {
        // Set dimension to radius of the circle
        circle.setRadius(5);
        circle.setColor("Blue");

        // Set dimension to width and height of rectangle
        rectangle.setWidth(10);
        rectangle.setHeight(4);

        std::cout << circle.area() << std::endl;
        std::cout << rectangle.area() << std::endl;
    } catch (const std::invalid_argument& e) {
        std::cerr << "Error: " << e.what() << std::endl;
    }
}