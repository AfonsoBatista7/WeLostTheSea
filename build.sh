#!/bin/bash

# Clean and compile the project
mvn clean package

# Check if the build was successful
if [ $? -eq 0 ]; then
    echo "Project compiled successfully."
else
    echo "Compilation failed."
    exit 1
fi
