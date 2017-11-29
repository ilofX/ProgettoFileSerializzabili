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

/**
 *
 * @author Stella Filippo
 * @version 0.01
 */
public class Filters {
    
    public static ArrayList<String> filtraPerPrezzo(ArrayList<String> lista,Integer start,Integer end){
        ArrayList<String> ris = new ArrayList<>();
        Iterator i = lista.iterator();
        while(i.hasNext()){
            Auto a = (Auto)i.next();
            if(a.getPrezzo()>=start && a.getPrezzo()<=end){
                ris.add(a.toString());
            }
        }
        return ris;
    }
    
    public static ArrayList<String> filtraPerAlimentazione(ArrayList<String> lista,String alimentazione){
        ArrayList<String> ris = new ArrayList<>();
        Iterator i = lista.iterator();
        while(i.hasNext()){
            Auto a = (Auto)i.next();
            if(a.getAlimentazione().equals(alimentazione)){
                ris.add(a.toString());
            }
        }
        return ris;
    }
    
    public static ArrayList<String> filtraPerAnnoProduzione(ArrayList<String> lista,Integer anno){
        ArrayList<String> ris = new ArrayList<>();
        Iterator i = lista.iterator();
        while(i.hasNext()){
            Auto a = (Auto)i.next();
            if(a.getAnno().equals(anno)){
                ris.add(a.toString());
            }
        }
        return ris;
    }
    
    public static ArrayList<String> filtraPerMeseProduzione(ArrayList<String> lista, String mese){
        ArrayList<String> ris = new ArrayList<>();
        Iterator i = lista.iterator();
        while(i.hasNext()){
            Auto a = (Auto)i.next();
            if(a.getMese().equals(mese)){
                ris.add(a.toString());
            }
        }
        return ris;
    }
        
}
