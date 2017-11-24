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
package Constants;

import java.util.ArrayList;

/**
 *
 * @author Filippo Stella
 * @version 0.01
 */
public class Utenti {
    
    private final ArrayList<String> user = new ArrayList<>(); 
    private final ArrayList<String> psw = new ArrayList<>();

    public Utenti() {
        this.user.add("Treviso");
        this.user.add("Oderzo");
        this.user.add("Vittorio");
        this.user.add("Mogliano");
        this.user.add("Ospite");
 
        this.psw.add("340ea3e1272e7bde6f7501f1f81bac3515b074f246e44a3bc252bae31a3b852b");
        this.psw.add("1f668f49a726c5e1ae98bcc0db26c10ebb60500c0698428fc0c17e17efaa52des"); 
        this.psw.add("138b84e874d8716c5156e40a8b2d1114db6d2bcc9301c537c850f674cde29a77");
        this.psw.add("f55594d3293b631bceeb0a058cf0adad2e5d863ec816fb4673f57a4871bc4817");
    }
    
    public boolean isValid(String user,String pasw){
        boolean ris=false;
        int pos=-1;
        if(this.user.contains(user)){
            pos=this.user.indexOf(user);
        }
        if(pos<5 && pos>-1){
            if(this.psw.get(pos).contains(pasw)){
                ris=true;
            }
        }
        return ris;
    }
    
}
