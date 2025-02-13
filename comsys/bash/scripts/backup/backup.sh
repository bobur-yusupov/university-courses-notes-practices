#! /bin/bash

RED='\033[0;31m'
GREEN='\033[0;32m'
BLUE='\033[0;34m'
NC='\033[0m'

if [ $# -ne 2 ]; then
    echo -e "${RED}Error: Two arguments are required.${NC}"
    echo -e "${BLUE}Usage: $0 <source_directory> <backup_directory>${NC}"
    exit 1

fi

SOURCE_DIR="$1"
BACKUP_DIR="$2"

if [ ! -d "$SOURCE_DIR" ]; then
    echo "Error: Source directory $SOURCE_DIR does not exist."

    exit 1

fi

TIMESTAMP=$(date +"%Y%m%d_%H%M%S")

BACKUP_PATH="$BACKUP_DIR/$(basename "$SOURCE_DIR")_$TIMESTAMP"
mkdir -p "$BACKUP_PATH"

cp -r "$SOURCE_DIR/"* "$BACKUP_PATH/"

if [ $? -eq 0 ]; then
    echo
    echo -e "${GREEN}Success: Backup of '$SOURCE_DIR' created at '$BACKUP_PATH'.${NC}"
    echo

else
    echo "Error during backup."
    
    exit 1

fi