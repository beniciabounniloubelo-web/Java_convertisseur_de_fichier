package rootfolder;

import java.io.DataOutputStream; 
import java.io.IOException;      
import java.util.Map;           
import java.util.TreeMap;

public class TabCanoWriter{
    public void ecrireTableCanonique(DataOutputStream dos, Map<Integer, String> tableCano) throws IOException{     
        int i = 0;

        for (Map.Entry<Integer, String> entree : tableCano.entrySet()) { //a faire pour chaque couleur!!
        // ecris des 0 pour toutes les cles manquantes avant la cle actuelle
        while (i < entree.getKey()) {
            dos.writeByte(0);
            i++;
        }
        // ecris la longeur du code actuel
        dos.writeByte(entree.getValue().length());
        i++;
        }
        // eventuellement, complete si la Map n'a pas toutes les cles
        while (i < 256) {
            dos.writeByte(0);
            i++;
        }
    }
}