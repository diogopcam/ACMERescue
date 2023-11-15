public class Terremoto extends Evento {
	private double magnitude;
	// MAGNITUDE UTILIZA A ESCALA RICHTER

	public Terremoto(String codigo, String data, double latitude, double longitude, double magnitude){
		super(codigo, data, latitude, longitude);
		this.magnitude = magnitude;
	}

	public void setMagnitude(double magnitude) {
		this.magnitude = magnitude;
	}

	public double getMagnitude() {
		return magnitude;
	}
}
