#!/bin/bash

if [ ! -f process ]; then
  echo "Compiling program ..."
  go build
fi

./process $@
