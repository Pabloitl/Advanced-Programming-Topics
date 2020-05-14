package AmigosBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DataBase {
    private String controlador;
    private String baseDeDatos;
    private String user;
    private String contrasena;
    private String consultaSQL;
    private String[] encabezados;
    private String[][] datosConsulta;

    private Connection conexion;
    private Statement consulta;
    private ResultSet resultados;
    private ResultSetMetaData rsMetaData;

    public DataBase(String dataBase, String con_SQL) {
        this(dataBase, con_SQL, null, null);
    }

    public DataBase(String dataBase, String con_SQL, String usr,
            String contras) {
        user = usr;
        contrasena = contras;
        baseDeDatos = dataBase;
        consultaSQL = con_SQL;
        controlador = "com.mysql.jdbc.Driver";
        try {
            conectarBD();
            realizaConsulta();
            interpretaResultados();
            conexion.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "No se ha podido completar algun paso");
        }
    }

    private void conectarBD() {
        try {
            conexion = DriverManager.getConnection(baseDeDatos,
                    user, contrasena);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                "Imposible conectar con la base de datos " + ex.getMessage());
        }
    }

    private void realizaConsulta() {
        try {
            consulta = conexion.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultados = consulta.executeQuery(consultaSQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Imposible realizar la consulta " + ex.getMessage());
        }
    }

    private void interpretaResultados() {
        try {
            rsMetaData = resultados.getMetaData();
            int columnas = rsMetaData.getColumnCount();
            encabezados = new String[columnas];
            for (int i = 1; i <= columnas; i++) {
                encabezados[i - 1] = rsMetaData.getColumnName(i);
            }

            int renglones = 0;
            while (resultados.next())
                renglones++;

            datosConsulta = new String[renglones][columnas];
            int registro = 0;
            resultados.beforeFirst();
            while (resultados.next()) {
                for (int i = 1; i <= columnas; i++) {
                    datosConsulta[registro][i - 1] =
                            resultados.getObject(i).toString();
                }
                registro++;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Imposible mostrar datos/encabezados " + ex.getMessage());
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Nada que mostrar");
        }
    }

    public String[] getEncabezados() {
        return encabezados;
    }
    
    public String[][] getDatos() {
        return datosConsulta;
    }
}
