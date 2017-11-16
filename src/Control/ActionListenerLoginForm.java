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
import View.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Alunno
 */
public class ActionListenerLoginForm implements ActionListener{

    private LoginPanel loginPanel;
    private MainFrame mf;

    public ActionListenerLoginForm(LoginPanel login, MainFrame mf) {
        this.loginPanel = login;
        this.mf = mf;
        this.loginPanel.setActionButton(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.loginPanel.getjButton1()){
            //LOGIN
            this.loginPanel.getjLabel3().setVisible(true);
            
            this.loginPanel.dispose();
            this.mf.setVisible(true);
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
