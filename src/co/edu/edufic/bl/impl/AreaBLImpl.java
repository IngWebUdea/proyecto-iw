package co.edu.edufic.bl.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.edufic.bl.AreaBL;
import co.edu.edufic.dao.AreaDAO;
import co.edu.edufic.dto.Area;
import co.edu.edufic.exception.MyException;

public class AreaBLImpl implements AreaBL {
	
	AreaDAO areaDAO;

	@Override
	public List<Area> areas() throws MyException {
		
		List<Area> areas = new ArrayList<Area>();
		areas = areaDAO.allAreas();			
		return areas;
	}

	@Override
	public Area areaById(Integer idArea) throws MyException {
		
		Area area = null;
		
		if(idArea.equals(null)) {
			new Exception("El campo área es requerido");
		}
		
		area = areaDAO.findById(idArea);
		if(area.equals(null)){
			new Exception("El área especificada no se encuentra en el sistema");
		}
		
		return area;
	}

	public AreaDAO getAreaDAO() {
		return areaDAO;
	}
	public void setAreaDAO(AreaDAO areaDAO) {
		this.areaDAO = areaDAO;
	}
		
}
