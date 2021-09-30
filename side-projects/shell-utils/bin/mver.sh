#!/bin/bash -l
mvn --batch-mode release:update-versions -DdevelopmentVersion=$1
