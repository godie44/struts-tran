/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transacciones.controller;

import com.opensymphony.xwork2.ActionContext;
import transacciones.model.Usuario;
import transacciones.model.Tarjetas;
import transacciones.model.Transacciones;
import transacciones.model.Recibos;
import transacciones.AD.UsuarioAD;
import transacciones.AD.TransaccionesAD;
import java.util.Calendar;
//import transacciones.model.ClientesHibernateUtil;
import com.opensymphony.xwork2.ModelDriven;
import java.util.*;

/**
 *
 * @author diego
 */
public class ClientesController implements ModelDriven<Usuario>{
    

 Map sesionVar = ActionContext.getContext().getSession();
 Usuario usuario = new Usuario();  
 Transacciones transac = new Transacciones();
 Tarjetas tarjeta = new Tarjetas();
 Recibos recibo = new Recibos();

 ArrayList<Usuario> listaUsuario = new ArrayList(); 
 ArrayList<Tarjetas> listaTarjetas = new ArrayList();
 ArrayList<Recibos> listaRecibos = new ArrayList();

 TransaccionesAD transaccionesAD;
 UsuarioAD usuarioAd;
 String msj = "";
 String aServ="";
 String tituloServicios="Pago de";
 String tarj = "";
 String tipPago="";

    public void setTipPago(String tipPago) {
        this.tipPago = tipPago;
    }

    public String getTipPago() {
        return tipPago;
    }
 
 public Recibos getRecibo() {
        return recibo;
    }

    public void setRecibo(Recibos recibo) {
        this.recibo = recibo;
    }
    
    public void setListaRecibos(ArrayList<Recibos> listaRecibos) {
        this.listaRecibos = listaRecibos;
    }

    public ArrayList<Recibos> getListaRecibos() {
        return listaRecibos;
    }

 
 
    public String getTituloServicios() {
        return tituloServicios;
    }

    public void setTituloServicios(String tituloServicios) {
        this.tituloServicios = tituloServicios;
    }

    public void setaServ(String aServ) {
        this.aServ = aServ;
    }

public String getaServ() {
        return aServ;}
 
    public String getTarj() {
        return tarj;
    }

    public Tarjetas getTarjeta() {
        return tarjeta;
    }

    public void setTarj(String tarj) {
        this.tarj = tarj;
    }

    public void setTarjeta(Tarjetas tarjeta) {
        this.tarjeta = tarjeta;
    }

    public ClientesController() {
        usuarioAd = new UsuarioAD();
        transaccionesAD = new TransaccionesAD();
    }

    
    public void setTransac(Transacciones transac) {
        this.transac = transac;
    }

    public Transacciones getTransac() {
        return transac;
    }
    
    public void setListaTarjetas(ArrayList<Tarjetas> listaTarjetas) {
        this.listaTarjetas = listaTarjetas;
    }

    public List<Tarjetas> getListaTarjetas() {
        return listaTarjetas;
    }
    
 
 
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
 
    public Usuario getUsuario() {
        return usuario;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public String getMsj() {
        return msj;
    }
 
 
 @Override
    public Usuario getModel() {
        return usuario;
    }
   
    public String Valida()
    {
        if(usuarioAd.VerificaUsuario(usuario))
        {
        sesionVar.put("usuario", usuario.getCedula()); 
        msj = "Bienvenido a su sucursal electronica favorita.";
        return "exito";}
        else{
            msj = "No se encontro un usario con esas credenciales";
            return "error";}
    }
    
    
 
    public String Add(Usuario _cliente)
    {
        try
        {
        if(usuarioAd.Agregar(_cliente))//modificado en comparacion a video
        {msj = "Cliente agregado con exito.";}
        else{msj = "Error al agregar usuario.";}
        }catch(Exception ex)
                {
                    msj="Error al insertar usuario.";
                }
        return "fin";
    
    }
    
    public String ConsultarTipoRecibo()
    {
        try{
        listaRecibos = transaccionesAD.SeleccionaRecibos((String) ActionContext.getContext().getSession().get("usuario"), tipPago);
        }
        catch(Exception e)
        {
            msj = "Error al consultar por las recibos.";
        }
        return "fin";
    }
    
    public String Depositar()
    {
        try
        {
        
         
        Calendar calendar = Calendar.getInstance();
        //transac.setTarjetas(tarjeta);
        transac.setTipo("1");
        transac.setFecha(calendar.getTime());
        if(transaccionesAD.Depositar(transac,tarjeta.getNumero()))//modificado en comparacion a video
        {msj = "Deposito con exito.";}
        else{msj = "Error al depositar.";}
        }catch(Exception ex)
                {
                    msj="Error al depositar.";
                }
        return "fin";
    
    }
    
    
    public String Retirar()
    {
        try
        {
        
         
        Calendar calendar = Calendar.getInstance();
        //transac.setTarjetas(tarjeta);
        transac.setTipo("2");
        transac.setFecha(calendar.getTime());
        msj =transaccionesAD.Retirar(transac,tarjeta.getNumero());
        
        }catch(Exception ex)
                {
                    msj="Error al depositar.";
                }
        return "fin";
    
    }
    
    
    
    public String Pagar()
    {
        try
        {
        
         
        Calendar calendar = Calendar.getInstance();
        //transac.setTarjetas(tarjeta);
        transac.setTipo("3");
        transac.setFecha(calendar.getTime());
        msj =transaccionesAD.PagaRecibo(transac,recibo.getId(),tarjeta.getNumero());
        
        }catch(Exception ex)
                {
                    msj="Error al pagar.";
                }
        return "fin";
    
    }
    
    
    
    
    public String ListaUsuarios()
    {
        //List<Usuario> listClientes=null;
        try
        {
            listaUsuario = usuarioAd.ListaUsuarios();
        }
        catch(Exception e)
        {
            msj = "Error al consultar por los usuarios.";
        }
        return "fin";
    }
    
    public String irSaldos()
    {
        //
        return "fin";
    }
    
    public String ListaTarjetas()
    {
        try
        {
            listaTarjetas = usuarioAd.ListaTarjetas((String) ActionContext.getContext().getSession().get("usuario"));
            for(int i=0; i< listaTarjetas.size();i++)
            {
                listaTarjetas.get(i).setSaldo(transaccionesAD.Saldo(listaTarjetas.get(i).getNumero()));
            }
        }
        catch(Exception e)
        {
            msj = "Error al consultar por las tarjetas.";
        }
        return "fin";
    }
    
    
    public String ListaRecibos()
    {
        try
        {
            listaRecibos = transaccionesAD.ListaRecibos((String) ActionContext.getContext().getSession().get("usuario"));
        }
        catch(Exception e)
        {
            msj = "Error al consultar por las tarjetas.";
        }
        return "fin";
    }
    
    public String execute()
    {
        String tar=ListaTarjetas();
        String rec =ListaRecibos();
        
        switch(aServ)
        {
            case "Agua":
                tituloServicios="Pago Servicios Agua";
                break;
            case "Luz":
                tituloServicios="Pago Servicios Luz";
                break;   
            case "Internet":
                tituloServicios="Pago Servicios Internet";
                break;
            case "Gas":
                tituloServicios="Pago Servicios Gas";
                break;
            case "Telefono":
                tituloServicios="Pago Servicios Telefono";
                break;
            case "Viajes":
                tituloServicios="Pago mensual del Club de Viajes";
                break;   
        }
        
        return "fin";
    }

    
}
