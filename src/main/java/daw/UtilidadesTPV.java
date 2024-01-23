/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package daw;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

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
    
    public static int opcion5Botones(){
        UIManager.put("OptionPane.background", new Color(32, 139, 223));
        UIManager.put("Panel.background", new Color(32, 139, 223));
        
        Object [] options = {"CANCELAR", "IMPRIMIR", "VISTA PREVIA", "Hola", "Qué hay?"};
        int opcion = JOptionPane.showOptionDialog(null, "Elige imprimir o cancelar", "Aviso",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[1]);
        System.out.println(opcion);
        return opcion;
    }
    
    
    
    
    
}
