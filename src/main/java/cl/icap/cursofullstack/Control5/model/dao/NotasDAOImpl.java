package cl.icap.cursofullstack.Control5.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.icap.cursofullstack.Control5.model.NotasDTO;

@Repository
@Transactional
public class NotasDAOImpl implements NotasDAO {
	private String list = "SELECT * FROM jobs";
	private String get = "SELECT c.curso_cod, c.curso_nom, a.alumno_rut, a.alumno_nombre, n.nmodulo, n.neval, n.nota " +
			"FROM notas n, alumno a, curso c " +
			" WHERE n.alumno_rut=? and c.curso_cod=n.curso_cod and a.alumno_rut=n.alumno_rut ORDER BY n.nmodulo";
	private String insert = "INSERT INTO jobs VALUES (?,?,?,?)";
	private String update = "UPDATE jobs SET job_id=?, job_title=?, min_salary=?, max_salary=? WHERE job_id=?";
	private String delete = "DELETE jobs WHERE job_id=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
	@Override
	public List<NotasDTO> list() {
		List<NotasDTO> listJobs = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(NotasDTO.class));
		return listJobs;
	}

	@Override
	public List<NotasDTO> get(int alumno_rut) {
	    Object[] args = {alumno_rut};
	    List<NotasDTO> notasDTO;
	    
	    try {
	    	notasDTO = jdbcTemplate.query(get,args,BeanPropertyRowMapper.newInstance(NotasDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	notasDTO=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	notasDTO=null;
	    	e.printStackTrace();
	    }
	    return notasDTO;
	}

	@Override
	public int insert(NotasDTO notasDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(NotasDTO notasDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int alumno_rut) {
		// TODO Auto-generated method stub
		return 0;
	}

}
