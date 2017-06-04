package co.edu.edufic.bl;

import java.util.List;

import co.edu.edufic.dto.Area;
import co.edu.edufic.exception.MyException;

/**
 * Interface para el manejo de la lógica de negocio correspondiente a las áreas 
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public interface AreaBL {

	/**
	 * Obtiene el listado de las áreas del sistema
	 * @return
	 * @throws MyException
	 */
	public List<Area> areas() throws MyException;
	
	/**
	 * Obtiene un área dado su identficador.
	 * @param idArea Identificador del área
	 * @return Ärea con el identificador dado.
	 * @throws MyException
	 */
	public Area areaById(Integer idArea)  throws MyException;
	
}
