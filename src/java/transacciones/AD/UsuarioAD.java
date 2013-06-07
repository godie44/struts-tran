/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transacciones.AD;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import transacciones.model.Tarjetas;
import transacciones.model.Usuario;

/**
 *
 * @author Diego
 */
public class UsuarioAD implements UsuarioInterfazAD{

    Transaction transaccion;
    Session sesion;
    
    @Override
    public boolean VerificaUsuario(Usuario _usuario) {
        try
        {
            sesion = hibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transac = sesion.beginTransaction();
            
            Usuario tmp = new Usuario();
            if(!sesion.createQuery("from Usuario where cedula ='"+_usuario.getCedula()+"' and password ='"+_usuario.getPassword()+"'").list().isEmpty())
            //tmp = (Usuario)sesion.createQuery("from Usuario where cedula ='"+_usuario.getCedula()+"' and password ='"+_usuario.getPassword()+"'").list().get(0);
            {return true;}
            else{return false;}
        }
        catch(Exception ex)
        {
            String exc = ex.toString();
            return false;
            
        }
    }
    
    @Override
    public ArrayList<Tarjetas> ListaTarjetas(String _usuario)
    {
        try{
            Session sesionl;
            Transaction transac;
            sesionl = hibernateUtil.getSessionFactory().getCurrentSession();
            transac = sesionl.beginTransaction();
            
            return (ArrayList<Tarjetas>)sesionl.createQuery("from Tarjetas where cedula = '"+_usuario+"'").list();
            }
        catch(Exception ex){return null;}
    }

    @Override
    public ArrayList<Usuario> ListaUsuarios() {
        try
        {
            Session sesionl;
            Transaction transac;
            sesionl = hibernateUtil.getSessionFactory().getCurrentSession();
            transac = sesionl.beginTransaction();
            
            return (ArrayList<Usuario>)sesionl.createQuery("from Usuario").list();
        }
        catch(Exception ex){return null;}
    }

    @Override
    public boolean Agregar(Usuario _usuario) {
        try
        {
            sesion = hibernateUtil.getSessionFactory().getCurrentSession();
            transaccion = sesion.beginTransaction();
            sesion.save(_usuario);
            transaccion.commit();
            return true;
        }
        catch(Exception ex){return false;}
    }

    

    
    
    
}
