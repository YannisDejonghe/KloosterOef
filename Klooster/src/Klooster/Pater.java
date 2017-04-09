package Klooster;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yannis
 */
public class Pater {

    private String naam;
    private Persoonlijkheid persoonlijkheid;
    private Gedachte[] gedachten;
    private int aantalGedachten = 0;
    private int counterGedachten = 0;
    private Inspiratie heiligeInspiratie;
    private List liGedachten;
    private int huidigeManier = 0;
    
    public Pater(String naam, Inspiratie heiligeInspiratie, Persoonlijkheid persoonlijkheid) {
        this.naam = naam;
        this.persoonlijkheid = persoonlijkheid;
        this.heiligeInspiratie = heiligeInspiratie;
        gedachten = new Gedachte[20];
    }

    public Pater(String naam, Inspiratie heiligeInspiratie) {
        this.naam = naam;
        this.heiligeInspiratie = heiligeInspiratie;
        gedachten = new Gedachte[20];
    }

    public void bid() {
        if (aantalGedachten <= 20) {
            int concept = heiligeInspiratie.inspireerMij();
            gedachten[aantalGedachten] = new Gedachte(concept, persoonlijkheid);
            aantalGedachten++;
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    public Woord spreek() {
        Woord woord = null;

        if (aantalGedachten > 0) {
            if (counterGedachten == aantalGedachten) {
                counterGedachten = 0;
            }
            woord = gedachten[counterGedachten].verwoord(persoonlijkheid);
            counterGedachten++;
        } else {
            throw new IllegalArgumentException();
        }
        return woord;
    }
    
    public void luister(Woord teHorenWoord){
        liGedachten = new ArrayList();
        Gedachte gedachte = new Gedachte(teHorenWoord, persoonlijkheid);
        liGedachten.add(gedachte);
        if (20 < liGedachten.size()){
            throw new IllegalArgumentException("full");
        }
    }
    
    public void denkNa(){
        List<Gedachte> nieuweGedachten = new ArrayList<>();
        List<Gedachte> werkLijst = new ArrayList<>();
        
        for (int huidigConcept = 1; huidigConcept <= 9; huidigConcept++) {
            for (int huidigeGedachte = 0; huidigeGedachte < aantalGedachten; huidigeGedachte++) {
                if (gedachten[huidigeGedachte].getConcept() == huidigConcept) {
                    werkLijst.add(gedachten[huidigeGedachte]);
                }
            }
            
            //Persoonlijkheid mijnKloon = persoonlijkheid.kopie();
            
            switch (huidigeManier) {
                //Manier 1 - vergelijk goedheid
                case 0:
                    int kleinsteAfstand = 0;
                    Gedachte kleinsteGedachte = null;
                    
                    for (Gedachte werkGedachte : werkLijst) {
                        int afstand = Math.abs(werkGedachte.getMening().getGoedheid() - persoonlijkheid.getGoedheid());
                        
                        if (afstand < kleinsteAfstand || kleinsteGedachte == null) {
                            kleinsteAfstand = afstand;
                            kleinsteGedachte = werkGedachte;
                        }
                    }
                    
                    nieuweGedachten.add(kleinsteGedachte);
                break;
                case 1:
                    
                break;
                case 2:
                    
                break;
            }
            
            werkLijst.clear();
        }
        
        gedachten = nieuweGedachten.toArray(new Gedachte[20]);
    }
}
