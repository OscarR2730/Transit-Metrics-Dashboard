package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CinemometroDAO {
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=BD_SeguridadVial;integratedSecurity=true;encrypt=false;";

    public List<Cinemometro> filtrarCinemometros(String region, int anio) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<Cinemometro> lista = new ArrayList<>();
        String sql = "{CALL sp_ConsultarCinemometrosFiltro(?, ?)}";

        try (Connection conn = DriverManager.getConnection(url);
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, region);
            stmt.setInt(2, anio);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cinemometro c = new Cinemometro();
                c.setNroDeteccion(rs.getString(1));
                c.setFecha(rs.getString(2));
                
                String carreteraDB = rs.getString(3);
                c.setCarretera(carreteraDB != null ? carreteraDB : "-");
                
                c.setLimiteVelocidad(rs.getInt(4));
                c.setVelocidadDetectada(rs.getInt(5));
                c.setLatitud(rs.getDouble(6));
                c.setLongitud(rs.getDouble(7));
                
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return lista;
    }
}
