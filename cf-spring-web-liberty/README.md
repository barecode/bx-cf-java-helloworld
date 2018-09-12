## Basic Web
IBM Cloud Basic Web Starter for Spring

## Customizations for Liberty + Spring Boot uber jar

**THIS IS NOT CURRENTLY WORKING! :(**

This is being experimented with buildpacks `liberty-for-java` and https://github.com/cloudfoundry/ibm-websphere-liberty-buildpack 

The manifest.yml has a few specific settings:
* buildpack: https://github.com/barecode/ibm-websphere-liberty-buildpack
* env: WLP_JAR_EXTRACT_ROOT: /tmp

My custom buildpack is used for testing purposes, but any changes will be merged into mainline `liberty-for-java`.

Current problems:
- The home directory for the buildpack is not writable. Instead of `/home/vcap/wlpExtract` we set `WLP_JAR_EXTRACT_ROOT=/tmp`. See [runnable jar variables](https://www.ibm.com/support/knowledgecenter/en/SSEQTP_liberty/com.ibm.websphere.wlp.doc/ae/rwlp_setup_jarserver.html)

Relevant documentation:
- https://docs.cloudfoundry.org/devguide/deploy-apps/manifest.html#env-block
- https://docs.cloudfoundry.org/devguide/deploy-apps/environment-variable.html#TMPDIR


[![](https://img.shields.io/badge/IBM%20Cloud-powered-blue.svg)](https://bluemix.net)
[![Platform](https://img.shields.io/badge/platform-java-lightgrey.svg?style=flat)](https://www.ibm.com/developerworks/learn/java/)

### Table of Contents
* [Summary](#summary)
* [Requirements](#requirements)
* [Configuration](#configuration)
* [Project contents](#project-contents)
* [Run](#run)

### Summary

The IBM Cloud Basic Web Starter in Java provides a starting point for creating web applications running on [Spring](https://spring.io/).

To deploy this application to IBM Cloud using a toolchain click the **Create Toolchain** button.
[![Create Toolchain](https://console.ng.bluemix.net/devops/graphics/create_toolchain_button.png)](https://console.ng.bluemix.net/devops/setup/deploy/)

### Requirements
* [Maven](https://maven.apache.org/install.html)
* Java 8: Any compliant JVM should work.
  * [Java 8 JDK from Oracle](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
  * [Java 8 JDK from IBM (AIX, Linux, z/OS, IBM i)](http://www.ibm.com/developerworks/java/jdk/)

### Configuration
Capabilities are provided through dependencies in the pom.xml file.

### Project contents
The ports are set to the defaults of 8080 for http and 8443 for https and are exposed to the CLI in the cli-config.yml file.

The project contains IBM Cloud specific files that are used to deploy the application as part of a IBM Cloud DevOps flow. The `.bluemix` directory contains files used to define the IBM Cloud toolchain and pipeline for your application. The `manifest.yml` file specifies the name of your application in IBM Cloud, the timeout value during deployment and which services to bind to.


Credentials are either taken from the VCAP_SERVICES environment variable that IBM Cloud provides or from environment variables passed in by the config file `src/main/resources/application-local.properties`.

### Run

To build and run the application:
1. `mvn install`
1. `java -jar ./target/cfspringwebliberty-1.0-SNAPSHOT.jar`

To run the application in Docker use the Docker file called `Dockerfile`. If you do not want to install Maven locally you can use `Dockerfile-tools` to build a container with Maven installed.

### Endpoints

The application exposes the following endpoints:
* Health endpoint: `<host>:<port>/health` e.g. http://localhost:8080/health
* Web content: `<host>:<port>`

The ports are set in the pom.xml file and exposed to the CLI in the cli-config.yml file.

### Notices

This project was generated using:
* generator-ibm-java v5.12.4
* ibm-java-codegen-common v3.0.1
* generator-ibm-service-enablement v2.5.0
* generator-ibm-cloud-enablement v1.2.0
* generator-ibm-java-spring v2.2.4
