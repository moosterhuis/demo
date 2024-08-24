#!/usr/bin/env bash

npm run build
cp -r out/* ../src/main/resources/static
