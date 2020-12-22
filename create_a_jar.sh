#!/bin/bash
make
cd build
jar -cfe jeu.jar Main $(find . -name "*.class")
cd ..
cp build/jeu.jar jeu.jar
