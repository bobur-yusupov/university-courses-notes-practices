#!/bin/sh

if [ $# -eq 2 ]
then
	expr $1 + $2

else
	echo I need 2 values
fi

