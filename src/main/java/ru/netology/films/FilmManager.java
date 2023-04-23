package ru.netology.films;

public class FilmManager {

    private String[] films = new String[0];
    private int lastFilmsCount;

    public FilmManager() {
        lastFilmsCount = 10;
    }

    public FilmManager(int lastFilmsCount) {
        this.lastFilmsCount = lastFilmsCount;
    }

    public void addFilm(String String) {
        String[] tmp = new String[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[films.length] = String;
        films = tmp;
    }

    public String[] findAll() {
        return films;
    }

    public String[] findLast() {
        int tmpLength = lastFilmsCount;

        if (films.length < lastFilmsCount) {
            tmpLength = films.length;
        }

        String[] tmp = new String[tmpLength];
        for (int i = 0; i < tmpLength; i++) {
            tmp[i] = films[films.length - i - 1];
        }
        return tmp;
    }
}
