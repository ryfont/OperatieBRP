FROM ${docker.registry}/busyboxappserver:0.1.1
MAINTAINER Operatie BRP

# Configuratie
ENV JMX_HOST localhost
ENV JMX_PORT 1099

# Setup
USER root
COPY migr-sync-runtime.zip /opt/appserver/migr-sync-runtime.zip
RUN cd /opt/appserver && unzip -o migr-sync-runtime.zip
COPY conf/* /opt/appserver/conf/
RUN chown -R appserver:appserver /opt/appserver

# External
EXPOSE $JMX_PORT
VOLUME ["/opt/appserver/conf"]
VOLUME ["/opt/appserver/logs"]
VOLUME ["/opt/appserver/work"]

# Run
USER appserver
WORKDIR /opt/appserver
CMD java -cp conf:lib/* -Dcom.sun.management.jmxremote -Djava.rmi.server.hostname=$JMX_HOST -Dcom.sun.management.jmxremote.port=$JMX_PORT -Dcom.sun.management.jmxremote.rmi.port=$JMX_PORT -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.local.only=false nl.bzk.migratiebrp.synchronisatie.runtime.Main -modus ${sync.modus}
