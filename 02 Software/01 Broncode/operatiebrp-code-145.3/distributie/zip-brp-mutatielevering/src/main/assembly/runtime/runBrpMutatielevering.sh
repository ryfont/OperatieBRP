#!/bin/bash

# store process ids in the "pids" file
pidfile=pids

touch "$pidfile"

#if [ -z ${JMX_PORT+x} ]; then JMX_PORT=1099; fi

#java -cp "conf:lib/*" -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=$JMX_PORT -Dcom.sun.management.jmxremote.rmi.port=$JMX_PORT -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.local.only=false nl.bzk.migratiebrp.isc.runtime.Main $@ >output.txt 2>&1 &
java -cp "./lib/*:conf/" -Xmx512M nl.bzk.brp.delivery.mutatielevering.Main $@ >output.txt 2>&1 &

syncpid=$!
echo $syncpid >>"$pidfile"
