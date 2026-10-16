package model;
public abstract class ProductoBase implements Producto {

    private final String nombre;
    private final double precio;
    private final double pesoGramos;

    protected ProductoBase(String nombre, double precio, double pesoGramos) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto es obligatorio");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero");
        }
        if (pesoGramos <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor que cero");
        }
        this.nombre = nombre;
        this.precio = precio;
        this.pesoGramos = pesoGramos;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public double getPesoGramos() {
        return pesoGramos;
    }
}
