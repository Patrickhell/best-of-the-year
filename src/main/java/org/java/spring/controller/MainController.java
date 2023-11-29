package org.java.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.java.spring.pojo.Movie;
import org.java.spring.pojo.Song;


@Controller
public class MainController {
	
	@GetMapping("/")
	
	public String titleName(Model model) {
		
		final String name = "PATRICK";
		model.addAttribute("name", name);

		return "index";
	}
	
    
    @GetMapping("/movies")
	private String getBestMovies(Model model) {
		
		List<Movie> movies = new ArrayList<>();
		
		movies.add(new Movie(1, "Alice au pays des merveilles"));
		movies.add(new Movie(2, "Superman"));
		movies.add(new Movie(3, "hello World"));
		 
		model.addAttribute("movies" , movies);
		return "movies" ;
	}
    
    
    @GetMapping("/songs")
	private String getBestSongs(Model model) {
        List<Song> songs = new ArrayList<>();
		
        songs.add(new Song(1, "All limit"));
        songs.add(new Song(2, "On fire"));
        songs.add(new Song(3, "Best song"));
        		
		model.addAttribute("songs" , songs);
		
		return "songs" ;
		
	}
    
    @GetMapping("/movies/{id}")
    
   public String getMovie(Model model, @PathVariable int id) {
    	

 		List<Movie> movie = new ArrayList<>();
 		
 		movie.add(new Movie(1, "Alice au pays des merveilles"));
 		movie.add(new Movie(2, "Superman"));
 		movie.add(new Movie(3, "hello World"));
 		
         Movie movieId =  movie.stream().filter(m -> m.getId() == id).findFirst().get();
         
    	model.addAttribute("movieId", movieId);
    	
    	return "movieId";
    }
    
    @GetMapping("/songs/{id}")
    public String getSong(Model model, @PathVariable int id) {
    	
        List<Song> song = new ArrayList<>();
		
        song.add(new Song(1, "All limit"));
        song.add(new Song(2, "On fire"));
        song.add(new Song(3, "Best song"));
        
        Song songId = song.stream().filter(m -> m.getId() == id).findFirst().get();
        
        model.addAttribute("songId", songId);
        
        return("songId");
        
    }

}
