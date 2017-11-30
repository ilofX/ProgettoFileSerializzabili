package Model;

import Model.EditedClasses.AppendObjectOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
public class FileManager {
    
    private final File Treviso,Oderzo,Vittorio,Mogliano;
    private final File Treviso_Vendute,Oderzo_Vendute,Vittorio_Vendute,Mogliano_Vendute;
    private FileInputStream inFile;
    private FileOutputStream outFile;
    private ObjectInputStream inObject;
    private ObjectOutputStream outObject;

    public FileManager() throws IOException { 
        File folder = new File("Resources/");
        if(!folder.exists()) {
            folder.mkdir();
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
        this.outFile.close();
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
                if(a!=null) {
                    ris.add(a);
                }
            } catch (IOException ex) {
                break;
            }
        }
        try {
            this.inFile.close();
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ris;
    }
    
    public Auto remove(String file,boolean vendute,Integer index) throws FileNotFoundException, IOException{
        File f;
        if(vendute){
            switch(file){
                case "Treviso":
                    f=this.Treviso_Vendute;
                    this.inFile = new FileInputStream(this.Treviso_Vendute);
                    break;
                case "Oderzo":
                    f=this.Oderzo_Vendute;
                    this.inFile = new FileInputStream(this.Oderzo_Vendute);
                    break;
                case "Vittorio":
                    f=this.Vittorio_Vendute;
                    this.inFile = new FileInputStream(this.Vittorio_Vendute);
                    break;
                case "Mogliano":
                    f=this.Mogliano_Vendute;
                    this.inFile = new FileInputStream(this.Mogliano_Vendute);
                    break;
                default:
                    throw new IllegalStateException("Filiale non trovata");           
            }
        }
        else{
            switch(file){
                case "Treviso":
                    f=this.Treviso;
                    this.inFile = new FileInputStream(this.Treviso);
                    break;
                case "Oderzo":
                    f=this.Oderzo;
                    this.inFile = new FileInputStream(this.Oderzo);
                    break;
                case "Vittorio":
                    f=this.Vittorio;
                    this.inFile = new FileInputStream(this.Vittorio);
                    break;
                case "Mogliano":
                    f=this.Mogliano;
                    this.inFile = new FileInputStream(this.Mogliano);
                    break;
                default:
                    throw new IllegalStateException("Filiale non trovata");           
            }
        }
        this.inObject = new ObjectInputStream(this.inFile);
        File dummy = new File("Resources/dummy.dat");
        boolean first=true;
        int i = 0;
        Auto a,ris=null;
        FileOutputStream outFileDummy; 
        ObjectOutputStream outObjectDummy;
        while(true){
            a = null;
            try {
                a = (Auto)this.inObject.readObject();
            } catch (ClassNotFoundException ex) {
                
            } catch (EOFException ex){
                break;
            } finally {
                if(first){
                    outFileDummy = new FileOutputStream(dummy);
                    outObjectDummy = new ObjectOutputStream(outFileDummy);
                    first=false;
                }
                else{
                    outFileDummy = new FileOutputStream(dummy,true);
                    outObjectDummy = new AppendObjectOutputStream(outFileDummy);
                }
                if(i==index){
                    ris = a;
                }
                else{
                    if(a!=null) {
                        outObjectDummy.writeObject(a);
                    }
                }
                outFileDummy.close();
            }
            i++;
        }
        if(index==0){
            outFileDummy = new FileOutputStream(dummy);
            outObjectDummy = new ObjectOutputStream(outFileDummy);
            first=false;
        }
        this.inFile.close();
        outFileDummy.close();
        f.delete();
        dummy.renameTo(f);
        return ris;
    }
    
    public void move(String file, Integer index) throws FileNotFoundException, IOException{
        Auto a = this.remove(file, false, index);
        this.write(file, true, a);
    }
    
    public void edit(String file, Integer index, Auto nuovo) throws FileNotFoundException, IOException{
        File f;
        switch(file){
            case "Treviso":
                f=this.Treviso;
                this.inFile = new FileInputStream(this.Treviso);
                break;
            case "Oderzo":
                f=this.Oderzo;
                this.inFile = new FileInputStream(this.Oderzo);
                break;
            case "Vittorio":
                f=this.Vittorio;
                this.inFile = new FileInputStream(this.Vittorio);
                break;
            case "Mogliano":
                f=this.Mogliano;
                this.inFile = new FileInputStream(this.Mogliano);
                break;
            default:
                throw new IllegalStateException("Filiale non trovata");           
        }
        this.inObject = new ObjectInputStream(this.inFile);
        File dummy = new File("Resources/dummy.dat");
        boolean first=true;
        int i = 0;
        Auto a;
        FileOutputStream outFileDummy; 
        ObjectOutputStream outObjectDummy;
        while(true){
            a = null;
            try {
                a = (Auto)this.inObject.readObject();
            } catch (ClassNotFoundException ex) {
                
            } catch (EOFException ex){
                break;
            } finally {
                if(first){
                    outFileDummy = new FileOutputStream(dummy);
                    outObjectDummy = new ObjectOutputStream(outFileDummy);
                    first=false;
                }
                else{
                    outFileDummy = new FileOutputStream(dummy,true);
                    outObjectDummy = new AppendObjectOutputStream(outFileDummy);
                }
                if(i==index){
                    outObjectDummy.writeObject(nuovo);
                }
                else{
                    if(a!=null) {
                        outObjectDummy.writeObject(a);
                    }
                }
                outFileDummy.close();
            }
            i++;
        }
        this.inFile.close();
        outFileDummy.close();
        f.delete();
        dummy.renameTo(f);
    }
    
    public ArrayList<Accessorio> getAccessori(String file, Integer index) throws FileNotFoundException, IOException {
        switch(file){
            case "Treviso":
                this.inFile = new FileInputStream(this.Treviso);
                break;
            case "Oderzo":
                this.inFile = new FileInputStream(this.Oderzo);
                break;
            case "Vittorio":
                this.inFile = new FileInputStream(this.Vittorio);
                break;
            case "Mogliano":
                this.inFile = new FileInputStream(this.Mogliano);
                break;
            default:
                throw new IllegalStateException("Filiale non trovata");           
        }
        this.inObject = new ObjectInputStream(this.inFile);
        Auto a;
        int i=0;
        ArrayList<Accessorio> ris = null;
        while(true){
            a = null;
            try {
                a = (Auto)this.inObject.readObject();
            } catch (ClassNotFoundException ex) {
            } catch (EOFException ex){
                break;
            }
            if(i==index){
                ris=a.getAccessori();
            }
            i++;
        }
        this.inFile.close();
        return ris;
    }
    
    public Auto getAuto(String file, Integer index){
        Auto ris=null;
        try {
            ArrayList <Auto> a = this.read(file, false);
            ris = a.get(index);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ris;
    }
}
