package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Consulta2_49Dao {
    public static DefaultTableModel modelo = new DefaultTableModel();
    public static JTable tabla = new JTable(modelo);
    public ArrayList<Consulta2VO_49> consulta2DAO() throws SQLException {

        modelo.addColumn("Nombre");
        modelo.addColumn("Salario");
        modelo.addColumn("isr");
        modelo.addColumn("ape");
        
        ArrayList<Consulta2VO_49> lista = new ArrayList<>();
        String consulta="SELECT Nombre , Salario , (Salario * 0.16) as isr , Primer_Apellido || ' ' || Segundo_Apellido as ape FROM Lider l2 WHERE Salario > 10000;";
        Connection conexion = JDBCUtilities.getConnection();
        PreparedStatement statement = conexion.prepareStatement(consulta);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            Consulta2VO_49 cons = new Consulta2VO_49();
            cons.setNombre(rs.getString("Nombre"));
            cons.setSalario(rs.getInt("Salario"));
            cons.setIsr(rs.getDouble("isr"));
            cons.setApe(rs.getString("ape"));
            lista.add(cons);
            Object [] fila = new Object[4];
            for (int i=0;i<4;i++)
                fila[i] = rs.getObject(i+1); 
            modelo.addRow(fila);
        }
        rs.close();
        statement.close();
        if(conexion != null){
            conexion.close();
        }
        return lista;
    }  
}
