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

import Model.Concessionaria;
import View.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Filippo Stella
 * @version 0.01
 */
public class ListenerFiltriStampa implements ActionListener{
    
    private MainFrame mf;
    private Concessionaria c;

    public ListenerFiltriStampa(MainFrame mf, Concessionaria c) {
        this.mf = mf;
        this.c = c;
        this.mf.setActionStampa(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.mf.getFiltroNuovo()){
        
        }
        else if(e.getSource()==this.mf.getFiltroUsato()){
        
        }
        else if(e.getSource()==this.mf.getFiltroAlimentazione()){
            if(this.mf.getFiltroAlimentazione().isSelected()){
                this.mf.getjComboBox7().setEnabled(true);
            }
            else{
                this.mf.getjComboBox7().setEnabled(false);
            }
        }
        else if(e.getSource()==this.mf.getFiltroAnno()){
        
        }
        else if(e.getSource()==this.mf.getFiltroMese()){
        
        }
        else if(e.getSource()==this.mf.getFiltroPrezzo()){
        
        }
        else{
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
}
