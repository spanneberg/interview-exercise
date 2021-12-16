#!/bin/bash

ENTRIES=$1
OUTPUT=$2

if [ "${ENTRIES}" = "" -o "${OUTPUT}" = "" ]; then
  echo "err: Not enough arguments"
  echo "Example usage: generate.sh 50 myTestData.txt"
  exit 1
fi

BASEURL="http://api.tech.com/item/"
BASE_ITEM_ID=121300

echo "" > $OUTPUT

for I in $( seq $ENTRIES ); do
  ITEM_ID=$(( $BASE_ITEM_ID + ( $RANDOM % 10000 ) ))
  WEIGHT=$RANDOM
  echo "${BASEURL}${ITEM_ID} $WEIGHT" >> $OUTPUT
done


