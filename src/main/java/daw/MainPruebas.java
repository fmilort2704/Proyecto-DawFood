/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package daw;

import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author FX506
 */
public class MainPruebas {

    public static void main(String[] args) {

//        ArrayList<Tarjeta> baseDatosTarjeta = UtilidadesTarjeta.baseDatosTarjeta();
//        
//        //Comprobando cual es el máximo día del mes
//        System.out.println(LocalDate.MAX.getDayOfMonth());
//        
//        //Buscando la tarjeta del cliente
//        System.out.println("----------------------------------------------------------------------");
//        String digitosCliente = "4567";
//        Tarjeta tarjetaCliente = new Tarjeta();
//        
//        for (int i = 0; i < baseDatosTarjeta.size(); i++) {
//            if (digitosCliente.equals(baseDatosTarjeta.get(i)
//                    .getNumTarjeta()
//                    .substring(baseDatosTarjeta.get(i).getNumTarjeta().length() - 4,
//                            baseDatosTarjeta.get(i).getNumTarjeta().length()))) {
//                tarjetaCliente = baseDatosTarjeta.get(i);
//            }
//        }
//        System.out.println(tarjetaCliente);
//        TPV tpv1 = new TPV("Estepona");
//        tpv1.encenderTPV();
//        ArrayList<Producto> baseDatosProductos = tpv1.getCartaProductos();
//
//        Categoria[] valoresCategorias = Categoria.values();
//
//        Categoria opcionElegida = (Categoria) JOptionPane.showInputDialog(null,
//                "Selector de categorias", "TPV", JOptionPane.YES_NO_CANCEL_OPTION,
//                null, valoresCategorias, valoresCategorias[0]);


          mostrarMenuPrincipal();

    }

    public static void mostrarMenuPrincipal() {
        String[] opcionesMenu = {"Ver menú", "Salir"};

        while (true) {
            // Crear un panel para personalizar el JOptionPane
            JPanel panel = new JPanel();
            JComboBox<String> comboBox = new JComboBox<>(opcionesMenu);
            JButton botonAceptar = new JButton("Aceptar");
            JButton botonVolver = new JButton("Volver");
            JButton botonInicio = new JButton("Inicio");

            panel.setLayout(new GridLayout(0, 1));
            panel.add(new JLabel("Seleccione una opción: "));
            panel.add(comboBox);
            panel.add(botonAceptar);
            panel.add(botonVolver);
            panel.add(botonInicio);

            int opcionSeleccionada = JOptionPane.showOptionDialog(
                    null,
                    panel,
                    "Menú Principal",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{},
                    opcionesMenu[0]);
            
            System.out.println(opcionSeleccionada);

            switch (opcionSeleccionada) {
                case JOptionPane.CLOSED_OPTION:
                    // Se ha cerrado la ventana
                    JOptionPane.showMessageDialog(null, "Ha salido del programa.");
                    System.exit(0); // Salir del programa
                case 0:
                    // Se ha seleccionado una opción del menú principal
                    realizarAccion(comboBox.getSelectedItem().toString());
                    break;
                case 1:
                    // Se ha seleccionado "Salir"
                    JOptionPane.showMessageDialog(null, "Ha salido del programa.");
                    System.exit(0); // Salir del programa
                default:
                    // Se ha seleccionado "Inicio"
                    JOptionPane.showMessageDialog(null, "Volviendo al inicio.");
                    break;
            }
        }
    }

    public static void realizarAccion(String opcion) {
        // Puedes agregar aquí la lógica para cada opción del menú principal
        // En este ejemplo, simplemente mostraremos un mensaje con la acción seleccionada
        JOptionPane.showMessageDialog(null, "Realizando acción: " + opcion);
    }

}
