number=$1

i=1

while [[ $i < 6 ]]
do
        expr $number \* $i

        i=`expr $i + 1`
done
