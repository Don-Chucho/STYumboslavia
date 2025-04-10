/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import modelo.Propietario;
import vista.VistaPropietario;



/**
 *
 * @author UNIVALLE
 */
public class ControlPropietarioGui implements ActionListener{

    private VistaPropietario vistaProp;
    private Propietario unPropietario;    
    private List<Propietario> listaPropietarios= new ArrayList<>();
    
    public ControlPropietarioGui(List<Propietario> listaPropitars){
        
        this.vistaProp= new VistaPropietario();
        this.vistaProp.setVisible(true);
        this.vistaProp.jbtn_aceptar.addActionListener(this);
        this.listaPropietarios= listaPropitars;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()== this.vistaProp.jbtn_aceptar){
            this.unPropietario= new Propietario();
            
            try{
                this.unPropietario.setDni(Integer.parseInt(this.vistaProp.jtf_dni.getText()));
            }catch(NumberFormatException exc){
                JOptionPane.showMessageDialog(this.vistaProp,"Ingrese Valores Numéricos\nPara el DNI");
            }
            
            this.unPropietario.setNombres(this.vistaProp.jtf_nombres.getText());
            this.unPropietario.setApellidos(this.vistaProp.jtf_apellidos.getText());
            this.unPropietario.setDireccion(this.vistaProp.jtf_direccion.getText());
            
            if(this.unPropietario.getDni()!=0)
                this.listaPropietarios.add(unPropietario);
        }
    }
    
}
