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


public class Consulta3_49Dao {
    public static DefaultTableModel modelo = new DefaultTableModel();
    public static JTable tabla = new JTable(modelo);
    public ArrayList<Consulta3VO_49> consulta3DAO() throws SQLException {

        modelo.addColumn("Constructora");
        modelo.addColumn("Baños");
        modelo.addColumn("Nombre");

        ArrayList<Consulta3VO_49> lista = new ArrayList<>();
        String consulta="SELECT p.Constructora , p.Numero_Banos , l3.Nombre FROM Proyecto p JOIN Lider l3  WHERE p.ID_Proyecto >= 5 AND p.ID_Proyecto <= 17 AND p.ID_Lider == l3.ID_Lider;";
        Connection conexion = JDBCUtilities.getConnection();
        PreparedStatement statement = conexion.prepareStatement(consulta);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            Consulta3VO_49 cons = new Consulta3VO_49();
            cons.setConstructora(rs.getString("Constructora"));
            cons.setBanos(rs.getInt("Numero_Banos"));
            cons.setNombre(rs.getString("Nombre"));
            lista.add(cons);
            Object [] fila = new Object[3];
            for (int i=0;i<3;i++)
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
