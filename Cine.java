
public class Cine {

	private Pelicula proyectar;
	private double precioEntrada;
	
	public Cine() {
		this(new Pelicula(), 10);
	}
	
	public Cine (Pelicula peli, double precio) {
		this.proyectar = peli;
		this.precioEntrada = precio;
	}

	public Pelicula getProyecta() {
		return proyectar;
	}

	public void setProyecta(Pelicula proyectar) {
		this.proyectar = proyectar;
	}

	public double getPrecioEntrada() {
		return precioEntrada;
	}

	public void setPrecioEntrada(double precioEntrada) {
		this.precioEntrada = precioEntrada;
	}
}
