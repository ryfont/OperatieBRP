#!/bin/sh

export CP=test-client-0.0.1-SNAPSHOT.jar
export CP=$CP:lib/stax-api-1.0-2.jar
export CP=$CP:lib/aopalliance-1.0.jar
export CP=$CP:lib/asm-3.3.jar
export CP=$CP:lib/commons-io-2.1.jar
export CP=$CP:lib/commons-logging-1.1.1.jar
export CP=$CP:lib/cxf-api-2.4.2.jar
export CP=$CP:lib/cxf-common-utilities-2.4.2.jar
export CP=$CP:lib/cxf-rt-bindings-soap-2.4.2.jar
export CP=$CP:lib/cxf-rt-bindings-xml-2.4.2.jar
export CP=$CP:lib/cxf-rt-core-2.4.2.jar
export CP=$CP:lib/cxf-rt-databinding-jaxb-2.4.2.jar
export CP=$CP:lib/cxf-rt-frontend-jaxws-2.4.2.jar
export CP=$CP:lib/cxf-rt-frontend-simple-2.4.2.jar
export CP=$CP:lib/cxf-rt-transports-common-2.4.2.jar
export CP=$CP:lib/cxf-rt-transports-http-2.4.2.jar
export CP=$CP:lib/cxf-rt-ws-addr-2.4.2.jar
export CP=$CP:lib/cxf-rt-ws-security-2.4.2.jar
export CP=$CP:lib/cxf-tools-common-2.4.2.jar
export CP=$CP:lib/geronimo-javamail_1.4_spec-1.7.1.jar
export CP=$CP:lib/hamcrest-core-1.1.jar
export CP=$CP:lib/javassist-3.15.0-GA.jar
export CP=$CP:lib/jaxb-impl-2.1.13.jar
export CP=$CP:lib/joda-time-1.6.2.jar
export CP=$CP:lib/junit-4.10.jar
export CP=$CP:lib/log4j-1.2.16.jar
export CP=$CP:lib/mockito-all-1.9.0-rc1.jar
export CP=$CP:lib/neethi-3.0.1.jar
export CP=$CP:lib/objenesis-1.2.jar
export CP=$CP:lib/opensaml-2.4.1.jar
export CP=$CP:lib/openws-1.4.1.jar
export CP=$CP:lib/powermock-api-mockito-1.4.10.jar
export CP=$CP:lib/powermock-api-support-1.4.10.jar
export CP=$CP:lib/powermock-core-1.4.10.jar
export CP=$CP:lib/powermock-module-junit4-1.4.10.jar
export CP=$CP:lib/powermock-module-junit4-common-1.4.10.jar
export CP=$CP:lib/powermock-reflect-1.4.10.jar
export CP=$CP:lib/serializer-2.7.1.jar
export CP=$CP:lib/slf4j-api-1.6.2.jar
export CP=$CP:lib/slf4j-log4j12-1.6.2.jar
export CP=$CP:lib/spring-aop-3.0.5.RELEASE.jar
export CP=$CP:lib/spring-asm-3.0.5.RELEASE.jar
export CP=$CP:lib/spring-beans-3.0.5.RELEASE.jar
export CP=$CP:lib/spring-context-3.0.5.RELEASE.jar
export CP=$CP:lib/spring-core-3.0.5.RELEASE.jar
export CP=$CP:lib/spring-expression-3.0.5.RELEASE.jar
export CP=$CP:lib/spring-web-3.0.5.RELEASE.jar
export CP=$CP:lib/stax2-api-3.0.2.jar
export CP=$CP:lib/woodstox-core-asl-4.1.1.jar
export CP=$CP:lib/wsdl4j-1.6.2.jar
export CP=$CP:lib/wss4j-1.6.2.jar
export CP=$CP:lib/xalan-2.7.1.jar
export CP=$CP:lib/xml-resolver-1.2.jar
export CP=$CP:lib/xmlschema-core-2.0.jar
export CP=$CP:lib/xmlsec-1.4.5.jar
export CP=$CP:lib/xmltooling-1.3.1.jar
echo $CP
java -cp $CP nl.bzk.brp.testclient.TestClient test-client.properties
