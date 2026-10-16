package model;
import visitor.Visitante;
public class ComputadoraTorre extends ProductoBase {

    public ComputadoraTorre(String nombre, double precio, double pesoGramos) {
        super(nombre, precio, pesoGramos);
    }

    @Override
    public void aceptar(Visitante visitante) {
        visitante.visitar(this);
    }
}
