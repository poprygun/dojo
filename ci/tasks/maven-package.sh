#!/usr/bin/env bash

cd resource-dojo
mvn package
mv target/dojo.jar ../output/dojo.jar