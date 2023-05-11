#! /bin/bash
echo java,$(java Bubble.java)$'\n'JavaScript,$(node Bubble.js) | tee speed.csv
