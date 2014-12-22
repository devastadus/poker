package runtime;

import components.Deck;
import components.Hand;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by c40944 on 12/17/14.
 */
public class Deal {
    int players;
    ArrayList<Hand> hands;

    public Deal(){
    }

    public ArrayList<Hand> dealCards(int players){

        Hand hand;
        Deck deck = new Deck();
        this.players = players;
        hands = new ArrayList<Hand>();
        for(int i=0; i<players;++i){
            hand = new Hand();
            hands.add(hand);
        }
        //stopped here
        for(int k=0; k<players*5; ++k){
            hand = hands.get(k%players);
            hand.addtoHand(deck.dealCard());
        }

        return hands;
    }

    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
