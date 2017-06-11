package co.edu.edufic.bl;

import co.edu.edufic.exception.MyException;

public interface EstudianteBL {
	
	/**
	 * Asigna un acudiente a un estudiante
	 * @param idAcudiente
	 * @param idEstudiante
	 */
	public void asignarAcudiente(String idAcudiente, String idEstudiante, String usuarioCrea) throws MyException;

}
