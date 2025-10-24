package com.example.quickfleet.models;

public class Pedido {
    private String id; // Un identificador único para el pedido
    private String fechaHora; // Fecha y hora (puede ser String o Date/Timestamp)
    private String direccion;
    private String descripcion;
    private String solicitante; // Quién lo pidió (para pendientes)
    private String Fecha; // Texto combinado para realizados (ej. "Pedido de A (Usuario) ##/##/20##")
    private String estado; // "En curso", "Pendiente", "Realizado"

    // Constructor vacío (necesario para algunas librerías como Firebase)
    public Pedido() {
    }

    // Constructor para un pedido pendiente (ejemplo)
    public Pedido(String id, String fechaHora, String direccion, String descripcion, String solicitante) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.solicitante = solicitante;
        this.estado = "Pendiente"; // Asumimos estado inicial
    }

    // Constructor para un pedido realizado (ejemplo)
    public Pedido(String id, String Fecha, String direccion, String descripcion) {
        this.id = id;
        this.Fecha = Fecha;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.estado = "Realizado";
    }

    // --- Getters y Setters ---
    // (Puedes generarlos automáticamente en Android Studio: Clic derecho -> Generate -> Getters and Setters -> Select All)

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFechaHora() { return fechaHora; }
    public void setFechaHora(String fechaHora) { this.fechaHora = fechaHora; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getSolicitante() { return solicitante; }
    public void setSolicitante(String solicitante) { this.solicitante = solicitante; }

    public String getUsuarioFecha() { return Fecha; }
    public void setUsuarioFecha(String Fecha) { this.Fecha = Fecha; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}