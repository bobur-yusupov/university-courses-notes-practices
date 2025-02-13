#include <iostream>
#include <string>

typedef std::string String;

class Car {
private:
    String brand;
    String model;
    int year;

public:

    Car(String brandName, String modelName, int yearProduced) {
        brand = brandName;
        model = modelName;
        year = yearProduced;
    };

    void updateBrandName(String _brandName) {
        brand = _brandName;
    }
    
    void updateModelName(String _modelName) {
        model = _modelName;
    }

    void updateYearProduced(int _yearProduced) {
        year = _yearProduced;
    }

    String getBrandName() {
        return brand;
    }

    String getModelName() {
        return model;
    }

    int getYear() {
        return year;
    }
};

int main() {
    Car merseder("Mersedes-Benz", "S222", 2022);

    if (merseder.getModelName() == "S222") {
        merseder.updateModelName("S220");
    }

    std::cout << merseder.getModelName();

    return 0;
}