/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transacciones.AD;

import java.util.*;
import transacciones.model.Usuario;
import transacciones.model.Tarjetas;

/**
 *
 * @author Diego
 */
public interface UsuarioInterfazAD {
    public boolean Agregar(Usuario _usuario);
    public boolean VerificaUsuario(Usuario _usuario);
    public List<Usuario> ListaUsuarios();
    public List<Tarjetas> ListaTarjetas(String _usuario);
}
