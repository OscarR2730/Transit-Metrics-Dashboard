package Modelo;

public class Accidente {
    private String nroReporte;
    private String fecha;
    private String via;
    private String departamento;
    private String modalidad;
    private int fallecidos;
    private int heridos;

    public Accidente() {}

    public String getNroReporte() { return nroReporte; }
    public void setNroReporte(String nroReporte) { this.nroReporte = nroReporte; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public String getVia() { return via; }
    public void setVia(String via) { this.via = via; }
    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
    public String getModalidad() { return modalidad; }
    public void setModalidad(String modalidad) { this.modalidad = modalidad; }
    public int getFallecidos() { return fallecidos; }
    public void setFallecidos(int fallecidos) { this.fallecidos = fallecidos; }
    public int getHeridos() { return heridos; }
    public void setHeridos(int heridos) { this.heridos = heridos; }
    private double latitud;
    private double longitud;

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
