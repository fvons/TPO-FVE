package Model;

public class CargaProfundidad extends ObjetosJuego {

	/**
	 * Default constructor
	 */
	public CargaProfundidad() {
	}

	private float alturaExplosion;
	private Buque buque;

	public CargaProfundidad(int velocidad, int altura, int largo, Coordenada c) {
		// OJ
		this.velocidad = velocidad;
		this.altura = altura;
		this.largo = largo;
		this.coordenada = c;
		// Carga
		setAlturaExplosion();
		buque = null;//TODO ver como asignarle el buque
	}

	public void soltar() {
		this.buque = null;
	}

	public void moveY(float deltaTime) {
		if (estaSoltada()) {
			float distancia = deltaTime * this.velocidad * ObjetosJuego.velocidadMultiplicador;
			this.coordenada.moverY(distancia);
			// TODO chequeo si tiene que explotar
			float yActual = this.coordenada.getX();
			if (yActual <= this.alturaExplosion)
				explotar();
		}
	}

	private void explotar() {
		// TODO implement here evento de explosion
	}

	private boolean estaSoltada() {
		return this.buque == null;
	}

	public int calcularDaņo(float explosionDistancia) {
		// TODO implement here
		return 0;
	}

	public int calcularPuntos(float explosionDistancia) {
		// TODO implement here
		return 0;
	}

	private void setAlturaExplosion() {
		// TODO numero random dentro del gamearea
		this.alturaExplosion = 0.0f;
	}

	public void moverConBuque(float deltaX) {
		if (!estaSoltada())
			this.coordenada.moverX(deltaX);
	}

}