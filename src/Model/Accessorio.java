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
package Model;

import java.util.Objects;

/**
 *
 * @author Stella Filippo
 * @version 0.01
 */
public class Accessorio {
    private final String accessorio,prezzo;

    public Accessorio(String accessorio, String prezzo) {
        this.accessorio = accessorio;
        this.prezzo = prezzo;
    }

    public String getAccessorio() {
        return accessorio;
    }
    public String getPrezzo() {
        return prezzo;
    }

    @Override
    public String toString() {
        return "Accessorio{" + "accessorio=" + accessorio + ", prezzo=" + prezzo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.accessorio);
        hash = 31 * hash + Objects.hashCode(this.prezzo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Accessorio other = (Accessorio) obj;
        if (!Objects.equals(this.accessorio, other.accessorio)) {
            return false;
        }
        return true;
    }
      
}
