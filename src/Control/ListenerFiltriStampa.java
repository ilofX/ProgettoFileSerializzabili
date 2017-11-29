/*
 * Copyright 2017 Filippo Stella.
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
package Control;

import Constants.Utenti;
import Model.Auto;
import Model.Concessionaria;
import Model.FileManager;
import Model.Filters;
import View.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Filippo Stella
 * @version 0.01
 */
public class ListenerFiltriStampa implements ActionListener{
    
    private final MainFrame mf;
    private final Concessionaria c;
    private final Utenti u; 
    private final FileManager fm;
    private final Filters f;

    public ListenerFiltriStampa(MainFrame mf, Concessionaria c, Utenti u, FileManager fm, Filters f) {
        this.mf = mf;
        this.c = c;
        this.u = u;
        this.fm = fm;
        this.f = f;
        this.mf.setActionStampa(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.mf.getFiltroAlimentazione()){
            if(this.mf.getFiltroAlimentazione().isSelected()){
                this.mf.getjComboBox7().setEnabled(true);
            }
            else{
                this.mf.getjComboBox7().setEnabled(false);
            }
        }
        else if(e.getSource()==this.mf.getFiltroAnno()){
            if(this.mf.getFiltroAnno().isSelected()){
                this.mf.getjComboBox8().setEnabled(true);
            }
            else{
                this.mf.getjComboBox8().setEnabled(false);
            }
        }
        else if(e.getSource()==this.mf.getFiltroMese()){
            if(this.mf.getFiltroMese().isSelected()){
                this.mf.getjComboBox9().setEnabled(true);
            }
            else{
                this.mf.getjComboBox9().setEnabled(false);
            }
        }
        else if(e.getSource()==this.mf.getFiltroPrezzo()){
            if(this.mf.getFiltroPrezzo().isSelected()){
                this.mf.getjComboBox5().setEnabled(true);
                this.mf.getjComboBox6().setEnabled(true);
            }
            else{
                this.mf.getjComboBox5().setEnabled(false);
                this.mf.getjComboBox6().setEnabled(false);
            }
        }
        else if(e.getSource()==this.mf.getApplicaFiltro()){
            try {
                //STAMPA DEI RISULTATI
                ArrayList<Auto> ris = this.fm.read(this.u.getLoggedUser(),this.mf.getFiltroUsato().isSelected());
                if(this.mf.getFiltroAlimentazione().isSelected())   ris = this.f.filtraPerAlimentazione(ris, (String)this.mf.getjComboBox7().getSelectedItem());
                if(this.mf.getFiltroPrezzo().isSelected())          ris = this.f.filtraPerPrezzo(ris, Integer.parseInt((String)this.mf.getjComboBox5().getSelectedItem()), Integer.parseInt((String)this.mf.getjComboBox6().getSelectedItem()));
                if(this.mf.getFiltroAnno().isSelected())            ris = this.f.filtraPerAnnoProduzione(ris, Integer.parseInt((String)this.mf.getjComboBox8().getSelectedItem()));
                if(this.mf.getFiltroMese().isSelected())            ris = this.f.filtraPerMeseProduzione(ris, (String)this.mf.getjComboBox9().getSelectedItem());
                this.mf.getLista_Stampa().setModel(this.f.convertiInLista(ris));
            } catch (FileNotFoundException | ClassNotFoundException ex) {
                Logger.getLogger(ListenerFiltriStampa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
}
