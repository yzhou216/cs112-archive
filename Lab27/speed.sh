#! /bin/bash
echo Selection Sort,$(java SelectionTime.java)$'\n'Insertion Sort,$(java InsertionTime.java) | tee speed.csv
