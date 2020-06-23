package cl.icap.cursofullstack.Control5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebAppController {
    @RequestMapping("/")
    public String getHome() {
        return "index";
    }
    
    @RequestMapping("/notas")
    public String getNotas() {
        return "notas";
    }
}
