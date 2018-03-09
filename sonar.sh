#! /bin/bash

# Run a clean package to ensure the sonar runs fine.

mvn clean package org.sonarsource.scanner.maven:sonar-maven-plugin:3.4.0.905:sonar -DrunSonar
