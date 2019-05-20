import java.util.ArrayList;
public class CadastroTrem{
    private ArrayList<Trem> tremList;
    private Trem trem;

    public CadastroTrem(){
        tremList = new ArrayList<Trem>();
    }

    public boolean newTrem(Locomotiva locomotiva){
        if(locomotiva.using()==false){
            tremList.add(new Trem(locomotiva));
            return true;
        }

    return false;
    }

    public String toString(){
        String linha = "";
        int i = 0;
        for(Trem trem : tremList){
            linha += "\n\n\nTrem numero: "+ i + "\n"+trem.toString()+"\n";
            i++;
        }
    return linha;
    }

    public String printTrem(int trem){
        String linha = "Trem numero: " + trem;
        linha += "\n" + tremList.get(trem).toString();
    return linha;
    }
    
    public boolean joinLocomotiva(Locomotiva locomotiva, int tremNumber){
        trem = tremList.get(tremNumber);
        if(trem.insertLocomotiva(locomotiva))    
            return true;
    return false;
    }
    
    public boolean joinVagao(Vagao vagao, int tremNumber){
        trem = tremList.get(tremNumber);
        if(trem.insertVagao(vagao))    
            return true;
    return false;
    }

    public int size(){
        return tremList.size();
    }

    public int qtdLocomotivas(int tremNumber){
        trem = tremList.get(tremNumber);
        return trem.qntLocomotivas();
    }

    public boolean removeVagao(Vagao vagao, int tremNumber){
        trem = tremList.get(tremNumber);
        if(trem.removeVagao(vagao))    
            return true;
    return false;
    }

    public boolean removeLocomotiva(Locomotiva locomotiva, int tremNumber){
        trem = tremList.get(tremNumber);
        if(trem.removeLocomotiva(locomotiva))    
            return true;
    return false;
    }
}