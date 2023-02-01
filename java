public class RockPaperScissors_EkeneAdim{
    
    //These are class constants (all methods in the class can see them). DO NOT CHANGE THEM!
    static final int ROCK = 123, PAPER = 124, SCISSORS = 125, YOU_WIN = 201, COMP_WIN = 202, DRAW = 203;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userInput;
        int yourScore=0, compScore=0;
        int currentResult;

        System.out.println("========================");
        System.out.println("ROCK-PAPER-SCISSORS GAME");
        System.out.println("========================");
        System.out.println("\nHello! Let's get started!\n=========================");

        do {
            //calling the playOneGame method
            currentResult = playOneGame(scan);
            
            if (currentResult == YOU_WIN)
                yourScore++;
            else if(currentResult == COMP_WIN)
                compScore++;
                
            printScores(yourScore,compScore);//printing the score
            
            System.out.print("Do you wish to play again? (y or n): ");
            userInput = scan.next();

        } while (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes"));
        
        System.out.println("========GAME OVER=======");
        System.out.println("       FINAL_SCORE:");
        printScores(yourScore,compScore);//printing the final score
    }


    /**
    This method "plays" the game.
    The input parameter is the Scanner object created in main()
    The method returns the int result of the game -- it should be one of the CONSTANTS!
    */
    private static int playOneGame(Scanner scan) {
        int yourChoice, compChoice;
        
        yourChoice = ROCK; 
        compChoice = ROCK; 
        
        //1. Prompt the user and use scan to read her input (R, P, or S)
        System.out.print("Rock, Paper, Scissors? (R,P,S): ");
        String poGin = scan.next(); 
        
        //2. Use a while loop to continue asking for user input if it is not 
        // one of the three above ("r", "p", or "s", ignoring case) 
        while (!poGin.equalsIgnoreCase("r") && !poGin.equalsIgnoreCase("p") && !poGin.equalsIgnoreCase("s")){
            
            System.out.println("BRRRZZZT! Sorry, that is an invalid entry! \nTry again. ");
            System.out.print("Rock, Paper, Scissors? (R,P,S): ");
            poGin = scan.next(); 
        }
        
        //3. Once the user input is satisfactory 
        //print out the choice (e.g. "You chose Rock!"),
        if (poGin.equalsIgnoreCase("r")){
            System.out.println(" Your choice:   Rock!"); 
            yourChoice = ROCK; 

        }else if(poGin.equalsIgnoreCase("p")){
            System.out.println(" Your choice:   Paper!");
            yourChoice = PAPER; 

        }else{
        System.out.println(" Your choice:   Scissors!");
        yourChoice = SCISSORS; 
//         System.out.println(yourChoice); 
        }
        //translate it to one of the int constants (ROCK, PAPER, or SCISSORS),
        //and assign to yourChoice variable (e.g. yourChoice = ROCK)
        //...
        
        //4. Use Math.random() to randomly generate computer's choice
        //One way to do it: split the range between 0 and 1 into
        int compRand = ((int)(Math.random()*3+1)); 
        // three equal intervals and if the random number is in one of them
        if(compRand == 1){
            compChoice = ROCK; 
            System.out.println(" Computer's choice: Rock!"); 
        }else if(compRand == 2){
            compChoice = PAPER;
            System.out.println(" Computer's choice: Paper!"); 
        }else{
            compChoice = SCISSORS;
            System.out.println(" Computer's choice: Scissors!"); 
            }
        // assign a corresponding constant to compChoice. There are other ways to do it.
        //Print out computer's choice as well.
        
        //Call the method whoWins using yourChoice and compChoice as parameters
        int gameResult = whoWins(yourChoice, compChoice);      
        
        //return the game result to main() (just re-returning the results from whoWins):
        return gameResult;
    }


    /**
    This method takes two int parameters yourChoice and compChoice,
    and returns the result of the game.
    
    
    It will return YOU_WIN if you win, COMP_WIN if computer wins 
    and DRAW if it is a draw. (Remember, these are constants defined in this class)
    
    In addition, the method prints out the corresponding description of
    the result of the game e.g. "It's a draw!!", 
    or "Scissors cut Paper! You WIN!".
    or "Rock is covered by Paper! You lose :(", and so on.
    */
    private static int whoWins(int yourChoice, int compChoice) {
     //    if ((compChoice == ROCK && yourChoice == ROCK)||(compChoice == PAPER && yourChoice == PAPER)||(compChoice == SCISSORS && yourChoice == SCISSORS)){
//             System.out.println("It's a draw"); 
//             return DRAW;
            
        if (yourChoice == ROCK && compChoice == SCISSORS){ 
            System.out.println("Rock blunts Scissors! You WIN!"); 
            return YOU_WIN; 
            
        }else if (yourChoice == SCISSORS && compChoice == PAPER){
            System.out.println("Scissors cuts Paper! You WIN!"); 
            return YOU_WIN;
             
        }else if (yourChoice == PAPER && compChoice == ROCK){
            System.out.println("Paper covers Rock! You WIN"); 
            return YOU_WIN; 
            
        }else if (compChoice == ROCK && yourChoice == SCISSORS){ 
            System.out.println("Rock blunts Scissors! Computer WINS!"); 
            return COMP_WIN; 
            
        }else if (compChoice == SCISSORS && yourChoice == PAPER){
            System.out.println("Scissors cuts Paper! Computer WINs!"); 
            return COMP_WIN;
             
        }else if (compChoice == PAPER && yourChoice == ROCK){
            System.out.println("Paper covers Rock! Computer WINS"); 
            return COMP_WIN; 
            
        }else /*((compChoice == ROCK && yourChoice == ROCK)||(compChoice == PAPER && yourChoice == PAPER)||(compChoice == SCISSORS && yourChoice == SCISSORS))*/{
            System.out.println("It's a draw"); 
            return DRAW;
            
        }
    }


    /**
    This method takes in yourScore and compScore as parameters and prints
    them out in a formatted way, as shown in the project description.
    */
    private static void printScores(int yourScore, int compScore) {
        System.out.println("        You : Comp \nSCORE: ---------\n\t   | "  + yourScore + " : " + compScore + " | \n\t   ---------");
    }

}
