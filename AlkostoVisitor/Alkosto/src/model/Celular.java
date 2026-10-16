package model;
import visitor.Visitante;
public class Celular extends ProductoBase {

    public Celular(String nombre, double precio, double pesoGramos) {
        super(nombre, precio, pesoGramos);
    }

    @Override
    public void aceptar(Visitante visitante) {
        visitante.visitar(this);
    }
}
