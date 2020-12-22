#!/bin/bash
make
cd build
jar -cfe jeuFenetre.jar MainFormulaire $(find . -name "*.class")
cd ..
cp build/jeuFenetre.jar jeuFenetre.jar
