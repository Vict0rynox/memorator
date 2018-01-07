package org.victorynox.memorator.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author victorynox
 * @version 0.1
 */

@org.springframework.stereotype.Controller
public class Controller {

	@RequestMapping("/demo")
	public String index(
			@RequestParam(value = "name", defaultValue = "World", required = false) String name, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("title", "Demo page");
		return "demo/index";
	}
}
