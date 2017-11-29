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

import View.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Stella Filippo
 * @version 0.01
 */
public class ActionListenerMainMenu implements ActionListener{

    private final MainFrame mf;

    public ActionListenerMainMenu(MainFrame mf) {
        this.mf = mf;
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
