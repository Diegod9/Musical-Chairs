import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;


public class MusicalChairs {

    public static void main(String[] args) {


        LoopList<Integer> MuscialChairsLoopList = new LoopList<>();
        int poolSize = 0;


        //Getting # of players
        //Assigning players to size
        //Printing out # of players
        Scanner ui = new Scanner(System.in);
        System.out.println("Please enter the number of players below");
        poolSize = ui.nextInt();



        //Getting "flavor" text
        //Tokenizing that text
        //Using tokens as a count
        Scanner ui2 = new Scanner(System.in);
        System.out.println("Please enter your flavor text: ");
        String flavorText = ui2.nextLine();
        int count = new StringTokenizer(flavorText, " ").countTokens();


        //Making MusicalChairIterator
        //Populating MusicalChairLoopList with number of players
        //Breaks out of loop when the size of the list equals the number of players the user inputed
        Iterator<Integer> MusicalChairIterator = MuscialChairsLoopList.iterator();

            for (int i = 0; i < poolSize; i++) {

                MuscialChairsLoopList.add(i);
            }

        //Loop through the List
        //Prints out flavor text and position of the node that get removed
        //Jumps out of loop once the size = 1
        //Prints out position of remaining Node
        System.out.println("Lets start the game");
        while (MusicalChairIterator.hasNext() && MuscialChairsLoopList.size != 1){
            for (int i = 0; i < count; i++){
                i = i;

            }

            System.out.println();
            System.out.println(flavorText);
            System.out.println();
            System.out.println("Position " + MuscialChairsLoopList.get() + " is removed");
            MusicalChairIterator.next();
            MusicalChairIterator.remove();
            MuscialChairsLoopList.size--;
        }

        System.out.println();
        System.out.println("Winner is position " + MuscialChairsLoopList.get());

    }
}







