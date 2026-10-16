package visitor;

import model.Celular;
import model.ComputadoraTorre;
import model.Nevera;
import model.Portatil;
import model.Producto;
import model.Tablet;
import model.Television;

public class CalculadorEnvio implements Visitante {

    private static final double GRAMOS_POR_TRAMO = 100.0;
    private static final double PORCENTAJE_POR_TRAMO = 2.0;

    private double costoEnvio = 0;

    private void acumular(Producto producto) {
        double porcentajeEnvio = (producto.getPesoGramos() / GRAMOS_POR_TRAMO) * PORCENTAJE_POR_TRAMO;
        costoEnvio += producto.getPrecio() * porcentajeEnvio / 100.0;
    }

    @Override
    public void visitar(Tablet tablet) {
        acumular(tablet);
    }

    @Override
    public void visitar(Portatil portatil) {
        acumular(portatil);
    }

    @Override
    public void visitar(ComputadoraTorre computadoraTorre) {
        acumular(computadoraTorre);
    }

    @Override
    public void visitar(Television television) {
        acumular(television);
    }

    @Override
    public void visitar(Celular celular) {
        acumular(celular);
    }

    @Override
    public void visitar(Nevera nevera) {
        acumular(nevera);
    }

    @Override
    public double getResultado() {
        return costoEnvio;
    }
}
