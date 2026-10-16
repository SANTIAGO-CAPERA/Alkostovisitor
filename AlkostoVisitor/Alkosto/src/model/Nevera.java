package model;

import visitor.Visitante;

public class Nevera extends ProductoBase {

    public Nevera(String nombre, double precio, double pesoGramos) {
        super(nombre, precio, pesoGramos);
    }

    @Override
    public void aceptar(Visitante visitante) {
        visitante.visitar(this);
    }
}
