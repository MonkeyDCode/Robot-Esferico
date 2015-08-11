/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import ftcomputing.roboTX.Cnt;
import ftcomputing.roboTX.Mot;
import ftcomputing.roboTX.Unv;

/**
 *
 * @author MarioAlberto
 */
public abstract class Constantes {
    
    public static final Mot ART1 = Mot.M4;
    public static final Mot ART2 = Mot.M2;
    public static final Mot ART3 = Mot.M3;
    public static final Mot PINZA = Mot.M1;
    
    public static final Cnt COUNT_ART1 = Cnt.C4;
    public static final Cnt COUNT_ART2 = Cnt.C2;
    public static final Cnt COUNT_ART3 = Cnt.C3;
    
    public static final Unv HOME_ART1 = Unv.I6;
    public static final Unv HOME_ART2 = Unv.I4;
    public static final Unv HOME_ART3 = Unv.I5;
    
    public static final Unv PARO_ART1 = Unv.I1;
    public static final Unv PARO_ART2 = Unv.I2;
    public static final Unv PARO_ART3 = Unv.I7;
    
    public static final Unv OPEN_PINZA = Unv.I3;
    
    public static final boolean IS_HOME_ART1 = false;
    public static final boolean IS_HOME_ART2 = true;
    public static final boolean IS_HOME_ART3 = true;
    
    public static final boolean IS_STOP_ART1 = true;
    public static final boolean IS_STOP_ART2 = true;
    public static final boolean IS_STOP_ART3 = false;
    
    public static final boolean IS_PINZA_OPEN = false;
    
    public static final double FIN_A3 = 51.746905089408528198074277854194;
    
    
    
}
