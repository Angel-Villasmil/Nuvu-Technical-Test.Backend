package cc.nuvu.technical.test.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@GetMapping("/")
	//@ResponseBody -> Para devolver un String, si no quitamos, en este caso,
	//buscará la vista index.
	public String index() {
		return "index"; 
		//return "index.html"; Devuelve lo mismo que el return "index";
	}
}