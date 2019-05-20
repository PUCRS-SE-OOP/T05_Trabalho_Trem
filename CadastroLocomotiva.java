import java.util.ArrayList;
public class CadastroLocomotiva{
    private ArrayList<Locomotiva> listaLocomotivas;

    public CadastroLocomotiva(){
        listaLocomotivas = new ArrayList<Locomotiva>();
    }
    
    public boolean newLocomotiva(String name, int power){
        listaLocomotivas.add(new Locomotiva(name, power));
        int size = listaLocomotivas.size()-1;
        if(listaLocomotivas.get(size).isTrash() == true){
            listaLocomotivas.remove(listaLocomotivas.size()-1);
            return false;
        }
        else
            return true;
    }

    public Locomotiva findLocomotiva(String name){
        for(Locomotiva locomotivaGet : listaLocomotivas){
            if(locomotivaGet.getName().equals(name))
                return locomotivaGet;
        }
    return null;
    }
    
    public int qtdLocomotivas(){
        return listaLocomotivas.size();
    }

    public String toString(){
        String linha = "";
        
        for(Locomotiva locomotiva : listaLocomotivas)
            if(locomotiva.using() == false)
                linha += "\n" + locomotiva.toString();

    return linha;
    }
}
