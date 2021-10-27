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
        final int S_ICU=480;          //start time in minutes  = (8 am)
        final int S_Radiology=540;    //start Time in minutes  = (9 am)
        final int S_Surgery=570;   //start time in minutes     = (9:30 am)
        final int S_Dentistry=600;   //start time in minutes   = (10 am)
        
        final int E_ICU=1080;          //end time in minutes  = (6 pm)
        final int E_Radiology=1020;    //end time in minutes  = (5 pm)
        final int E_Surgery=1230;   //end time in minutes  = (8:30 pm)
        final int E_Dentistry=960;    //end time in minutes  = (4 pm)
        
        int I_Time=S_ICU;        //initial value
        int R_Time=S_Radiology;  //initial value
        int S_Time=S_Surgery;    //initial value
        int D_Time=S_Dentistry;  //initial value
        Scanner input=new Scanner(System.in);
        String choice;
        do{
            displayMainMenu();
            String userInput=input.next();
            choice=userInput;
            if(choice.equalsIgnoreCase("Book")){
                System.out.println("");
                char bookChoice=readAndVerify();
                switch(bookChoice){
                    case 'I':
                    case 'i': 
                        if(I_Time <= E_ICU){
                            System.out.println("");
                            System.out.print("	Enter the name (first and last): ");
                            String fname,lname;
                            fname=input.next();   lname=input.next();
                            String name=fname+" "+lname;
                            System.out.print("	Enter the national ID number:  ");
                            int nationalID=input.nextInt();
                            String tFormat=formatTime(I_Time); //call format time
                            System.out.println("	The appointment will be at "+tFormat);
                            System.out.print("	Press 1 to confirm, 2 to cancel : ");
                            int confirm=input.nextInt();
                            if(confirm==1){
                                displayInfo(nationalID,name,I_Time,"ICU",1000);
                                switch(bookChoice){
                                    case 'I': case 'i': I_Time+=60; break; //increase ICU Time
                                    case 'R': case 'r': R_Time+=60; break; //increase Radiology Time
                                    case 'S': case 's': S_Time+=60; break; //increase Surgery Time
                                    case 'D': case 'd': D_Time+=60; break;   //increase Dentistry Time
                                }
                            }
                            System.out.println("");                            
                        }
                        else
                            System.out.println("sorry Clinic Closed");
                        break;
                    case 'R':
                    case 'r':
                        if(R_Time <= E_Radiology){
                            System.out.println("");
                            System.out.print("	Enter the name (first and last): ");
                            String fname,lname;
                            fname=input.next();   lname=input.next();
                            String name=fname+" "+lname;
                            System.out.print("	Enter the national ID number:  ");
                            int nationalID=input.nextInt();
                            String tFormat=formatTime(R_Time); //call format time
                            System.out.println("	The appointment will be at "+tFormat);
                            System.out.print("	Press 1 to confirm, 2 to cancel : ");
                            int confirm=input.nextInt();
                            if(confirm==1){
                                displayInfo(nationalID,name,R_Time,"Radiology",200);
                                switch(bookChoice){
                                    case 'I': case 'i': I_Time+=60; break; //increase ICU Time
                                    case 'R': case 'r': R_Time+=60; break; //increase Radiology Time
                                    case 'S': case 's': S_Time+=60; break; //increase Surgery Time
                                    case 'D': case 'd': D_Time+=60; break;   //increase Dentistry Time
                                }
                            }
                            System.out.println("");                            
                        }else
                            System.out.println("sorry Clinic Closed");
                        
                        break;
                    case 'S':
                    case 's': 
                        if(S_Time <= E_Surgery){
                            System.out.println("");
                            System.out.print("	Enter the name (first and last): ");
                            String fname,lname;
                            fname=input.next();   lname=input.next();
                            String name=fname+" "+lname;
                            System.out.print("	Enter the national ID number:  ");
                            int nationalID=input.nextInt();
                            String tFormat=formatTime(S_Time); //call format time
                            System.out.println("	The appointment will be at "+tFormat);
                            System.out.print("	Press 1 to confirm, 2 to cancel : ");
                            int confirm=input.nextInt();
                            if(confirm==1){
                                displayInfo(nationalID,name,S_Time,"Surgery",3000);
                                switch(bookChoice){
                                    case 'I': case 'i': I_Time+=60; break; //increase ICU Time
                                    case 'R': case 'r': R_Time+=60; break; //increase Radiology Time
                                    case 'S': case 's': S_Time+=60; break; //increase Surgery Time
                                    case 'D': case 'd': D_Time+=60; break;   //increase Dentistry Time
                                }
                            }
                            System.out.println("");                            
                        }
                        else
                            System.out.println("sorry Clinic Closed");
                        break;
                    case 'D':
                    case 'd': 
                        if(D_Time <= E_Dentistry){
                            System.out.println("");
                            System.out.print("	Enter the name (first and last): ");
                            String fname,lname;
                            fname=input.next();   lname=input.next();
                            String name=fname+" "+lname;
                            System.out.print("	Enter the national ID number:  ");
                            int nationalID=input.nextInt();
                            String tFormat=formatTime(D_Time); //call format time
                            System.out.println("	The appointment will be at "+tFormat);
                            System.out.print("	Press 1 to confirm, 2 to cancel : ");
                            int confirm=input.nextInt();
                            if(confirm==1){
                                displayInfo(nationalID,name,D_Time,"Dentistry:",150);
                                switch(bookChoice){
                                    case 'I': case 'i': I_Time+=60; break; //increase ICU Time
                                    case 'R': case 'r': R_Time+=60; break; //increase Radiology Time
                                    case 'S': case 's': S_Time+=60; break; //increase Surgery Time
                                    case 'D': case 'd': D_Time+=60; break;   //increase Dentistry Time
                                }
                            }
                            System.out.println("");                            
                        }
                        else
                            System.out.println("sorry Clinic Closed");
                        break;
                }

            }
            else if(choice.equalsIgnoreCase("Add")){
                System.out.println("");
                char clinicChoice=readAndVerify(); 
                String clinicName="";
                String customerName="";
                switch(clinicChoice){
                    case 'I':case 'i':{
                        System.out.println("");
                        System.out.print("	Enter the name (first and last): ");
                        String firstName=input.next();
                        String lastName=input.next();
                        customerName=firstName+" "+lastName;                        
                        clinicName="ICU";
                    }    break;
                    case 'R':case 'r': {
                        System.out.println("");
                        System.out.print("	Enter the name (first and last): ");
                        String firstName=input.next();
                        String lastName=input.next();
                        customerName=firstName+" "+lastName;                          
                        clinicName="RADIOLOGY";
                    } break;
                    case 'S':case 's': {
                        System.out.println("");
                        System.out.print("	Enter the name (first and last): ");
                        String firstName=input.next();
                        String lastName=input.next();
                        customerName=firstName+" "+lastName;                          
                        clinicName="Surgery";
                    } break;
                    case 'D':case 'd':{
                        System.out.println("");
                        System.out.print("	Enter the name (first and last): ");
                        String firstName=input.next();
                        String lastName=input.next();
                        customerName=firstName+" "+lastName;                          
                        clinicName="DENTISTRY";
                    }  break;
                }                
                System.out.print("	Enter the national ID number:  ");
                int nationalID=input.nextInt();               
                System.out.print("	Enter your age: ");
                int age=input.nextInt();
                System.out.print("	Enter your mobile number (###-###-####):  ");
                String phone=input.next();
                System.out.print("	Enter your weight in Kilogram: ");
                double weight=input.nextDouble();
                System.out.print("	Enter your height in Centimeter: ");
                double height=input.nextDouble();
                displayInfo(nationalID,customerName,age,phone,clinicName,weight,height);   
            }
            else if(choice.equalsIgnoreCase("Exit")){
                
            }
            else
            {
                System.out.println("");
                System.out.println("	Wrong Selection of Service Type!");
                System.out.println("");
            }
        }while(choice.equalsIgnoreCase("Exit")==false);
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
        char choice;
        do{
            String menu=("	-------------------------------------------------\n");
            menu+=("	DEPARTMENT: please select the correct department:\n");
            menu+=("	-------------------------------------------------\n");
            menu+=("	Enter I or i for ICU:\n");
            menu+=("	Enter R or r for Radiology:\n");
            menu+=("	Enter S or s for Surgery:\n");    
            menu+=("	Enter D or d for Dentistry:\n");             
            printMsg(menu);
            System.out.print("Enter your Choice: ");
            choice=input.next().charAt(0);
            if(choice!='I'&&choice!='i'&&choice!='R'&&choice!='r'&&choice!='S'&&choice!='s'&&choice!='D'&&choice!='d'){
                System.out.println("\n	Wrong Selection of clinic... try again!\n"); 
            }
            else
                break;
        }while(choice!='I'&&choice!='i'&&choice!='R'&&choice!='r'&&choice!='S'&&choice!='s'&&choice!='D'&&choice!='d');
        return choice;
    }
    public static void printMsg(String menu){
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
        
        String type="AM";
        if(time>=720) //if time >= (720 minutes) -> time >=  (12 )
            type="PM";
            
        int hours=(time/60)%12;
        if(hours==0)
            hours=12;        
        int minutes=time%60;
        String min=(minutes<9)?("0"+minutes):String.valueOf(minutes);
        String hou=(hours<9)?("0"+hours):String.valueOf(hours);
        String format;
        if(minutes==0)
            format=hou+" "+type;
        else
            format=hou+":"+min+" "+type;          
        System.out.printf("Clinic                  : %-25s   Appointment Time           : %s%n",clinic,format);
        System.out.printf("Appointment fee         : %d S.R",fee);
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("---------------------------Redirect to the main menu-----------------------------------------------");
        System.out.println("");
    }

    public static void displayInfo(int id, String name,  int age, String phone, String clinic, double weight, double height) {
        double BMI=(weight/((height/100)*(height/100)));
        String bmi="";
        if(BMI>30.0)
                bmi="Obese";         
        else if(BMI>=25.0 && BMI<= 30.0){
            bmi="Overweight";
        }
        else if(BMI>18.5 && BMI< 25.0){
            bmi="Normal";
        }
        else if(BMI<=18.5){
            bmi="Underweight";
        }
        System.out.println("");
        System.out.println("");
        System.out.println("			-------------------------------------------------");
        System.out.println("			    Information Details for Adding Patient");
        System.out.println("			-------------------------------------------------");
        System.out.println("");
        System.out.printf("Name                    : %-25s   National ID Number         : %7d%n",name.toUpperCase(),id);
        System.out.printf("Age                     : %-25d   Phone number               : %s%n",age,phone);
        System.out.printf("Clinic                  : %-25s   Weight                     : %.2f kg%n",clinic,weight);        
        System.out.printf("BMI                     : %-25s   Height                     : %.2f cm%n",bmi,height);
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("---------------------------Redirect to the main menu-----------------------------------------------");        
    }

    public static String formatTime(int t) {
        String type="AM";
        if(t>=720) //if time >= (720 minutes) -> time >=  (12 )
            type="PM";
            
        int hours=(t/60)%12;
        if(hours==0)
            hours=12;
        int minutes=t%60;
        String min=(minutes<9)?("0"+minutes):String.valueOf(minutes);
        String hou=(hours<9)?("0"+hours):String.valueOf(hours);
        String format=hou+":"+min+" "+type;          
        return format;
    }
    
}