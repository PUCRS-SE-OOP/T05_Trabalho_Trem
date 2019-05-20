import java.util.ArrayList;
public class CadastroVagao{
    private ArrayList<Vagao> listaVagoes;

    public CadastroVagao(){
        listaVagoes = new ArrayList<Vagao>();
    }

    public boolean newVagao(String name, String type, int i){
        listaVagoes.add(new Vagao(name, type, i));
        int size = listaVagoes.size()-1;
        if(listaVagoes.get(size).isTrash()){
            listaVagoes.remove(listaVagoes.size()-1);
            return false;
        }
        else 
            return true;
    }
 
    public Vagao findVagao(String name){
        for(Vagao vagaoGet : listaVagoes){
            if(vagaoGet.getName().equals(name))
                return vagaoGet;
        }
    return null;
    }
    
    public int qtdVagoes(){
        return listaVagoes.size();
    }

    public String toString(){
        String linha = "";
        
        for(Vagao vagao : listaVagoes)
            if(vagao.using() == false)
                linha += "\n" + vagao.toString();

    return linha;
    }
}