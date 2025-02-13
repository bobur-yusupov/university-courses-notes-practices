#!/bin/bash

# Shell script executes the command which creates a new folder and creates multiple .txt files

if [[ ! -d ./exec/linux/txtFiles ]]; then
    mkdir -p ./exec/linux/txtFiles

fi

cd ./exec/linux/txtFiles

for number in {1..10};
do
    echo "This file number $number" > $number.txt
done