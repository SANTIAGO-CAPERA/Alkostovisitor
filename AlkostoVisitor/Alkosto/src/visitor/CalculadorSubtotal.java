package visitor;

import model.Celular;
import model.ComputadoraTorre;
import model.Nevera;
import model.Portatil;
import model.Producto;
import model.Tablet;
import model.Television;

public class CalculadorSubtotal implements Visitante {

    private double subtotal = 0;

    private void sumar(Producto producto) {
        subtotal += producto.getPrecio();
    }

    @Override
    public void visitar(Tablet tablet) {
        sumar(tablet);
    }

    @Override
    public void visitar(Portatil portatil) {
        sumar(portatil);
    }

    @Override
    public void visitar(ComputadoraTorre computadoraTorre) {
        sumar(computadoraTorre);
    }

    @Override
    public void visitar(Television television) {
        sumar(television);
    }

    @Override
    public void visitar(Celular celular) {
        sumar(celular);
    }

    @Override
    public void visitar(Nevera nevera) {
        sumar(nevera);
    }

    @Override
    public double getResultado() {
        return subtotal;
    }
}
