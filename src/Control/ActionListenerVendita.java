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
import View.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stella Filippo
 * @version 0.01
 */
public class ActionListenerVendita implements ActionListener{

    private final MainFrame mf;
    private final FileManager fm;
    private final Utenti u;

    public ActionListenerVendita(MainFrame mf, FileManager fm, Utenti u) {
        this.mf = mf;
        this.fm = fm;
        this.u = u;
        this.mf.setActionVendita(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.mf.getjButton1()){
            if(this.mf.getLista_Vendita().getSelectedIndex()>=0){
                try {
                    this.fm.move(this.u.getLoggedUser(), this.mf.getLista_Vendita().getSelectedIndex());
                    this.mf.getjLabel9().setText("Auto venduta con successo");
                    this.mf.clearLogger();
                } catch (IOException ex) {
                    Logger.getLogger(ActionListenerVendita.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                this.mf.getjLabel9().setText("Nessuna auto selezionata");
                this.mf.clearLogger();
            }
        }
        else{
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
}
