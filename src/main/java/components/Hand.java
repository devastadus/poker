package components;

import java.util.ArrayList;

/**
 * Created by c40944 on 12/17/14.
 */
public class Hand {
    ArrayList<Card> hand;
    Score score;

    public Hand(){
        hand = new ArrayList<Card>();
        score = new Score();
    }

    public void addtoHand(Card card){
        hand.add(card);
    }

    public void printHand(){
        System.out.println("printing hand");
        String suit ="";
        for(Card card:hand){
            if(card.getNumber()>10){
                if(card.getNumber()==11){
                    suit = "J";
                }
                else if(card.getNumber()==12){
                    suit = "Q";
                }
                else if(card.getNumber()==13){
                    suit = "K";
                }
                else if(card.getNumber()==14){
                    suit = "A";
                }
            } else {
                suit = String.valueOf(card.getNumber());
            }
            System.out.println(suit+" "+card.getSuite());
        }
        System.out.println();
    }


    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
}
