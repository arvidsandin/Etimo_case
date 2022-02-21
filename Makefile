all:
	javac -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar *.java

run:
	java UserInterface

test:
	javac -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar *.java
	java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore TestStore

clean:
	rm -rf *.class