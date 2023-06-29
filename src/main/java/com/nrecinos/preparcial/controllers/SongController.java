package com.nrecinos.preparcial.controllers;

import java.net.http.HttpRequest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nrecinos.preparcial.models.entities.Song;
import com.nrecinos.preparcial.services.SongService;

@RestController
@RequestMapping("/songs")
@CrossOrigin(origins = "*")
public class SongController {
	@Autowired
	private SongService songService;
	
	/*@SuppressWarnings("unchecked")*/
	@GetMapping("")
	ResponseEntity<?>getAll(@RequestParam(defaultValue = "", name="fragment") String fragment) {
		
		List<Song> songs = songService.findAll(fragment);
		return new ResponseEntity<>(
			songs, HttpStatus.OK
		);
	}
}
