#!/bin/bash

if [ ! -f src/process/Process.class ]; then
  echo "Compiling program ..."
  javac src/process/Process.java
fi

java -cp src/process/* process.Process $@
