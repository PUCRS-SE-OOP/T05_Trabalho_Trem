import java.util.ArrayList;

public class Trem{
    private ArrayList<Locomotiva> locomotivas;
    private ArrayList<Vagao> vagoes;
    
    public Trem(Locomotiva locomotiva){
        locomotivas = new ArrayList<Locomotiva>();
        vagoes = new ArrayList<Vagao>();   
        locomotivas.add(locomotiva);
        locomotiva.using(true); 
    }

    public boolean insertVagao(Vagao vagao){
        if(vagao.using() == false){
            vagoes.add(vagao);
            vagao.using(true);
            return true;
        }
    return false;
    }

    public boolean insertLocomotiva(Locomotiva locomotiva){
        if(locomotiva.using() == false){
            locomotivas.add(locomotiva);
            locomotiva.using(true);
            return true;
        }
    return false;
    }

    public boolean removeLocomotiva(Locomotiva locomotiva){
        for(Locomotiva locomotivaFor : locomotivas)
            if(locomotivaFor.getName().equals(locomotiva.getName())){
                locomotivas.remove(locomotivaFor);
                locomotivaFor.using(false);
                return true;
            }
    return false;
    }

    public boolean removeVagao(Vagao vagao){
        for(Vagao vagaoFor : vagoes)
            if(vagaoFor.getName().equals(vagao.getName())){
                vagoes.remove(vagaoFor);
                vagaoFor.using(false);
                return true;
            }
    return false;
    }

    public int qntLocomotivas(){
        return locomotivas.size();
    }
    
    public String toString(){
        String linha = "Trem composto por: ";
        
        for(Locomotiva locomotiva : locomotivas)
            linha += "\n" + locomotiva.toString();

        for(Vagao vagao : vagoes)
            linha += "\n" + vagao.toString();

    return linha;
    }
}