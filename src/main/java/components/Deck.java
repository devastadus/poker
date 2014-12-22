package components;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by c40944 on 12/17/14.
 */
public class Deck {
    ArrayList<Card> deck;

    public Deck(){
        this.Shuffle();
    }

    public void Shuffle(){
        deck = new ArrayList<Card>();
        for(int i=0;i<4;++i){
            for(int k=2;k<15;++k){
                Card card = new Card();
                card.setNumber(k);
                if(i==0){
                    card.setSuite("Club");
                }
                else if(i==1){
                    card.setSuite("Diamond");
                }
                else if(i==2){
                    card.setSuite("Heart");
                }
                else if(i==3){
                    card.setSuite("Spade");
                }
                deck.add(card);
            }
        }
    }

    public Card dealCard(){
        Card card;
        int amount = deck.size();
        Random rand = new Random();
        int randomNum = rand.nextInt(amount);
        card = deck.get(randomNum);
        deck.remove(card);
        return card;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }
}
