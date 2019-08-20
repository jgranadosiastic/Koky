package com.jgranados.koky.interpreter.lexer;

import java_cup.runtime.*;
import com.jgranados.koky.interpreter.token.Token;
import com.jgranados.koky.interpreter.parser.sym;
import static com.jgranados.koky.interpreter.parser.sym.*;
import java.util.ArrayList;
import java.util.List;
import com.jgranados.koky.instructions.logic.Messages;

%%

%class Lexer
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
K_ = [kK]
L_ = [lL]
N_ = [nN]
O_ = [oO]
P_ = [pP]
R_ = [rR]
S_ = [sS]
T_ = [tT]
U_ = [uU]
W_ = [wW]
X_ = [xX]
Y_ = [yY]

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
    {F_}{O_}{R_}{W_}{A_}{R_}{D_}        {   return symbol(FORWARD);                     }
    {F_}{D_}                            {   return symbol(FORWARD);                     }
    {B_}{A_}{C_}{K_}{W_}{A_}{R_}{D_}    {   return symbol(BACKWARD);                    }
    {B_}{K_}                            {   return symbol(BACKWARD);                    }
    {R_}{I_}{G_}{H_}{T_}                {   return symbol(RIGHT);                       }
    {R_}{T_}                            {   return symbol(RIGHT);                       }
    {L_}{E_}{F_}{T_}                    {   return symbol(LEFT);                        }
    {L_}{T_}                            {   return symbol(LEFT);                        }
    {C_}{L_}{E_}{A_}{R_}{S_}            {   return symbol(CLEARS);                      }
    {C_}{S_}                            {   return symbol(CLEARS);                      }
    {P_}{E_}{N_}{U_}{P_}                {   return symbol(PENUP);                       }
    {P_}{U_}                            {   return symbol(PENUP);                       }
    {P_}{E_}{N_}{D_}{O_}{W_}{N_}        {   return symbol(PENDOWN);                     }
    {P_}{D_}                            {   return symbol(PENDOWN);                     }
    {T_}{O_}{C_}{E_}{N_}{T_}{E_}{R_}    {   return symbol(TOCENTER);                    }
    {C_}{R_}                            {   return symbol(TOCENTER);                    }
    {C_}{O_}{L_}{O_}{R_}                {   return symbol(COLOR);                       }
    {P_}{O_}{S_}{I_}{T_}{I_}{O_}{N_}{X_}{Y_}    {   return symbol(POSITIONXY);          }
    {P_}{O_}{S_}{X_}{Y_}                        {   return symbol(POSITIONXY);          }
    {P_}{O_}{S_}{I_}{T_}{I_}{O_}{N_}{X_}        {   return symbol(POSITIONX);           }
    {P_}{O_}{S_}{X_}                            {   return symbol(POSITIONX);           }
    {P_}{O_}{S_}{I_}{T_}{I_}{O_}{N_}{Y_}        {   return symbol(POSITIONY);           }
    {P_}{O_}{S_}{Y_}                            {   return symbol(POSITIONY);           }
    {H_}{I_}{D_}{E_}{T_}{U_}{R_}{T_}{L_}{E_}    {   return symbol(HIDETURTLE);         }
    {H_}{T_}                                    {   return symbol(HIDETURTLE);         }
    {S_}{H_}{O_}{W_}{T_}{U_}{R_}{T_}{L_}{E_}    {   return symbol(SHOWTURTLE);          }
    {S_}{T_}                                    {   return symbol(SHOWTURTLE);          }
    {T_}{O_}{E_}{R_}{A_}{S_}{E_}                {   return symbol(TOERASE);             }
    {T_}{E_}                                    {   return symbol(TOERASE);             }
    {T_}{O_}{D_}{R_}{A_}{W_}                    {   return symbol(TODRAW);              }
    {T_}{D_}                                    {   return symbol(TODRAW);              }
    {R_}{E_}{P_}{E_}{A_}{T_}                    {   return symbol(REPEAT);              }
    {W_}{I_}{D_}{T_}{H_}                        {   return symbol(WIDTH);               }
    {W_}{D_}                                    {   return symbol(WIDTH);               }
    

    {WhiteSpace} 	{   /*return symbol(WHITESPACE); */  }

    {Comment}           {   /* ignoring */  }

    [a-zA-Z]+[0-9]*       {   error(yytext());    }

}

/* error fallback */
[^]                              {   error(yytext());    }
// a new state ERROR to collect all chars until reach space or line. go back one char?