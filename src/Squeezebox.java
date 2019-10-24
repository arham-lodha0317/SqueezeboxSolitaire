import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Squeezebox {

    private static ArrayList<LinkedList<Cards>> gameBoard;
    private static Cards[] hands;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner file = new Scanner(new File("input.dat"));

        while(true){
            hands = new Cards[52];

            //Create Cards and Hands
            String line1 = file.nextLine();

            if(line1.trim().equals("#")){
                break;
            }

            String game = line1 + " " + file.nextLine();

            String[] arr = game.split(" ");

            for (int i = 0; i < arr.length; i++) {
                hands[i] = new Cards(arr[i].substring(0,1), arr[i].substring(1));
            }

            //Start game
            gameBoard = new ArrayList<>();

            gameBoard.add(new LinkedList<>());
            gameBoard.get(0).addFirst(hands[0]);

            int cardNumber = 1;

            while (cardNumber < arr.length){

                //place Cards intitial
                placeCard(cardNumber);

                cardNumber++;

            }

            System.out.println(gameBoard.size() + " piles remaining: ");
            for (LinkedList<Cards> cards : gameBoard) {
                System.out.print(cards.size() + ": ");

                for (Cards c :
                        cards) {
                    System.out.print(c + " ");
                }

                System.out.println();
            }

            System.out.println();

        }



        }

        private static void emptyStack(LinkedList<Cards> l1, LinkedList<Cards> l2){

            while (!l2.isEmpty()){
                l1.addFirst(l2.removeFirst());
            }

        }

        private static void placeCard(int cardNumber){

            Cards currentCard = hands[cardNumber];
            gameBoard.add(new LinkedList<>());
            gameBoard.get(gameBoard.size() - 1).addFirst(currentCard);
            int lastIndex = gameBoard.size() - 1;
            int placed = lastIndex;

            if(lastIndex >= 3 && currentCard.stackable(gameBoard.get(lastIndex - 3).getFirst())) {
                gameBoard.remove(lastIndex);
                gameBoard.get(lastIndex - 3).addFirst(currentCard);
                placed -= 3;
            }
            else if(currentCard.stackable(gameBoard.get(lastIndex - 1).getFirst())){
                gameBoard.remove(lastIndex);
                lastIndex = gameBoard.size() - 1;
                gameBoard.get(lastIndex).addFirst(currentCard);
                placed -= 1;
            }

            simplifyDeck(placed);
        }

        private static void simplifyDeck(int placed){
//
//            while (true){
//                int moves = 0;
//
//                for (int i = gameBoard.size() - 1; i >= 0; i--) {
//
//                    if(gameBoard.get(i).isEmpty()){
//                        gameBoard.remove(i);
//                    }
//                    else {
//
//                        for (int j = gameBoard.size() - 1; j >= 0 ; j--) {
//
//                            if(i != j){
//                                if(gameBoard.get(i).getFirst().stackable(gameBoard.get(j).getFirst())){
//
//                                    if (i > j) i = combine(i, j);
//                                    else j = combine(j, i);
//                                    moves++;
//                                }
//
//
//                            }
//
//                        }
//
//                    }
//
//                }
//
//                if(moves == 0) break;
//
//            }

            for (int i = 0; i < gameBoard.size() ; i++) {
                if (i != placed){
                    if(gameBoard.get(placed).getFirst().stackable(gameBoard.get(i).getFirst())) {
                        if (placed < i) combine(i, placed);
                        else combine(placed, i);

                        break;
                    }
                }
            }


        }

        private static void combine(int big, int small){

            emptyStack(gameBoard.get(small), gameBoard.get(big));
            gameBoard.remove(big);

        }


}
