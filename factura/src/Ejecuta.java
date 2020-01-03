import java.io.ObjectInputStream.GetField;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ejecuta {

	public static void main(String[] ar) {

		FacturaServicio factura1 = new FacturaServicio();

		Factura var = factura1.nuevaFactura("Marco");
		
		// Lista de productos Disponibles
		Product producto1 = new Product();
		producto1.setCosto(new BigDecimal(5.6).setScale(2,
				RoundingMode.HALF_UP));
		producto1.setNombre("Calabaza");

		Product producto2 = new Product();
		producto2.setCosto(new BigDecimal(9.1).setScale(2,
				RoundingMode.HALF_UP));
		producto2.setNombre("Mango   ");

		Product producto3 = new Product();
		producto3.setCosto(new BigDecimal(8.2).setScale(2,
				RoundingMode.HALF_UP));
		producto3.setNombre("Pepino  ");
		
		
		
		// Productos seleccionados por el cliente
		factura1.nuevoDetalle(var, producto1, 2);
		factura1.nuevoDetalle(var, producto3, 4);

		
		// Mostrar datos
		System.out.print("Facture Number: ");	
		System.out.print(var.getNumber());
		System.out.print("      ");
		// System.out.println(var.getCliente();
		System.out.print("Fecha de Emision    : ");	
		System.out.println(var.getFechaEmision());
		System.out.print("Cliente:        ");
		System.out.print(var.getCliente().getNombre());
		System.out.print("          ");
		System.out.print("Fecha de Vencimiento: ");
		System.out.println(var.getFechaVencimiento());
		System.out.println();	
//		System.out.println(var.getLista());
		
		
		System.out.println("Producto     Costo  Cantidad   Subtotal    ");
		for (int i = 0; i < var.getLista().size(); i++) {		
		Detalle a = (var.getLista().get(i));
		System.out.print(a.producto.getNombre()+ "     ");
		System.out.print(a.getCosto()+ "      ");
		System.out.print(a.getCantidad()+ "         ");
		System.out.println(a.getSubtotal());
		}		
		
		System.out.println();		
		System.out.print("IMPORTE TOTAL:   $ ");
		System.out.println(var.getTotal());

	}

}
