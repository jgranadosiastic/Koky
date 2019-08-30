
echo "STARTING JFLEX COMPILING"
#change the location of jflex jar
java -jar ~/CUNOC/bin/jflex-1.6.1.jar  -d  /home/richard/Documentos/Compi2/KOKY/Koky/src/com/jgranados/koky/interpreter/lexer/languages LexerEs.flex
java -jar ~/CUNOC/bin/jflex-1.6.1.jar  -d  /home/richard/Documentos/Compi2/KOKY/Koky/src/com/jgranados/koky/interpreter/lexer/languages LexerKiche.flex
java -jar ~/CUNOC/bin/jflex-1.6.1.jar  -d  /home/richard/Documentos/Compi2/KOKY/Koky/src/com/jgranados/koky/interpreter/lexer/languages LexerAll.flex
