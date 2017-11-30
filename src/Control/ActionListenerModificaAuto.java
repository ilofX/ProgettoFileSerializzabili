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
package Control;

import Constants.Accessori;
import Constants.Utenti;
import Model.Accessorio;
import Model.Auto;
import Model.FileManager;
import Model.Filters;
import View.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Stella Filippo
 * @version 0.01
 */
public class ActionListenerModificaAuto implements ActionListener, ListSelectionListener {
    
    private final Accessori a;
    private final Utenti u;
    private final MainFrame mf;
    private final FileManager fm;
    private final Filters f;

    public ActionListenerModificaAuto(Accessori a, Utenti u, MainFrame mf, FileManager fm, Filters f) {
        this.a = a;
        this.u = u;
        this.mf = mf;
        this.fm = fm;
        this.f = f;
        this.mf.setActionModificaAuto(this, this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.mf.getjButton3()){
            if(!((DefaultListModel<String>)this.mf.getjList3().getModel()).contains((String)this.mf.getjComboBox4().getSelectedItem())){
                ((DefaultListModel<String>)this.mf.getjList3().getModel()).addElement((String)this.mf.getjComboBox4().getSelectedItem());
            }
            else{
                System.err.println("Accessorio già presente");
            }
        }
        else if(e.getSource()==this.mf.getjButton5()){
            Auto temp = this.fm.getAuto(this.u.getLoggedUser(), this.mf.getjList2().getSelectedIndex());
            for(int i=0;i<this.mf.getjList3().getModel().getSize();i++){
                String s = this.mf.getjList3().getModel().getElementAt(i);
                Accessorio acc= new Accessorio(s, ""+this.a.getPrezzo(s));
                temp.aggiungiAccessorio(acc);
            }
            try {
                this.fm.edit(this.u.getLoggedUser(), this.mf.getjList2().getSelectedIndex(), temp);
            } catch (IOException ex) {
                Logger.getLogger(ActionListenerModificaAuto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getSource()==this.mf.getjList2()){
            if(this.mf.getjList2().getSelectedIndex()>-1){
                this.mf.getjComboBox4().setEnabled(true);
                this.mf.getjButton3().setEnabled(true);
                try {
                    this.mf.getjList3().setModel(this.f.convertiInListaAccessori(this.fm.getAccessori(this.u.getLoggedUser(), this.mf.getjList2().getSelectedIndex())));
                } catch (IOException ex) {
                    Logger.getLogger(ActionListenerModificaAuto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                this.mf.getjComboBox4().setEnabled(false);
                this.mf.getjButton3().setEnabled(false);
            }
        }
        else{
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
}
