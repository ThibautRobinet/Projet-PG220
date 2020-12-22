#!/bin/bash
make
cd build
jar -cfe puissance.jar MainFormulaire $(find . -name "*.class")
cd ..
cp build/puissance.jar puissance.jar
