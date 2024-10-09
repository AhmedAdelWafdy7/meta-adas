#!/bin/bash

while true; do
  /usr/bin/info_client 
  if [ $? -eq 0 ]; then
    break
  else
    sleep 5
  fi
done
