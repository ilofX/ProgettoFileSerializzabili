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
package Model;

import Constants.Utenti;
import java.io.IOException;

/**
 *
 * @author Filippo Stella
 * @version 0.01
 */
public class Concessionaria {
    
    private final FileManager fm;
    private final Utenti u;

    public Concessionaria(FileManager fm, Utenti u) {
        this.fm = fm;
        this.u = u;
    }
    
    public void aggiungiAuto(Auto a, boolean usato) throws IOException{
        this.fm.write(this.u.getLoggedUser(), usato, a);
    }
    

}
