package facturadb.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle")

public class Detalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "cantidad", nullable = false)
	private int cantidad;

	@Column(name = "subtotal", nullable = false, precision = 14, scale = 2)
	private BigDecimal subtotal;

	@JoinColumn(name = "producto_id", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	public Product producto;

	@Column(name = "costo", nullable = false, precision = 14, scale = 2)
	private BigDecimal costo;

	// Asociar la tabla detalle con la tabla factura por su Id
	@JoinColumn(name = "factura_id", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Factura factura;

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Product getProducto() {
		return producto;
	}

	public void setProducto(Product producto) {
		this.producto = producto;
	}

	// get costo producto

	// subtotal=cantidad*costo

}
