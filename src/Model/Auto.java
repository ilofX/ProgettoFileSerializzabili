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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Stella Filippo
 * @version 0.01
 */
public class Auto implements Serializable{
    
    private final String marca,tipo,alimentazione,mese;
    private final ArrayList<Accessorio> accessori;
    private final ImageIcon image;
    private final Integer cilindrata,anno,prezzo;
    private final boolean usato;

    public Auto(String marca, String tipo, String alimentazione, ImageIcon image, Integer cilindrata, Integer prezzo) {
        this.marca = marca;
        this.tipo = tipo;
        this.alimentazione = alimentazione;
        this.image = image;
        this.cilindrata = cilindrata;
        this.accessori = new ArrayList<>();
        this.usato=false;
        this.mese="";
        this.anno=-1;
        this.prezzo = prezzo;
    }

    public Auto(String marca, String tipo, String alimentazione, ImageIcon image, Integer cilindrata, Integer prezzo, String mese, Integer anno) {
        this.marca = marca;
        this.tipo = tipo;
        this.alimentazione = alimentazione;
        this.image = image;
        this.cilindrata = cilindrata;
        this.mese = mese;
        this.anno = anno;
        this.accessori=new ArrayList<>();
        this.usato=true;
        this.prezzo = prezzo;
    }
    
    public boolean aggiungiAccessorio(Accessorio a){
        if(this.accessori.contains(a)){
            return false;
        }
        else{
            this.accessori.add(a);
            return true;
        }
    }
    
    public ImageIcon getImage() {
        return this.image;
    }
    public String getMarca() {
        return this.marca;
    }
    public String getTipo() {
        return this.tipo;
    }
    public String getAlimentazione() {
        return this.alimentazione;
    }
    public Integer getCilindrata() {
        return this.cilindrata;
    }
    public boolean isUsato(){
        return this.usato;
    }
    public String getData(){
        return ""+this.mese+"/"+this.anno;
    }
    public ArrayList<Accessorio> getAccessori() {
        return this.accessori;
    }
    public DefaultTableModel getTabellaAccessori(){
        DefaultTableModel tableModel = new DefaultTableModel(new String[] {"Accessorio","Prezzo"}, 0);
        Iterator<Accessorio> i=this.accessori.iterator();
        while(i.hasNext()){
            Accessorio a = i.next();
            tableModel.addRow(new String[] {a.getAccessorio(),a.getPrezzo()});
        }
        return tableModel;
    }
    public Integer getPrezzo() {
        Integer ris=0;
        ris+=this.prezzo;
        for(Accessorio a : this.accessori){
            ris+=new Double(a.getPrezzo()).intValue();
        }
        return ris;
    }
    public String getMese() {
        return mese;
    }
    public Integer getAnno() {
        return anno;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.marca);
        hash = 41 * hash + Objects.hashCode(this.tipo);
        hash = 41 * hash + Objects.hashCode(this.alimentazione);
        hash = 41 * hash + Objects.hashCode(this.accessori);
        hash = 41 * hash + Objects.hashCode(this.cilindrata);
        hash = 41 * hash + Objects.hashCode(this.mese);
        hash = 41 * hash + Objects.hashCode(this.anno);
        hash = 41 * hash + (this.usato ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Auto other = (Auto) obj;
        if (this.usato != other.isUsato()) {
            return false;
        }
        if (!Objects.equals(this.marca, other.getMarca())) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.getTipo())) {
            return false;
        }
        if (!Objects.equals(this.alimentazione, other.getAlimentazione())) {
            return false;
        }
        if (!Objects.equals(this.accessori, other.getAccessori())) {
            return false;
        }
        if (!Objects.equals(this.cilindrata, other.getCilindrata())) {
            return false;
        }
        if (!Objects.equals(this.getData(), other.getData())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Auto{" + "marca=" + marca + ", tipo=" + tipo + ", alimentazione=" + alimentazione + ", mese=" + mese + ", accessori=" + accessori + ", image=" + image + ", cilindrata=" + cilindrata + ", anno=" + anno + ", prezzo=" + this.getPrezzo() + ", usato=" + usato + '}';
    }

    
    
}
