import components.Card;
import components.Deck;
import components.Hand;
import components.Score;
import org.testng.Assert;
import org.testng.annotations.Test;
import runtime.Deal;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by c40944 on 12/17/14.
 */
public class PokerTest {

    @Test
    public void testDeckSize(){
        Deck deck = new Deck();
        ArrayList<Card> currentDeck = deck.getDeck();
        Assert.assertEquals(currentDeck.size(),52);

    }
    @Test
    public void testDeckFormat() {
        Deck deck = new Deck();
        int club=0;
        int diamond=0;
        int spade=0;
        int heart=0;
        ArrayList<Card> currentDeck = deck.getDeck();
        ArrayList<Number> hearts = new ArrayList<Number>();
        ArrayList<Number> clubs = new ArrayList<Number>();
        ArrayList<Number> diamonds = new ArrayList<Number>();
        ArrayList<Number> spades = new ArrayList<Number>();

        for(Card card: currentDeck){
            //System.out.print(card.getSuite() + " " + card.getNumber() + "\n");

            if(card.getSuite()=="Heart"){
                ++heart;
                addToArray(hearts,card.getNumber());
            }

            if(card.getSuite()=="Spade"){
                ++spade;
                addToArray(spades,card.getNumber());
            }

            if(card.getSuite()=="Diamond"){
                ++diamond;
                addToArray(diamonds,card.getNumber());
            }

            if(card.getSuite()=="Club"){
                ++club;
                addToArray(clubs,card.getNumber());
            }

        }
        Assert.assertEquals(club,13);
        Assert.assertEquals(spade,13);
        Assert.assertEquals(diamond,13);
        Assert.assertEquals(heart,13);
    }

    @Test void checkHands(){
        Deal deal = new Deal();
        ArrayList<Hand> hands = deal.dealCards(5);

        Assert.assertEquals(hands.size(),5);

        for(Hand hand: hands){
            hand.printHand();
        }
    }

    @Test void checkHighestScore(){
        Hand hand = new Hand();
        Card card = new Card();
        Score score = new Score();
        card.setNumber(5);
        card.setSuite("Spade");
        hand.addtoHand(card);
        card = new Card();
        card.setNumber(6);
        card.setSuite("Spade");
        hand.addtoHand(card);
        Number number = score.HighCard(hand);
        Assert.assertEquals(number,6);
    }

    @Test void checkFlush(){
        Score score = new Score();
        Hand hand = generateRoyalFlush();
        boolean bool = score.isFlush(hand);
        Assert.assertEquals(bool,true);
    }

    @Test void checkNotFlush(){
        Score score = new Score();
        Hand hand = generateHighHand();
        boolean bool = score.isFlush(hand);
        Assert.assertEquals(bool,false);
    }

    @Test void checkStraight(){
        Score score = new Score();
        Hand hand = generateRoyalFlush();
        boolean bool = score.isStraight(hand);
        Assert.assertEquals(bool,true);
    }

    @Test void checkStraightLow(){
        Score score = new Score();
        Hand hand = generateLowStraightFlush();
        boolean bool = score.isStraight(hand);
        Assert.assertEquals(bool,true);
    }

    @Test void notStraight(){
        Score score = new Score();
        Hand hand = generateNotStraightFlush();
        boolean bool = score.isStraight(hand);
        Assert.assertEquals(bool,false);

    }

    @Test
    public void random(){
        Number number =5;
        String str = number.toString();

    }

    public Hand generateHighHand(){
        Hand hand = new Hand();
        Card card = new Card();
        card.setNumber(14);
        card.setSuite("Spade");
        hand.addtoHand(card);

        card = new Card();
        card.setNumber(2);
        card.setSuite("Heart");
        hand.addtoHand(card);

        card = new Card();
        card.setNumber(7);
        card.setSuite("Spade");
        hand.addtoHand(card);

        card = new Card();
        card.setNumber(4);
        card.setSuite("Spade");
        hand.addtoHand(card);

        card = new Card();
        card.setNumber(5);
        card.setSuite("Spade");
        hand.addtoHand(card);

        return hand;

    }


    public Hand generateNotStraightFlush(){
        Hand hand = new Hand();
        Card card = new Card();
        card.setNumber(14);
        card.setSuite("Spade");
        hand.addtoHand(card);

        card = new Card();
        card.setNumber(2);
        card.setSuite("Spade");
        hand.addtoHand(card);

        card = new Card();
        card.setNumber(7);
        card.setSuite("Spade");
        hand.addtoHand(card);

        card = new Card();
        card.setNumber(4);
        card.setSuite("Spade");
        hand.addtoHand(card);

        card = new Card();
        card.setNumber(5);
        card.setSuite("Spade");
        hand.addtoHand(card);

        return hand;

    }

    public Hand generateLowStraightFlush(){
        Hand hand = new Hand();
        Card card = new Card();
        card.setNumber(14);
        card.setSuite("Spade");
        hand.addtoHand(card);

        card = new Card();
        card.setNumber(2);
        card.setSuite("Spade");
        hand.addtoHand(card);

        card = new Card();
        card.setNumber(3);
        card.setSuite("Spade");
        hand.addtoHand(card);

        card = new Card();
        card.setNumber(4);
        card.setSuite("Spade");
        hand.addtoHand(card);

        card = new Card();
        card.setNumber(5);
        card.setSuite("Spade");
        hand.addtoHand(card);

        return hand;

    }

    public Hand generateRoyalFlush(){
        Hand hand = new Hand();
        Card card = new Card();
        card.setNumber(14);
        card.setSuite("Spade");
        hand.addtoHand(card);

        card = new Card();
        card.setNumber(13);
        card.setSuite("Spade");
        hand.addtoHand(card);

        card = new Card();
        card.setNumber(12);
        card.setSuite("Spade");
        hand.addtoHand(card);

        card = new Card();
        card.setNumber(11);
        card.setSuite("Spade");
        hand.addtoHand(card);

        card = new Card();
        card.setNumber(10);
        card.setSuite("Spade");
        hand.addtoHand(card);

        return hand;

    }

   // @Test
    public void randomNumber(){
        for(int i=0;i<100;++i){
            System.out.println(randInt(0,10));
        }
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

    private void addToArray(ArrayList<Number> array, Number num){
        if(array.contains(num)){
            Assert.fail(num+"already exist");
        }
        else{
            array.add(num);
        }
    }
}
