package Modelo;

public class Emergencia {
    private String codigoReporte;
    private String fechaOcurrencia;
    private String fenomeno;
    private String provincia;
    private String distrito;
    private double latitud;
    private double longitud;

    public Emergencia() {}

    public String getCodigoReporte() { return codigoReporte; }
    public void setCodigoReporte(String codigoReporte) { this.codigoReporte = codigoReporte; }
    public String getFechaOcurrencia() { return fechaOcurrencia; }
    public void setFechaOcurrencia(String fechaOcurrencia) { this.fechaOcurrencia = fechaOcurrencia; }
    public String getFenomeno() { return fenomeno; }
    public void setFenomeno(String fenomeno) { this.fenomeno = fenomeno; }
    public String getProvincia() { return provincia; }
    public void setProvincia(String provincia) { this.provincia = provincia; }
    public String getDistrito() { return distrito; }
    public void setDistrito(String distrito) { this.distrito = distrito; }
    public double getLatitud() { return latitud; }
    public void setLatitud(double latitud) { this.latitud = latitud; }
    public double getLongitud() { return longitud; }
    public void setLongitud(double longitud) { this.longitud = longitud; }
}
