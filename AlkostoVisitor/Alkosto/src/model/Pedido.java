package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import visitor.Visitante;
public class Pedido {

    private final List<ItemPedido> items = new ArrayList<>();

    public void agregarProducto(Producto producto, int cantidad) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        items.add(new ItemPedido(producto, cantidad));
    }

    public void aceptar(Visitante visitante) {
        if (visitante == null) {
            throw new IllegalArgumentException("El visitante no puede ser nulo");
        }
        for (ItemPedido item : items) {
            for (int i = 0; i < item.getCantidad(); i++) {
                item.getProducto().aceptar(visitante);
            }
        }
    }

    public List<ItemPedido> getItems() {
        return Collections.unmodifiableList(items);
    }
}
