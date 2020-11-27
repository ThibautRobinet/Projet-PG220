JFLAGS = -d
JC = javac
B = build

FILES = \
	src/main/java/information/*.java \
	src/main/java/board/*.java \
	src/main/java/game/*.java \
	src/main/java/player/*.java \
	src/main/java/Main.java 
	

all: clean
	$(JC) $(JFLAGS) $(B) -cp src/main/ $(FILES)
	java -cp build Main
clean:
	rm -rf build*/*