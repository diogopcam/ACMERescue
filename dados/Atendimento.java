package dados;
import excecoes.EquipeInvalida;
import dados.equipamentos.Equipamento;

public class Atendimento {

	private int codigo;

	private String dataInicio;

	private int duracao;

	private StatusAtendimento status;
	private Equipe equipeAlocada;
	private Evento eventoAtendido;
	private double distanciaEqEv;

	public Atendimento(int c, String data){
		codigo = c;
		dataInicio = data;
		duracao = 0;
		status = StatusAtendimento.PENDENTE;
	}

	
	public void setEquipeAlocada(Equipe e) throws EquipeInvalida {
		double lat1 = e.getLatitude();
		double long1 = e.getLongitude();
		double lat2 = eventoAtendido.getLatitude();
		double long2 = eventoAtendido.getLongitude();

		if(convLatLong(lat1, long1, lat2, long2) <= 5000){
			setEquipeAlocada(e);
		} else {
			throw new EquipeInvalida("Essa equipe não pode ser alocada nesse atendimento pois sua distância até o evento ultrapassa 5000km! ");
		}
	}

	public double calculaDeslocamento(Evento e, Equipe eq){
		double lat1 = e.getLatitude();
		double long1 = e.getLongitude();
		double lat2 = eq.getLatitude();
		double long2 = eq.getLongitude();

		distanciaEqEv = convLatLong(lat1, long1, lat2, long2);

		return distanciaEqEv;
	}

	public double calculaPrecoDeslocamento(){
		distanciaEqEv * (100*(equipeAlocada.getQuantidade()) + ((10/100) * e))
	}

	public int calculaCustoEquipe(){
		//duracaox 250 x numero de membros
		return getDuracao() * 250 * equipeAlocada.getQuantidade();
	}

	public double custoEquipamentos(){
		return duracao * equipeAlocada.custoDiarioEquipamentos();
	}

	public double convLatLong(double lat1, double lon1, double lat2, double lon2){
		double R = 6371;  // raio da Terra em quilômetros

		// converter graus para radianos
		lat1 = Math.toRadians(lat1);
		lon1 = Math.toRadians(lon1);
		lat2 = Math.toRadians(lat2);
		lon2 = Math.toRadians(lon2);

		// diferenças de coordenadas
		double dlat = lat2 - lat1;
		double dlon = lon2 - lon1;

		// fórmula de Haversine
		double a = Math.sin(dlat / 2) * Math.sin(dlat / 2) +
				Math.cos(lat1) * Math.cos(lat2) * Math.sin(dlon / 2) * Math.sin(dlon / 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		// distância em quilômetros
		double distance = R * c;

		return distance;
	}

	public Equipe getEquipeAlocada() {
		return equipeAlocada;
	}

	public void setEventoAtendido(Evento e){
		eventoAtendido = e;
	}

	public Evento getEventoAtendido() {
		return eventoAtendido;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setStatus(StatusAtendimento status) {
		this.status = status;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public int getDuracao() {
		return duracao;
	}

	public StatusAtendimento getStatus() {
		return status;
	}

	public double calculaCusto() {
		return 0;
	}

	public String atendimentoToString(){
		return "\n---ATENDIMENTO---\nCódigo: "+codigo+"\nData de início: "+dataInicio+"\nDuração: "+duracao+"\nStatus : "+status;
	}


	public static double calculateHaversineDistance(double lat1, double lon1, double lat2, double lon2) {
		double R = 6371;  // raio da Terra em quilômetros

		// converter graus para radianos
		lat1 = Math.toRadians(lat1);
		lon1 = Math.toRadians(lon1);
		lat2 = Math.toRadians(lat2);
		lon2 = Math.toRadians(lon2);

		// diferenças de coordenadas
		double dlat = lat2 - lat1;
		double dlon = lon2 - lon1;

		// fórmula de Haversine
		double a = Math.sin(dlat / 2) * Math.sin(dlat / 2) +
				Math.cos(lat1) * Math.cos(lat2) * Math.sin(dlon / 2) * Math.sin(dlon / 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		// distância em quilômetros
		double distance = R * c;

		return distance;
	}

}
