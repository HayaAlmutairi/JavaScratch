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
        // TODO code application logic here
        Scanner input=new Scanner(System.in);
        intro();
        int index=0;
        int[] game_stat=new int[300];
        for (int i = 0; i < game_stat.length; i++) {
            game_stat[i]=1;
        }
        char userChoice='0';
        while(userChoice!='n'&&userChoice!='N'){
            String word=getSecretWord();
            char[] sLetter=new char[word.length()];
            int i = sLetter.length-1;
            for (; i >=0 ; ) { //fill array with under score chars
                sLetter[i]='_';
                i--;
            }
            if(!playOneGame(word, sLetter))
                game_stat[index]=0;
            System.out.println("Do you want to play again (y / n):");
            userChoice=input.next().charAt(0);
            index++;
        }
        getStat(game_stat, index);
    }
    public static void intro(){
        System.out.println("Hangman Game!\nI will think of a random word.\nYou'll try to guess its letters.\nTry guess correctly to avoid loses!");
    }
    public static String getSecretWord(){
        String[] word_list = { "ruby", "python", "java", "fortran", "", "" };
        word_list[4]="html";
        word_list[5]="php";
        int random= (int)(Math.random() * (5 + 1)) + 0;
        return word_list[random];
    }
    public static boolean playOneGame(String secret_word,char[] secret_letter){
        Scanner input=new Scanner(System.in);
        int tries=5, numCorrect=0;
        boolean done=false;
        char[] misses=new char[5];
        do{
            String line="-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-";
            System.out.println(line);
            System.out.println("You have "+tries+" trials left.");
            System.out.print("Word:	");
            for (int i = 0; i < secret_letter.length; i++) {
                System.out.print(secret_letter[i]+" ");
            }
            System.out.println("\n");
            System.out.print("Enter your Guess Letter: ");
            char userGuess=input.next().charAt(0);
            boolean valid=correctGuess(secret_word, secret_letter, userGuess);
            if(!valid){
                misses[5-tries]=userGuess;
                System.out.println("");
                System.out.print("Misses:  ");
                tries--;
                for (int j = 0; j < (5-tries); j++) {
                    System.out.print(misses[j]+" ");
                }
                System.out.println("");
            }
            else{
                int incrementValue=1;
                numCorrect=numCorrect+incrementValue;
            }
            int state=winningState(secret_letter);
            done=(state==0);
        }while(!done && tries>0);
        System.out.println("************************************");
        System.out.println("Your Attempt Status: ");
        System.out.println("_____________________");
        System.out.println(" number of wrong guess is = "+(5-tries));
        System.out.println(" number of correct guesses is = "+numCorrect);
        if(!done){
            System.out.println("\n");
            System.out.printf("Wrong :( ,The word was...%s%n",secret_word);
            System.out.println("\n");
            return false;
        }
        else{
            System.out.println("\n");
            System.out.printf("You did it right :) , The word is:  %s%n",secret_word);
            System.out.println("");
            return true;
        }
    }
    public static boolean correctGuess(String secret_word,char[] secret_letter,char guessLetter){
        boolean exist=false;
        int i = 0;
        for (   ; i < secret_word.length(); i++) {
            if(Character.toLowerCase(guessLetter)==Character.toLowerCase(secret_word.charAt(i))){
                secret_letter[i]=guessLetter;
                exist=true;
            }
        }
        return exist;
    }
    public static int winningState(char[] secret_letter){
        int count=0;
        for (int i = 0; i < secret_letter.length; i++) {
            if(secret_letter[i]=='_'){
                int incrementValue=1;
                count=count+incrementValue;
            }
        }
        return count;
    }
    public static void getStat(int[] game_stat,int index){
        System.out.println("Your final Profile status:");
        System.out.println("____________________________");
        System.out.println("total number of Hangman games played  = "+(index));
        int count1=0,count2=0;
        for (int i = 0; i < index; i++) {
            if(game_stat[i]==1)
                count1++;
            else
                count2++;
        }
        String totalStr="total number of ";
        System.out.println(totalStr+"won games  = "+count1);
        System.out.println(totalStr+"loss games  = "+count2);
    }
}
