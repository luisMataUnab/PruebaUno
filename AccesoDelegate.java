package cl.scp.commons.delegate;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import cl.procesac.scp.commons.interfaces.ControlAccesoSCP;
import cl.procesac.scp.commons.interfaces.ControlAccesoSCPHome;
import cl.procesac.scp.dto.UsuarioDTO;

public class AccesoDelegate {

	private static ControlAccesoSCP getServicio() throws NamingException,
			RemoteException, CreateException {
		InitialContext context = new InitialContext();
		Object object = context.lookup(ControlAccesoSCPHome.JNDI_NAME);
		ControlAccesoSCPHome servHome = (ControlAccesoSCPHome) PortableRemoteObject
				.narrow(object, ControlAccesoSCPHome.class);
		ControlAccesoSCP servicio = servHome.create();
		return servicio;

	}

	public String getAcceso(UsuarioDTO usuarioDTO, String codigo)
			throws RemoteException, NamingException, CreateException {
		String acceso = "";
		acceso = getServicio().accesoFuncion(usuarioDTO, codigo);
		return acceso;

	}

}
