    import java.util.ArrayList;
    import java.util.Scanner;
    
    public class MyProgram{
        public static void main(String[] args) {
            Scanner input= new Scanner(System.in);
           
            Connections trial = new Connections();

            trial.printGame();
            ArrayList<String[]> correctGuesses = new ArrayList<String[]>();  
           
            int errors=0;
            String[] guesses = new String[4]; 
            while(errors<4 && trial.getKey().size() != 0){
                System.out.println("Type 4 words from the bank in order: ");
                for(int i=1; i<5; i++){
                    System.out.println("Enter guess " + i);
                    guesses[i-1] = input.nextLine();  
                }
                if(trial.checkGuess(guesses)){
                    correctGuesses.add(trial.getKey().get(trial.getIndexofRightGuess()));
                    trial.removeFromKey(trial.getIndexofRightGuess());
                    System.out.println("You're right!");
                    for(String[] category:correctGuesses){
                        System.out.println(); 
                        for(String word:category){
                            System.out.print(word+": "); 
                        }
                    }
                    trial.printGame(); 
                }else{
                    System.out.println("Try Again :)");
                    errors++;
                    trial.printGame();
                    for(String[] category:correctGuesses){
                        System.out.println(); 
                        for(String word: category){
                            System.out.print(word+" "); 
                        }
                    }  
                }
                }
                if(errors==4){
                    System.out.println("Game Over");
                    trial.printKey(); 
                }else{
                    System.out.println("Congrats! You won!");
                } 
                input.close();
        }
    }
