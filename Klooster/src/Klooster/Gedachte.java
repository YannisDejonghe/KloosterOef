
package Klooster;

/**
 *
 * @author Yannis
 */
public class Gedachte {
    private int concept;
    private Persoonlijkheid mening;
    private Woord woord;
    private Persoonlijkheid persoonlijkheid;
    
    public Gedachte(int concept, Persoonlijkheid mening){
        this.concept = concept;
        this.mening = mening;
        
    }
    public Gedachte(Woord woord, Persoonlijkheid persoonlijkheid){
        this.woord = woord;
        this.persoonlijkheid = persoonlijkheid;
    }
    
    public int getConcept(){
        return concept;
    }
    
    public Woord verwoord(Persoonlijkheid begeerstering){
        return new Woord(this, begeerstering);
    }

    public Persoonlijkheid getMening() {
        return mening;
    }
}
