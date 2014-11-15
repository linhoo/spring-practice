package org.tobby.spring.remoting.rest.server;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.tobby.spring.remoting.rest.domain.Spitter;
import org.tobby.spring.remoting.rest.domain.Spittle;

@Controller
@RequestMapping("/spitters")
public class SpitterController {
	
	@RequestMapping(value = "/{spitter}", method = RequestMethod.GET)
	@ResponseBody
	public Spitter getSpitter(@PathVariable("spitter") long spitterId) {
		System.out.println(spitterId);
		Spitter spitter = new Spitter("tobby", "aa");
		return spitter;
	}

	@RequestMapping(value = "/{spitterName}/spittles", method = RequestMethod.GET)
	public @ResponseBody Spittle[] getSpittlesForSpitter(
			@PathVariable("spitterName") String spitterName) {
		System.out.println("All the Spittles for " + spitterName + " is:");
		Spittle[] spittles = new Spittle[3];
		spittles[0] = new Spittle();
		spittles[1] = new Spittle();
		spittles[2] = new Spittle();

		spittles[0].setId(3);
		spittles[1].setId(4);
		spittles[2].setId(5);

		spittles[0].setText("I");
		spittles[1].setText("AM");
		spittles[2].setText(spitterName);
		return spittles;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Spitter createSpitter(@RequestBody Spitter spitter, HttpServletResponse response) {
		spitter.setId(889L);
		response.setHeader("Location", "/spittles/" + spitter.getId());
		System.out.println(spitter.getUsername());
		return spitter;
	}

}
