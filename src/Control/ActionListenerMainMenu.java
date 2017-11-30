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

import Constants.Utenti;
import Model.FileManager;
import Model.Filters;
import View.MainFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stella Filippo
 * @version 0.01
 */
public class ActionListenerMainMenu implements ActionListener{

    private final MainFrame mf;
    private final FileManager fm;
    private final Utenti u;

    public ActionListenerMainMenu(MainFrame mf, Utenti u, FileManager fm) {
        this.mf = mf;
        this.fm = fm;
        this.u = u;
        this.mf.setActionMenuButton(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.mf.getMButton_Aggiungi()){
            this.mf.getStampa().setVisible(false);
            this.mf.getAggiunta().setVisible(true);
            this.mf.getModifica().setVisible(false);
            this.mf.getVendita().setVisible(false);
            this.mf.getWelcome().setVisible(false);
            this.mf.ToggleMenu();
        }
        else if(e.getSource()==this.mf.getMButton_Modifica()){
            try {
                this.mf.getjList2().setModel(Filters.convertiInLista(this.fm.read(u.getLoggedUser(), false)));
            } catch (FileNotFoundException ex){
                this.mf.getjLabel9().setForeground(Color.red);
                this.mf.getjLabel9().setText("File inesistente");
                this.mf.clearLogger();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ActionListenerMainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.mf.getStampa().setVisible(false);
            this.mf.getAggiunta().setVisible(false);
            this.mf.getModifica().setVisible(true);
            this.mf.getVendita().setVisible(false);
            this.mf.getWelcome().setVisible(false);
            this.mf.ToggleMenu();
        }
        else if(e.getSource()==this.mf.getMButton_Nuovi()){
            this.mf.getStampa().setVisible(true);
            this.mf.getAggiunta().setVisible(false);
            this.mf.getModifica().setVisible(false);
            this.mf.getVendita().setVisible(false);
            this.mf.getWelcome().setVisible(false);
            this.mf.ToggleMenu();
        }
        else if(e.getSource()==this.mf.getMButton_Vendita()){
            try {
                this.mf.getLista_Vendita().setModel(Filters.convertiInLista(this.fm.read(u.getLoggedUser(), false)));
            } catch (FileNotFoundException ex){
                this.mf.getjLabel9().setForeground(Color.red);
                this.mf.getjLabel9().setText("File inesistente");
                this.mf.clearLogger();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ActionListenerMainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.mf.getStampa().setVisible(false);
            this.mf.getAggiunta().setVisible(false);
            this.mf.getModifica().setVisible(false);
            this.mf.getVendita().setVisible(true);
            this.mf.getWelcome().setVisible(false);
            this.mf.ToggleMenu();
        }
        else{
            throw new UnsupportedOperationException("Not supported yet.");
        }   
    }
    
}
