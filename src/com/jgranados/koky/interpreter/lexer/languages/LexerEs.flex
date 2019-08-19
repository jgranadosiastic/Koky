package com.jgranados.koky.interpreter.lexer.languages;

import java_cup.runtime.*;
import com.jgranados.koky.interpreter.token.Token;
import com.jgranados.koky.interpreter.parser.sym;
import static com.jgranados.koky.interpreter.parser.sym.*;
import java.util.ArrayList;
import java.util.List;
import com.jgranados.koky.instructions.logic.Messages;

%%

%class LexerEs
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
    private Messages message = new Messages();
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
            System.out.printf("No entiendo el texto %s en la linea %d, columna %d. Borralo e intenta de nuevo.\n", lexeme, yyline + 1, yycolumn + 1);
            errorsList.add(message.errorLexer(lexeme));
        } else {
            System.out.printf("No entiendo el texto %s en la instruccion. Borralo e intenta de nuevo.\n", lexeme);
            errorsList.add(message.errorLexer(lexeme));
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
    {A_}{V_}{A_}{N_}{Z_}{A_}{R_}        {   return symbol(FORWARD);                     }
    {A_}{R_}                            {   return symbol(FORWARD);                     }
    {R_}{E_}{T_}{R_}{O_}{C_}{E_}{D_}{E_}{R_} {   return symbol(BACKWARD);                    }
    {R_}{R_}                            {   return symbol(BACKWARD);                    }
    {D_}{E_}{R_}{E_}{C_}{H_}{A_}        {   return symbol(RIGHT);                       }
    {D_}{A_}                            {   return symbol(RIGHT);                       }
    {I_}{Z_}{Q_}{U_}{I_}{E_}{R_}{D_}{A_} {   return symbol(LEFT);                        }
    {I_}{A_}                            {   return symbol(LEFT);                        }
    {L_}{I_}{M_}{P_}{I_}{A_}{R_}        {   return symbol(CLEARS);                      }
    {L_}{R_}                            {   return symbol(CLEARS);                      }
    {L_}{E_}{V_}{A_}{N_}{T_}{A_}{R_}    {   return symbol(PENUP);                       }
    {L_}{V_}                            {   return symbol(PENUP);                       }
    {B_}{A_}{J_}{A_}{R_}                {   return symbol(PENDOWN);                     }
    {B_}{R_}                            {   return symbol(PENDOWN);                     }
    {A_}{L_}{C_}{E_}{N_}{T_}{R_}{O_}    {   return symbol(TOCENTER);                    }
    {C_}{R_}                            {   return symbol(TOCENTER);                    }
    {C_}{O_}{L_}{O_}{R_}                {   return symbol(COLOR);                       }
    {P_}{O_}{S_}{I_}{C_}{I_}{O_}{N_}{X_}{Y_}    {   return symbol(POSITIONXY);          }
    {P_}{O_}{S_}{X_}{Y_}                        {   return symbol(POSITIONXY);          }
    {P_}{O_}{S_}{I_}{C_}{I_}{O_}{N_}{X_}        {   return symbol(POSITIONX);           }
    {P_}{O_}{S_}{X_}                            {   return symbol(POSITIONX);           }
    {P_}{O_}{S_}{I_}{C_}{I_}{O_}{N_}{Y_}        {   return symbol(POSITIONY);           }
    {P_}{O_}{S_}{Y_}                            {   return symbol(POSITIONY);           }
    {T_}{A_}{P_}{A_}{R_}{T_}{O_}{R_}{T_}{U_}{G_}{A_}    {   return symbol(HIDETURTLE);         }
    {T_}{T_}                                    {   return symbol(HIDETURTLE);         }
    {V_}{E_}{R_}{T_}{O_}{R_}{T_}{U_}{G_}{A_}    {   return symbol(SHOWTURTLE);          }
    {V_}{T_}                                    {   return symbol(SHOWTURTLE);          }
    {B_}{O_}{R_}{R_}{A_}{D_}{O_}{R_}            {   return symbol(TOERASE);             }
    {B_}{O_}                                    {   return symbol(TOERASE);             }
    {D_}{I_}{B_}{U_}{J_}{A_}{R_}                {   return symbol(TODRAW);              }
    {D_}{I_}                                    {   return symbol(TODRAW);              }
    {R_}{E_}{P_}{E_}{T_}{I_}{R_}                {   return symbol(REPEAT);              }
    {A_}{N_}{C_}{H_}{O_}                        {   return symbol(WIDTH);               }
    {A_}{N_}                                    {   return symbol(WIDTH);               }
    {WhiteSpace} 	{   /*return symbol(WHITESPACE); */  }

    {Comment}           {   /* ignoring */  }

    [a-zA-Z]+[0-9]*       {   error(yytext());    }

}

/* error fallback */
[^]                              {   error(yytext());    }
// a new state ERROR to collect all chars until reach space or line. go back one char?