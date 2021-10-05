javac Main.java
if [ -f Main.class ]
then
	echo "Compilation Successful... Running Program"
	java Main
	rm Main.class
else
	echo "There were errors"
fi

