package view;

import controller.GestionSocioVideoClub;
import model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class FormDevoluciones extends JFrame{

    GestionSocioVideoClub lista;
    private JPanel panelDevoluciones;
    private JTextField txtFieldNifSocio;
    private JButton btnComprobarSocio;
    private JLabel lblNifSocio;
    private JList listaDevolver;
    private JButton btnDevolver;
    private String socioNIF;
    private boolean existeNif;

    public FormDevoluciones() {
        super.setContentPane(panelDevoluciones);
        super.setLocationRelativeTo(null);
        super.setJMenuBar(MenuBar.crearMenuBar());
        MenuBar.gestionDeVentanas();

        btnComprobarSocio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    socioNIF = txtFieldNifSocio.getText().toUpperCase();
                    existeNif = GestionSocioVideoClub.comprobarNif(GestionSocioVideoClub.socios,socioNIF);

                    if (socioNIF.equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null,"El campo NIF Socio está vacio");

                    } else if (!existeNif) {
                        JOptionPane.showMessageDialog(null,"No existe el NIF introducido");

                    } else {
                        listaDevolver.setModel(GestionSocioVideoClub.mostarMultSocio(txtFieldNifSocio.getText()));
                    }
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        btnDevolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(null,"Estás seguro que quieres devolver-lo?","Alerta!",JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    GestionSocioVideoClub.devolverMultimedia(txtFieldNifSocio.getText(), listaDevolver.getSelectedValue().toString());
                }
            }
        });
    }

}
