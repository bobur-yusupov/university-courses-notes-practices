#!/bin/bash

# Check if a threshold value is provided
if [ -z "$1" ]; then
  echo "Usage: ./fekez.sh <distance_threshold>"
  exit 1
fi

threshold=$1

# Process each line in data.txt
while read -r date time speed _ distance_to _; do
  # Check if distance to the front is less than the threshold
  if [ $((distance_to)) -lt "$threshold" ]; then
    echo "Brake! Break at $time. Your distance is less than $threshold"
  fi

done < data.txt
