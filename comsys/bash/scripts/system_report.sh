#!/bin/bash

show_summary=false

while getopts "s" opt; do
  case $opt in
    s)
      show_summary=true
      ;;
    \?)
      echo "Invalid option: -$OPTARG" >&2
      exit 1
      ;;
  esac
done

if $show_summary; then
  printf "Date: \e[36m%s\e[0m\n" "$(date +%F)"
  printf "Hostname: \e[32m%s\e[0m\n" "$(hostname)"
  printf "Memory Usage:\n"
  free -h | awk 'NR==2 {printf "  Total: %s\tUsed: %s\tFree: %s\n", $2, $3, $4}'

else # Show full report
  echo "Here is the System Report"
  echo

  printf "Current time is \e[36m%s\e[0m and current date is \e[36m%s\e[0m\n" "$(date +%T)" "$(date +%F)"

  printf "Hostname of the system is \e[32m%s\e[0m\n" "$(hostname)"

  printf "System uptime: \e[36m%s\e[0m\n" "$(uptime -p)"

  echo

  who -H -b

  echo

  printf "Memory Usage:\n"
  free -h | awk 'NR==2 {printf "  Total: %s\tUsed: %s\tFree: %s\n", $2, $3, $4}'
fi