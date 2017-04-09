package Klooster;

/**
 *
 * @author Yannis
 */
public class Inspiratie {

    int concept = 0;

    public Inspiratie() {

    }

    public int inspireerMij() {
        concept++;
        
        if (concept > 9) {
            
            concept = 1;
        }
        
        return concept;

    }

}
