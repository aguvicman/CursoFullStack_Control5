package cl.icap.cursofullstack.Control5.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.icap.cursofullstack.Control5.model.NotasDTO;
import cl.icap.cursofullstack.Control5.service.AvgService;
import cl.icap.cursofullstack.Control5.service.NotasService;

@RestController
@RequestMapping(value="/notas")
public class NotasController {
	@Autowired
	NotasService notasService;
	
	
	@RequestMapping(value="/get")
	public List<NotasDTO> ajaxGet(HttpServletRequest req, HttpServletResponse res) {
		List<NotasDTO> notas = notasService.get(Integer.parseInt(req.getParameter("alumno_rut")));
		return notas;
	}
	
	@RequestMapping(value="/avg")
	public String ajaxAvg(HttpServletRequest req, HttpServletResponse res) {
		int avg = new AvgService().computeAvg(req.getParameter("lista_notas"));
		System.out.println("LLEGA");
		return Integer.toString(avg);
	}
}
