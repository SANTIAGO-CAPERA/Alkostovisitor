package model;

import visitor.Visitante;

public class Tablet extends ProductoBase {

    public Tablet(String nombre, double precio, double pesoGramos) {
        super(nombre, precio, pesoGramos);
    }

    @Override
    public void aceptar(Visitante visitante) {
        visitante.visitar(this);
    }
}
