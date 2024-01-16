/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package daw;

/**
 *
 * @author francisco
 */
public enum IVA {
    IVA_VETIUNO(1.21),
    IVA_DIEZ(1.1);
    
    private final double IVA;
    
    IVA(double IVA){
        this.IVA = IVA;
    }

    public double getIVA() {
        return IVA;
    }
    
    
}
