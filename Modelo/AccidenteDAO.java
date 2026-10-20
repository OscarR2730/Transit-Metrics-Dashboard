package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccidenteDAO {
    // Configura aquí las credenciales de tu SQL Server
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=BD_SeguridadVial;encrypt=false";
    private String user = "sa"; 
    private String pass = "tu_contraseña_aqui";

    public List<Accidente> filtrarAccidentes(String departamento, int anio) {
        List<Accidente> lista = new ArrayList<>();
        String sql = "{CALL sp_ConsultarAccidentesFiltro(?, ?)}";
        
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             CallableStatement stmt = conn.prepareCall(sql)) {
            
            stmt.setString(1, departamento);
            stmt.setInt(2, anio);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Accidente a = new Accidente();
                a.setNroReporte(rs.getString("N° Reporte"));
                a.setFecha(rs.getString("Fecha"));
                a.setVia(rs.getString("Vía"));
                a.setDepartamento(rs.getString("Departamento"));
                a.setModalidad(rs.getString("Modalidad"));
                a.setFallecidos(rs.getInt("Fallecidos"));
                a.setHeridos(rs.getInt("Heridos"));
                lista.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
