#! /bin/bash 
echo "STARTING JFLEX COMPILING"
#change the location of jflex jar
java -jar /home/richard/Documentos/Compi1/JFlexCup/jflex-1.7.0/lib/jflex-full-1.7.0.jar -d lexer lexer/Lexer.flex

echo "STARTING CUP COMPILING"
#change the location of cup jar
java -jar /home/richard/Documentos/Compi1/JFlexCup/java-cup-bin-11b-20160615/java-cup-11b.jar -parser Parser parser/Parser.cup
mv Parser.java parser/Parser.java
mv sym.java parser/sym.java