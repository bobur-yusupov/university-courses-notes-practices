#!/bin/sh

if test -f words.txt
then
        echo "File does not exist"
fi

sum=0

while read line
do
        echo $line | grep "stu" | wc -l >> num_lines.txt
done < $1

while read number
do
        sum=`expr $sum + $number`
done < num_lines.txt

rm num_lines.txt

echo $sum
