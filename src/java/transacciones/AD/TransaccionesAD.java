/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transacciones.AD;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import transacciones.model.Tarjetas;
import transacciones.model.Transacciones;
import transacciones.model.Recibos;
/**
 *
 * @author diego
 */
public class TransaccionesAD {
    
    Transaction transaccion;
    Session sesion;
    
    public boolean Depositar(Transacciones _transaccion, String tarjeta)
    {
        try{
        sesion = hibernateUtil.getSessionFactory().getCurrentSession();
        transaccion = sesion.beginTransaction();  
        Tarjetas t = new Tarjetas();
        t =(Tarjetas)sesion.createQuery("from Tarjetas where numero ='"+tarjeta+"'").list().get(0);
        _transaccion.setTarjetas(t);
        sesion.save(_transaccion);
        transaccion.commit();
          
            return true;
        }
        catch(Exception ex)
        {
            String x ="";
            return false;
        }
    }
    
    
    public String Retirar(Transacciones _transaccion, String _tarjeta)
    {
       
        sesion = hibernateUtil.getSessionFactory().getCurrentSession();
        transaccion = sesion.beginTransaction();  
         try{
        String retorno="";
        Tarjetas t = new Tarjetas();
        t =(Tarjetas)sesion.createQuery("from Tarjetas where numero ='"+_tarjeta+"'").list().get(0);
        _transaccion.setTarjetas(t);
        double saldo = Saldo(_tarjeta);                
        
        if(saldo- _transaccion.getMonto()>= 0){
        
        sesion.save(_transaccion);
        transaccion.commit();
        retorno ="Transaccion realizada con exito.";}
        else{retorno = "Fondos insuficientes.";}
        
        
        return retorno;
        }
        catch(Exception ex)
        {
            String x ="";
            transaccion.rollback();
            return "Error";
        }
    }
    
    public double Saldo(String _tarjeta)
    {
        Tarjetas t = new Tarjetas();
        sesion = hibernateUtil.getSessionFactory().getCurrentSession();
        transaccion = sesion.beginTransaction(); 
        double saldo=0.0;
        try{
        t =(Tarjetas)sesion.createQuery("from Tarjetas where numero ='"+_tarjeta+"'").list().get(0);
        
        String query ="select COALESCE(sum(a.monto),0.0) from Transacciones a where a.tarjetas.numero = '"+_tarjeta+"' and a.tipo='1'";
        
        double deb = Double.valueOf(sesion.createQuery(query).list().get(0).toString());
        query = "select COALESCE(sum(a.monto),0.0) from Transacciones a where a.tarjetas.numero = '"+_tarjeta+"' and a.tipo!='1'";
        double cre = Double.valueOf(sesion.createQuery(query).list().get(0).toString());
        saldo = deb - cre;
        double limite = t.getLimite().doubleValue();
        if(limite>0)
        {
            if(saldo > 0)
            {
                saldo = saldo + limite;
            }else
            {
                saldo = Math.abs(saldo)+ limite*-1;
            }
        }
        }catch(Exception ex)
        {
            String msj ="Error";
        }
        return Math.abs(saldo);
    }
    
    
   public ArrayList<Recibos> ListaRecibos(String _usuario)
   {
       try{
            Session sesionl;
            Transaction transac;
            sesionl = hibernateUtil.getSessionFactory().getCurrentSession();
            transac = sesionl.beginTransaction();
            
            return (ArrayList<Recibos>)sesionl.createQuery("from Recibos where cedula = '"+_usuario+"' and estado='Pendiente'").list();
            }
        catch(Exception ex){return null;}
   }
   
   public ArrayList<Recibos> SeleccionaRecibos(String _usuario, String _tipo)
   {
       try{
            Session sesionl;
            Transaction transac;
            sesionl = hibernateUtil.getSessionFactory().getCurrentSession();
            transac = sesionl.beginTransaction();
            
            return (ArrayList<Recibos>)sesionl.createQuery("from Recibos where cedula = '"+_usuario+"' and tipo ='"+_tipo+"' and estado='Pendiente'").list();
            }
        catch(Exception ex){return null;}
   }
   
   public String PagaRecibo(Transacciones _transaccion,int _id,String _tarjeta)
   {
       sesion = hibernateUtil.getSessionFactory().getCurrentSession();
        transaccion = sesion.beginTransaction();  
         try{
        String retorno="";
        Tarjetas t = new Tarjetas();
        t =(Tarjetas)sesion.createQuery("from Tarjetas where numero ='"+_tarjeta+"'").list().get(0);
        _transaccion.setTarjetas(t);
        double saldo = Saldo(_tarjeta);                
        
        if(saldo- _transaccion.getMonto()>= 0){
        
        sesion.save(_transaccion);
        String hql = "update Recibos set estado = 'Cancelado' where id = "+String.valueOf(_id)+"";
        int query = sesion.createQuery(hql).executeUpdate();
        //int rowCount = query.executeUpdate();
        
        transaccion.commit();
        retorno ="Transaccion realizada con exito.";}
        else{retorno = "Fondos insuficientes.";}
        
        
        return retorno;
        }
        catch(Exception ex)
        {
            String x ="";
            transaccion.rollback();
            return "Error";
        }
   }
    
    
}
