/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment5;

import java.util.Scanner;

public class Assignment5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        intro();
        int index=0;
        String playsCase="", word;
        char choice;
        do{
            word=getSecretWord();
            char[] secretLetters=new char[word.length()];
            for (int i = secretLetters.length-1; i >= 0; i--) 
                secretLetters[i]='_';
            playsCase+=(playOneGame(word, secretLetters))?"1":"0";
            System.out.println("Do you want to play again (y / n):");
            choice=input.next().charAt(0);
            index++;
        }while(choice=='y'||choice=='Y');
        int[] game_stat=new int[playsCase.length()]; 
        for (int i = 0; i < playsCase.length(); i++) 
            game_stat[i]=Integer.parseInt(""+playsCase.charAt(i)+"");
        getStat(game_stat, index);
    }
    public static void intro(){
        System.out.println("Hangman Game!");
        System.out.println("I will think of a random word.");
        String msg="You'll try to guess its letters.\nTry guess correctly to avoid loses!\n";
        System.out.print(msg);
    }
    public static String getSecretWord(){
        
        String[] words = { "", "python", "java", "fortran", "html", "php" };
        words[0]="ruby";
        return words[((int)(Math.random() * (6)))];
    }
    public static boolean playOneGame(String secret_word,char[] secret_letter){
        Scanner input=new Scanner(System.in);
        int tries=5, numCorrect=0;
        boolean solved=false;
        String misses="";
        do{
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("You have "+tries+" trials left.");
            System.out.print("Word:	");
            System.out.print(secret_letter[0]+" ");
            for (int i = 1; i < secret_letter.length; i++) {
                System.out.print(secret_letter[i]+" ");
            }
            System.out.println("\n");
            System.out.print("Enter your Guess Letter: ");
            char ch=input.next().charAt(0);
            boolean isCorrect=correctGuess(secret_word, secret_letter, ch);
            if(isCorrect)
                numCorrect++;
            else{
                misses+=ch+" ";
                System.out.println("");
                System.out.println("Misses:  "+misses);
            }
            if(!isCorrect)
                tries--;
                
            int state=winningState(secret_letter);
            if(state==0)
                solved=true;
        }while(!solved && tries>0);
        printAttemps(solved,tries,numCorrect,secret_word);
        return solved;
    }
    public static boolean correctGuess(String secret_word,char[] secret_letter,char guessLetter){
        boolean exist=false;
        int i = 0;
        while ( i < secret_word.length()) {
            if(Character.toLowerCase(secret_word.charAt(i))==Character.toLowerCase(guessLetter)){
                secret_letter[i]=guessLetter;
                exist=true;
            }
            i++;
        }
        return exist;
    }
    public static int winningState(char[] secret_letter){
        int count=0;
        for (int i = 0; i < secret_letter.length; i++) {
            char underScore='_';
            if(secret_letter[i]==underScore)
                count++;
        }
        return count;
    }
    public static void getStat(int[] game_stat,int index){
        System.out.println("Your final Profile status:");
        System.out.println("____________________________");
        System.out.println("total number of Hangman games played  = "+(index));
        int winCount=0;
        for (int i = 0; i < index; i++)
            if(game_stat[i]==1)
                winCount++;
        System.out.println("total number of won games  = "+winCount);
        System.out.println("total number of loss games  = "+(index-winCount));
    }

    public static void printAttemps(boolean solved,int tries, int numCorrect, String secret_word) {
        System.out.println("************************************");
        System.out.println("Your Attempt Status: ");
        System.out.println("_____________________");
        System.out.println(" number of wrong guess is = "+(5-tries));
        System.out.println(" number of correct guesses is = "+numCorrect);
        if(solved){
            System.out.println("");
            System.out.println("");
            System.out.println("You did it right :) , The word is:  "+secret_word);
            System.out.println("");
        }
        else{
            System.out.println("");
            System.out.println("");
            System.out.println("Wrong :( ,The word was..."+secret_word);
            System.out.println("");
            System.out.println("");
        }        
    }
}
