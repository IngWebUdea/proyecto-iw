package co.edu.edufic.bl;

import java.util.List;

import co.edu.edufic.dto.Area;
import co.edu.edufic.exception.MyException;

/**
 * Interface para el manejo de la l�gica de negocio correspondiente a las �reas 
 * @author Andr�s Castro -- andres.castrop@udea.edu.co
 *
 */
public interface AreaBL {

	/**
	 * Obtiene el listado de las �reas del sistema
	 * @return
	 * @throws MyException
	 */
	public List<Area> areas() throws MyException;
	
	/**
	 * Obtiene un �rea dado su identficador.
	 * @param idArea Identificador del �rea
	 * @return �rea con el identificador dado.
	 * @throws MyException
	 */
	public Area areaById(Integer idArea)  throws MyException;
	
}
