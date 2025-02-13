#!/bin/sh

sumOdds=0

while read number
do
    if [ $((number % 2)) -eq 1 ]
    then
        sumOdds=$((sumOdds + number))
    fi
done < numbers.txt

echo "Sum of odd numbers: $sumOdds"