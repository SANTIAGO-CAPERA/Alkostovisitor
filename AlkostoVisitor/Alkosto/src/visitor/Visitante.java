package visitor;

import model.Celular;
import model.ComputadoraTorre;
import model.Nevera;
import model.Portatil;
import model.Tablet;
import model.Television;

public interface Visitante {

    void visitar(Tablet tablet);

    void visitar(Portatil portatil);

    void visitar(ComputadoraTorre computadoraTorre);

    void visitar(Television television);

    void visitar(Celular celular);

    void visitar(Nevera nevera);

    double getResultado();
}
