#!/bin/sh

sum=0

while read number
do
	sum=`expr $number + $sum`

done < $1

echo $sum
