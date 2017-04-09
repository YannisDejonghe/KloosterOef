
package Klooster;

import java.util.Random;

/**
 *
 * @author Yannis
 */
public class Persoonlijkheid {
    private int goedheid; 
    private int creativiteit; 
    
    public Persoonlijkheid(int goedheid, int creativiteit){
        this.goedheid = goedheid;
        this.creativiteit = creativiteit;
    }
    
    public Persoonlijkheid(){
        this(new Random().nextInt(99),new Random().nextInt(99));
    }
    
    @Override
    public String toString(){
        String res = "";
        if(creativiteit >= 33 && 0 <= creativiteit) res += "lawful ";
        if(creativiteit >= 66 && 34 <= creativiteit) res += "neutral";
        if(creativiteit >= 99 && 67 <= creativiteit) res += "chaotic";
        
        if(goedheid >= 33 && 0 <= goedheid) res += "evil ";
        if(goedheid >= 66 && 34 <= goedheid) res += "neutral";
        if(goedheid >= 99 && 67 <= goedheid) res += "good";
        
        return res;
    }

    public int getGoedheid() {
        return goedheid;
    }

    public int getCreativiteit() {
        return creativiteit;
    }

    public Persoonlijkheid kopie() {
        return new Persoonlijkheid(goedheid, creativiteit);
    }
}
