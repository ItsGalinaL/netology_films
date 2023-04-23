package ru.netology.films;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilmManagerTest {

    @Test
    void testNoFilms() {
        FilmManager filmManager = new FilmManager();

        assertEquals(0, filmManager.findAll().length);
        assertEquals(0, filmManager.findLast().length);
    }

    @Test
    void testLimit() {
        FilmManager filmManager = new FilmManager(3);

        String f1 = "Берегись автомобиля";
        filmManager.addFilm(f1);

        String f2 = "Бриллиантовая рука";
        filmManager.addFilm(f2);

        String f3 = "Кавказская пленница";
        filmManager.addFilm(f3);

        assertEquals(3, filmManager.findAll().length);
        assertEquals(f1, filmManager.findAll()[0]);
        assertEquals(f2, filmManager.findAll()[1]);
        assertEquals(f3, filmManager.findAll()[2]);

        assertEquals(3, filmManager.findLast().length);
        assertEquals(f3, filmManager.findLast()[0]);
        assertEquals(f2, filmManager.findLast()[1]);
        assertEquals(f1, filmManager.findLast()[2]);
    }


    @Test
    void testOverLimit() {
        FilmManager filmManager = new FilmManager(2);

        String f1 = "Берегись автомобиля";
        filmManager.addFilm(f1);

        String f2 = "Бриллиантовая рука";
        filmManager.addFilm(f2);

        String f3 = "Кавказская пленница";
        filmManager.addFilm(f3);

        assertEquals(2, filmManager.findLast().length);
        assertEquals(f3, filmManager.findLast()[0]);
        assertEquals(f2, filmManager.findLast()[1]);
    }
}