import java.util.ArrayList;
public class ListaEventos {
    private int quantEventos;
    private ArrayList<Evento> listaEventos;

    public ListaEventos() {
        listaEventos = new ArrayList<>();
        quantEventos = 0;
    }

    public int getQuantEventos() {
        return quantEventos;
    }

    public ArrayList<Evento> getListaEventos() {
        return listaEventos;
    }

    public void mostraEventos() {
        for (Evento i : listaEventos) {
            i.eventoToString();
        }
    }

    public boolean verificaCodigo(String codigo) {
        if(listaEventos.isEmpty()) return true;
        for (Evento i : listaEventos) {
            if (codigo.equalsIgnoreCase(i.getCodigo())) {
                return false;
            }
        }
        return true;
    }

    public void addEvento(Evento e){
        if(verificaCodigo(e.getCodigo())){
            listaEventos.add(e);
            quantEventos++;
        } else {
            System.out.println("Não é possível adicionar esse evento pois esse código já existe.");
        }
    }
}
