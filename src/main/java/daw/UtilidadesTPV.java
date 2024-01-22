/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package daw;

import javax.swing.JOptionPane;

/**
 *
 * @author FX506
 */
public class UtilidadesTPV {

    public static int opcionModo() {
        
        String[] opciones = {"Administrador", "Usuario"};
        
        int opcionUsuario =  JOptionPane.showOptionDialog(null, 
                "Elige un modo", "TPV", JOptionPane.DEFAULT_OPTION, 
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        
        return opcionUsuario;
    }
    
    
    
}
