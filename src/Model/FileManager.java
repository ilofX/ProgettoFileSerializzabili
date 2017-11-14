package Model;

import Model.EditedClasses.AppendObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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
public class FileManager {
    
    private final File Treviso,Oderzo,Vittorio,Mogliano;
    private final File Treviso_Vendute,Oderzo_Vendute,Vittorio_Vendute,Mogliano_Vendute;
    private FileInputStream inFile;
    private FileOutputStream outFile;
    private ObjectInputStream inObject;
    private ObjectOutputStream outObject;

    public FileManager() throws IOException { 
        File folder = new File("Resources");
        if(!folder.exists()) {
            folder.createNewFile();
        }
        
        this.Treviso = new File("Resources/Treviso.dat");
        this.Oderzo = new File("Resources/Oderzo.dat");
        this.Vittorio = new File("Resources/Vittorio.dat");
        this.Mogliano = new File("Resources/Mogliano.dat");
        
        this.Treviso_Vendute = new File("Resources/Treviso_Vendute.dat");
        this.Oderzo_Vendute = new File("Resources/Oderzo_Vendute.dat");
        this.Vittorio_Vendute = new File("Resources/Vittorio_Vendute.dat");
        this.Mogliano_Vendute = new File("Resources/Mogliano_Vendute.dat");
    }
    
    public void write(String file,boolean vendute,Auto auto) throws FileNotFoundException, IOException{
        if(vendute){
            switch(file){
                case "Treviso":
                    if(this.Treviso_Vendute.exists()){
                        this.outFile = new FileOutputStream(this.Treviso_Vendute,true);
                        this.outObject = new AppendObjectOutputStream(this.outFile);
                    }                    
                    else{
                        this.outFile = new FileOutputStream(this.Treviso_Vendute);
                        this.outObject = new ObjectOutputStream(this.outFile);
                    }
                    break;
                case "Oderzo":
                    if(this.Oderzo_Vendute.exists()){
                        this.outFile = new FileOutputStream(this.Oderzo_Vendute,true);
                        this.outObject = new AppendObjectOutputStream(this.outFile);
                    }                    
                    else{
                        this.outFile = new FileOutputStream(this.Oderzo_Vendute);
                        this.outObject = new ObjectOutputStream(this.outFile);
                    }
                    break;
                case "Vittorio":
                    if(this.Vittorio_Vendute.exists()){
                        this.outFile = new FileOutputStream(this.Vittorio_Vendute,true);
                        this.outObject = new AppendObjectOutputStream(this.outFile);
                    }                    
                    else{
                        this.outFile = new FileOutputStream(this.Vittorio_Vendute);
                        this.outObject = new ObjectOutputStream(this.outFile);
                    }
                    break;
                case "Mogliano":
                    if(this.Mogliano_Vendute.exists()){
                        this.outFile = new FileOutputStream(this.Mogliano_Vendute,true);
                        this.outObject = new AppendObjectOutputStream(this.outFile);
                    }                    
                    else{
                        this.outFile = new FileOutputStream(this.Mogliano_Vendute);
                        this.outObject = new ObjectOutputStream(this.outFile);
                    }
                    break;
                default:
                    throw new IllegalStateException("Filiale non trovata");           
            }
        }
        else{
            switch(file){
                case "Treviso":
                    if(this.Treviso.exists()){
                        this.outFile = new FileOutputStream(this.Treviso,true);
                        this.outObject = new AppendObjectOutputStream(this.outFile);
                    }                    
                    else{
                        this.outFile = new FileOutputStream(this.Treviso);
                        this.outObject = new ObjectOutputStream(this.outFile);
                    }
                    break;
                case "Oderzo":
                    if(this.Oderzo.exists()){
                        this.outFile = new FileOutputStream(this.Oderzo,true);
                        this.outObject = new AppendObjectOutputStream(this.outFile);
                    }                    
                    else{
                        this.outFile = new FileOutputStream(this.Oderzo);
                        this.outObject = new ObjectOutputStream(this.outFile);
                    }
                    break;
                case "Vittorio":
                    if(this.Vittorio.exists()){
                        this.outFile = new FileOutputStream(this.Vittorio,true);
                        this.outObject = new AppendObjectOutputStream(this.outFile);
                    }                    
                    else{
                        this.outFile = new FileOutputStream(this.Vittorio);
                        this.outObject = new ObjectOutputStream(this.outFile);
                    }
                    break;
                case "Mogliano":
                    if(this.Mogliano.exists()){
                        this.outFile = new FileOutputStream(this.Mogliano,true);
                        this.outObject = new AppendObjectOutputStream(this.outFile);
                    }                    
                    else{
                        this.outFile = new FileOutputStream(this.Mogliano);
                        this.outObject = new ObjectOutputStream(this.outFile);
                    }
                    break;
                default:
                    throw new IllegalStateException("Filiale non trovata");           
            }
        }
        this.outObject.writeObject(auto);
    }

    public ArrayList<Auto> read(String file,boolean vendute) throws FileNotFoundException, ClassNotFoundException{
        ArrayList<Auto> ris = new ArrayList<>();
        if(vendute){
            switch(file){
                case "Treviso":
                    if(this.Treviso_Vendute.exists()){
                        this.inFile = new FileInputStream(this.Treviso_Vendute);
                    }                    
                    else{
                        throw new FileNotFoundException("The file is not present on the HDD");
                    }
                    break;
                case "Oderzo":
                    if(this.Oderzo_Vendute.exists()){
                        this.inFile = new FileInputStream(this.Oderzo_Vendute);
                    }                    
                    else{
                        throw new FileNotFoundException("The file is not present on the HDD");
                    }
                    break;
                case "Vittorio":
                    if(this.Vittorio_Vendute.exists()){
                        this.inFile = new FileInputStream(this.Vittorio_Vendute);
                    }                    
                    else{
                        throw new FileNotFoundException("The file is not present on the HDD");
                    }
                    break;
                case "Mogliano":
                    if(this.Mogliano_Vendute.exists()){
                        this.inFile = new FileInputStream(this.Mogliano_Vendute);
                    }                    
                    else{
                        throw new FileNotFoundException("The file is not present on the HDD");
                    }
                    break;
                default:
                    throw new IllegalStateException("Filiale non trovata");           
            }
        }
        else{
            switch(file){
                case "Treviso":
                    if(this.Treviso.exists()){
                        this.inFile = new FileInputStream(this.Treviso);
                    }                    
                    else{
                        throw new FileNotFoundException("The file is not present on the HDD");
                    }
                    break;
                case "Oderzo":
                    if(this.Oderzo.exists()){
                        this.inFile = new FileInputStream(this.Oderzo);
                    }                    
                    else{
                        throw new FileNotFoundException("The file is not present on the HDD");
                    }
                    break;
                case "Vittorio":
                    if(this.Vittorio.exists()){
                        this.inFile = new FileInputStream(this.Vittorio);
                    }                    
                    else{
                        throw new FileNotFoundException("The file is not present on the HDD");
                    }
                    break;
                case "Mogliano":
                    if(this.Mogliano.exists()){
                        this.inFile = new FileInputStream(this.Mogliano);
                    }                    
                    else{
                        throw new FileNotFoundException("The file is not present on the HDD");
                    }
                    break;
                default:
                    throw new IllegalStateException("Filiale non trovata");           
            }
        }
        try {
            this.inObject = new ObjectInputStream(this.inFile);
        } catch (IOException ex) {
            throw new FileNotFoundException("Unable to open file");
        }
        while(true){
            try {
                Auto a = (Auto) this.inObject.readObject();
                ris.add(a);
            } catch (IOException ex) {
                break;
            }
        }
        return ris;
    }
    
    
}
