
echo "STARTING JFLEX COMPILING"
#change the location of jflex jar
java -jar /home/richard/Documentos/Compi1/JFlexCup/jflex-1.7.0/lib/jflex-full-1.7.0.jar -d /home/richard/Documentos/Compi2/Koky-master/src/com/rmendez/koky/interpreter/lexer LexerEs.flex
java -jar /home/richard/Documentos/Compi1/JFlexCup/jflex-1.7.0/lib/jflex-full-1.7.0.jar -d /home/richard/Documentos/Compi2/Koky-master/src/com/rmendez/koky/interpreter/lexer LexerKiche.flex
java -jar /home/richard/Documentos/Compi1/JFlexCup/jflex-1.7.0/lib/jflex-full-1.7.0.jar -d /home/richard/Documentos/Compi2/Koky-master/src/com/rmendez/koky/interpreter/lexer LexerAll.flex
