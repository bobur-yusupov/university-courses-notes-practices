/*
wchar_t or wide character type is data type which accept complex characters. 
As char only 8-bit data type it would be hard to accept chinese or japanese characters.
*/

#include <iostream>

int main() {
    wchar_t text = L'あ';

    std::wcout << text;

    return 0;
}