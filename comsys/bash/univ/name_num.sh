#!/bin/sh

if test $# -gt 0
then
	for name in $*
	do
		getent passwd | grep $name | wc -l
	done

else
	for name in `cat`
	do
		gotent passwd | grep $name | wc -l
	done
fi
