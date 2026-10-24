package Modelo;

public class Cinemometro {
    private String nroDeteccion;
    private String fecha;
    private String carretera;
    private int limiteVelocidad;
    private int velocidadDetectada;
    private double latitud;
    private double longitud;

    public Cinemometro() {}

    public String getNroDeteccion() { return nroDeteccion; }
    public void setNroDeteccion(String nroDeteccion) { this.nroDeteccion = nroDeteccion; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public String getCarretera() { return carretera; }
    public void setCarretera(String carretera) { this.carretera = carretera; }
    public int getLimiteVelocidad() { return limiteVelocidad; }
    public void setLimiteVelocidad(int limiteVelocidad) { this.limiteVelocidad = limiteVelocidad; }
    public int getVelocidadDetectada() { return velocidadDetectada; }
    public void setVelocidadDetectada(int velocidadDetectada) { this.velocidadDetectada = velocidadDetectada; }
    public double getLatitud() { return latitud; }
    public void setLatitud(double latitud) { this.latitud = latitud; }
    public double getLongitud() { return longitud; }
    public void setLongitud(double longitud) { this.longitud = longitud; }
}
