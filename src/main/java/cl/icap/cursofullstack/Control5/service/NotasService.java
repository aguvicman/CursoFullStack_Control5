package cl.icap.cursofullstack.Control5.service;

import java.util.List;

import cl.icap.cursofullstack.Control5.model.NotasDTO;

public interface NotasService {
	public List<NotasDTO> list();
	public List<NotasDTO> get(int alumno_rut);
	public int insert(NotasDTO notasDTO);
	public int update(NotasDTO notasDTO);
	public int delete(int alumno_rut);
}
