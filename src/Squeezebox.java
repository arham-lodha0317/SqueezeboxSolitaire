import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Squeezebox {

    private static ArrayList<LinkedList<Cards>> gameBoard;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner file = new Scanner(new File("input.dat"));

        while(true) {
            //Create Cards and Hands
            String line1 = file.nextLine();

            if (line1.trim().equals("#")) {
                break;
            }

            String game = line1 + " " + file.nextLine();

            String[] arr = game.split(" ");

            //Start game
            gameBoard = new ArrayList<>();

            for (int i = 0; i < arr.length; i++) {
                gameBoard.add(new LinkedList<>());
                gameBoard.get(i).addFirst(new Cards(arr[i].substring(0, 1), arr[i].substring(1)));
            }

            int i = 1;
            while(gameBoard.size() != 1 && i < gameBoard.size()){

                if(i >= 3 && gameBoard.get(i - 3).getFirst().stackable(gameBoard.get(i).getFirst()))
                {
                    combine(i, i - 3);
                    i = 1;
                }
                else if(gameBoard.get(i -1).getFirst().stackable(gameBoard.get(i).getFirst())){
                    combine(i, i-1);
                    i = 1;
                }
                else {
                    i++;
                }
            }
            System.out.print(gameBoard.size() + " piles remaining: ");

            for (LinkedList<Cards> cards : gameBoard) {
                System.out.print(cards.size() + " ");
            }

            System.out.println();
        }
        }


        private static void combine(int b, int s){

            while(!gameBoard.get(b).isEmpty()){
                gameBoard.get(s).addFirst(gameBoard.get(b).removeFirst());
            }

            gameBoard.remove(b);

        }

}
