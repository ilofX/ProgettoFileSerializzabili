
import Control.FocusListenerLogin;
import View.LoginForm.LoginPanel;
import javax.swing.JFrame;

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
        JFrame dial = new JFrame();
        dial.setContentPane(new LoginPanel());
        dial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dial.setUndecorated(true);
        dial.pack();
        dial.setLocationRelativeTo(null);
        //((JPanel)dial.getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5));
        dial.setVisible(true);
        
        
        FocusListenerLogin fll = new FocusListenerLogin((LoginPanel)dial.getContentPane());
    }
    
}