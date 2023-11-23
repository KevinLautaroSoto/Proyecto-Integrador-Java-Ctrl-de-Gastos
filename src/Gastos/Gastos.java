package Gastos;

import Categoria.Categoria;

import java.util.Date;

public class Gastos {
    private int idGastos;
    private Date fecha;
    private Double monto;
    private String descripcion;
    private Categoria categoria;

    public Gastos (int idGastos, Date fecha, Double monto, String descripcion, Categoria categoria) {
        this.idGastos = idGastos;
        this.fecha = fecha;
        this.monto = monto;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public int getIdGastos () {
        return this.idGastos;
    }

    public void setIdGastos (int idGastos) {
        this.idGastos = idGastos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
