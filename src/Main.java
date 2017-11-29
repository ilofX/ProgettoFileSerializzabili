
import Constants.Accessori;
import Constants.Utenti;
import Control.ActionListenerLoginForm;
import Control.ActionListenerMainMenu;
import Control.ListenerAggiuntaAuto;
import Control.ListenerFiltriStampa;
import Model.Concessionaria;
import Model.FileManager;
import Model.Filters;
import View.LoginForm.LoginPanel;
import View.MainFrame;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



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

/**
 *
 * @author Stella Filippo
 * @version 0.01
 */
public class Main {

    public static void main(String[] args) {
        try {
            MainFrame mf = new MainFrame();
            LoginPanel lp = new LoginPanel();
            Accessori a = new Accessori();
            Utenti u = new Utenti();
            FileManager fm = new FileManager();
            Filters f = new Filters();
            Concessionaria c = new Concessionaria(fm, u);
            ActionListenerLoginForm allf = new ActionListenerLoginForm(lp, mf, u);
            ActionListenerMainMenu almm = new ActionListenerMainMenu(mf);
            ListenerAggiuntaAuto laa = new ListenerAggiuntaAuto(mf,c,a);
            ListenerFiltriStampa lfs = new ListenerFiltriStampa(mf, c, u, fm, f);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
