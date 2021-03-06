package petline.sessLayer;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;

import petline.dataLayer.EntNotificacion;
import petline.valueObject.Notificacion;

public class SessNotificacion {
	/**
	 * 
	 * @param idTracker
	 * @return
	 * @throws SQLException
	 */
	public HashMap<Integer, Calendar> obtenerUltimasNotificacionesRealizadas( int idTracker ) throws SQLException{
		EntNotificacion entNotificacion = new EntNotificacion();
		return entNotificacion.getUltimasNotificacionesRealizadas(idTracker);		
	}
	/**
	 * 
	 * @param idTracker
	 * @return
	 * @throws SQLException
	 */
	public Collection<Notificacion> obtenerNotificacionesUltimaSemana( int idTracker ) throws SQLException{
		EntNotificacion entNotificacion = new EntNotificacion();
		return entNotificacion.getNotificacionesUltimaSemana(idTracker);
	}
	/**
	 * 
	 * @param notificacion
	 * @throws SQLException
	 */
	public void insertarNotificacion( Notificacion notificacion ) throws SQLException{
		EntNotificacion entNotificacion = new EntNotificacion();
		entNotificacion.insertNotificacion(notificacion);
	}
}
