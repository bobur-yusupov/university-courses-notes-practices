while read name
do
        echo $name | wc -m
done < $1
