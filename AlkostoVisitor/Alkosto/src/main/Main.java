package main;
import java.util.Locale;
import model.Celular;
import model.ComputadoraTorre;
import model.ItemPedido;
import model.Nevera;
import model.Pedido;
import model.Portatil;
import model.Tablet;
import model.Television;
import visitor.CalculadorEnvio;
import visitor.CalculadorSubtotal;

public class Main {

    public static void main(String[] args) {
        System.out.println("ALKOSTO");
        System.out.println();

        escenarioTaller();
        escenarioProductosExtra();
        escenarioPedidoVacio();
        escenarioCantidadInvalida();
    }

    private static void escenarioTaller() {
        Pedido pedido = new Pedido();
        pedido.agregarProducto(new Tablet("Tablet", 200, 250), 2);
        pedido.agregarProducto(new Portatil("Portatil", 400, 1000), 1);
        pedido.agregarProducto(new ComputadoraTorre("Computadora de torre", 600, 6000), 1);
        pedido.agregarProducto(new Television("Television", 300, 4000), 1);

        System.out.println("Escenario 1: pedido del taller");
        mostrarPedido(pedido);
    }

    private static void escenarioProductosExtra() {
        Pedido pedido = new Pedido();
        pedido.agregarProducto(new Celular("Celular", 500, 200), 2);
        pedido.agregarProducto(new Nevera("Nevera", 600, 30000), 1);

        System.out.println("Escenario 2: productos adicionales");
        mostrarPedido(pedido);
    }

    private static void escenarioPedidoVacio() {
        Pedido pedido = new Pedido();

        System.out.println("Escenario 3: pedido vacio");
        mostrarPedido(pedido);
    }

    private static void escenarioCantidadInvalida() {
        Pedido pedido = new Pedido();

        System.out.println("Escenario 4: cantidad invalida");
        try {
            pedido.agregarProducto(new Tablet("Tablet", 200, 250), 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error controlado: " + e.getMessage());
        }
    }

    private static void mostrarPedido(Pedido pedido) {
        for (ItemPedido item : pedido.getItems()) {
            System.out.println("Producto: " + item.getProducto().getNombre()+ ", cantidad: " + item.getCantidad());
        }

        CalculadorSubtotal subtotalVisitor = new CalculadorSubtotal();
        pedido.aceptar(subtotalVisitor);

        CalculadorEnvio envioVisitor = new CalculadorEnvio();
        pedido.aceptar(envioVisitor);

        double subtotal = subtotalVisitor.getResultado();
        double envio = envioVisitor.getResultado();
        double total = subtotal + envio;

       System.out.printf(Locale.US, "Subtotal: %.2f COP%n", subtotal);
       System.out.printf(Locale.US, "Envio: %.2f COP%n", envio);
       System.out.printf(Locale.US, "Total a pagar: %.2f COP%n", total);
       System.out.println();
    }
}
