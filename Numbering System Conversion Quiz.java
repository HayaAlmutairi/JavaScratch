/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment3;

import java.util.Scanner;

public class Assignment3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("		************************************************");
        System.out.println("		Welcome to the Numbering System Conversion Quiz!");
        System.out.println("		************************************************");
        System.out.println("");
        System.out.println("The quiz consists of 8 random questions on converting between Decimal, Binary, ");
        System.out.println("and Hexadecimal numbers. You have a maximum number of 3 trials per question.");
        System.out.println("");
        System.out.print("Please enter 1 to start the quiz or 0 to exit: ");
        int status=input.nextInt();
        System.out.println();
        while(status!=0){
            int grade=0;
            //definition variables section
            String status1="",status2="",status3="",status4="";
            String status5="",status6="",status7="",status8="";
            int dec1=0,dec2=0,dec3=0,dec4=0;
            int input5=0,input6=0,input7=0,input8=0;
            String input1="",input2="",input3="",input4="";
            String hexa1="",hexa2="",bin1="",bin2="";
            //-------------------------------------------//
            long startTime = System.currentTimeMillis();
            for (int index = 0; index < 2; index++) {
                int decimal= (int)(Math.random() * ((255 - 0) + 1));
                String hexaValue="";
                if(decimal!=0){
                    int num=decimal;
                    while(num>0){
                        int rem=num%16;
                        String currentNum="";
                        if(rem<10)
                            currentNum+= rem;
                        else{
                            char charStr=(char)('A'+(rem-10));
                            currentNum+= charStr;
                        }
                        hexaValue=currentNum+hexaValue;
                        num=num/16;
                    }
                }
                else{
                    hexaValue="0";
                }                
                int  attempts=0;
                boolean correct;
                String userInput,choice="";
                do{
                    System.out.printf("Please enter the equivalent Hexadecimal number of %d: ",decimal);
                    userInput=input.next();            
                    if(attempts==0)
                        choice=userInput;
                    correct= (hexaValue.equals(userInput));
                    attempts++;
                    if(correct){
                        System.out.println("");
                        System.out.println("	Correct Answer!");
                        System.out.println("");
                        choice=userInput;
                        grade+=2;
                    }
                    else if(attempts<3 && !correct){
                        System.out.println("");
                        System.out.println("	Wrong Answer! ");
                        System.out.println("");
                    }
                    else if(attempts==3&& !correct){
                        System.out.println("");
                        System.out.println("	Sorry, you have exceeded the maximum number of trials for this question!");
                        System.out.println("");
                    }
                    
                }while(attempts<3 && !correct);
                if(index==0){
                    input1=choice;
                    status1=(correct?"correct":"wrong");
                    dec1=decimal;
                }
                if(index==1){
                    input2=choice;
                    status2=(correct?"correct":"wrong");
                    dec2=decimal;
                }
            }
            for (int index = 0; index < 2; index++) {
                int decimal= (int)(Math.random() * ((255 - 0) + 1));
                String binValue="";
                if(decimal!=0){
                    int n=decimal;
                    while(n>0){
                        int rem=n%2;
                        binValue=rem+binValue;
                        n=n/2;
                    }
                }
                else{
                    binValue="0";
                }
                int  attempts=0;
                boolean correct;
                String userInput,choice="";
                do{
                    System.out.printf("Please enter the equivalent Binary number of %d: ",decimal);
                    userInput=input.next();                    
                    if(attempts==0)
                        choice=userInput;
                    correct= (binValue.equals(userInput));
                    attempts++;
                    if(correct){
                        System.out.println("\n	Correct Answer!\n");
                        choice=userInput;
                        grade+=2;
                    }
                    else if(attempts<3 && !correct){
                        System.out.println("");
                        System.out.println("	Wrong Answer! ");
                        System.out.println("");
                    }
                    else if(attempts==3&& !correct){
                        System.out.println("");
                        System.out.println("	Sorry, you have exceeded the maximum number of trials for this question!");
                        System.out.println("");
                    }
                    
                }while(attempts<3 && !correct);
                if(index==0){
                    status3=(correct?"correct":"wrong");
                    dec3=decimal;
                    input3=choice;
                }
                else{//index==1
                    status4=(correct?"correct":"wrong");
                    dec4=decimal;
                    input4=choice;
                }
            }
            for (int i = 0; i < 2; i++) {
                String part;
                String hexValue="";
                int decimal=0;
                for (int j = 0; j < 2; j++) {
                    int digit  = (int)(Math.random() * (16));
                    if(digit<10)
                        part=String.valueOf(digit);
                    else
                        part=""+(char)('A'+(digit-10));
                    hexValue=part+hexValue;
                    decimal+=digit*((int)Math.pow(16, j));
                }

                int  attempts=0;
                boolean correct;
                int userInput,choice=0;
                do{
                    System.out.printf("Please enter the equivalent Decimal number of %s: ",hexValue);
                    userInput=input.nextInt();                    
                    if(attempts==0)
                        choice=userInput;
                    correct= (decimal==userInput);
                    attempts++;
                    if(correct){
                        System.out.println("\n	Correct Answer!\n");
                        choice=userInput;
                        grade+=2;
                    }
                    else if(attempts<3 && !correct){
                        System.out.println("");
                        System.out.println("	Wrong Answer! ");
                        System.out.println("");
                    }
                    else if(attempts==3&& !correct){
                        System.out.println("");
                        System.out.println("	Sorry, you have exceeded the maximum number of trials for this question!");
                        System.out.println("");
                    }
                    
                }while(attempts<3 && !correct);
                if(i==0){
                    input5=choice;
                    status5=(correct?"correct":"wrong");
                    hexa1=hexValue;
                }
                else{
                    input6=choice;
                    status6=(correct?"correct":"wrong");
                    hexa2=hexValue;
                }
            }
            for (int i = 0; i < 2; i++) {
                String binValue="";
                for (int j = 0; j < 8; j++) {
                    int digit  = (int)(Math.random() * (2));
                    binValue+=digit;
                }
                int  attempts=0;
                boolean correct;
                int userInput,choice=0;
                do{
                    System.out.printf("Please enter the equivalent Decimal number of %s: ",binValue);
                    userInput=input.nextInt();
                    if(attempts==0)
                        choice=userInput;
                    int decimal=0;
                    for (int j = 7; j >=0; j--) {
                        int index=(7-j);
                        decimal +=Character.getNumericValue(binValue.charAt(j))*(int)Math.pow(2, index);
                    }
                    correct= (decimal==userInput);
                    attempts++;
                    if(correct){
                        System.out.println("\n	Correct Answer!\n");
                        choice=userInput;
                        grade+=2;
                    }
                    else if(attempts<3 && !correct){
                        System.out.println("");
                        System.out.println("	Wrong Answer! ");
                        System.out.println("");
                    }
                    else if(attempts==3&& !correct){
                        System.out.println("");
                        System.out.println("	Sorry, you have exceeded the maximum number of trials for this question!");
                        System.out.println("");
                    }
                    
                }while(attempts<3 && !correct);
                if(i==0){
                    input7=choice;
                    status7=(correct?"correct":"wrong");
                    bin1=binValue;
                }
                else{
                    input8=choice;
                    status8=(correct?"correct":"wrong");
                    bin2=binValue;
                }
            }
            long endTime = System.currentTimeMillis();
            double  totaltime= ((endTime-startTime)/1000.0)/60;
            System.out.println();
            System.out.println("		************************************");
            System.out.printf("		Time taken to complete the quiz: %.1f minutes%n",totaltime);
            double score=(grade/16.0)*100.0;
            System.out.println("		Score is: "+score+"%");
            if(score>=60)
                System.out.println("		Congratulations, you have passed!");
            else
                System.out.println("		You didn’t pass the quiz!");
            System.out.println("		************************************");
            System.out.println();
            System.out.println("Detailed Results:");
            System.out.println("---------------------");
            System.out.println("The equivalent Hexadecimal number of "+dec1+" is "+input1+": "+status1);
            System.out.println("The equivalent Hexadecimal number of "+dec2+" is "+input2+": "+status2);
            System.out.println("The equivalent Binary number of "+dec3+" is "+input3+": "+status3);
            System.out.println("The equivalent Binary number of "+dec4+" is "+input4+": "+status4);
            System.out.println("The equivalent Decimal number of "+hexa1+" is "+input5+": "+status5);
            System.out.println("The equivalent Decimal number of "+hexa2+" is "+input6+": "+status6);
            System.out.println("The equivalent Decimal number of "+bin1+" is "+input7+": "+status7);
            System.out.println("The equivalent Decimal number of "+bin2+" is "+input8+": "+status8);
            System.out.println();
            System.out.println();
            System.out.print("Please enter 1 to re-take the quiz or 0 to exit: ");
            status=input.nextInt();
            
        }
        System.out.println("\n\n		*** Thank you for using this Application ***");
    }
    
}
