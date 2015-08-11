/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import modelo.Movimiento;

/**
 *
 * @author MarioAlberto
 */
public abstract class Movements {
    
    public static final Movimiento BLACK = new Movimiento(0, 42, 0);
    public static final Movimiento WHITE = new Movimiento(180, 42, 0);
    public static final Movimiento RED = new Movimiento(45, 42, 0);
    public static final Movimiento BLUE = new Movimiento(130, 42, 0);
    public static final Movimiento GREEN = new Movimiento(160, 42, 0);
    
    private static final Movimiento MOV_0_9 = new Movimiento(69.3,42,1.9);
    private static final Movimiento MOV_0_8 = new Movimiento(71.3,42,3.5);
    private static final Movimiento MOV_0_7 = new Movimiento(72,42,5);
    private static final Movimiento MOV_0_6 = new Movimiento(72.5,42,6.7);
    private static final Movimiento MOV_0_5 = new Movimiento(73,42,8.3);
    private static final Movimiento MOV_0_4 = new Movimiento(73,42,10);
    private static final Movimiento MOV_0_3 = new Movimiento(73.5,42,11.3);
        private static final Movimiento MOV_0_2 = new Movimiento(74,42,12.5);
    private static final Movimiento MOV_0_1 = new Movimiento(74.2,42,14.3);
    private static final Movimiento MOV_0_0 = new Movimiento(74.65,42,16);
    private static final Movimiento[] MOV_0 = {MOV_0_0,MOV_0_1,MOV_0_2,MOV_0_3,MOV_0_4,MOV_0_5,
                                                MOV_0_6,MOV_0_7,MOV_0_8,MOV_0_9};
    
    private static final Movimiento MOV_1_9 = new Movimiento(72.9,42,1.5);
    private static final Movimiento MOV_1_8 = new Movimiento(73.05,42,3.2);
    private static final Movimiento MOV_1_7 = new Movimiento(73.4,42,4.7);
    private static final Movimiento MOV_1_6 = new Movimiento(74,42,6.3);
    private static final Movimiento MOV_1_5 = new Movimiento(74.4,42,7.6);
    private static final Movimiento MOV_1_4 = new Movimiento(74.4,42,9);
    private static final Movimiento MOV_1_3 = new Movimiento(74.8,42,10.8);
    private static final Movimiento MOV_1_2 = new Movimiento(76,42,12.5);
    private static final Movimiento MOV_1_1 = new Movimiento(76.9,42,14);
    private static final Movimiento MOV_1_0 = new Movimiento(77.2,42,15.5);
    private static final Movimiento[] MOV_1 = {MOV_1_0,MOV_1_1,MOV_1_2,MOV_1_3,MOV_1_4,MOV_1_5,
                                                MOV_1_6,MOV_1_7,MOV_1_8,MOV_1_9};
    
    private static final Movimiento MOV_2_9 = new Movimiento(74.4,42,1);
    private static final Movimiento MOV_2_8 = new Movimiento(75.1,42,2.7);
    private static final Movimiento MOV_2_7 = new Movimiento(76,42,4.1);
    private static final Movimiento MOV_2_6 = new Movimiento(76,42,5.8);
    private static final Movimiento MOV_2_5 = new Movimiento(76.3,42,7.2);
    private static final Movimiento MOV_2_4 = new Movimiento(76.6,42,9);
    private static final Movimiento MOV_2_3 = new Movimiento(76.8,42,10.5);
    private static final Movimiento MOV_2_2 = new Movimiento(77,42,12.2);
    private static final Movimiento MOV_2_1 = new Movimiento(77.2,42,13.9);
    private static final Movimiento MOV_2_0 = new Movimiento(77.4,42,15.3);
    private static final Movimiento[] MOV_2 = {MOV_2_0,MOV_2_1,MOV_2_2,MOV_2_3,MOV_2_4,MOV_2_5,
                                                MOV_2_6,MOV_2_7,MOV_2_8,MOV_2_9};
    
    private static final Movimiento MOV_3_9 = new Movimiento(78.2,42,.5);
    private static final Movimiento MOV_3_8 = new Movimiento(78.5,42,2.3);
    private static final Movimiento MOV_3_7 = new Movimiento(78.8,42,4);
    private static final Movimiento MOV_3_6 = new Movimiento(79,42,5.6);
    private static final Movimiento MOV_3_5 = new Movimiento(79.4,42,7.1);
    private static final Movimiento MOV_3_4 = new Movimiento(79.5,42,8.7);
    private static final Movimiento MOV_3_3 = new Movimiento(79.7,42,10.2);
    private static final Movimiento MOV_3_2 = new Movimiento(80,42,12);
    private static final Movimiento MOV_3_1 = new Movimiento(80.2,42,13.5);
    private static final Movimiento MOV_3_0 = new Movimiento(80.3,42,15.2);
    private static final Movimiento[] MOV_3 = {MOV_3_0,MOV_3_1,MOV_3_2,MOV_3_3,MOV_3_4,MOV_3_5,
                                                MOV_3_6,MOV_3_7,MOV_3_8,MOV_3_9};
   
    private static final Movimiento MOV_4_9 = new Movimiento(80.1,42,0.3);
    private static final Movimiento MOV_4_8 = new Movimiento(80.5,42,2.2);
    private static final Movimiento MOV_4_7 = new Movimiento(80.7,42,3.6);
    private static final Movimiento MOV_4_6 = new Movimiento(80.8,42,5.3);
    private static final Movimiento MOV_4_5 = new Movimiento(80.7,42,6.9);
    private static final Movimiento MOV_4_4 = new Movimiento(81.3,42,8.5);
    private static final Movimiento MOV_4_3 = new Movimiento(81.5,42,10);
    private static final Movimiento MOV_4_2 = new Movimiento(82.1,42,11.7);
    private static final Movimiento MOV_4_1 = new Movimiento(82.2,42,13.2);
    private static final Movimiento MOV_4_0 = new Movimiento(82.8,42,15);
    private static final Movimiento[] MOV_4 = {MOV_4_0,MOV_4_1,MOV_4_2,MOV_4_3,MOV_4_4,MOV_4_5,
                                                MOV_4_6,MOV_4_7,MOV_4_8,MOV_4_9};
    
    private static final Movimiento MOV_5_9 = new Movimiento(83.6,42,0.1);
    private static final Movimiento MOV_5_8 = new Movimiento(84,42,1.9);
    private static final Movimiento MOV_5_7 = new Movimiento(84.1,42,3.5);
    private static final Movimiento MOV_5_6 = new Movimiento(84.3,42,5.2);
    private static final Movimiento MOV_5_5 = new Movimiento(84.4,42,6.8);
    private static final Movimiento MOV_5_4 = new Movimiento(84.5,42,8.4);
    private static final Movimiento MOV_5_3 = new Movimiento(84.6,42,10);
    private static final Movimiento MOV_5_2 = new Movimiento(84.6,42,11.5);
    private static final Movimiento MOV_5_1 = new Movimiento(84.7,42,13.3);
    private static final Movimiento MOV_5_0 = new Movimiento(84.6,42,14.8);
    private static final Movimiento[] MOV_5 = {MOV_5_0,MOV_5_1,MOV_5_2,MOV_5_3,MOV_5_4,MOV_5_5,
                                                MOV_5_6,MOV_5_7,MOV_5_8,MOV_5_9};
    
    private static final Movimiento MOV_6_9 = new Movimiento(86.1,42,0);
    private static final Movimiento MOV_6_8 = new Movimiento(86.1,42,1.8);
    private static final Movimiento MOV_6_7 = new Movimiento(86,42,3.3);
    private static final Movimiento MOV_6_6 = new Movimiento(85.9,42,5.1);
    private static final Movimiento MOV_6_5 = new Movimiento(86.1,42,6.6);
    private static final Movimiento MOV_6_4 = new Movimiento(86.1,42,8.2);
    private static final Movimiento MOV_6_3 = new Movimiento(86.2,42,9.7);
    private static final Movimiento MOV_6_2 = new Movimiento(86.1,42,11.4);
    private static final Movimiento MOV_6_1 = new Movimiento(86.1,42,12.9);
    private static final Movimiento MOV_6_0 = new Movimiento(86.1,42,15);
    private static final Movimiento[] MOV_6 = {MOV_6_0,MOV_6_1,MOV_6_2,MOV_6_3,MOV_6_4,MOV_6_5,
                                                MOV_6_6,MOV_6_7,MOV_6_8,MOV_6_9};
    
    private static final Movimiento MOV_7_9 = new Movimiento(89.4, 42, 0.1);
    private static final Movimiento MOV_7_8 = new Movimiento(89.4, 42, 1.9);
    private static final Movimiento MOV_7_7 = new Movimiento(89.3, 42, 3.5);
    private static final Movimiento MOV_7_6 = new Movimiento(89.2, 42, 5.1);
    private static final Movimiento MOV_7_5 = new Movimiento(89.2, 42, 6.8);
    private static final Movimiento MOV_7_4 = new Movimiento(89.2, 42, 8.4);
    private static final Movimiento MOV_7_3 = new Movimiento(89.2, 42, 9.9);
    private static final Movimiento MOV_7_2 = new Movimiento(89.2, 42, 11.7);
    private static final Movimiento MOV_7_1 = new Movimiento(89.1, 42, 13.2);
    private static final Movimiento MOV_7_0 = new Movimiento(89, 42, 14.7);
    private static final Movimiento[] MOV_7 = {MOV_7_0,MOV_7_1,MOV_7_2,MOV_7_3,MOV_7_4,MOV_7_5,
                                                MOV_7_6,MOV_7_7,MOV_7_8,MOV_7_9};
    
    private static final Movimiento MOV_8_9 = new Movimiento(91.5, 42, 0.3);
    private static final Movimiento MOV_8_8 = new Movimiento(91.5, 42, 2);
    private static final Movimiento MOV_8_7 = new Movimiento(91.4, 42, 3.7);
    private static final Movimiento MOV_8_6 = new Movimiento(91.2, 42, 5.3);
    private static final Movimiento MOV_8_5 = new Movimiento(91.1, 42, 6.8);
    private static final Movimiento MOV_8_4 = new Movimiento(91.1, 42, 8.2);
    private static final Movimiento MOV_8_3 = new Movimiento(91.1, 42, 10);
    private static final Movimiento MOV_8_2 = new Movimiento(91, 42, 11.7);
    private static final Movimiento MOV_8_1 = new Movimiento(91, 42, 13.3);
    private static final Movimiento MOV_8_0 = new Movimiento(90.9, 42, 14.9);
    private static final Movimiento[] MOV_8 = {MOV_8_0,MOV_8_1,MOV_8_2,MOV_8_3,MOV_8_4,MOV_8_5,
                                                MOV_8_6,MOV_8_7,MOV_8_8,MOV_8_9};
    
    private static final Movimiento MOV_9_9 = new Movimiento(94.2, 42, 0.4);
    private static final Movimiento MOV_9_8 = new Movimiento(93.5, 42, 2.2);
    private static final Movimiento MOV_9_7 = new Movimiento(93.1, 42, 3.8);
    private static final Movimiento MOV_9_6 = new Movimiento(92.8, 42, 5.2);
    private static final Movimiento MOV_9_5 = new Movimiento(92.8, 42, 6.8);
    private static final Movimiento MOV_9_4 = new Movimiento(92.7, 42, 8.5);
    private static final Movimiento MOV_9_3 = new Movimiento(92.4, 42, 10);
    private static final Movimiento MOV_9_2 = new Movimiento(92.4, 42, 11.8);
    private static final Movimiento MOV_9_1 = new Movimiento(92.4, 42, 13.5);
    private static final Movimiento MOV_9_0 = new Movimiento(92, 42, 15.3);
    private static final Movimiento[] MOV_9 = {MOV_9_0,MOV_9_1,MOV_9_2,MOV_9_3,MOV_9_4,MOV_9_5,
                                                MOV_9_6,MOV_9_7,MOV_9_8,MOV_9_9};
    
    private static final Movimiento MOV_10_9 = new Movimiento(97.3, 42, 0.6);
    private static final Movimiento MOV_10_8 = new Movimiento(96.9, 42, 2.4);
    private static final Movimiento MOV_10_7 = new Movimiento(96.8, 42, 3.9);
    private static final Movimiento MOV_10_6 = new Movimiento(96.3, 42, 5.6);
    private static final Movimiento MOV_10_5 = new Movimiento(95.7, 42, 7.3);
    private static final Movimiento MOV_10_4 = new Movimiento(95.1, 42, 8.8);
    private static final Movimiento MOV_10_3 = new Movimiento(94.7, 42, 10.2);
    private static final Movimiento MOV_10_2 = new Movimiento(94.5, 42, 11.8);
    private static final Movimiento MOV_10_1 = new Movimiento(94.3, 42, 13.7);
    private static final Movimiento MOV_10_0 = new Movimiento(94.1, 42, 15.3);
    private static final Movimiento[] MOV_10 = {MOV_10_0,MOV_10_1,MOV_10_2,MOV_10_3,MOV_10_4,MOV_10_5,
                                                MOV_10_6,MOV_10_7,MOV_10_8,MOV_10_9};
    
    private static final Movimiento MOV_11_9 = new Movimiento(99.5, 42, 1.4);
    private static final Movimiento MOV_11_8 = new Movimiento(98.9, 42, 3.2);
    private static final Movimiento MOV_11_7 = new Movimiento(98.3, 42, 4.6);
    private static final Movimiento MOV_11_6 = new Movimiento(97.9, 42, 6.2);
    private static final Movimiento MOV_11_5 = new Movimiento(97.8, 42, 7.8);
    private static final Movimiento MOV_11_4 = new Movimiento(97.7, 42, 9.2);
    private static final Movimiento MOV_11_3 = new Movimiento(97.3, 42, 10.7);
    private static final Movimiento MOV_11_2 = new Movimiento(96.9, 42, 12.4);
    private static final Movimiento MOV_11_1 = new Movimiento(96.7, 42, 13.9);
    private static final Movimiento MOV_11_0 = new Movimiento(96.5, 42, 15.4);
    private static final Movimiento[] MOV_11 = {MOV_11_0,MOV_11_1,MOV_11_2,MOV_11_3,MOV_11_4,MOV_11_5,
                                                MOV_11_6,MOV_11_7,MOV_11_8,MOV_11_9};
    
    private static final Movimiento MOV_12_9 = new Movimiento(103, 42, 2);
    private static final Movimiento MOV_12_8 = new Movimiento(102.6, 42, 3.2);
    private static final Movimiento MOV_12_7 = new Movimiento(102.1, 42, 5);
    private static final Movimiento MOV_12_6 = new Movimiento(101.5, 42, 6.4);
    private static final Movimiento MOV_12_5 = new Movimiento(100.5, 42, 7.9);
    private static final Movimiento MOV_12_4 = new Movimiento(99.3, 42, 9.8);
    private static final Movimiento MOV_12_3 = new Movimiento(98.8, 42, 11.3);
    private static final Movimiento MOV_12_2 = new Movimiento(98.4, 42, 12.8);
    private static final Movimiento MOV_12_1 = new Movimiento(98.2, 42, 14.3 );
    private static final Movimiento MOV_12_0 = new Movimiento(98, 42, 15.9);
    private static final Movimiento[] MOV_12 = {MOV_12_0,MOV_12_1,MOV_12_2,MOV_12_3,MOV_12_4,MOV_12_5,
                                                MOV_12_6,MOV_12_7,MOV_12_8,MOV_12_9};
    
    private static final Movimiento MOV_13_9 = new Movimiento(105.4, 42, 2.4);
    private static final Movimiento MOV_13_8 = new Movimiento(104.6, 42, 4.1);
    private static final Movimiento MOV_13_7 = new Movimiento(104.1, 42, 5.5);
    private static final Movimiento MOV_13_6 = new Movimiento(103.6, 42, 7);
    private static final Movimiento MOV_13_5 = new Movimiento(103.2, 42, 8.6);
    private static final Movimiento MOV_13_4 = new Movimiento(102.7, 42, 10.1);
    private static final Movimiento MOV_13_3 = new Movimiento(102.2, 42, 11.4);
    private static final Movimiento MOV_13_2 = new Movimiento(101.5, 42, 13);
    private static final Movimiento MOV_13_1 = new Movimiento(100.7, 42, 14.4);
    private static final Movimiento MOV_13_0 = new Movimiento(100, 42, 16);
    private static final Movimiento[] MOV_13 = {MOV_13_0,MOV_13_1,MOV_13_2,MOV_13_3,MOV_13_4,MOV_13_5,
                                                MOV_13_6,MOV_13_7,MOV_13_8,MOV_13_9};
    
    
    public static final Movimiento [][] MOVIMIENTOS = {MOV_0,MOV_1,MOV_2,MOV_3,
        MOV_4,MOV_5,MOV_6,MOV_7,MOV_8,MOV_9,MOV_10,MOV_11,MOV_12,MOV_13};
    
}
