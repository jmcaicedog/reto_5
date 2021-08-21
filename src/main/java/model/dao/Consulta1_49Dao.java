package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.lang.annotation.Retention;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Consulta1_49Dao {
    public static DefaultTableModel modelo = new DefaultTableModel();
    public static JTable tabla = new JTable(modelo);
    public ArrayList<Consulta1VO_49> consulta1DAO() throws SQLException {

        modelo.addColumn("Nombre");
        modelo.addColumn("Salario");

        ArrayList<Consulta1VO_49> lista = new ArrayList<>();
        String consulta="SELECT Nombre , Salario FROM Lider l WHERE Ciudad_Residencia = 'Bogota';";
        Connection conexion = JDBCUtilities.getConnection();
        PreparedStatement statement = conexion.prepareStatement(consulta);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            Consulta1VO_49 cons = new Consulta1VO_49();
            cons.setNombre(rs.getString("Nombre"));
            cons.setSalario(rs.getInt("Salario"));
            lista.add(cons);
            Object [] fila = new Object[2];
            for (int i=0;i<2;i++)
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
