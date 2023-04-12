package com.co.practicaactivity.model;

public class Registro {

    private String fechaVisita;
    private String valorKilowatts;

    public Registro(String fechaVisita, String valorKilowatts) {
        this.fechaVisita = fechaVisita;
        this.valorKilowatts = valorKilowatts;
    }

    public String getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(String fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public String getValorKilowatts() {
        return valorKilowatts;
    }

    public void setValorKilowatts(String valorKilowatts) {
        this.valorKilowatts = valorKilowatts;
    }

    @Override
    public String toString() {
        return "fechaVisita='" + fechaVisita + '\'' +
                ", valorKilowatts='" + valorKilowatts;
    }
}
