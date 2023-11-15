public class Ciclone extends Evento {
	private double velocidade;
	private double precipitacao;

	public Ciclone(String codigo, String data, double latitude, double longitude, double velocidade, double precipitacao){
		super(codigo, data, latitude, longitude);
		this.velocidade = velocidade;
		this.precipitacao = precipitacao;
	}

	public void setVelocidade(double velocidade) {
		this.velocidade = velocidade;
	}

	public double getVelocidade() {
		return velocidade;
	}

	public void setPrecipitacao(double precipitacao) {
		this.precipitacao = precipitacao;
	}

	public double getPrecipitacao() {
		return precipitacao;
	}
}
