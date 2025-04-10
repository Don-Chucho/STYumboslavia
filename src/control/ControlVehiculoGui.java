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
import modelo.Vehiculo;
import vista.*;


/**
 *
 * @author UNIVALLE
 */
public class ControlVehiculoGui implements ActionListener{

    private VistaVehiculo vistaVehic;
    private VistaPropietario vistaProp;
    private Vehiculo vehiculo;
    private List<Vehiculo> listadoAutos= new ArrayList<>();
    
    public ControlVehiculoGui(List<Vehiculo> listaAuts){
        
        this.vistaVehic= new VistaVehiculo();
        this.vistaVehic.setVisible(true);
        this.vistaVehic.jbtn_aceptar.addActionListener(this);
        this.listadoAutos= listaAuts;
        
    }
    
    public Vehiculo getVehiculo(){
        return this.vehiculo;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Boton Ingresar Vehiculo
        if(e.getSource() == this.vistaVehic.jbtn_aceptar){
            
            this.vehiculo= new Vehiculo();
            String placa=this.vistaVehic.jtf_placa.getText();
            
            if(placa.matches("^[A-Z]{3}[0-9]{3}$")){
                this.vehiculo.setPlaca(placa);                                
            }else{
                JOptionPane.showMessageDialog(vistaVehic, "Formato de placa\nNo válido\n ABC123");
            }
            
            this.vehiculo.setMarca(this.vistaVehic.jtf_marca.getText());            
            
            try{
                String anhoFab= this.vistaVehic.jtf_anhoFab.getText();
                
                if(anhoFab.matches("^[0-9]{4}$")){
                    this.vehiculo.setAnhoFab(Integer.parseInt(anhoFab));                
                }else{
                    JOptionPane.showMessageDialog(vistaVehic, "Formato de año\nNo válido\nIngese 4 dígitos\nYYYY");
                }                
                
            }catch(NumberFormatException exc){
                JOptionPane.showMessageDialog(vistaVehic, "Debe ingresar el año en números");
            }
            if(this.vehiculo.getPlaca()!=null && this.vehiculo.getAnhoFab()!= 0)
                this.listadoAutos.add(vehiculo);
        }
    }
    
}
