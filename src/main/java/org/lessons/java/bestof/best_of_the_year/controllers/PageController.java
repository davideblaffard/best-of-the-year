package org.lessons.java.bestof.best_of_the_year.controllers;

import org.lessons.java.bestof.best_of_the_year.models.Movie;
import org.lessons.java.bestof.best_of_the_year.models.Song;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Arrays;

@Controller
public class PageController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Davidoneone"); 
        return "home";
    }

    @GetMapping("/movies")
    public String movies(Model model) {
        model.addAttribute("movies", getBestMovies());
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model) {
        model.addAttribute("songs", getBestSongs());
        return "songs";
    }

    private List<Movie> getBestMovies(){
        return Arrays.asList(new Movie(1, "Interstellar"), new Movie(2, "Inception"), new Movie(3, "Tenet"));
    }

    private List<Song> getBestSongs(){
        return Arrays.asList(new Song(1, "Like him"), new Song(2, "earthquake"), new Song(3, "can i get a kiss"));
    }

    @GetMapping("/movies/{id}")
        public String movieDetail(@PathVariable int id, Model model){
            List<Movie> movies = getBestMovies();
            Movie movie = movies.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);

            model.addAttribute("movie", movie);
            return "movie-detail";
        }

        @GetMapping("/songs/{id}")
        public String songDetail(@PathVariable int id, Model model){
            List<Song> songs = getBestSongs();
            Song song = songs.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);

            model.addAttribute("song", song);
            return "song-detail";
        }
    
}
