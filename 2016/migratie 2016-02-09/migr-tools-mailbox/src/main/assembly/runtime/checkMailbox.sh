#!/bin/bash

pidfile=pids

while read pid
do
  ps -f $pid | grep nl.bzk.migratiebrp.tools.mailbox.MailboxMain >/dev/null
  isrunning=$?
  if [ $isrunning -eq 0 ]
  then
    echo "Proces $pid is running"
  else
    echo "Proces $pid is not running"
  fi
done < "$pidfile"
