/**
 * 
 */
package cl.scp.commons.delegate;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import cl.procesac.scp.commons.interfaces.AplicacionSCP;
import cl.procesac.scp.commons.interfaces.AplicacionSCPHome;

/**
 * @author David
 *
 */
public class AplicacionDelegate {
	
	public List getSistemasDuenios(int organizacion) throws RemoteException, NamingException, CreateException{
		List sistemasDuenios = null;
		sistemasDuenios = getAplicacion().getSistemasDuenios(organizacion);
		return sistemasDuenios;
	}

	private static AplicacionSCP getAplicacion() throws NamingException, RemoteException, CreateException {
		InitialContext context = new InitialContext();
		Object object = context.lookup(AplicacionSCPHome.JNDI_NAME);
		AplicacionSCPHome aplicacionSCPHome = (AplicacionSCPHome) PortableRemoteObject.narrow(object, AplicacionSCPHome.class);
		AplicacionSCP aplicacionSCP = aplicacionSCPHome.create();
		return aplicacionSCP;
	}
	
}
