package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmergenciaDAO {
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=BD_SeguridadVial;integratedSecurity=true;encrypt=false;";

    public List<Emergencia> filtrarEmergencias(String departamento, int anio) {
        try { Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); } 
        catch (ClassNotFoundException e) { e.printStackTrace(); }

        List<Emergencia> lista = new ArrayList<>();
        String sql = "{CALL sp_ConsultarEmergenciasFiltro(?, ?)}";

        try (Connection conn = DriverManager.getConnection(url);
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, departamento);
            stmt.setInt(2, anio);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Emergencia e = new Emergencia();
                e.setCodigoReporte(rs.getString(1));
                e.setFechaOcurrencia(rs.getString(2));
                e.setFenomeno(rs.getString(3));
                e.setProvincia(rs.getString(4));
                e.setDistrito(rs.getString(5));
                e.setLatitud(rs.getDouble(6));
                e.setLongitud(rs.getDouble(7));
                lista.add(e);
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return lista;
    }
}
