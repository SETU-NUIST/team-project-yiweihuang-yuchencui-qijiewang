package models;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    Movie movie;
    @BeforeEach
    void setUp(){
        movie = new Movie("流浪地球", "郭帆", 2023, 7.9, "科幻", "特效震撼");
    }
    @AfterEach
    void tearDown(){
        movie=null;
    }
    @Test
    void getTitle() {
        assertEquals("流浪地球", movie.getTitle());
    }
    @Test
    void setTitle() {
        movie.setTitle("流浪地球2");
        assertEquals("流浪地球2", movie.getTitle());
    }
    @Test
    void getDirector() {
        assertEquals("郭帆", movie.getDirector());
    }
    @Test
    void setDirector() {
        assertEquals("郭帆", movie.getDirector());
    }
    @Test
    void getYear() {
        assertEquals(2023, movie.getYear());
    }
    @Test
    void setYear() {
        movie.setYear(2023);
        assertEquals(2023, movie.getYear());
    }
    @Test
    void getRating() {
        assertEquals(7.9, movie.getRating(), 0.001);
    }

    @Test
    void setRating() {
        movie.setRating(7.9);
        assertEquals(7.9, movie.getRating(), 0.001);
    }

    @Test
    void getGenre() {
        assertEquals("科幻", movie.getGenre());
    }
    @Test
    void setGenre() {
        movie.setGenre("灾难");
        assertEquals("灾难", movie.getGenre());
    }
    @Test
    void getReview() {
        assertEquals("特效震撼", movie.getReview());
    }
    @Test
    void setReview() {
        movie.setReview("剧情紧凑");
        assertEquals("剧情紧凑", movie.getReview());
    }
    @Test
    void testToString() {
        String result = movie.toString();
        assertTrue(result.contains("流浪地球"));
        assertTrue(result.contains("郭帆"));
        assertTrue(result.contains("2023"));
        assertTrue(result.contains("7.9"));
    }

    @Test
    void getRatingLevel() {
        assertEquals(3, movie.getRatingLevel(movie.getRating()));
        movie.setRating(8.9);
        assertEquals(2, movie.getRatingLevel(movie.getRating()));
        movie.setRating(8.0);
        assertEquals(2, movie.getRatingLevel(movie.getRating()));
        movie.setRating(7.9);
        assertEquals(3, movie.getRatingLevel(movie.getRating()));
        movie.setRating(7.0);
        assertEquals(3, movie.getRatingLevel(movie.getRating()));
        movie.setRating(6.0);
        assertEquals(4, movie.getRatingLevel(movie.getRating()));
        movie.setRating(5.9);
        assertEquals(5, movie.getRatingLevel(movie.getRating()));
        movie.setRating(0.0);
        assertEquals(5, movie.getRatingLevel(movie.getRating()));
    }


}
