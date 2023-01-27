import java.util.List;

/**
 * @author arronshentu
 */
public class Checker {
  public static void main(String[] args) {
    String givenSentence =
      "Given a string, implement a method that given a word in the sentence, randomly a word of its following words. a word not in the sentence,";
    // given a substring of the sentence, return the next words of the substring.
    String input = "";
  }
}

// Coding Card game, step by step.
// Money is represented in number of each color: black, blue, green, green, white.
// A card has properties of how much it requires by it.
// Implement a canPurchase() method to decide whether a certain amount of money can buy a card.Implement the purchase
// method,
// which should update the money and cards owned.
// Discount with card owned. Each card has a property of color.
// If you own cards of a color. Next time purchase of another card, the price of this color can be discounted by
// the number of card you owned. Update the canPurchase and purchase method.

class Player {
  List<Money> wallet;
  List<Card> ownedCard;

  boolean canPurchase() {
    return false;
  }

  void purchase(Card card) {
    //
  }
}

class Card {
  int price;
  int color;
}

class Money {
  int value;
  int color;
}
