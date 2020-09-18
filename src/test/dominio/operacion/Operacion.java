package dominio.operacion;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import dominio.notificacion.BandejaMensajes;

public class Operacion{

	private Documento documento;
	private LocalDate fechaOperacion;
	private Proveedor proveedor;
	private MedioPago medioPago;
	private List<Item> items = new ArrayList<Item>();
	private String datosPropios;
	private Integer cantidadPresupuestosCompra;
	private String etiqueta;
	private List<Presupuesto> presupuestos = new ArrayList<Presupuesto>();
	
	public List<Presupuesto> getPresupuestos() {
		return presupuestos;
	}

	private List<BandejaMensajes> observadores = new ArrayList<BandejaMensajes>();

	public Operacion(Integer cantidadPresupuestosCompra) {
		this.cantidadPresupuestosCompra = cantidadPresupuestosCompra;
	}

	public void setCantidadPresupuestosCompra(int cantidadPresupuestosCompra) {
		this.cantidadPresupuestosCompra = cantidadPresupuestosCompra;
	}

	public BigDecimal valorTotal() {
		return items.stream().map(item -> item.valor()).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public void asociarPresupuesto(Presupuesto presupuesto) {

		this.presupuestos.add(presupuesto);

	}

	public void validarCompras() {

		if (this.tieneCompraTodosSusPresupuestos() && this.estaLaCompraBasadaEnAlgunPresupuesto())
			notificarObservadores("Compra Validada");

	}

	public boolean tieneCompraTodosSusPresupuestos() {

		return cantidadPresupuestosCompra == presupuestos.stream().count();

	}

	public boolean estaLaCompraBasadaEnAlgunPresupuesto() {

		return presupuestos.stream().anyMatch(presupuesto -> presupuesto.estaBasadoEnLaCompra(this));
	}

	public void notificarObservadores(String mensaje) {

		observadores.stream().forEach(p -> p.sendMensajes(mensaje));
	}

	public void agregarObservadores(BandejaMensajes bandeja) {

		observadores.add(bandeja);
	}

	public void removerObservadores(BandejaMensajes bandeja) {

		observadores.remove(bandeja);
	}

	public void agregarItem(Item item) {

		items.add(item);
	}

	public LocalDate getFechaOperacion() {
		return fechaOperacion;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public List<Presupuesto> presupuestos() {
				return presupuestos;
	}

	public void setFechaOperacion(int anio, int mes, int dia) {
		this.fechaOperacion = LocalDate.of(anio, mes, dia);
	}

	public List<Item> items() {
		return items;
	}

}
