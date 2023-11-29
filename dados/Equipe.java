package dados;
import java.util.ArrayList;

public class Equipe implements ConverteLatLong{

	private String codinome;

	private int quantidade;

	private double latitude;

	private double longitude;
	private Atendimento atendimentoResponsavel;
	private ArrayList<Equipamento> listaEquipamentosEquipe;

	public Equipe(String codinome, int quantidade, double latitude, double longitude) {
		this.codinome = codinome;
		this.quantidade = quantidade;
		this.latitude = latitude;
		this.longitude = longitude;
		listaEquipamentosEquipe = new ArrayList<Equipamento>();
	}

	public String getCodinome() {
		return codinome;
	}

	public void setCodinome(String codinome) {
		this.codinome = codinome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setAtendimentoResponsavel(Atendimento atendimentoResponsavel) {
		this.atendimentoResponsavel = atendimentoResponsavel;
	}

	public Atendimento getAtendimentoResponsavel() {
		return atendimentoResponsavel;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void adicionaEquipamento(Equipamento e){
		listaEquipamentosEquipe.add(e);
	}

	public ArrayList<Equipamento> getListaEquipamentosEquipe() {
		ArrayList<Equipamento> cloneLista = (ArrayList<Equipamento>) listaEquipamentosEquipe.clone();
		return cloneLista;
	}

	public String equipeToString() {
		return "\nCodinome: "+getCodinome()+"\nQuantidade de membros: "+getQuantidade()+"\nLatitude: "+getLatitude()+"\nLongitude: "+getLongitude();
	}


	public double custoDiarioEquipamentos(){
		double custoDiarioTodosEquip = 0;
		for(Equipamento e:listaEquipamentosEquipe){
			custoDiarioTodosEquip+= e.getCustoDia();
		}
		return custoDiarioTodosEquip;
	}


}
