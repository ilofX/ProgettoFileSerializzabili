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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author Alunno
 */
public class FocusListenerLogin implements FocusListener{

    private LoginPanel loginPanel;

    public FocusListenerLogin(LoginPanel login) {
        this.loginPanel = login;
        this.loginPanel.setFocusTextArea(this);
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
    
}
