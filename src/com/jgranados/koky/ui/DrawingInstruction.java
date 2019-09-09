package com.jgranados.koky.ui;

/**
 *
 * @author jesfrin
 */
public class DrawingInstruction {

    //Instrucciones traingle
    public static final String TRIANGLE_INSTRUCTION_ENGLISH = "pu,tocenter,fd 100,lt 150,pd,repeat 3[fd 200 lt 120],ht";
    public static final String TRIANGLE_ISTRUCTION_SPANISH = "levantar,alCentro,avanzar 100,izquierda 150,bajar,repetir 3[avanzar 200 izquierda 120],tt";
    public static final String TRIANGLE_INSTRUCTION_QUICHE = "wa'lijik,oj,b'inik 100,moxq'ab 150,qajik,jutijchik 3[b'inik 200 moxq'ab 120],uk";

    //Instructions square
    public static final String SQUARE_INSTRUCTION_ENGLISH = "pu,tocenter,rt 45,fd 141,lt 135,pd ,repeat 4[fd 200 lt 90],ht";
    public static final String SQUARE_INSTRUCTION_SPANISH = "levantar,alCentro,derecha 45,avanzar 141,izquierda 135,bajar,repetir 4[avanzar 200 izquierda 90],tt";
    public static final String SQUARE_INSTRUCTION_QUICHE = "wa'lijik,oj,kb 45,b'inik 141,moxq'ab 135,qajik,jutijchik 4[b'inik 200 moxq'ab 90],uk";

    //Instructions Circle
    public static final String CIRCLE_INSTRUCTION_ENGLISH = "pu,tocenter,lt 90,fd 90,rt 90,pd,repeat 360[ rt 1 fd 2],ht";
    public static final String CIRCLE_INSTRUCTION_SPANISH = "levantar,alCentro,izquierda 90,avanzar 90,derecha 90,bajar,repetir 360[derecha 1 avanzar 2],tt";
    public static final String CIRCLE_INSTRUCTION_QUICHE = "wa'lijik,oj,moxq'ab 90,b'inik 90,kb 90,qajik,jutijchik 360[kb 1 b'inik 2],uk";

    //Instruction Pentagon
    public static final String PENTAGON_INSTRUCTION_ENGLISH = "pu,tocenter,bk 100,lt 90,pd,fd 70,rt 72,repeat 4[fd 140 rt 180 lt 108],fd 70,ht";
    public static final String PENTAGON_INSTRUCTION_SPANISH = "levantar,alCentro,retroceder 100,izquierda 90,bajar,avanzar 70,derecha 72,repetir 4[avanzar 140 derecha 180 izquierda 108],avanzar 70,tt";
    public static final String PENTAGON_INSTRUCTION_QUICHE = "wa'lijik,oj,tzalijik 100,moxq'ab 90,qajik,b'inik 70,kb 72,jutijchik 4[b'inik 140 kb 180 moxq'ab 108],b'inik 70,uk";

    //Instruction Star
    public static final String STAR_INSTRUCTION_ENGLISH = "pu,tocenter,bk 100,lt 90,fd 70,pd,rt 108,repeat 5[fd 225 rt 144],ht";
    public static final String STAR_INSTRUCTION_SPANISH = "levantar,alCentro,retroceder 100,izquierda 90,avanzar 70,bajar,derecha 108,repetir 5[avanzar 225 derecha 144],tt";
    public static final String STAR_INSTRUCTION_QUICHE = "wa'lijik,oj,tzalijik 100,moxq'ab 90,b'inik 70,qajik, kb 108,jutijchik 5[b'inik 225 kb 144],uk";
    
    //Instriction Cube
    public static final String CUBE_INSTRUCTION_ENGLISH = "pu,tocenter,bk 60,rt 60,pd,repeat 7[fd 60 lt 60],lt 60,repeat 2[fd 60 lt 60],rt 60,pu,bk 60,rt 120,pd ,fd 60,rt 120,pu,fd 60,lt 60,pd,fd 90,lt 120,repeat 8[fd 150 lt 60],lt 60,fd 90,pu,tocenter,bk 60,pd ,bk 90,ht";
    public static final String CUBE_INSTRUCTION_QUICHE  = "wa'lijik,oj,tzalijik 60,kb 60,qajik,jutijchik 7[b'inik 60 moxq'ab 60],moxq'ab 60,jutijchik 2[b'inik 60 moxq'ab 60],kb 60,wa'lijik,tzalijik 60,kb 120,qajik,b'inik 60,kb 120,wa'lijik,b'inik 60,moxq'ab 60,qajik,b'inik 90,moxq'ab 120,jutijchik 8[b'inik 150 moxq'ab 60],moxq'ab 60,b'inik 90,wa'lijik,oj,tzalijik 60,qajik,tzalijik 90,uk";
    public static final String CUBE_INSTRUCTION_SPANISH = "levantar,alCentro,retroceder 60,derecha 60,bajar,repetir 7[avanzar 60 izquierda 60],izquierda 60,repetir 2[avanzar 60 izquierda 60],derecha 60,levantar,retroceder 60,derecha 120,bajar,avanzar 60,derecha 120,levantar,avanzar 60,izquierda 60,bajar,avanzar 90,izquierda 120,repetir 8[avanzar 150 izquierda 60],izquierda 60,avanzar 90,levantar,alCentro,retroceder 60,bajar,retroceder 90,tt";
    
    public KokyFrame frame;

    public DrawingInstruction(KokyFrame frame) {
        this.frame = frame;
    }

    public void drawingInstruction(String instruction) {
        String instructions[] = instruction.split(",");
        this.frame.getTxtInstructions().append("***************************************************\n");
        for (int i = 0; i < instructions.length; i++) {
            this.frame.parseInstruction(instructions[i],this.frame.getPanelDraw());
            this.frame.getTxtInstructions().append(instructions[i] + "\n");
        }
        this.frame.getTxtInstructions().append("***************************************************\n");
    }

}
