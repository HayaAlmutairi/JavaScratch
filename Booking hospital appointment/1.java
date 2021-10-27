/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment4 ;

import java.util.Scanner;

public class Assignment4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int ICU_start=480;   //8*60//
        final int ICU_end=1080; //18*60  
        
        int Radiology_start=540;   //9*60
        final int Radiology_end=1020; //17*60
        
         int Surgery_start=570;  //9*60+30
        final int Surgery_end=1230;//20*60+30
        
        int Dentistry_start=600;//10*60   
        final int Dentistry_end=960; //16*60
        
        Scanner input=new Scanner(System.in);
        String ch;
        int fee,timeToPrint;
        do{
            printMsg("MainMenu");
            ch=input.next();
            if(ch.equalsIgnoreCase("Book")){
                System.out.println("");
                char bookCh=readAndVerify();
                String clinic="";
                fee=0;
                timeToPrint=0;
                boolean available=false;
                switch(bookCh){
                    case 'I':
                    case 'i':
                        clinic="ICU"; 
                        fee=1000;
                        break;
                    case 'R':
                    case 'r':
                        clinic="Radiology"; 
                        fee=200;                        
                        break;
                    case 'S':
                    case 's':
                        clinic="Surgery"; 
                        fee=3000;                        
                        break;
                    case 'D':
                    case 'd':
                        clinic="Dentistry:"; 
                        fee=150;                        
                        break;
                }
                switch(bookCh){
                    case 'I':
                    case 'i': 
                        timeToPrint=ICU_start;
                        available = ICU_start <= ICU_end;
                        break;
                    case 'R':
                    case 'r':
                        timeToPrint=Radiology_start;
                        available = Radiology_start <= Radiology_end;                        
                        break;
                    case 'S':
                    case 's': 
                        timeToPrint=Surgery_start;
                        available = Surgery_start <= Surgery_end;                        
                        break;
                    case 'D':
                    case 'd': 
                        timeToPrint=Dentistry_start;
                        available = Dentistry_start <= Dentistry_end;                        
                        break;
                }
                if(available==true){
                    Scanner input2=new Scanner(System.in);
                    System.out.println("");
                    System.out.print("	Enter the name (first and last): ");
                    String name=input2.nextLine();
                    System.out.print("	Enter the national ID number:  ");
                    int nationalID=input.nextInt();
                    //-----------------------------
                    int hours=timeToPrint/60;
                    int minutes=timeToPrint%60;
                    String type="AM";
                    if(hours>=12){
                        if(hours>12)
                            hours=hours-12;
                        type="PM";
                    }
                    String m;
                    if(minutes<9)
                        m=("0"+minutes);
                    else 
                        m=(""+minutes);
                    String h;
                    if(hours<9)
                        h=("0"+hours);
                    else
                        h=(""+hours);
                    String time=h+":"+m+" "+type;                    
                    //-----------------------------
                    System.out.println("	The appointment will be at "+time);
                    System.out.print("	Press 1 to confirm, 2 to cancel : ");
                    int conf=input.nextInt();
                    if(conf==1){
                        Assignment4.displayInfo(nationalID,name,timeToPrint,clinic,fee);
                        //increase variable based on book type
                        if(bookCh=='I'||bookCh=='i'){
                            ICU_start+=60; 
                        }
                        else if(bookCh=='R'||bookCh=='r'){
                            Radiology_start+=60;
                        }
                        else if(bookCh=='S'||bookCh=='s'){
                            Surgery_start+=60;
                        }
                        else if(bookCh=='D'||bookCh=='d'){
                            Dentistry_start+=60;
                        }

                    }
                    System.out.println("");
                }
            }
            else if(ch.equalsIgnoreCase("Add")){
                System.out.println("");
                char clinicChoice=readAndVerify(); 
                String clinic="";
                Scanner input2=new Scanner(System.in);
                String name="",phone="";
                int nationalID=0,age=0;
                System.out.println("");
                switch(clinicChoice){
                    case 'I':case 'i': 
                        clinic="ICU";   
                        System.out.println("");
                        System.out.print("	Enter the name (first and last): ");
                        name=input2.nextLine();
                        System.out.print("	Enter the national ID number:  ");
                        nationalID=input.nextInt();               
                        System.out.print("	Enter your age: ");
                        age=input.nextInt();
                        System.out.print("	Enter your mobile number (###-###-####):  ");
                         phone=input.next();
                    break;
                    case 'R':case 'r': 
                        clinic="RADIOLOGY"; 
                        System.out.println("");
                        System.out.print("	Enter the name (first and last): ");
                        name=input2.nextLine();
                        System.out.print("	Enter the national ID number:  ");
                        nationalID=input.nextInt();               
                        System.out.print("	Enter your age: ");
                        age=input.nextInt();
                        System.out.print("	Enter your mobile number (###-###-####):  ");
                         phone=input.next();                        
                        break;
                    case 'S':case 's': 
                        clinic="Surgery";
                        System.out.println("");
                        System.out.print("	Enter the name (first and last): ");
                        name=input2.nextLine();
                        System.out.print("	Enter the national ID number:  ");
                        nationalID=input.nextInt();               
                        System.out.print("	Enter your age: ");
                        age=input.nextInt();
                        System.out.print("	Enter your mobile number (###-###-####):  ");
                         phone=input.next();                        
                    break;
                    case 'D':case 'd':
                        clinic="DENTISTRY";  
                        System.out.println("");
                        System.out.print("	Enter the name (first and last): ");
                        name=input2.nextLine();
                        System.out.print("	Enter the national ID number:  ");
                        nationalID=input.nextInt();               
                        System.out.print("	Enter your age: ");
                        age=input.nextInt();
                        System.out.print("	Enter your mobile number (###-###-####):  ");
                         phone=input.next();                        
                        break;
                }                
                double weight,height;
                System.out.print("	Enter your weight in Kilogram: ");
                weight=input.nextDouble();
                System.out.print("	Enter your height in Centimeter: ");
                height=input.nextDouble();
                displayInfo(nationalID,name,age,phone,clinic,weight,height);   
            }
            else if(!ch.equalsIgnoreCase("Exit")){
                System.out.println("");
                System.out.println("	Wrong Selection of Service Type!");
                System.out.println("");
            }
        }while(ch.equalsIgnoreCase("Exit")==false);
    }

    
    public static void displayMainMenu() {
        System.out.println("----------------------------------------------------------------"); 
        System.out.println("	Welcome to the Jeddah National Hospital Administration");
        System.out.println("----------------------------------------------------------------"); 
        System.out.println("	Enter \"Book\" to book a new appointment");
        System.out.println("	Enter \"Add\" to add a new patient");
        System.out.println("	Enter \"Exit\" to exit the program");
        System.out.print("Enter your Choice: ");
    }

    public static char readAndVerify() {
        Scanner input=new Scanner(System.in);
        char ch;
        do{
            printMsg("DepartmentMenu");
            System.out.print("Enter your Choice: ");
            ch=input.next().charAt(0);
            if(!(ch=='I'||ch=='i'||ch=='R'||ch=='r'||ch=='S'||ch=='s'||ch=='D'||ch=='d')){
                System.out.println("");
                System.out.println("	Wrong Selection of clinic... try again!"); 
                System.out.println("");
            }
        }while(!(ch=='I'||ch=='i'||ch=='R'||ch=='r'||ch=='S'||ch=='s'||ch=='D'||ch=='d'));
        return ch;
    }
    public static void printMsg(String menu){
        if(menu.equals("MainMenu")){
            displayMainMenu();
        }
        else if(menu.equals("DepartmentMenu")){
            System.out.println("	-------------------------------------------------");
            System.out.println("	DEPARTMENT: please select the correct department:");
            System.out.println("	-------------------------------------------------");
            System.out.println("	Enter I or i for ICU:");
            System.out.println("	Enter R or r for Radiology:");
            System.out.println("	Enter S or s for Surgery:");    
            System.out.println("	Enter D or d for Dentistry:"); 
        }
        else
            System.out.println(menu);
        
    }
    public static void displayInfo( int id, String name,int time, String clinic, int fee) {       
        System.out.println("");
        System.out.println("");
        System.out.println("			-------------------------------------------------");
        System.out.println("			    Information Details for Booking Appointment");
        System.out.println("			-------------------------------------------------");
        System.out.println("");
        System.out.printf("Name                    : %-25s   National ID Number         : %7d%n",name.toUpperCase(),id);
        
        int hours=time/60;
        int minutes=time%60;
        String type="AM";
        if(hours>=12){
            if(hours>12)
                hours=hours-12;
            type="PM";
        }
        String m;
        if(minutes<9)
            m=("0"+minutes);
        else 
            m=(""+minutes);
        String h;
        if(hours<9)
            h=("0"+hours);
        else
            h=(""+hours);
        
        String stime;
        if(minutes==0)
            stime=hours+" "+type; 
        else
            stime=h+":"+m+" "+type; 
        System.out.printf("Clinic                  : %-25s   Appointment Time           : %s%n",clinic,stime);
        System.out.printf("Appointment fee         : %d S.R",fee);
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("---------------------------Redirect to the main menu-----------------------------------------------");
        System.out.println("");
    }

    public static void displayInfo(int id, String name,  int age, String phone, String clinic, double weight, double height) {
        double BMI=(weight/((height/100)*(height/100)));
        String res="";
        if(BMI<=18.5){
            res="Underweight";
        }
        else if(BMI>18.5 && BMI< 25.0){
            res="Normal";
        }
        else if(BMI>=25.0 && BMI<= 30.0){
            res="Overweight";
        }
        else if(BMI>30.0)
                res="Obese";         
        System.out.println("");
        System.out.println("");
        System.out.println("			-------------------------------------------------");
        System.out.println("			    Information Details for Adding Patient");
        System.out.println("			-------------------------------------------------");
        System.out.println("");
        System.out.printf("Name                    : %-25s   National ID Number         : %7d%n",name.toUpperCase(),id);
        System.out.printf("Age                     : %-25d   Phone number               : %s%n",age,phone);
        System.out.printf("Clinic                  : %-25s   Weight                     : %.2f kg%n",clinic,weight);        
        System.out.printf("BMI                     : %-25s   Height                     : %.2f cm%n",res,height);
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("---------------------------Redirect to the main menu-----------------------------------------------");        
    }
    
}