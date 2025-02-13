#! /bin/bash

RED='\033[0;31m'
GREEN='\033[0;32m'
BLUE='\033[0;34m'
NC='\033[0m'

if [ $# -ne 1 ]; then
    echo -e "${RED}Error: limit not provided"

fi

LIMIT="$1"

df -h | awk 'NR>1 {print $5 " " $1}' | while read output;

do

    USAGE=$(echo $output | awk '{print $1}' | sed 's/%//')  # Remove '%' sign
    FILESYSTEM=$(echo $output | awk '{print $2}')

    if [ $USAGE -gt $LIMIT ]; then
        echo -e "${BLUE}Warning: Filesystem $FILESYSTEM is at ${USAGE}% usage, which exceeds the limit of ${LIMIT}%${NC}"
    else
        echo -e "${GREEN}Success: Filesystem $FILESYSTEM is at ${USAGE}% usage, which is within the limit.${NC}"
    fi

done