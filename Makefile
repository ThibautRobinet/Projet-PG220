JFLAGS = -d
JC = javac -classpath lib/pmml-evaluator-example-executable-1.5.7.jar
B = build

FILES = \
	src/main/java/information/*.java \
	src/main/java/game/*.java \
	src/main/java/game/board/*.java \
	src/main/java/player/*.java \
	src/main/java/*.java \
	src/Test/Test.java
	 


all: clean
	$(JC) $(JFLAGS) $(B) -cp src/main/ $(FILES) -Xlint:unchecked

run:
	java -cp build Main

formulaire:
	java -cp build MainFormulaire

test: 
	java -cp build Test

create_jar:all
	./create_a_jar.sh

run_jar:
	java -jar puissance.jar

clean:
	rm -rf puissance.jar
	rm -rf human_move.txt
	rm -rf player*.txt
	rm -rf build*/*
	rm -rf log.txt
	rm -rf ./.DS_Store
	rm -rf ./src/.DS_Store
	rm -rf ./src/main/.DS_Store
	rm -rf ./src/main/java/.DS_Store