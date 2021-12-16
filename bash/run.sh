#!/bin/bash

INPUT_FILE=$1
OUTPUT_LINES=$2

if [ "${INPUT_FILE}" = "" -o "${OUTPUT_LINES}" = "" ]; then
  echo "err: Not enough arguments"
  echo "Example usage: ./process myInputFile.txt 5"
  exit 1
fi

if [ ! -f $INPUT_FILE ]; then
  echo "err: Input file ${INPUT_FILE} doesn't exist"
  exit 1
fi

sort -k2 -nr $INPUT_FILE | head -n $OUTPUT_LINES | awk '{ print $1 }'
