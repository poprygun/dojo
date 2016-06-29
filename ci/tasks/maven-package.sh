#!/usr/bin/env bash

cd resource-dojo
mvn package
mv target/dojo.war ../output/dojo.war