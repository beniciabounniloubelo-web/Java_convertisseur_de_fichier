import java.util.Map;
import java.util.TreeMap;

public class Tab{

    private Map<Integer, Integer> tab; 
    //TreeMap fait un tri automatique des cles + pas de cle null possible

    public Tab(Map <Integer, Integer> tab){
        this.tab = tab;
    }

    /*
    public void setTab(Map<Integer, Integer> tab){
        this.tab=tab;
    }
    */

    public Map<Integer, Integer> getTab() {
        return tab;
    }
}