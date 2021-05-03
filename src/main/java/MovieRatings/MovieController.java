package MovieRatings;

import java.text.SimpleDateFormat;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {  
        
        @Autowired
        MovieRepository movieRepository;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        
        @GetMapping("/movie/new")
        public String createMovie( Model model) {
                Movie movie = new Movie();
                model.addAttribute("movie", movie);
                movie.setDate(formatter.format(new java.util.Date()).toString());
                model.addAttribute("date", movie.getDate());
                
                return "movie_form";
        }
        
        @PostMapping("/movie")
        public String processMovieForm(@Valid Movie movie, BindingResult result, 
                        Model model) {
                if (result.hasErrors()) {
                        return "movie_form";
                }
                movieRepository.save(movie);
                return "movie_show";
        }
        
        @GetMapping("/movie")
        public String getAllMovies(Model model) {
                Iterable<Movie> movie = movieRepository.findAllMovieRatingsOrderByTitleDateDesc();
                model.addAttribute("movies", movie);
                return "movie_list";
                
        }
}
