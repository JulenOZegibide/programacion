/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2bd;

import UML.*;
import Ventanas.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MARTA
 */
public class Ejercicio2BD {

    public static Menu vm;
    public static VentanaEventos ve;
    public static Evento oevento;
    public static EventoDAO oeventoDAO;
    public static ArrayList<Evento>listaeventos;
    public static void main(String[] args) {
        vm=new Menu();
        vm.setVisible(true);
    }
    public static void cambioAñadir(){
        vm.setVisible(false);
        
        ve=new VentanaEventos();
        ve.setVisible(true);
    }   
    public static void daralta(String nombre,String lugar,LocalDate fecha,LocalTime fechaini,LocalTime fechafin,int aforomax){
        oevento=new Evento(nombre,lugar,fecha,fechaini,fechafin,aforomax);
        oeventoDAO.daralta(oevento);
        
        listaeventos=new ArrayList<Evento>();
        listaeventos.add(oevento);
    }
    public static void modificarevento(String nombre,String lugar,LocalDate fecha,LocalTime fechaini,LocalTime fechafin,int aforomax){
        oevento=new Evento(nombre,lugar,fecha,fechaini,fechafin,aforomax);
        oeventoDAO.modificarevento(oevento);
    }
    public static void cambio(){
        ve.setVisible(false);
        
        vm=new Menu();
        vm.setVisible(true);        
    }
    public static void cambiomodificar()throws Exception{
        listaeventos = oeventoDAO.listadeeventos();
        if (listaeventos.size()>0) 
        {
            ve = new VentanaEventos(listaeventos.get(0).getNombre(),listaeventos.get(0).getLugar(),listaeventos.get(0).getFecha(),listaeventos.get(0).getFechainicio(),listaeventos.get(0).getFechafin(),listaeventos.get(0).getAforomax);
            ve.setVisible(true);
        }
        else{
            throw new Exception("No hay personas");     
        }
    }   
    public static void salir(){
        System.exit(0);
    }    

    public static void buscarEvento(String nombre) {
        int borrar=JOptionPane.showConfirmDialog(null,"Estas seguro de que quieres borrar este evento");
                if(borrar==1)
        oevento=oeventoDAO.borrarevento(nombre);
    }



}
