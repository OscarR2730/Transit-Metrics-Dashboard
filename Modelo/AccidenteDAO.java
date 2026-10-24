package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccidenteDAO {
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=BD_SeguridadVial;integratedSecurity=true;encrypt=false;";

    public List<Accidente> filtrarAccidentes(String departamento, int anio) {
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error cargando el driver de SQL Server: " + e.getMessage());
            e.printStackTrace();
        }

        List<Accidente> lista = new ArrayList<>();
        String sql = "{CALL sp_ConsultarAccidentesFiltro(?, ?)}";

        try (Connection conn = DriverManager.getConnection(url);
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, departamento);
            stmt.setInt(2, anio);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Accidente a = new Accidente();
                
                a.setNroReporte(rs.getString(1));
                a.setFecha(rs.getString(2));
                
                String viaDB = rs.getString(3);
                a.setVia(viaDB != null ? viaDB : "-");
                
                a.setDepartamento(rs.getString(4));
                a.setModalidad(rs.getString(5));
                a.setFallecidos(rs.getInt(6));
                a.setHeridos(rs.getInt(7));
                
                a.setLatitud(rs.getDouble(8));
                a.setLongitud(rs.getDouble(9));
                
                lista.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());
            e.printStackTrace();
        }
        
        return lista;
    }
}
