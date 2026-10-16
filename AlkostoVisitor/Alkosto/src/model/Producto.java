package model;

import visitor.Visitante;

public interface Producto {

    String getNombre();

    double getPrecio();

    double getPesoGramos();

    void aceptar(Visitante visitante);
}
