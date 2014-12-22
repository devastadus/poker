package components;

import java.util.*;

/**
 * Created by c40944 on 12/19/14.
 */
public class Score {
    Integer highestCard;
    boolean straight;
    boolean flush;
    boolean fullhouse;
    boolean hasAce;
    Map<Integer,Integer> pairs;

    public Score(){
        pairs = null;
        highestCard = 0;
        straight = false;
        flush = false;
        fullhouse = false;
        hasAce = false;
    }

    public void scoreHand(Hand hand){
        highestCard = HighCard(hand);
        straight = isStraight(hand);
        flush = isFlush(hand);
    }

    public Map<Integer,Integer> findPairs(Hand hand){

        Map<Integer,Integer> cardMap = new HashMap<Integer, Integer>();
        ArrayList<Integer> cardList = sortedList(hand);
        Integer current = cardList.get(0);

        for(int i = 1;i<cardList.size();++i){
            if(current == cardList.get(i)){
                if(cardMap.containsKey(current)){
                    Integer value = cardMap.get(current);
                    ++value;
                    cardMap.put(current,value);
                }
                else
                    cardMap.put(current,2);
            }
            current = i;
        }
        return cardMap;
    }

    public boolean isFlush(Hand hand){
        ArrayList<Card> cardsInHand;
        cardsInHand = hand.getHand();
        String suite = cardsInHand.get(0).getSuite();
        for(Card card:cardsInHand){
            if(suite != card.getSuite())
                return false;
        }
        return true;
    }

    public boolean isStraight(Hand hand){
        ArrayList<Card> cardsInHand;
        int current = 0;
        cardsInHand = hand.getHand();

        ArrayList<Integer> listOfCards = sortedList(hand);


        current = listOfCards.get(0);
        int lookAHead =0;
        boolean lowAce = false;

        for(int k=0;k<listOfCards.size()-1;++k){
            lookAHead = listOfCards.get(k+1);
            current = listOfCards.get(k);

            if(hasAce && k == listOfCards.size()-2){
                if(listOfCards.get(0)==2)
                    return true;
            }

            else if(current+1 != lookAHead){
                return false;
            }

        }

        return true;
    }

    public ArrayList<Integer> sortedList(Hand hand){
        //see if there an ace
        ArrayList<Card> cardsInHand = hand.getHand();
        ArrayList<Integer> listofCards = new ArrayList<Integer>();
        for(Card card:cardsInHand){
            if(card.getNumber() == 14){
                hasAce = true;

            }
            listofCards.add(card.getNumber());
        }

        Collections.sort(listofCards);
        return listofCards;

    }

    public Integer HighCard(Hand hand){
        ArrayList<Card> cardsInHand;
        Integer currentHighest = 0;
        cardsInHand = hand.getHand();
        for(Card card:cardsInHand){
            if(card.getNumber() > currentHighest.intValue())
                currentHighest = card.getNumber();
        }
        return currentHighest;
    }
}
