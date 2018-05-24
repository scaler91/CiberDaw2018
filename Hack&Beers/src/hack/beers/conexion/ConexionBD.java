/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers.conexion;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import ventasbd.dao.exception.ErrorConexionBD;

/**
 *
 * @author alxayu97
 */

public class ConexionBD {
    Connection conn;
    Statement stmt;
    
    static ConexionBD instancia = null;
    
    private ConexionBD() throws ErrorConexionBD {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cibercafebd","root","");
            stmt = conn.createStatement();
        }
        catch(SQLException e) {
            throw new ErrorConexionBD();
        }
    }
    
    public Connection getConnection() {
        return conn;
    }
    
    //ESTO ES LO QUE HE AÑADIDO
    public static Connection getConnectio() throws ClassNotFoundException, SQLException{
        Connection cn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdb");
        } catch (Exception e){  
        }
        return cn;
    }
    
    public Statement getStatement() {
        return stmt;
    }
    
    public static void crearConexion() throws ErrorConexionBD {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
    }
    
    public static ConexionBD instancia() {
        return instancia;
    }
    
    public static void desconectar() {
        if (instancia != null) {
            try {
                instancia.stmt.execute("shutdown");
                instancia.stmt.close();
                instancia.conn.close();
                instancia = null;
            }
            catch(SQLException e) {
            }
        }
    }
}
