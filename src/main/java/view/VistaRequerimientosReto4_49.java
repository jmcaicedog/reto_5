package view;

import controller.*;
import model.dao.Consulta1_49Dao;
import model.dao.Consulta2_49Dao;
import model.dao.Consulta3_49Dao;
import model.vo.*;

import java.sql.SQLException;
import java.util.ArrayList;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;  


public class VistaRequerimientosReto4_49 extends JFrame {
    
    public static final ControladorRequerimientosReto4_49 controlador = new ControladorRequerimientosReto4_49();

    public static JFrame ventana = new JFrame("Consultas reto 5 - Grupo 49");

    public static void consulta1(){
        
        try{
            controlador.realizarConsulta1();
        }
        catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        } 
        

        JDialog popup1 = new JDialog(ventana,"Consulta 1");
        popup1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		DefaultTableModel modelo = Consulta1_49Dao.modelo; 
        final JTable tabla = new JTable(modelo);
        final JScrollPane scroll = new JScrollPane(tabla);
        tabla.setModel(modelo);
		popup1.getContentPane().add(scroll);
		popup1.pack();
        popup1.setVisible(true);
        
    }

    public static void consulta2(){
        try{
            controlador.realizarConsulta2();
        }
        catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

        JDialog popup2 = new JDialog(ventana,"Consulta 2");
        popup2.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		DefaultTableModel modelo = Consulta2_49Dao.modelo; 
        final JTable tabla = new JTable(modelo);
        final JScrollPane scroll = new JScrollPane(tabla);
        tabla.setModel(modelo);
		popup2.getContentPane().add(scroll);
		popup2.pack();
        popup2.setVisible(true);

        
    }


    public static void consulta3(){
        try{
            controlador.realizarConsulta3();
        }
        catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
        JDialog popup3 = new JDialog(ventana,"Consulta 3");
        popup3.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		DefaultTableModel modelo = Consulta3_49Dao.modelo; 
        final JTable tabla = new JTable(modelo);
        final JScrollPane scroll = new JScrollPane(tabla);
        tabla.setModel(modelo);
		popup3.getContentPane().add(scroll);
		popup3.pack();
        popup3.setVisible(true);      
    }


    public static void ventana(){
        JButton boton1,boton2,boton3;

        boton1=new JButton("Consulta 1");
		boton1.setBounds(10,10,150,30);
		boton2=new JButton("Consulta 2");
		boton2.setBounds(160,10,150,30);
		boton3=new JButton("Consulta 3");
		boton3.setBounds(310,10,150,30);

        
        boton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){  
                consulta1();
            }  
        }); 

        boton2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){  
                consulta2(); 
            }  
        }); 

        boton3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){  
                consulta3(); 
            }  
        }); 
        

        ventana.pack();
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setBounds(10,10,600,400);
        ventana.add(boton1);
        ventana.add(boton2);
        ventana.add(boton3);
        ventana.setLayout(null);  
        ventana.setVisible(true);
    }

}
