#!/bin/sh

if test -f words.txt
then
	rm words.txt
fi

while read word
	test "$word" != "end"

do
	echo $word >> words.txt
done
if test -f words.txt
then
	sort words.txt
	rm words.txt

fi
