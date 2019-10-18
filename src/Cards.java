public class Cards {

    String suit;
    String rank;

    public Cards(String rank, String suit){
        this.suit = suit;
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }
}
