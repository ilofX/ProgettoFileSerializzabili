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

import Constants.Utenti;
import View.LoginForm.LoginPanel;
import View.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alunno
 */
public class ActionListenerLoginForm implements ActionListener{

    private LoginPanel loginPanel;
    private MainFrame mf;
    private final Utenti utenti = new Utenti();

    public ActionListenerLoginForm(LoginPanel login, MainFrame mf) {
        this.loginPanel = login;
        this.mf = mf;
        this.loginPanel.setActionButton(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        byte[] hash = null;
        if(e.getSource()==this.loginPanel.getjButton1()){
            try {
                MessageDigest digest= MessageDigest.getInstance("SHA-256");
                hash = digest.digest(this.loginPanel.getjTextField2().getText().getBytes());
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ActionListenerLoginForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            String psw = new String(hash);
            System.out.println(psw);
            if(utenti.isValid(this.loginPanel.getjTextField1().getText(), psw)){
                this.loginPanel.dispose();
                this.mf.setVisible(true);
            }
            else{
                this.loginPanel.getjLabel3().setVisible(true);
            }
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
