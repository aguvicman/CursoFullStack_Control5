package cl.icap.cursofullstack.Control5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.icap.cursofullstack.Control5.model.NotasDTO;
import cl.icap.cursofullstack.Control5.model.dao.NotasDAO;

@Service
public class NotasServiceImpl implements NotasService {
	
	@Autowired
	NotasDAO notasDAO;
	
	@Override
	public List<NotasDTO> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NotasDTO> get(int alumno_rut) {
		return notasDAO.get(alumno_rut);
	}

	@Override
	public int insert(NotasDTO jobsDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(NotasDTO jobsDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int alumno_rut) {
		// TODO Auto-generated method stub
		return 0;
	}

}
