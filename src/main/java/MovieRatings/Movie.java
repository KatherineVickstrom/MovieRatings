package MovieRatings;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Movie {
        
        @Id
        @GeneratedValue
        private long id;
        
        @NotNull
        @Size(min=3, max=25)
        private String name;
        
        @NotNull
        @Size(min=3, max=25)
        private String title;
        
        @NotNull
        @Min(1)
        @Max(5)
        private int rating;
        
        private String date;
        
        public Movie() {
                
        }
        
        public Movie(long id, String name, String title, int rating) {
                super();
                this.id = id;
                this.name = name;
                this.title = title;
                this.rating = rating;
        }
        
        public long getId() { return id; }
        public void setId(long id) { this.id = id;}

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public int getRating() {
                return rating;
        }

        public void setRating(int rating) {
                this.rating = rating;
        } 
        
        public String getDate() {
           return date;
        }

        public void setDate(String date) {
           this.date = date;
        }
}