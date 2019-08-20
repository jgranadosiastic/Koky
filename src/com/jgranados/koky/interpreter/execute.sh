#! /bin/bash 
echo "STARTING JFLEX COMPILING"
#change the location of jflex jar
java -jar ~/CUNOC/bin/jflex-1.6.1.jar -d lexer lexer/Lexer.flex

echo "STARTING CUP COMPILING"
#change the location of cup jar
java -jar ~/CUNOC/bin/java-cup-11b.jar -parser Parser parser/Parser.cup
mv Parser.java parser/Parser.java
mv sym.java parser/sym.java
