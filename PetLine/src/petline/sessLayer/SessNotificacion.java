package petline.sessLayer;

import java.sql.SQLException;
import java.util.Collection;

import petline.dataLayer.EntNotificacion;
import petline.valueObject.Notificacion;

public class SessNotificacion {

	public Collection<Notificacion> obtenerNotificacionesUltimaSemana( int idTracker ) throws SQLException{
		EntNotificacion entNotificacion = new EntNotificacion();
		return entNotificacion.getNotificacionesUltimaSemana(idTracker);
	}
	
	public void insertarNotificacion( Notificacion notificacion ) throws SQLException{
		EntNotificacion entNotificacion = new EntNotificacion();
		entNotificacion.insertNotificacion(notificacion);
	}
}
