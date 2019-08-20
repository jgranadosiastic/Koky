/* The following code was generated by JFlex 1.7.0 */

package com.jgranados.koky.interpreter.lexer.languages;

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
 * from the specification file <tt>LexerAll.flex</tt>
 */
public class LexerAll implements java_cup.runtime.Scanner {

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
    "\1\4\2\0\1\57\1\50\1\51\1\54\1\52\1\45\1\53\1\0"+
    "\1\55\1\6\11\7\1\5\1\0\1\0\1\56\3\0\1\13\1\14"+
    "\1\15\1\20\1\11\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41"+
    "\1\42\1\43\1\44\1\12\1\46\1\0\1\47\1\0\1\4\1\0"+
    "\1\13\1\14\1\15\1\16\1\17\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37"+
    "\1\40\1\41\1\42\1\43\1\44\1\12\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uff95\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\1\3\1\1\2\4\1\5\26\1"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\2\5\2\1\1\21\1\22\2\1"+
    "\1\23\1\24\1\25\1\0\1\22\2\1\1\26\1\27"+
    "\1\30\1\1\1\31\2\1\1\32\1\1\1\33\2\1"+
    "\1\34\1\35\1\1\1\0\4\1\1\21\1\1\1\25"+
    "\7\1\1\24\1\31\6\1\1\5\6\1\1\0\15\1"+
    "\1\0\13\1\2\0\6\1\1\0\4\1\1\5\6\1"+
    "\1\0\1\36\1\37\14\1\2\0\7\1\1\36\1\37"+
    "\4\1\2\0\6\1\1\0\4\1\1\5\4\1\1\0"+
    "\1\40\2\1\1\41\6\1\1\42\2\0\2\1\1\0"+
    "\3\1\1\40\4\1\2\0\6\1\1\0\3\1\1\5"+
    "\4\1\1\0\5\1\2\0\2\1\1\0\6\1\1\27"+
    "\1\0\3\1\1\0\1\26\1\1\1\0\1\1\1\43"+
    "\3\1\1\0\2\1\2\0\1\1\1\33\3\1\1\0"+
    "\2\1\1\0\1\1\2\0\2\1\2\0\3\1\1\0"+
    "\1\1\1\0\1\1\1\30\1\1\1\32\1\0\2\1"+
    "\1\31\1\1\1\24\1\1\1\0\1\1\1\34\1\1";

  private static int [] zzUnpackAction() {
    int [] result = new int[311];
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
    "\0\0\0\60\0\140\0\60\0\220\0\300\0\60\0\360"+
    "\0\u0120\0\u0150\0\u0180\0\u01b0\0\u01e0\0\u0210\0\u0240\0\u0270"+
    "\0\u02a0\0\u02d0\0\u0300\0\u0330\0\u0360\0\u0390\0\u03c0\0\u03f0"+
    "\0\u0420\0\u0450\0\u0480\0\u04b0\0\u04e0\0\u0510\0\u0540\0\60"+
    "\0\60\0\60\0\60\0\60\0\60\0\60\0\60\0\60"+
    "\0\60\0\300\0\u0570\0\u05a0\0\u05d0\0\u0600\0\u0630\0\u0150"+
    "\0\u0660\0\u0690\0\u0150\0\u06c0\0\u0150\0\u06f0\0\u0720\0\u0750"+
    "\0\u0780\0\u0150\0\u0150\0\u0150\0\u07b0\0\u07e0\0\u0810\0\u0840"+
    "\0\u0150\0\u0870\0\u0150\0\u08a0\0\u08d0\0\u0150\0\u0150\0\u0900"+
    "\0\u0930\0\u0960\0\u0990\0\u09c0\0\u09f0\0\u0150\0\u0a20\0\u0a20"+
    "\0\u0a50\0\u0a80\0\u0ab0\0\u0ae0\0\u0b10\0\u0b40\0\u0b70\0\u0150"+
    "\0\u0150\0\u0ba0\0\u0bd0\0\u0c00\0\u0c30\0\u0c60\0\u0c90\0\u0cc0"+
    "\0\u0cf0\0\u0d20\0\u0d50\0\u0d80\0\u0db0\0\u0de0\0\u0e10\0\u0e40"+
    "\0\u0e70\0\u0ea0\0\u0ed0\0\u0f00\0\u0f30\0\u0f60\0\u0f90\0\u0fc0"+
    "\0\u0ff0\0\u1020\0\u1050\0\u1080\0\u10b0\0\u10e0\0\u1110\0\u1140"+
    "\0\u1170\0\u11a0\0\u11d0\0\u1200\0\u1230\0\u1260\0\u1290\0\u12c0"+
    "\0\u12f0\0\u1320\0\u1350\0\u1380\0\u13b0\0\u13e0\0\u1410\0\u1440"+
    "\0\u1470\0\u14a0\0\u14d0\0\u1500\0\u1530\0\u1560\0\u1590\0\u15c0"+
    "\0\u15f0\0\u1620\0\u1650\0\u1680\0\u16b0\0\u16e0\0\60\0\u1710"+
    "\0\u1740\0\u1770\0\u17a0\0\u17d0\0\u1800\0\u1830\0\u1860\0\u1890"+
    "\0\u18c0\0\u18f0\0\u1920\0\u1950\0\u1980\0\u19b0\0\u19e0\0\u1a10"+
    "\0\u1a40\0\u1a70\0\u1aa0\0\u1ad0\0\u1b00\0\u0150\0\u1b30\0\u1b60"+
    "\0\u1b90\0\u1bc0\0\u1bf0\0\u1c20\0\u1c50\0\u1c80\0\u1cb0\0\u1ce0"+
    "\0\u1d10\0\u1d40\0\u1d70\0\u1da0\0\u1dd0\0\u1e00\0\u1e30\0\u1e60"+
    "\0\u1e90\0\u1ec0\0\u1ef0\0\u1f20\0\u1f50\0\60\0\u1f80\0\u1fb0"+
    "\0\u0150\0\u1fe0\0\u2010\0\u2040\0\u2070\0\u20a0\0\u20d0\0\u0150"+
    "\0\u2100\0\u2130\0\u2160\0\u2190\0\u21c0\0\u21f0\0\u2220\0\u2250"+
    "\0\u0150\0\u2280\0\u22b0\0\u22e0\0\u2310\0\u2340\0\u2370\0\u23a0"+
    "\0\u23d0\0\u2400\0\u2430\0\u2460\0\u2490\0\u24c0\0\u24f0\0\u2520"+
    "\0\u2550\0\u2580\0\u25b0\0\u25e0\0\u2610\0\u2640\0\u2670\0\u26a0"+
    "\0\u26d0\0\u2700\0\u2730\0\u2760\0\u2790\0\u27c0\0\u27f0\0\u2820"+
    "\0\u2850\0\u2880\0\u28b0\0\u28e0\0\u2910\0\u2940\0\u2970\0\60"+
    "\0\u29a0\0\u29d0\0\u2a00\0\u2a30\0\u2a60\0\60\0\u2a90\0\u2ac0"+
    "\0\u2af0\0\u0570\0\u2b20\0\u2b50\0\u2b80\0\u2bb0\0\u2be0\0\u2c10"+
    "\0\u2c40\0\u2c70\0\u2ca0\0\60\0\u2cd0\0\u2d00\0\u2d30\0\u2d60"+
    "\0\u2d90\0\u2dc0\0\u2df0\0\u2e20\0\u2e50\0\u2e80\0\u2eb0\0\u2ee0"+
    "\0\u2f10\0\u2f40\0\u2f70\0\u2fa0\0\u2fd0\0\u3000\0\u3030\0\u3060"+
    "\0\u3090\0\60\0\u30c0\0\60\0\u30f0\0\u3120\0\u3150\0\60"+
    "\0\u3180\0\60\0\u31b0\0\u31e0\0\u3210\0\60\0\u3240";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[311];
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
    "\1\11\2\12\1\13\1\14\1\15\1\16\1\12\1\16"+
    "\1\17\1\12\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\12\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\1\12\1\40\1\41\1\42\1\43"+
    "\1\44\1\45\1\46\1\47\1\50\1\51\1\2\62\0"+
    "\1\4\60\0\1\5\60\0\1\52\1\0\2\52\1\0"+
    "\34\52\6\0\1\52\12\0\2\10\50\0\1\53\2\0"+
    "\3\53\2\54\1\53\1\54\1\53\7\54\36\53\6\0"+
    "\2\55\1\0\34\12\21\0\2\55\1\0\16\12\1\56"+
    "\1\12\1\57\3\12\1\60\3\12\1\61\3\12\21\0"+
    "\2\55\1\0\2\12\1\62\12\12\1\63\3\12\1\64"+
    "\2\12\1\65\7\12\12\0\1\66\6\0\2\55\1\0"+
    "\12\12\1\67\1\12\1\63\1\12\1\70\2\12\1\71"+
    "\2\12\1\72\1\73\6\12\21\0\2\55\1\0\2\12"+
    "\1\74\3\12\2\75\3\12\1\76\20\12\21\0\2\55"+
    "\1\0\5\12\1\60\1\12\1\60\11\12\1\77\12\12"+
    "\21\0\2\55\1\0\13\12\1\100\12\12\1\101\5\12"+
    "\21\0\2\55\1\0\1\12\1\102\1\103\31\12\21\0"+
    "\2\55\1\0\2\12\1\104\31\12\21\0\2\55\1\0"+
    "\2\12\1\105\12\12\1\106\3\12\1\107\5\12\1\110"+
    "\4\12\12\0\1\111\6\0\2\55\1\0\6\12\2\112"+
    "\3\12\1\113\10\12\1\73\1\12\1\103\1\12\1\107"+
    "\3\12\21\0\2\55\1\0\3\12\1\103\15\12\1\114"+
    "\12\12\21\0\2\55\1\0\13\12\1\115\13\12\1\116"+
    "\4\12\21\0\2\55\1\0\5\12\1\65\1\117\1\120"+
    "\11\12\1\121\5\12\1\107\4\12\21\0\2\55\1\0"+
    "\15\12\1\101\16\12\21\0\2\55\1\0\6\12\2\122"+
    "\3\12\1\123\10\12\1\63\1\12\1\74\5\12\21\0"+
    "\2\55\1\0\12\12\1\124\2\12\1\73\10\12\1\106"+
    "\1\125\4\12\21\0\2\55\1\0\1\12\1\126\1\127"+
    "\1\12\1\130\1\131\2\130\5\12\1\131\3\12\1\132"+
    "\4\12\1\101\1\133\4\12\21\0\2\55\1\0\15\12"+
    "\1\134\14\12\1\72\1\12\21\0\2\55\1\0\6\12"+
    "\2\135\16\12\1\106\5\12\21\0\2\55\1\0\3\12"+
    "\1\74\1\12\1\116\1\12\1\116\3\12\1\136\20\12"+
    "\21\0\2\55\1\0\15\12\1\65\11\12\1\137\4\12"+
    "\13\0\1\53\2\0\56\53\2\0\3\53\2\140\1\53"+
    "\1\140\1\53\7\140\36\53\6\0\2\55\56\0\2\55"+
    "\1\0\4\12\1\141\27\12\21\0\2\55\1\0\4\12"+
    "\1\142\27\12\21\0\2\55\1\0\2\12\1\143\31\12"+
    "\21\0\2\55\1\0\4\12\1\144\7\12\1\145\17\12"+
    "\21\0\2\55\1\0\24\12\1\146\7\12\26\0\1\147"+
    "\52\0\2\55\1\0\13\12\1\150\13\12\1\151\4\12"+
    "\21\0\2\55\1\0\6\12\2\152\24\12\21\0\2\55"+
    "\1\0\16\12\1\153\15\12\21\0\2\55\1\0\24\12"+
    "\1\154\7\12\21\0\2\55\1\0\3\12\1\155\30\12"+
    "\21\0\2\55\1\0\24\12\1\156\7\12\21\0\2\55"+
    "\1\0\5\12\1\157\1\12\1\157\24\12\21\0\2\55"+
    "\1\0\23\12\1\160\10\12\21\0\2\55\1\0\25\12"+
    "\1\161\6\12\21\0\2\55\1\0\13\12\1\162\3\12"+
    "\1\163\14\12\21\0\2\55\1\0\23\12\1\164\10\12"+
    "\53\0\1\165\25\0\2\55\1\0\10\12\1\166\17\12"+
    "\1\167\3\12\21\0\2\55\1\0\17\12\1\170\14\12"+
    "\21\0\2\55\1\0\32\12\1\171\1\12\21\0\2\55"+
    "\1\0\17\12\1\172\14\12\21\0\2\55\1\0\20\12"+
    "\1\173\13\12\21\0\2\55\1\0\25\12\1\174\6\12"+
    "\21\0\2\55\1\0\22\12\1\175\3\12\1\176\5\12"+
    "\21\0\2\55\1\0\11\12\1\177\22\12\21\0\2\55"+
    "\1\0\21\12\1\200\12\12\21\0\2\55\1\0\34\12"+
    "\12\0\1\201\6\0\2\55\1\0\34\12\12\0\1\202"+
    "\6\0\2\55\1\0\22\12\1\203\11\12\21\0\2\55"+
    "\1\0\4\12\1\204\1\205\1\206\1\207\24\12\21\0"+
    "\2\55\1\0\24\12\1\210\7\12\21\0\2\55\1\0"+
    "\34\12\12\0\1\211\6\0\2\55\1\0\24\12\1\212"+
    "\7\12\21\0\2\55\1\0\5\12\1\213\1\12\1\213"+
    "\5\12\1\214\16\12\21\0\2\55\1\0\16\12\1\215"+
    "\15\12\13\0\1\53\2\0\3\53\2\216\1\53\1\216"+
    "\1\53\7\216\36\53\6\0\2\55\1\0\6\12\2\217"+
    "\24\12\21\0\2\55\1\0\12\12\1\220\21\12\21\0"+
    "\2\55\1\0\20\12\1\221\13\12\21\0\2\55\1\0"+
    "\15\12\1\222\16\12\21\0\2\55\1\0\2\12\1\223"+
    "\31\12\21\0\2\55\1\0\24\12\1\224\7\12\44\0"+
    "\1\225\11\0\1\226\1\227\21\0\2\55\1\0\24\12"+
    "\1\230\7\12\21\0\2\55\1\0\4\12\1\231\15\12"+
    "\1\210\11\12\21\0\2\55\1\0\2\12\1\232\31\12"+
    "\21\0\2\55\1\0\21\12\1\233\12\12\21\0\2\55"+
    "\1\0\6\12\2\234\24\12\21\0\2\55\1\0\27\12"+
    "\1\235\4\12\21\0\2\55\1\0\31\12\1\236\2\12"+
    "\21\0\2\55\1\0\6\12\2\237\24\12\21\0\2\55"+
    "\1\0\27\12\1\240\4\12\21\0\2\55\1\0\26\12"+
    "\1\241\5\12\21\0\2\55\1\0\23\12\1\242\10\12"+
    "\21\0\2\55\1\0\27\12\1\243\4\12\21\0\2\55"+
    "\1\0\34\12\12\0\1\244\37\0\1\245\26\0\2\55"+
    "\1\0\26\12\1\103\5\12\21\0\2\55\1\0\2\12"+
    "\1\246\31\12\21\0\2\55\1\0\22\12\1\247\11\12"+
    "\21\0\2\55\1\0\23\12\1\250\10\12\21\0\2\55"+
    "\1\0\27\12\1\251\4\12\21\0\2\55\1\0\5\12"+
    "\1\252\1\12\1\252\17\12\1\253\4\12\21\0\2\55"+
    "\1\0\13\12\1\254\16\12\1\255\1\256\21\0\2\55"+
    "\1\0\6\12\2\257\24\12\21\0\2\55\1\0\24\12"+
    "\1\260\7\12\21\0\2\55\1\0\12\12\1\261\21\12"+
    "\21\0\2\55\1\0\31\12\1\262\2\12\44\0\1\263"+
    "\41\0\1\264\52\0\2\55\1\0\2\12\1\265\31\12"+
    "\21\0\2\55\1\0\6\12\2\266\24\12\21\0\2\55"+
    "\1\0\24\12\1\267\7\12\21\0\2\55\1\0\24\12"+
    "\1\270\7\12\21\0\2\55\1\0\24\12\1\271\7\12"+
    "\21\0\2\55\1\0\26\12\1\272\5\12\53\0\1\273"+
    "\25\0\2\55\1\0\26\12\1\274\5\12\21\0\2\55"+
    "\1\0\26\12\1\275\5\12\21\0\2\55\1\0\13\12"+
    "\1\276\20\12\21\0\2\55\1\0\27\12\1\277\4\12"+
    "\13\0\1\53\2\0\3\53\2\300\1\53\1\300\1\53"+
    "\7\300\36\53\6\0\2\55\1\0\20\12\1\301\13\12"+
    "\21\0\2\55\1\0\21\12\1\116\12\12\21\0\2\55"+
    "\1\0\1\12\1\302\32\12\21\0\2\55\1\0\31\12"+
    "\1\303\2\12\21\0\2\55\1\0\24\12\1\65\7\12"+
    "\21\0\2\55\1\0\2\12\1\304\31\12\37\0\1\305"+
    "\77\0\1\306\21\0\2\55\1\0\13\12\1\307\20\12"+
    "\21\0\2\55\1\0\12\12\1\60\21\12\21\0\2\55"+
    "\1\0\24\12\1\310\7\12\21\0\2\55\1\0\24\12"+
    "\1\311\7\12\21\0\2\55\1\0\4\12\1\312\27\12"+
    "\21\0\2\55\1\0\14\12\1\313\17\12\21\0\2\55"+
    "\1\0\2\12\1\314\31\12\21\0\2\55\1\0\26\12"+
    "\1\315\5\12\21\0\2\55\1\0\13\12\1\316\20\12"+
    "\21\0\2\55\1\0\2\12\1\317\31\12\21\0\2\55"+
    "\1\0\21\12\1\107\12\12\21\0\2\55\1\0\16\12"+
    "\1\320\15\12\53\0\1\321\57\0\1\322\25\0\2\55"+
    "\1\0\20\12\1\323\13\12\21\0\2\55\1\0\13\12"+
    "\1\324\20\12\21\0\2\55\1\0\34\12\12\0\1\325"+
    "\6\0\2\55\1\0\31\12\1\326\2\12\21\0\2\55"+
    "\1\0\21\12\1\327\12\12\21\0\2\55\1\0\22\12"+
    "\1\107\11\12\21\0\2\55\1\0\4\12\1\330\21\12"+
    "\1\330\5\12\21\0\2\55\1\0\33\12\1\331\21\0"+
    "\2\55\1\0\2\12\1\332\23\12\1\333\5\12\21\0"+
    "\2\55\1\0\21\12\1\334\12\12\21\0\2\55\1\0"+
    "\26\12\1\74\5\12\21\0\2\55\1\0\26\12\1\335"+
    "\5\12\37\0\1\336\60\0\1\337\40\0\2\55\1\0"+
    "\24\12\1\340\7\12\21\0\2\55\1\0\20\12\1\341"+
    "\13\12\21\0\2\55\1\0\2\12\1\342\31\12\21\0"+
    "\2\55\1\0\2\12\1\343\31\12\21\0\2\55\1\0"+
    "\2\12\1\344\31\12\21\0\2\55\1\0\1\12\1\345"+
    "\32\12\72\0\1\346\6\0\2\55\1\0\21\12\1\347"+
    "\12\12\21\0\2\55\1\0\12\12\1\116\21\12\21\0"+
    "\2\55\1\0\23\12\1\350\10\12\21\0\2\55\1\0"+
    "\20\12\1\351\13\12\13\0\1\53\2\0\3\53\2\352"+
    "\1\53\1\352\1\53\7\352\36\53\6\0\2\55\1\0"+
    "\26\12\1\353\5\12\21\0\2\55\1\0\2\12\1\354"+
    "\31\12\21\0\2\55\1\0\2\12\1\355\31\12\21\0"+
    "\2\55\1\0\5\12\1\356\1\12\1\356\24\12\41\0"+
    "\1\357\37\0\2\55\1\0\14\12\1\63\17\12\21\0"+
    "\2\55\1\0\25\12\1\73\6\12\21\0\2\55\1\0"+
    "\12\12\1\360\21\12\21\0\2\55\1\0\2\12\1\361"+
    "\31\12\21\0\2\55\1\0\24\12\1\362\7\12\21\0"+
    "\2\55\1\0\27\12\1\363\4\12\21\0\2\55\1\0"+
    "\6\12\2\364\24\12\21\0\2\55\1\0\23\12\1\311"+
    "\10\12\72\0\1\365\31\0\1\366\34\0\2\55\1\0"+
    "\26\12\1\367\5\12\21\0\2\55\1\0\2\12\1\370"+
    "\31\12\26\0\1\371\52\0\2\55\1\0\27\12\1\372"+
    "\4\12\21\0\2\55\1\0\31\12\1\373\2\12\21\0"+
    "\2\55\1\0\13\12\1\374\20\12\21\0\2\55\1\0"+
    "\26\12\1\320\5\12\21\0\2\55\1\0\13\12\1\375"+
    "\20\12\21\0\2\55\1\0\4\12\1\376\27\12\21\0"+
    "\2\55\1\0\27\12\1\377\4\12\41\0\1\u0100\44\0"+
    "\1\u0101\52\0\2\55\1\0\26\12\1\u0102\5\12\21\0"+
    "\2\55\1\0\26\12\1\u0103\5\12\21\0\2\55\1\0"+
    "\31\12\1\131\2\12\21\0\2\55\1\0\25\12\1\u0104"+
    "\6\12\21\0\2\55\1\0\25\12\1\u0104\3\12\1\131"+
    "\2\12\21\0\2\55\1\0\34\12\12\0\1\u0105\43\0"+
    "\1\u0106\22\0\2\55\1\0\24\12\1\u0107\7\12\21\0"+
    "\2\55\1\0\34\12\12\0\1\u0108\6\0\2\55\1\0"+
    "\13\12\1\u0109\20\12\13\0\1\53\2\0\3\53\2\u010a"+
    "\1\53\1\u010a\1\53\7\u010a\36\53\6\0\2\55\1\0"+
    "\24\12\1\u010b\7\12\21\0\2\55\1\0\24\12\1\60"+
    "\7\12\21\0\2\55\1\0\24\12\1\u010c\7\12\21\0"+
    "\2\55\1\0\21\12\1\u010d\12\12\37\0\1\u010e\41\0"+
    "\2\55\1\0\2\12\1\74\31\12\21\0\2\55\1\0"+
    "\24\12\1\131\7\12\21\0\2\55\1\0\5\12\1\60"+
    "\1\12\1\60\24\12\21\0\2\55\1\0\24\12\1\u010f"+
    "\7\12\21\0\2\55\1\0\24\12\1\u0110\7\12\41\0"+
    "\1\u0111\55\0\1\u0112\41\0\2\55\1\0\2\12\1\u0113"+
    "\31\12\21\0\2\55\1\0\24\12\1\73\7\12\27\0"+
    "\1\u0114\51\0\2\55\1\0\4\12\1\275\27\12\21\0"+
    "\2\55\1\0\20\12\1\65\13\12\21\0\2\55\1\0"+
    "\21\12\1\u0115\12\12\21\0\2\55\1\0\24\12\1\320"+
    "\7\12\21\0\2\55\1\0\6\12\2\u0116\24\12\21\0"+
    "\2\55\1\0\24\12\1\u0117\7\12\44\0\1\u0118\34\0"+
    "\2\55\1\0\21\12\1\u0119\12\12\21\0\2\55\1\0"+
    "\6\12\2\u011a\24\12\21\0\2\55\1\0\6\12\2\130"+
    "\24\12\37\0\1\u011b\41\0\2\55\1\0\26\12\1\u011c"+
    "\5\12\26\0\1\u011d\52\0\2\55\1\0\15\12\1\65"+
    "\16\12\21\0\2\55\1\0\21\12\1\72\12\12\21\0"+
    "\2\55\1\0\5\12\1\63\1\12\1\63\24\12\21\0"+
    "\2\55\1\0\24\12\1\130\7\12\42\0\1\u011e\36\0"+
    "\2\55\1\0\26\12\1\u011f\5\12\21\0\2\55\1\0"+
    "\5\12\1\u0120\1\12\1\u0120\24\12\45\0\1\u0121\53\0"+
    "\1\u0122\37\0\2\55\1\0\24\12\1\107\7\12\21\0"+
    "\2\55\1\0\20\12\1\u0123\13\12\21\0\2\55\1\0"+
    "\5\12\1\u0124\1\12\1\u0124\24\12\21\0\2\55\1\0"+
    "\26\12\1\u0125\5\12\37\0\1\u0126\41\0\2\55\1\0"+
    "\24\12\1\u0127\7\12\21\0\2\55\1\0\24\12\1\72"+
    "\7\12\27\0\1\u0128\51\0\2\55\1\0\27\12\1\u0129"+
    "\4\12\27\0\1\u012a\106\0\1\226\1\227\21\0\2\55"+
    "\1\0\16\12\1\u012b\15\12\21\0\2\55\1\0\2\12"+
    "\1\103\31\12\41\0\1\u012c\57\0\1\u012d\37\0\2\55"+
    "\1\0\32\12\1\255\1\256\21\0\2\55\1\0\6\12"+
    "\2\u012e\24\12\21\0\2\55\1\0\16\12\1\u012f\15\12"+
    "\41\0\1\u0130\37\0\2\55\1\0\26\12\1\u0131\5\12"+
    "\72\0\1\u0132\6\0\2\55\1\0\11\12\1\u0133\22\12"+
    "\21\0\2\55\1\0\6\12\2\101\24\12\45\0\1\u0134"+
    "\33\0\2\55\1\0\24\12\1\63\7\12\21\0\2\55"+
    "\1\0\6\12\2\106\24\12\21\0\2\55\1\0\27\12"+
    "\1\u0135\4\12\21\0\2\55\1\0\2\12\1\106\31\12"+
    "\41\0\1\u0136\37\0\2\55\1\0\11\12\1\u0137\22\12"+
    "\21\0\2\55\1\0\2\12\1\101\31\12\13\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[12912];
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
    "\1\0\1\11\1\1\1\11\2\1\1\11\30\1\12\11"+
    "\14\1\1\0\22\1\1\0\35\1\1\0\15\1\1\0"+
    "\13\1\2\0\6\1\1\0\13\1\1\0\1\1\1\11"+
    "\14\1\2\0\15\1\2\0\6\1\1\0\11\1\1\0"+
    "\1\11\12\1\2\0\2\1\1\0\10\1\2\0\6\1"+
    "\1\0\10\1\1\0\5\1\2\0\2\1\1\0\6\1"+
    "\1\11\1\0\3\1\1\0\1\11\1\1\1\0\5\1"+
    "\1\0\2\1\2\0\1\1\1\11\3\1\1\0\2\1"+
    "\1\0\1\1\2\0\2\1\2\0\3\1\1\0\1\1"+
    "\1\0\1\1\1\11\1\1\1\11\1\0\2\1\1\11"+
    "\1\1\1\11\1\1\1\0\1\1\1\11\1\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[311];
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
            System.out.printf("I don't understand the text %s in the line %d, column %d. Delete it and try again\n", lexeme, yyline + 1, yycolumn + 1);
            errorsList.add(Messages.errorLexer(lexeme));
        } else {
            System.out.printf("I don't understand the text %s in the instruction. Delete it and try again.\n", lexeme);
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
  public LexerAll(java.io.Reader in) {
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
    while (i < 206) {
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
          case 36: break;
          case 2: 
            { return symbol(LINE_TERMINATOR);
            } 
            // fall through
          case 37: break;
          case 3: 
            { /*return symbol(WHITESPACE); */
            } 
            // fall through
          case 38: break;
          case 4: 
            { return symbol(INTEGER_LITERAL, yytext());
            } 
            // fall through
          case 39: break;
          case 5: 
            { /* ignoring */
            } 
            // fall through
          case 40: break;
          case 6: 
            { return symbol(COMMA);
            } 
            // fall through
          case 41: break;
          case 7: 
            { return symbol(OPEN_BRACKET);
            } 
            // fall through
          case 42: break;
          case 8: 
            { return symbol(CLOSE_BRACKET);
            } 
            // fall through
          case 43: break;
          case 9: 
            { return symbol(OPEN_PAR);
            } 
            // fall through
          case 44: break;
          case 10: 
            { return symbol(CLOSE_PAR);
            } 
            // fall through
          case 45: break;
          case 11: 
            { return symbol(PLUS);
            } 
            // fall through
          case 46: break;
          case 12: 
            { return symbol(MINUS);
            } 
            // fall through
          case 47: break;
          case 13: 
            { return symbol(MULT);
            } 
            // fall through
          case 48: break;
          case 14: 
            { return symbol(DIV);
            } 
            // fall through
          case 49: break;
          case 15: 
            { return symbol(EQ);
            } 
            // fall through
          case 50: break;
          case 16: 
            { return symbol(ID, yytext());
            } 
            // fall through
          case 51: break;
          case 17: 
            { return symbol(WIDTH);
            } 
            // fall through
          case 52: break;
          case 18: 
            { return symbol(FORWARD);
            } 
            // fall through
          case 53: break;
          case 19: 
            { return symbol(BACKWARD);
            } 
            // fall through
          case 54: break;
          case 20: 
            { return symbol(TOERASE);
            } 
            // fall through
          case 55: break;
          case 21: 
            { return symbol(PENDOWN);
            } 
            // fall through
          case 56: break;
          case 22: 
            { return symbol(TOCENTER);
            } 
            // fall through
          case 57: break;
          case 23: 
            { return symbol(CLEARS);
            } 
            // fall through
          case 58: break;
          case 24: 
            { return symbol(RIGHT);
            } 
            // fall through
          case 59: break;
          case 25: 
            { return symbol(TODRAW);
            } 
            // fall through
          case 60: break;
          case 26: 
            { return symbol(HIDETURTLE);
            } 
            // fall through
          case 61: break;
          case 27: 
            { return symbol(LEFT);
            } 
            // fall through
          case 62: break;
          case 28: 
            { return symbol(SHOWTURTLE);
            } 
            // fall through
          case 63: break;
          case 29: 
            { return symbol(PENUP);
            } 
            // fall through
          case 64: break;
          case 30: 
            { return symbol(POSITIONX);
            } 
            // fall through
          case 65: break;
          case 31: 
            { return symbol(POSITIONY);
            } 
            // fall through
          case 66: break;
          case 32: 
            { return symbol(POSITIONXY);
            } 
            // fall through
          case 67: break;
          case 33: 
            { return symbol(COLOR);
            } 
            // fall through
          case 68: break;
          case 34: 
            { return symbol(REPEAT);
            } 
            // fall through
          case 69: break;
          case 35: 
            { return symbol(HEXA_LITERAL, yytext());
            } 
            // fall through
          case 70: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
