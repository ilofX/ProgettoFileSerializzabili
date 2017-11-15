/*
 * Copyright 2017 Alunno.
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

import View.LoginForm.LoginPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author Alunno
 */
public class ListenerLoginForm implements FocusListener, ActionListener{

    private LoginPanel loginPanel;

    public ListenerLoginForm(LoginPanel login) {
        this.loginPanel = login;
        this.loginPanel.setFocusTextArea(this);
        this.loginPanel.setActionButton(this);
    }
    
    
    
    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource()==this.loginPanel.getjTextField1()){
            if(this.loginPanel.getjTextField1().getText().equals("Username")){
                this.loginPanel.getjTextField1().setText("");
            }
        }
        else if(e.getSource()==this.loginPanel.getjTextField2()){
            if(this.loginPanel.getjTextField2().getText().equals("Password")){
                this.loginPanel.getjTextField2().setText("");
            }
        }
        else{
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(e.getSource()==this.loginPanel.getjTextField1()){
            if(this.loginPanel.getjTextField1().getText().isEmpty()){
                this.loginPanel.getjTextField1().setText("Username");
            }
        }
        else if(e.getSource()==this.loginPanel.getjTextField2()){
            if(this.loginPanel.getjTextField2().getText().isEmpty()){
                this.loginPanel.getjTextField2().setText("Password");
            }
        }
        else{
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.loginPanel.getjButton1()){
            //LOGIN
            this.loginPanel.getjLabel3().setVisible(true);
        }
        else if(e.getSource()==this.loginPanel.getjButton2()){
            //ANNULLA
            System.exit(0);
        }
        else{
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
}
