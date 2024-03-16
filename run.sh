#!/bin/bash

JAVA_MAJOR_VERSION=$(java -version 2>&1 | sed -E -n 's/.* version "([^.-]*).*"/\1/p' | cut -d' ' -f1)

if [[ "$JAVA_MAJOR_VERSION" -lt 22 ]]; then
  echo "Java version 22 required"
  exit 1
fi

rm HelloWorld.class HelloWorldTranslator.class
javac --release 22 --enable-preview HelloWorld.java 2>/dev/null
java --enable-preview HelloWorld
javac --release 22 --enable-preview HelloWorldTranslator.java 2>/dev/null
java -cp . --enable-preview HelloWorldTranslator HelloWorld.class "${1:-Hello Wereld}"
java --enable-preview HelloWorld
