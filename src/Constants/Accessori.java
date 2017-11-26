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
package Constants;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Stella Filippo
 * @version 0.01
 */
public class Accessori {
    
    private final Map<String,Double> accessori;

    public Accessori() {
        this.accessori = new HashMap<>();
        this.accessori.put("Climatizzatore", 150.00);
        this.accessori.put("Navigatore", 200.00);
        this.accessori.put("Radio",80.00);
        this.accessori.put("Cerchi in lega", 180.00);
    }
    
    public Double getPrezzo(String s){
        return accessori.get(s);
    }

}
