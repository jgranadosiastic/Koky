package com.jgranados.koky.interpreter.lexer.languages;

import java_cup.runtime.*;
import com.jgranados.koky.interpreter.token.Token;
import com.jgranados.koky.interpreter.parser.sym;
import static com.jgranados.koky.interpreter.parser.sym.*;
import java.util.ArrayList;
import java.util.List;
import com.jgranados.koky.instructions.logic.Messages;

%%

%class LexerKiche
%public
%cup
%line
%column

/* special chars */
LineTerminator = \r|\n|\r\n
WhiteSpace = [ \t\f]+

/* identifiers */
IdentifierLetter = [a-zA-Z0-9_\-\$]
Identifier = :{IdentifierLetter}+

/* integer literals */
IntegerLiteral = 0 | [1-9][0-9]*

/* hexa literal */
HexaLiteral = #[0-9a-fA-F0]{6}

/*  */
InvalidText = [a-zA-Z]+[0-9]*;

/* insensitive letters */
A_ = [aA]
B_ = [bB]
C_ = [cC]
D_ = [dD]
E_ = [eD]
F_ = [fF]
G_ = [gG]
H_ = [hH]
I_ = [iI]
J_ = [jJ]
K_ = [kK]
L_ = [lL]
M_ = [mM]
N_ = [nN]
O_ = [oO]
P_ = [pP]
Q_ = [qQ]
R_ = [rR]
S_ = [sS]
T_ = [tT]
U_ = [uU]
V_ = [vV]
W_ = [wW]
X_ = [xX]
Y_ = [yY]
Z_ = [zZ]

/* comments */
Comment     = "#" [^\r\n]*

%{
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
            System.out.printf("Ayi’ Ch’ob’o are tzij %s en are Cholajil %d, columna %d. Kchuputaj e intenta de K’ak’.\n", lexeme, yyline + 1, yycolumn + 1);
            errorsList.add(Messages.errorLexer(lexeme));
        } else {
            System.out.printf("Ayi’ Ch’ob’o are tzij %s en are Cholajil. Kchuputaj e intenta de K’ak’.\n", lexeme);
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
%}

%init{
    errorsList = new ArrayList<>();
%init}

%%

/* reglas lexicas */
<YYINITIAL> {

    {LineTerminator}                {   return symbol(LINE_TERMINATOR);             }
    {IntegerLiteral}                {   return symbol(INTEGER_LITERAL, yytext());   }
    {HexaLiteral}                   {   return symbol(HEXA_LITERAL, yytext());      }
    {Identifier}                    {   return symbol(ID, yytext());                }
    ","                             {   return symbol(COMMA);                       }
    "["                             {   return symbol(OPEN_BRACKET);                }
    "]"                             {   return symbol(CLOSE_BRACKET);               }
    "("                             {   return symbol(OPEN_PAR);                    }
    ")"                             {   return symbol(CLOSE_PAR);                   }
    "+"                             {   return symbol(PLUS);                        }
    "-"                             {   return symbol(MINUS);                       }
    "*"                             {   return symbol(MULT);                        }
    "/"                             {   return symbol(DIV);                         }
    "="                             {   return symbol(EQ);                          }

    /* Reserved words */
    {B_}"'"{I_}{N_}{I_}{K_}             {   return symbol(FORWARD);                     }
    {B_}{K_}                            {   return symbol(FORWARD);                     }
    {T_}{Z_}{A_}{L_}{I_}{J_}{I_}{K_}    {   return symbol(BACKWARD);                    }
    {T_}{K_}                            {   return symbol(BACKWARD);                    }
    {K_}"'"{I_}{Q_}"'"{A_}{B_}"'  "     {   return symbol(RIGHT);                       }
    {K_}{B_}                            {   return symbol(RIGHT);                       }
    {M_}{O_}{X_}{Q_}"'"{A_}{B_}         {   return symbol(LEFT);                        }
    {M_}{B_}                            {   return symbol(LEFT);                        }
    {S_}{U_}"'"{N_}{I_}{K_}             {   return symbol(CLEARS);                      }
    {S_}{K_}                            {   return symbol(CLEARS);                      }
    {W_}{A_}"'"{L_}{I_}{J_}{I_}{K_}     {   return symbol(PENUP);                       }
    {W_}{K_}                            {   return symbol(PENUP);                       }
    {Q_}{A_}{J_}{I_}{K_}                {   return symbol(PENDOWN);                     }
    {Q_}{K_}                            {   return symbol(PENDOWN);                     }
    {O_}{J_}{P_}{A_}{N_}{I_}{K_}"'"{A_}{J_} {   return symbol(TOCENTER);                    }
    {O_}{J_}                            {   return symbol(TOCENTER);                    }
    {K_}{A_}{Y_}{B_}"'"{A_}{L_}{I_}{L_} {   return symbol(COLOR);                       }
    {K_}{R_}{I_}{Q_}{T_}{A_}{J_}{X_}{Y_}    {   return symbol(POSITIONXY);          }
    {K_}{J_}{X_}{Y_}                        {   return symbol(POSITIONXY);          }
    {K_}{R_}{I_}{Q_}{T_}{A_}{J_}{X_}        {   return symbol(POSITIONX);           }
    {K_}{J_}{X_}                            {   return symbol(POSITIONX);           }
    {K_}{R_}{I_}{Q_}{T_}{A_}{J_}{Y_}        {   return symbol(POSITIONY);           }
    {K_}{J_}{Y_}                            {   return symbol(POSITIONY);           }
    {U_}{K_}"'"{U_}"'"{I_}{K_}{K_}{O_}{K_}      {   return symbol(HIDETURTLE);          }
    {U_}{K_}                                    {   return symbol(HIDETURTLE);          }
    {R_}{I_}{L_}{I_}{K_}{K_}{O_}{K_}            {   return symbol(SHOWTURTLE);          }
    {R_}{K_}                                    {   return symbol(SHOWTURTLE);          }
    {C_}{H_}{U_}{P_}{U_}{B_}"'"{A_}{L_}         {   return symbol(TOERASE);             }
    {C_}{L_}                                    {   return symbol(TOERASE);             }
    {U_}{T_}{Z_}{J_}{U_}{C_}{H_}"'"{U_}{N_}{I_}{K_} {   return symbol(TODRAW);              }
    {U_}{J_}                                    {   return symbol(TODRAW);              }
    {J_}{U_}{T_}{I_}{J_}{C_}{H_}{I_}{K_}        {   return symbol(REPEAT);              }
    {U_}{W_}{A_}{C_}{H_}                        {   return symbol(WIDTH);               } 
    {U_}{W_}                                    {   return symbol(WIDTH);               }
    {K_}{J_}{E_}{Q_}{E_}"'"{I_}{K_}             {   return symbol(VOID);                }
    {S_}{I_}{K_}"'"{I_}{M_}                     {   return symbol(CALL);                }

    {WhiteSpace} 	{   /*return symbol(WHITESPACE); */  }

    {Comment}           {   /* ignoring */  }

    [a-zA-Z]+[0-9]*       {   error(yytext());    }

}

/* error fallback */
[^]                              {   error(yytext());    }
// a new state ERROR to collect all chars until reach space or line. go back one char?