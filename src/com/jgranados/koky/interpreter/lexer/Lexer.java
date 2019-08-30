/* The following code was generated by JFlex 1.7.0 */

package com.jgranados.koky.interpreter.lexer;

import java_cup.runtime.*;
import com.jgranados.koky.interpreter.token.Token;
import com.jgranados.koky.interpreter.parser.sym;
import static com.jgranados.koky.interpreter.parser.sym.*;
import java.util.ArrayList;
import java.util.List;
import com.jgranados.koky.instructions.logic.Messages;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>Lexer.flex</tt>
 */
public class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\2\1\0\1\3\1\1\22\0\1\3\2\0\1\10"+
    "\1\4\3\0\1\45\1\46\1\51\1\47\1\42\1\50\1\0\1\52"+
    "\1\6\11\7\1\5\1\0\1\0\1\53\3\0\1\13\1\14\1\15"+
    "\1\20\1\11\1\21\1\22\1\23\1\24\1\12\1\25\1\26\1\12"+
    "\1\27\1\30\1\31\1\12\1\32\1\33\1\34\1\35\1\36\1\37"+
    "\1\40\1\41\1\12\1\43\1\0\1\44\1\0\1\4\1\0\1\13"+
    "\1\14\1\15\1\16\1\17\1\21\1\22\1\23\1\24\1\12\1\25"+
    "\1\26\1\12\1\27\1\30\1\31\1\12\1\32\1\33\1\34\1\35"+
    "\1\36\1\37\1\40\1\41\1\12\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uff95\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\1\3\1\1\2\4\1\5\14\1"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\2\5\2\1\1\21\3\1\1\22"+
    "\1\23\1\24\2\1\1\25\1\1\1\26\1\27\1\1"+
    "\1\27\1\1\1\30\2\1\1\31\1\1\1\32\1\33"+
    "\1\34\2\1\1\35\1\1\1\5\22\1\1\5\1\1"+
    "\1\36\7\1\1\37\1\40\7\1\1\41\1\1\1\5"+
    "\2\1\1\42\4\1\1\43\6\1\1\5\5\1\1\44"+
    "\3\1\1\45\12\1";

  private static int [] zzUnpackAction() {
    int [] result = new int[140];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\54\0\130\0\54\0\204\0\260\0\54\0\334"+
    "\0\u0108\0\u0134\0\u0160\0\u018c\0\u01b8\0\u01e4\0\u0210\0\u023c"+
    "\0\u0268\0\u0294\0\u02c0\0\u02ec\0\u0318\0\54\0\54\0\54"+
    "\0\54\0\54\0\54\0\54\0\54\0\54\0\54\0\260"+
    "\0\u0344\0\u0370\0\u039c\0\u03c8\0\u0134\0\u03f4\0\u0420\0\u044c"+
    "\0\u0134\0\u0134\0\u0134\0\u0478\0\u04a4\0\u0134\0\u04d0\0\u0134"+
    "\0\u0134\0\u04fc\0\u04fc\0\u0528\0\u0134\0\u0554\0\u0580\0\u0134"+
    "\0\u05ac\0\u0134\0\u0134\0\u0134\0\u05d8\0\u0604\0\u0134\0\u0630"+
    "\0\u065c\0\u0688\0\u06b4\0\u06e0\0\u070c\0\u0738\0\u0764\0\u0790"+
    "\0\u07bc\0\u07e8\0\u0814\0\u0840\0\u086c\0\u0898\0\u08c4\0\u08f0"+
    "\0\u091c\0\u0948\0\u0974\0\u09a0\0\u09cc\0\u0134\0\u09f8\0\u0a24"+
    "\0\u0a50\0\u0a7c\0\u0aa8\0\u0ad4\0\u0b00\0\u0b2c\0\u0134\0\u0b58"+
    "\0\u0b84\0\u0bb0\0\u0bdc\0\u0c08\0\u0c34\0\u0c60\0\u0134\0\u0c8c"+
    "\0\u0cb8\0\u0ce4\0\u0d10\0\u0134\0\u0d3c\0\u0d68\0\u0d94\0\u0dc0"+
    "\0\u0134\0\u0dec\0\u0e18\0\u0e44\0\u0e70\0\u0e9c\0\u0ec8\0\u0ef4"+
    "\0\u0f20\0\u0f4c\0\u0f78\0\u0fa4\0\u0fd0\0\u0134\0\u0ffc\0\u1028"+
    "\0\u1054\0\u0344\0\u1080\0\u10ac\0\u10d8\0\u1104\0\u1130\0\u115c"+
    "\0\u1188\0\u11b4\0\u11e0\0\u120c";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[140];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\2\1\6\1\7\1\10"+
    "\1\11\3\12\1\13\1\14\3\12\1\15\1\12\1\16"+
    "\2\12\1\17\2\12\1\20\1\21\1\22\1\23\1\12"+
    "\1\24\1\25\2\12\1\26\1\27\1\30\1\31\1\32"+
    "\1\33\1\34\1\35\1\36\1\37\56\0\1\4\54\0"+
    "\1\5\54\0\1\40\1\0\2\40\1\0\31\40\6\0"+
    "\1\40\11\0\2\10\44\0\1\41\2\0\3\41\2\42"+
    "\1\41\1\42\1\41\7\42\32\41\6\0\2\43\1\0"+
    "\31\12\20\0\2\43\1\0\2\12\1\44\11\12\1\45"+
    "\14\12\20\0\2\43\1\0\2\12\1\46\12\12\1\47"+
    "\1\12\1\50\1\12\1\51\1\52\6\12\20\0\2\43"+
    "\1\0\5\12\1\53\1\12\1\53\7\12\1\54\11\12"+
    "\20\0\2\43\1\0\13\12\1\55\7\12\1\56\5\12"+
    "\20\0\2\43\1\0\6\12\2\57\13\12\1\60\5\12"+
    "\20\0\2\43\1\0\5\12\1\61\1\62\1\63\7\12"+
    "\1\64\4\12\1\65\4\12\20\0\2\43\1\0\6\12"+
    "\2\66\3\12\1\67\7\12\1\70\5\12\20\0\2\43"+
    "\1\0\12\12\1\71\10\12\1\72\5\12\20\0\2\43"+
    "\1\0\5\12\1\73\2\74\7\12\1\75\11\12\20\0"+
    "\2\43\1\0\17\12\1\76\11\12\20\0\2\43\1\0"+
    "\5\12\1\77\1\12\1\77\3\12\1\100\15\12\12\0"+
    "\1\41\2\0\52\41\2\0\3\41\2\101\1\41\1\101"+
    "\1\41\7\101\32\41\6\0\2\43\52\0\2\43\1\0"+
    "\4\12\1\102\24\12\20\0\2\43\1\0\15\12\1\103"+
    "\13\12\20\0\2\43\1\0\6\12\2\104\21\12\20\0"+
    "\2\43\1\0\15\12\1\105\13\12\20\0\2\43\1\0"+
    "\21\12\1\106\7\12\20\0\2\43\1\0\5\12\1\107"+
    "\1\12\1\107\21\12\20\0\2\43\1\0\10\12\1\110"+
    "\20\12\20\0\2\43\1\0\16\12\1\111\12\12\20\0"+
    "\2\43\1\0\22\12\1\112\6\12\20\0\2\43\1\0"+
    "\20\12\1\113\10\12\20\0\2\43\1\0\11\12\1\114"+
    "\17\12\20\0\2\43\1\0\17\12\1\115\11\12\20\0"+
    "\2\43\1\0\4\12\1\116\1\117\1\120\1\121\21\12"+
    "\20\0\2\43\1\0\13\12\1\122\15\12\20\0\2\43"+
    "\1\0\5\12\1\123\1\12\1\123\21\12\12\0\1\41"+
    "\2\0\3\41\2\124\1\41\1\124\1\41\7\124\32\41"+
    "\6\0\2\43\1\0\14\12\1\125\14\12\20\0\2\43"+
    "\1\0\15\12\1\126\13\12\20\0\2\43\1\0\2\12"+
    "\1\127\26\12\20\0\2\43\1\0\17\12\1\130\11\12"+
    "\20\0\2\43\1\0\26\12\1\131\2\12\20\0\2\43"+
    "\1\0\6\12\2\132\21\12\20\0\2\43\1\0\23\12"+
    "\1\60\5\12\20\0\2\43\1\0\5\12\1\133\1\12"+
    "\1\133\14\12\1\134\4\12\20\0\2\43\1\0\13\12"+
    "\1\135\13\12\1\136\1\137\20\0\2\43\1\0\6\12"+
    "\2\140\21\12\20\0\2\43\1\0\12\12\1\141\16\12"+
    "\20\0\2\43\1\0\26\12\1\142\2\12\20\0\2\43"+
    "\1\0\6\12\2\143\21\12\20\0\2\43\1\0\21\12"+
    "\1\144\7\12\20\0\2\43\1\0\21\12\1\145\7\12"+
    "\20\0\2\43\1\0\21\12\1\146\7\12\20\0\2\43"+
    "\1\0\5\12\1\147\1\12\1\147\21\12\20\0\2\43"+
    "\1\0\23\12\1\150\5\12\12\0\1\41\2\0\3\41"+
    "\2\151\1\41\1\151\1\41\7\151\32\41\6\0\2\43"+
    "\1\0\26\12\1\152\2\12\20\0\2\43\1\0\21\12"+
    "\1\153\7\12\20\0\2\43\1\0\21\12\1\154\7\12"+
    "\20\0\2\43\1\0\2\12\1\155\26\12\20\0\2\43"+
    "\1\0\23\12\1\156\5\12\20\0\2\43\1\0\17\12"+
    "\1\157\11\12\20\0\2\43\1\0\20\12\1\65\10\12"+
    "\20\0\2\43\1\0\23\12\1\160\5\12\20\0\2\43"+
    "\1\0\30\12\1\161\20\0\2\43\1\0\2\12\1\162"+
    "\26\12\20\0\2\43\1\0\23\12\1\70\5\12\20\0"+
    "\2\43\1\0\23\12\1\163\5\12\20\0\2\43\1\0"+
    "\16\12\1\164\12\12\20\0\2\43\1\0\2\12\1\165"+
    "\26\12\20\0\2\43\1\0\2\12\1\166\26\12\20\0"+
    "\2\43\1\0\2\12\1\167\26\12\20\0\2\43\1\0"+
    "\12\12\1\77\16\12\12\0\1\41\2\0\3\41\2\170"+
    "\1\41\1\170\1\41\7\170\32\41\6\0\2\43\1\0"+
    "\2\12\1\171\26\12\20\0\2\43\1\0\22\12\1\52"+
    "\6\12\20\0\2\43\1\0\21\12\1\172\7\12\20\0"+
    "\2\43\1\0\24\12\1\173\4\12\20\0\2\43\1\0"+
    "\26\12\1\174\2\12\20\0\2\43\1\0\13\12\1\175"+
    "\15\12\20\0\2\43\1\0\23\12\1\176\5\12\20\0"+
    "\2\43\1\0\24\12\1\177\4\12\20\0\2\43\1\0"+
    "\23\12\1\200\5\12\20\0\2\43\1\0\26\12\1\73"+
    "\2\12\20\0\2\43\1\0\22\12\1\201\6\12\20\0"+
    "\2\43\1\0\22\12\1\201\3\12\1\73\2\12\12\0"+
    "\1\41\2\0\3\41\2\202\1\41\1\202\1\41\7\202"+
    "\32\41\6\0\2\43\1\0\21\12\1\203\7\12\20\0"+
    "\2\43\1\0\5\12\1\53\1\12\1\53\21\12\20\0"+
    "\2\43\1\0\21\12\1\204\7\12\20\0\2\43\1\0"+
    "\16\12\1\61\12\12\20\0\2\43\1\0\17\12\1\205"+
    "\11\12\20\0\2\43\1\0\21\12\1\206\7\12\20\0"+
    "\2\43\1\0\6\12\2\207\21\12\20\0\2\43\1\0"+
    "\6\12\2\74\21\12\20\0\2\43\1\0\5\12\1\45"+
    "\1\12\1\45\21\12\20\0\2\43\1\0\23\12\1\210"+
    "\5\12\20\0\2\43\1\0\16\12\1\211\12\12\20\0"+
    "\2\43\1\0\23\12\1\212\5\12\20\0\2\43\1\0"+
    "\21\12\1\51\7\12\20\0\2\43\1\0\15\12\1\213"+
    "\13\12\20\0\2\43\1\0\27\12\1\136\1\137\20\0"+
    "\2\43\1\0\15\12\1\214\13\12\20\0\2\43\1\0"+
    "\6\12\2\56\21\12\20\0\2\43\1\0\6\12\2\72"+
    "\21\12\12\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4664];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\1\1\1\11\2\1\1\11\16\1\12\11"+
    "\155\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[140];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true iff the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true iff the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
    private boolean analyzingFile = false;
    private List<String> errorsList;
    private Symbol symbol(int type) {


        String lexeme = yytext();
        System.out.printf("Token tipo %d, lexeme %s, en linea %d, columna %d\n", type, lexeme == null ? "" : lexeme, yyline + 1, yycolumn + 1);
        return new Symbol(type, new Token(lexeme, yyline + 1, yycolumn + 1));
    }

    private Symbol symbol(int type, String lexeme) {
        System.out.printf("Token tipo %d, lexeme %s, en linea %d, columna %d\n", type, lexeme == null ? "" : lexeme, yyline + 1, yycolumn + 1);
        return new Symbol(type, new Token(lexeme, yyline + 1, yycolumn + 1));
    }

    private void error(String lexeme) {
        if (isAnalyzingFile()) {
            errorsList.add(Messages.errorLexer(lexeme));
        } else {
            errorsList.add(Messages.errorLexer(lexeme));
        }
    }

    public void setAnalyzingFile(boolean value) {
        analyzingFile = value;
    }

    public boolean isAnalyzingFile() {
        return analyzingFile;
    }

    public List<String> getErrorsList() {
        return errorsList;
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
      errorsList = new ArrayList<>();
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 204) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(sym.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { error(yytext());
            } 
            // fall through
          case 38: break;
          case 2: 
            { return symbol(LINE_TERMINATOR);
            } 
            // fall through
          case 39: break;
          case 3: 
            { /*return symbol(WHITESPACE); */
            } 
            // fall through
          case 40: break;
          case 4: 
            { return symbol(INTEGER_LITERAL, yytext());
            } 
            // fall through
          case 41: break;
          case 5: 
            { /* ignoring */
            } 
            // fall through
          case 42: break;
          case 6: 
            { return symbol(COMMA);
            } 
            // fall through
          case 43: break;
          case 7: 
            { return symbol(OPEN_BRACKET);
            } 
            // fall through
          case 44: break;
          case 8: 
            { return symbol(CLOSE_BRACKET);
            } 
            // fall through
          case 45: break;
          case 9: 
            { return symbol(OPEN_PAR);
            } 
            // fall through
          case 46: break;
          case 10: 
            { return symbol(CLOSE_PAR);
            } 
            // fall through
          case 47: break;
          case 11: 
            { return symbol(PLUS);
            } 
            // fall through
          case 48: break;
          case 12: 
            { return symbol(MINUS);
            } 
            // fall through
          case 49: break;
          case 13: 
            { return symbol(MULT);
            } 
            // fall through
          case 50: break;
          case 14: 
            { return symbol(DIV);
            } 
            // fall through
          case 51: break;
          case 15: 
            { return symbol(EQ);
            } 
            // fall through
          case 52: break;
          case 16: 
            { return symbol(ID, yytext());
            } 
            // fall through
          case 53: break;
          case 17: 
            { return symbol(BACKWARD);
            } 
            // fall through
          case 54: break;
          case 18: 
            { return symbol(TOCENTER);
            } 
            // fall through
          case 55: break;
          case 19: 
            { return symbol(CLEARS);
            } 
            // fall through
          case 56: break;
          case 20: 
            { return symbol(FORWARD);
            } 
            // fall through
          case 57: break;
          case 21: 
            { return symbol(HIDETURTLE);
            } 
            // fall through
          case 58: break;
          case 22: 
            { return symbol(LEFT);
            } 
            // fall through
          case 59: break;
          case 23: 
            { return symbol(PENDOWN);
            } 
            // fall through
          case 60: break;
          case 24: 
            { return symbol(PENUP);
            } 
            // fall through
          case 61: break;
          case 25: 
            { return symbol(RIGHT);
            } 
            // fall through
          case 62: break;
          case 26: 
            { return symbol(SHOWTURTLE);
            } 
            // fall through
          case 63: break;
          case 27: 
            { return symbol(TODRAW);
            } 
            // fall through
          case 64: break;
          case 28: 
            { return symbol(TOERASE);
            } 
            // fall through
          case 65: break;
          case 29: 
            { return symbol(WIDTH);
            } 
            // fall through
          case 66: break;
          case 30: 
            { return symbol(CALL);
            } 
            // fall through
          case 67: break;
          case 31: 
            { return symbol(POSITIONX);
            } 
            // fall through
          case 68: break;
          case 32: 
            { return symbol(POSITIONY);
            } 
            // fall through
          case 69: break;
          case 33: 
            { return symbol(VOID);
            } 
            // fall through
          case 70: break;
          case 34: 
            { return symbol(COLOR);
            } 
            // fall through
          case 71: break;
          case 35: 
            { return symbol(POSITIONXY);
            } 
            // fall through
          case 72: break;
          case 36: 
            { return symbol(REPEAT);
            } 
            // fall through
          case 73: break;
          case 37: 
            { return symbol(HEXA_LITERAL, yytext());
            } 
            // fall through
          case 74: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
