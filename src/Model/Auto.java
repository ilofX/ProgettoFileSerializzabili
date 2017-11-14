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
    
    private final String marca,tipo,alimentazione;
    private final ArrayList<Accessorio> accessori;
    private final ImageIcon image;
    private final Integer cilindrata,mese,anno;
    private final boolean usato;

    public Auto(String marca, String tipo, String alimentazione, ImageIcon image, Integer cilindrata) {
        this.marca = marca;
        this.tipo = tipo;
        this.alimentazione = alimentazione;
        this.image = image;
        this.cilindrata = cilindrata;
        this.accessori = new ArrayList<>();
        this.usato=false;
        this.mese=-1;
        this.anno=-1;
    }

    public Auto(String marca, String tipo, String alimentazione, ImageIcon image, Integer cilindrata, Integer mese, Integer anno) {
        this.marca = marca;
        this.tipo = tipo;
        this.alimentazione = alimentazione;
        this.image = image;
        this.cilindrata = cilindrata;
        this.mese = mese;
        this.anno = anno;
        this.accessori=new ArrayList<>();
        this.usato=true;
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
    public DefaultTableModel getAccessori(){
        DefaultTableModel tableModel = new DefaultTableModel(new String[] {"Accessorio","Prezzo"}, 0);
        Iterator<Accessorio> i=this.accessori.iterator();
        while(i.hasNext()){
            Accessorio a = i.next();
            tableModel.addRow(new String[] {a.getAccessorio(),a.getPrezzo()});
        }
        return tableModel;
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
        if (this.usato != other.usato) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.alimentazione, other.alimentazione)) {
            return false;
        }
        if (!Objects.equals(this.accessori, other.accessori)) {
            return false;
        }
        if (!Objects.equals(this.cilindrata, other.cilindrata)) {
            return false;
        }
        if (!Objects.equals(this.mese, other.mese)) {
            return false;
        }
        if (!Objects.equals(this.anno, other.anno)) {
            return false;
        }
        return true;
    }

}
