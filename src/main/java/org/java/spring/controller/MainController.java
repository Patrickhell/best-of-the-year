package org.java.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class MainController {
	
	@GetMapping("/")
	
	public String titleName(Model model) {
		
		final String name = "PATRICK";
		model.addAttribute("name", name);

		return "index";
	}
	
	public class Movie {
		
		int id;
		String title;
		
		public Movie(int id,String title) {
			
			setId(id);
			setTitle(title);
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Movie => " + getTitle();
		}
	}
	
    public class Song {
		
		int id;
		String title;
		
        public Song(int id,String title) {
			
			setId(id);
			setTitle(title);
		}
    
        public int getId() {
		   return id;
	    }  

	    public void setId(int id) {
		   this.id = id;
	    }

	    public String getTitle() {
		   return title;
	    }

	    public void setTitle(String title) {
		   this.title = title;
	    }
	    
	    @Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Song => " + getTitle();
		}
	}
    
    @GetMapping("/movies")
	private String getBestMovies(Model model) {
    	
    	
		
		List<Movie> movie = new ArrayList<>();
		
		movie.add(new Movie(1, "Alice au pays des merveilles"));
		movie.add(new Movie(2, "Superman"));
		movie.add(new Movie(3, "hello World"));
		 String moviesList = movie.stream().map(Movie::getTitle).collect(Collectors.joining(" , "));
		 
		model.addAttribute("moviesList" , moviesList);
		return "movies" ;
	}
    
    
    @GetMapping("/songs")
	private String getBestSongs(Model model) {
        List<Song> song = new ArrayList<>();
		
        song.add(new Song(1, "All limit"));
        song.add(new Song(2, "On fire"));
        song.add(new Song(3, "Best song"));
        
        String songsList = song.stream().map(Song::getTitle).collect(Collectors.joining( " , "));
		
		model.addAttribute("songsList" , songsList);
		
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
