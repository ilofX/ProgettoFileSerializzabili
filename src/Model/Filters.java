/*
 * Copyright 2017 Stella Filippo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package Model;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;

/**
 *
 * @author Stella Filippo
 * @version 0.01
 */
public class Filters {
    
    public static ArrayList<Auto> filtraPerStato(ArrayList<Auto> lista, boolean usato){
        ArrayList<Auto> ris = new ArrayList<>();
        for (Auto a : lista) {
            if(usato){
                if(a.isUsato()){
                    ris.add(a);
                }
            }
            else{
                if(!a.isUsato()){
                    ris.add(a);
                }
            }
        }
        return ris;
    }
    
    public static ArrayList<Auto> filtraPerPrezzo(ArrayList<Auto> lista,Integer start,Integer end){
        ArrayList<Auto> ris = new ArrayList<>();
        for (Auto a : lista) {
            if(a.getPrezzo()>=start && a.getPrezzo()<=end){
                ris.add(a);
            }
        }
        return ris;
    }
    
    public static ArrayList<Auto> filtraPerAlimentazione(ArrayList<Auto> lista,String alimentazione){
        ArrayList<Auto> ris = new ArrayList<>();
        for (Auto a : lista) {
            if(a.getAlimentazione().equals(alimentazione)){
                ris.add(a);
            }
        }
        return ris;
    }
    
    public static ArrayList<Auto> filtraPerAnnoProduzione(ArrayList<Auto> lista,Integer anno){
        ArrayList<Auto> ris = new ArrayList<>();
        for (Auto a : lista) {
            if(a.getAnno().equals(anno)){
                ris.add(a);
            }
        }
        return ris;
    }
    
    public static ArrayList<Auto> filtraPerMeseProduzione(ArrayList<Auto> lista, String mese){
        ArrayList<Auto> ris = new ArrayList<>();
        for (Auto a : lista) {
            if(a.getMese().equals(mese)){
                ris.add(a);
            }
        }
        return ris;
    }
        
    public static DefaultListModel<String> convertiInLista(ArrayList<Auto> lista){
        DefaultListModel<String> ris = new DefaultListModel<>();
        Iterator<Auto> i = lista.iterator();
        while(i.hasNext()){
            Auto a = i.next();
            ris.addElement(a.toString());
        }
        if(ris.isEmpty()) {
            ris.addElement("La ricerca non ha prodotto risultati");
        }
        return ris;
    }
    
    public static DefaultListModel<String> convertiInListaAccessori(ArrayList<Accessorio> lista){
        DefaultListModel<String> ris = new DefaultListModel<>();
        Iterator<Accessorio> i = lista.iterator();
        while(i.hasNext()){
            Accessorio a = i.next();
            ris.addElement(a.getAccessorio());
        }
        if(ris.isEmpty()) {
            ris.addElement("La ricerca non ha prodotto risultati");
        }
        return ris;
    }
}
