package org.tobby.spring.remoting.rest.server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.tobby.spring.remoting.rest.domain.Spittle;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

	@RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
	public String getSpittle(@PathVariable("spittleId") long id, Model model) {
		model.addAttribute("spittleName", "tobby" + id);
		return "spittles/view";
	}
	
	@RequestMapping(value="/get/{spittleId}", method=RequestMethod.GET)
	public String getSpittleView(@PathVariable("spittleId") long id, Model model) {
		model.addAttribute("spittleName", "tobby" + id);
		return "spittles/getView";
	}
	
	@RequestMapping(value="/put/{spittleId}", method=RequestMethod.GET)
	public String putSpittleView(@PathVariable("spittleId") long id, Model model) {
		model.addAttribute("spittleName", "tobby" + id);
		return "spittles/putView";
	}
	
	@RequestMapping(value="/delete/{spittleId}", method=RequestMethod.GET)
	public String deleteSpittleView(@PathVariable("spittleId") long id, Model model) {
		model.addAttribute("spittleName", "tobby" + id);
		return "spittles/deleteView";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getSpittle(@ModelAttribute Spittle spittle, HttpServletResponse response, HttpServletRequest request) {
		String text = request.getParameter("text");
		System.out.println(text);
		return "spittles/getView";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String createSpittle(@RequestBody MultiValueMap<String, String> spittle, HttpServletResponse response) {
		spittle.get("text");
		response.setHeader("Location", "/spittles/" + spittle.get("id"));
		System.out.println(spittle.get("text"));
		return "spittles/view";
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public String putSpittle(Spittle spittle, HttpServletResponse response) {
		System.out.println(spittle.getText());
		//System.out.println(spittle.getText());
		return "spittles/putView";
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public String deleteSpittle(String id, HttpServletResponse response) {
		System.out.println(id);
		//System.out.println(spittle.getText());
		return "spittles/deleteView";
	}
	
	@RequestMapping(value="/{spittleId}", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateSpittle(@PathVariable("spittleId") long spittleId, @RequestBody Spittle spittle) {
		System.out.println(spittleId);
		System.out.println(spittle.getText());
	}
	
	@RequestMapping(value="/{spittleId}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteSpittle(@PathVariable long spittleId) {
		System.out.println("The Spittle with ID " + spittleId + " is deleted.");
	}
	
}
