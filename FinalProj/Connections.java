   import java.util.ArrayList;

   public class Connections{
       
        private String[][] categories; 
        private ArrayList<String[]>key=new ArrayList<String[]>(); 
        private String[][] game; 
        private static int indexOfRightGuess;   
       

        public int random(){
            return (int)(Math.random()*categories.length); 
        }

        public Connections() {
            categories = new String[][]{
                    {"Java Data Types:", "Double", "Boolean", "Int", "Char"},
                    {"Phone __:", "Number", "Book", "Call", "Line"}, 
                    {"Nail Shapes:", "Almond", "Stilleto", "Coffin", "Square"},
                    {"____ change: ", "Chump", "Climate", "Tide", "Loose"},
                    {"Food: ", "Chow", "Eats", "Grub", "Fare"},
                    {"Contribute to movie: ", "Act", "Produce", "Direct", "Write"}, 
                    {"Edit menu commands: ", "Cut", "Copy", "Paste", "Undo"},
                    {"Wallop: ", "Clock", "Deck", "Slug", "Truck"}, 
                    {"Lil __ Rappers: ", "Kim", "Baby", "Jon", "Wayne"}, 
                    {"Shades of Black: ", "Ebony", "Raven", "Onyx", "Jet"}, 
                    {"Art movements: ", "Dada", "Deco", "Gothic", "Pop"}, 
                    {"Slang for Zero: ", "Jack", "Nada", "Nothing", "Squat"}, 
                    {"Specific Shades: ", "Magenta", "Turqoise", "Peach", "Periwinkle"}, 
                    {"Nobles Hangout spots: ", "Stacks", "Foster", "Beach", "Gleason"}, 
                    {"Beach Games", "Sewy", "Spikeball", "Pickleball", "Rocket Launch"} 
            };

            int index0 = random();
            key.add(categories[index0]);

            int index1 = random(); 
            while(index1==index0){
                index1=random(); 
            }
            key.add(1, categories[index1]);

            int index2 = random(); 
            while(index2==index1 || index2==index0){
                index2=random(); 
            }
            key.add(categories[index2]);;

            int index3 = random(); 
            while(index3==index2 || index3 == index1 || index3 == index0){
                index3 = random(); 
            }
            key.add(categories[index3]);
            
        }

        public void printGame(){
            ArrayList<String> words = new ArrayList<String>(); 

            for(int r=0; r<key.size(); r++){
                for(int c=1; c<key.get(r).length; c++){
                    words.add(key.get(r)[c]); 
                }
            }

            for(int r=0; r<words.size(); r++){
                for(int c=0; c<4; c++){
                    int randomIndex = (int)(Math.random()*words.size()); 
                    System.out.print(words.get(randomIndex) + " ");
                    words.remove(randomIndex); 
                }
                System.out.println(); 
            }
        }

        public void printKey(){
            for(int r=0; r<4; r++){
                for(int c=0; c<key.get(r).length; c++){
                    System.out.print((key.get(r))[c] + ", ");
                }
                System.out.println(); 
            }
        } 

        public boolean checkGuess(String[] guesses){
            for(int r = 0; r<key.size(); r++){
                int count = 0; 
                for(String realWord:key.get(r)){
                    for(int i=0; i<guesses.length; i++){
                        if(guesses[i].equals(realWord)){
                            count++; 
                        }
                    }
                }
                if(count==4){
                    indexOfRightGuess=r; 
                    return true;

                }
            }
            return false; 
        }

        public void removeFromKey(int idx){
            key.remove(idx); 
        }

        public ArrayList<String[]> getKey(){
            return key; 
        }

        public int getIndexofRightGuess(){
            return indexOfRightGuess; 
        }

}



