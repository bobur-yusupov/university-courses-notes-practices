/*
    Structure or so-called "struct" is a user-defined data type to store related variables into one place
    Unlike array, struct contain different type of data types (int, string, float)
*/

#include <iostream>

using namespace std;

struct Student {
    string firstName;
    string lastName;
    int age;
};

int main() {
    Student student1; // creating student1

    // Assigning values to members of Student struct
    student1.firstName = "Test";
    student1.lastName = "Testov";
    student1.age = 18;

    cout << "First Name: " << student1.firstName << endl;
    cout << "Last Name: " << student1.lastName << endl;
    cout << "Age: " << student1.age << endl;
}