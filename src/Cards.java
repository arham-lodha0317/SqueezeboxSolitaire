public class Cards {

    private String suit;
    private String rank;

    Cards(String rank, String suit){
        this.suit = suit;
        this.rank = rank;
    }

    private String getRank() {
        return rank;
    }

    private String getSuit() {
        return suit;
    }

    boolean stackable(Cards card2){
        return this.rank.equals(card2.getRank()) || this.suit.equals(card2.getSuit());
    }

    @Override
    public String toString() {
        return rank + suit;
    }
}
