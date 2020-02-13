package com.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
	@RequestMapping("/")
	private String pulbic() {
		return "Hello";
	}
}