package labyrinthgenerator;

import java.util.Random;
import main.Labyrinth;

/**
 * Labyrintin generointialgoritmien yliluokka.
 *
 * @author Juri Kuronen
 */
public abstract class LabyrinthGenerator {

    /**
     * Labyrintti, jolle algoritmit ajetaan.
     */
    public Labyrinth labyrinth;
    /**
     * Random-olio, jota käytetään satunnaisalgoritmeissa.
     */
    protected Random random;

    /**
     * Ottaa syötteenä labyrintin ja alustaa Random-olion.
     */
    public LabyrinthGenerator() {
        random = new Random();
    }

    /**
     * Labyrintin generoiva metodi.
     *
     * @throws java.lang.Exception Palauttaa poikkeuksen, jos labyrintin
     * käsittelyssä käytettiin labyrintin ulkopuolista koordinaattia. (Näin ei
     * pitäisi koskaan käydä.
     */
    public abstract void generateLabyrinth() throws Exception;

    /**
     * Tyhjentää labyrintin, jos se ei ole tyhjä.
     *
     * @throws java.lang.Exception Heittää poikkeuksen, jos labyrinttia ei ole
     * asetettu tai käsiteltiin jotain labyrintin ulkopuolista koordinaattia.
     * @see main.Labyrinth
     */
    public void createEmptyLabyrinthIfNeeded() throws Exception {
        if (labyrinth == null) {
            throw new Exception("Labyrinth generator doesn't have a labyrinth to generate!");
        }
        if (labyrinth.labyrinth[0][0] != 0) {
            labyrinth.labyrinth = new byte[labyrinth.height][labyrinth.width];
        }
    }

    /**
     * Tulostusrutiini.
     *
     * @throws java.lang.Exception Heittää poikkeuksen, jos labyrinttia ei ole
     * asetettu tai käsiteltiin jotain labyrintin ulkopuolista koordinaattia.
     */
    public void printRoutine() throws Exception {
        System.out.println(" (" + labyrinth.width + "x" + labyrinth.height + ")");
        createEmptyLabyrinthIfNeeded();
        long startTime = System.nanoTime() / 1000;
        generateLabyrinth();
        long finishTime = System.nanoTime() / 1000;
        String timeFormat = labyrinth.formatTime(finishTime - startTime);
        System.out.println("Generation time: " + timeFormat);
    }

}
