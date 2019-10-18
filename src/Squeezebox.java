import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Squeezebox {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner file = new Scanner(new File("input.dat"));

        while(true){
            Cards[] hands = new Cards[52];

            String line1 = file.nextLine();

            if(line1.trim().equals("#")){
                break;
            }

            String game = line1 + " " + file.nextLine();

            String[] arr = game.split(" ");

            for (int i = 0; i < arr.length; i++) {
                hands[i] = new Cards(arr[i].substring(0,1), arr[i].substring(1));
            }

            ArrayList<LinkedList<Cards>> gameBoard = new ArrayList<>();

            gameBoard.add(new LinkedList<>());
            gameBoard.get(0).addFirst(hands[0]);

            boolean win = false;
            boolean lose = false;

            int cardNumber = 1;

            while (!win || !lose){


                if(cardNumber >= 4){



                }


            }

        }



        }

}
