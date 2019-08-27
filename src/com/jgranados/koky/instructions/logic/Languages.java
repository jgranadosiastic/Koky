
package com.jgranados.koky.instructions.logic;

/**
 *
 * @author richard
 */
public enum Languages {
    ALL(true),
    ENGLISH(false),
    SPANISH(false),
    KICHE(false);
    
    private boolean typeLanguage;
    
    private Languages (boolean typeLanguage){
        this.typeLanguage = typeLanguage;
    }
    
    public boolean getTypeLanguage(){
        return typeLanguage;
    }
    
     public void setTypeLanguage(boolean activated) {
        this.typeLanguage = activated;
    }
    
    
    
}
