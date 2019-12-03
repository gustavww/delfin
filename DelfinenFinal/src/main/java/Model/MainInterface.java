
package Model;

import java.util.Scanner;

public class MainInterface {
    
    MethodDirectory directory = new MethodDirectory();
    Scanner input = new Scanner(System.in);
    
    public void runProgram(){
        
        while(true){
            startText();
            int switchInput = input.nextInt();
            
            
            switch (switchInput) {
                
                case 1:
                newMember(true);
                break;
                    
                case 2:
                insertCompetition();  
                break;
                        
                case 3:    
                deleteMember();
                break;
                    
                case 4:
                removeCompetition();
                break;
                    
                case 5:
                updateBestTime();
                break;
                
                case 6:
                showTopFive();
                break;
                    
            } 
        }
    }
    
    public void newMember(boolean insert){
        while(insert){
            System.out.println("Enter member name: ");
            String name = input.next();
            name += input.nextLine();
            
            System.out.println("Enter age: ");
            int age = input.nextInt();
            
            System.out.println("Enter telephone number: ");
            int tlf = input.nextInt();
            
            System.out.println("Enter address: ");
            String address = input.next();
            address += input.nextLine();
            
            System.out.println("Enter 1 for active membership and 0 for inactive:");
            int status = input.nextInt();
            
            Medlem medlem1 = new Medlem(name, age, tlf, address, status);
            directory.Insert(medlem1);
            
            System.out.println("Do you want to enter more members?");
            System.out.println("Press 1 if yes, or press 2 to cancel.");
            int svar = input.nextInt();
            
            if(svar != 1){
                break;
            }
        }
    }
    
    public void insertCompetition(){
        System.out.println("Enter the ID of the member you want to insert into competition:");
        int id = input.nextInt();
    
        directory.InsertKonkurrence(id);
    }
    
    public void updateBestTime(){
        System.out.println("Enter the ID of the member whose best time you want to update:");
        int id = input.nextInt();
        
        disciplineText();
        System.out.println("Enter the discipline you want to update the score of:");
        int svar = input.nextInt();
        
        String disciplin = disciplineSvar(svar);
         
        System.out.println("Enter the new score:");
        int nummer = input.nextInt();
        
        directory.Update(disciplin, id, nummer);
    }
    
    public void deleteMember(){
        System.out.println("Enter the ID of the member you want to remove:");
        int id = input.nextInt();
        directory.Remove(id);
    }
    
    public void removeCompetition(){
        System.out.println("Enter the ID of the member whose competition membership you want to remove:");
        int id = input.nextInt();
        directory.RemoveKonkurrence(id);
    }
    
    public void showTopFive(){
        disciplineText();
        System.out.println("Enter the discipline that you want to see the top 5 of:");
        int svar = input.nextInt();
        
        String discipline = disciplineSvar(svar);
         
        directory.showTopFive(discipline);    
    }
    
    public void startText(){
        System.out.println("Enter 1 to insert new member.");
        System.out.println("Enter 2 to insert new competition member.");
        System.out.println("Enter 3 to remove a member.");
        System.out.println("Enter 4 to remove a member from competitions.");
        System.out.println("Enter 5 to insert update best time in member's discipline.");
        System.out.println("Enter 6 to show the top five of a given discipline.");
    }
    
    public void disciplineText(){
        System.out.println("1: crawl.");
        System.out.println("2: butterfly.");
        System.out.println("3: rygcrawl.");
        System.out.println("4: brystsvømning.");
    }
    
    public String disciplineSvar(int svar){
        String discipline;
        if(svar == 1){
            discipline = "crawl";
        }
        else if(svar == 2){
            discipline = "butterfly";
        }
        else if(svar == 3){
            discipline = "rygcrawl";
        }
        else {
            discipline = "brystsvømning";
        }   
        return discipline;
    }
    
    public static void main(String[] args) {
        MainInterface face = new MainInterface();
        face.runProgram();
    }
}
