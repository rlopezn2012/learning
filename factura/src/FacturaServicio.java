import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;

public class FacturaServicio {


	public Factura nuevaFactura(String nombreCliente) {

		Factura nuevaFactura = new Factura();

		nuevaFactura.setFechaEmision(LocalDate.now());
		nuevaFactura.setFechaVencimiento(LocalDate.now().plusDays(30));
		nuevaFactura.setNumber("MUg578493");
		nuevaFactura.setTotal(BigDecimal.ZERO);
		nuevaFactura.setLista(new ArrayList<Detalle>());
		nuevaFactura.setCliente(new Cliente(nombreCliente));
		return nuevaFactura;
	}

	public void nuevoDetalle(Factura nuevaFactura, Product producto1, int cantidad) {

		// calcular y actualizar subtotal
		BigDecimal nuevoSubtotal = producto1.getCosto().multiply(new BigDecimal(cantidad)).setScale(2,
				RoundingMode.HALF_UP);
		BigDecimal nuevoTotal = nuevaFactura.getTotal().add(nuevoSubtotal);
		nuevaFactura.setTotal(nuevoTotal);

		// Crear nuevo detalle
		
		Detalle nuevoDetalle =new Detalle();
		
		nuevoDetalle.setCantidad(cantidad);
		nuevoDetalle.setProducto(producto1);
		nuevoDetalle.setSubtotal(nuevoSubtotal);
		nuevoDetalle.setCosto(producto1.getCosto());
		
				
		// Agregar el nuevo detalle a la factura
		
		nuevaFactura.getLista().add(nuevoDetalle);
		
	
	}

}
