package ru.netology.films;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FilmManagerTest {

    @Test
    void testNoFilms() {
        FilmManager filmManager = new FilmManager();

        assertEquals(0, filmManager.findAll().length);
        assertEquals(0, filmManager.findLast().length);
    }

    @Test
    void testFindAll() {
        String[] expected = new String[3];
        expected[0] = "Берегись автомобиля";
        expected[1] = "Бриллиантовая рука";
        expected[2] = "Кавказская пленница";
        FilmManager filmManager = new FilmManager();
        filmManager.addFilm(expected[0]);
        filmManager.addFilm(expected[1]);
        filmManager.addFilm(expected[2]);

        assertArrayEquals(expected, filmManager.findAll());
    }

    @Test
    void testLimitEquals() {
        String[] expected = new String[3];
        expected[0] = "Берегись автомобиля";
        expected[1] = "Бриллиантовая рука";
        expected[2] = "Кавказская пленница";
        FilmManager filmManager = new FilmManager(3);
        filmManager.addFilm(expected[2]);
        filmManager.addFilm(expected[1]);
        filmManager.addFilm(expected[0]);

        assertArrayEquals(expected, filmManager.findLast());
    }


    @Test
    void testLimitExceeded() {
        String[] expected = new String[2];
        expected[0] = "Бриллиантовая рука";
        expected[1] = "Кавказская пленница";
        FilmManager filmManager = new FilmManager(2);
        filmManager.addFilm("Берегись автомобиля");
        filmManager.addFilm(expected[1]);
        filmManager.addFilm(expected[0]);

        String[] actual = filmManager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void testLimitLower() {
        String[] expected = new String[3];
        expected[0] = "Берегись автомобиля";
        expected[1] = "Бриллиантовая рука";
        expected[2] = "Кавказская пленница";
        FilmManager filmManager = new FilmManager(10);
        filmManager.addFilm(expected[2]);
        filmManager.addFilm(expected[1]);
        filmManager.addFilm(expected[0]);

        String[] actual = filmManager.findLast();

        assertArrayEquals(expected, actual);
    }
}
