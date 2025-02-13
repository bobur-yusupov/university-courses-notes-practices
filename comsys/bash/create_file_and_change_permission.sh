#!/bin/bash

if [[ ! -d ./exec/linux/txtFiles ]]; then
    mkdir -p ./exec/linux/file_permission

fi

# Name of a file
file_name="new_script.sh"
file_path="./exec/linux/file_permission"

# Create the new script file at the specified path
touch "$file_path/$file_name"

# Change the mode to executable
chmod +x "$file_path/$file_name"

# Print success message
echo "Success"
