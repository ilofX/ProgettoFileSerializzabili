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
package Control;

import Constants.Accessori;
import Model.Accessorio;
import Model.Auto;
import Model.Concessionaria;
import View.MainFrame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Stella Filippo
 * @version 0.01
 */
public class ListenerAggiuntaAuto implements ActionListener, MouseListener {

    private final MainFrame mf;
    private final Concessionaria cn;
    private final Accessori a;
    private static Integer maxPrezzo=-1;

    public ListenerAggiuntaAuto(MainFrame mf, Concessionaria cn, Accessori a) {
        this.mf = mf;
        this.cn = cn;
        this.a = a;
        this.mf.setActionAggiungiButton(this,this);
    }
    
    public static Integer getMaxPrezzo(){
        return ListenerAggiuntaAuto.maxPrezzo;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.mf.getjRadioButton1()){
            this.mf.getjComboBox1().setEnabled(false);
            this.mf.getjComboBox2().setEnabled(false);
        }
        else if(e.getSource()==this.mf.getjRadioButton2()){
            this.mf.getjComboBox1().setEnabled(true);
            this.mf.getjComboBox2().setEnabled(true);
        }
        else if(e.getSource()==this.mf.getjButton2()){
            if(!((DefaultListModel<String>)this.mf.getjList1().getModel()).contains((String)this.mf.getjComboBox3().getSelectedItem())){
                ((DefaultListModel<String>)this.mf.getjList1().getModel()).addElement((String)this.mf.getjComboBox3().getSelectedItem());
            }
            else{
                System.err.println("Accessorio già presente");
            }
        }
        else if(e.getSource()==this.mf.getjButton4()){
            Auto temp=null;
            if(this.mf.getjRadioButton2().isSelected()){
                temp= new Auto(this.mf.getjTextField1().getText(), this.mf.getjTextField4().getText(), (String)this.mf.getjComboBox10().getSelectedItem(), (ImageIcon)this.mf.getjLabel12().getIcon(), Integer.parseInt(this.mf.getjTextField6().getText()), Integer.parseInt(this.mf.getjTextField3().getText()) , (String)this.mf.getjComboBox1().getSelectedItem(), Integer.parseInt((String)this.mf.getjComboBox2().getSelectedItem()));
            }
            else{
                temp= new Auto(this.mf.getjTextField1().getText(), this.mf.getjTextField4().getText(), (String)this.mf.getjComboBox10().getSelectedItem(), (ImageIcon)this.mf.getjLabel12().getIcon(), Integer.parseInt(this.mf.getjTextField6().getText()), Integer.parseInt(this.mf.getjTextField3().getText()));
            }
            for(int i=0;i<this.mf.getjList1().getModel().getSize();i++){
                String s = this.mf.getjList1().getModel().getElementAt(i);
                Accessorio acc= new Accessorio(s, ""+this.a.getPrezzo(s));
                temp.aggiungiAccessorio(acc);
            }
            if(Integer.parseInt(this.mf.getjTextField3().getText())>ListenerAggiuntaAuto.maxPrezzo){
                ListenerAggiuntaAuto.maxPrezzo=Integer.parseInt(this.mf.getjTextField3().getText());
            }
            try {
                this.cn.aggiungiAuto(temp, false);
            } catch (IOException ex) {
                Logger.getLogger(ListenerAggiuntaAuto.class.getName()).log(Level.SEVERE, null, ex);
                this.mf.getjLabel9().setText("Errore durante l'aggiunta dell'automobile");
                return;
            }
            this.mf.getjLabel9().setText("Automobile aggiunta al parco auto");
            
        }         
        else{
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==this.mf.getjTextField5()){
            FileNameExtensionFilter def = new FileNameExtensionFilter("Images", "jpg,jpeg,png");
            JFileChooser chooser = new JFileChooser();
            chooser.addChoosableFileFilter(def);
            chooser.setFileFilter(def);
            int n = chooser.showOpenDialog(this.mf);
            if(n==JFileChooser.APPROVE_OPTION){
                File f = chooser.getSelectedFile();
                ImageIcon temp = new ImageIcon(f.getAbsolutePath());
                double d = 300D / Math.max(temp.getIconWidth(), temp.getIconHeight());
                int width = (int)Math.round(temp.getIconWidth() * d);
                int heigth = (int)Math.round(temp.getIconHeight() *d);
                Image img1 = temp.getImage();
                BufferedImage img2 = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_BGR);
                Graphics g = img2.getGraphics();
                g.drawImage(img1, 0, 0, width, heigth, null);
                ImageIcon finale = new ImageIcon(img2);
                this.mf.getjLabel12().setText("");
                this.mf.getjLabel12().setIcon(finale);
                this.mf.getjTextField5().setText(f.getAbsolutePath());
            }
        }
        else{
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
