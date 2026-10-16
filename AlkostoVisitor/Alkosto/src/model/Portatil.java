package model;

import visitor.Visitante;

public class Portatil extends ProductoBase {

    public Portatil(String nombre, double precio, double pesoGramos) {
        super(nombre, precio, pesoGramos);
    }

    @Override
    public void aceptar(Visitante visitante) {
        visitante.visitar(this);
    }
}
