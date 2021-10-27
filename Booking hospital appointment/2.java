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
        // TODO code application logic here
        //we store begin and close times (in minute)
         int D_begin=10*60;   
         int S_begin=9*60+30;   
         int R_begin=9*60;   
         int I_begin=8*60;   
        
         int D_close=16*60;
         int S_close=20*60+30;
         int R_close=17*60;   
         int I_close=18*60;   
        
        int IVar=I_begin; 
        int RVar=R_begin; 
        int SVar=S_begin; 
        int DVar=D_begin; 
        String choice="";
        Scanner input=new Scanner(System.in);
        while(!choice.equalsIgnoreCase("Exit")){
            String mainMenu=("MainMenu");
            printMsg(mainMenu);
            choice=input.next();
            if(choice.equalsIgnoreCase("Book")){
                System.out.println("");
                char bChoice=readAndVerify();
                String clinic="";
                int fee=0;
                int  timeToPrint=0;
                boolean available=false;
                String name="",t="";
                int id=0;
                switch(bChoice){
                    case 'I':
                    case 'i': {
                        clinic="ICU"; 
                        fee=1000;
                        timeToPrint=IVar;
                        if(IVar <= I_close)
                            available=true;
                        System.out.println("");
                        System.out.print("	Enter the name (first and last): ");
                        String firstName=input.next();
                        String lastName=input.next();
                         name=firstName+" "+lastName;
                        System.out.print("	Enter the national ID number:  ");
                         id=input.nextInt();
                        //-----------------------------
                         t=getTimeFormat(timeToPrint);                    
                        //-----------------------------     
                         
                    }break;
                    case 'R':
                    case 'r':{
                        clinic="Radiology"; 
                        fee=200;
                        timeToPrint=RVar;
                        if(RVar <= R_close)
                            available=true;
                        System.out.println("");
                        System.out.print("	Enter the name (first and last): ");
                        String firstName=input.next();
                        String lastName=input.next();
                         name=firstName+" "+lastName;
                        System.out.print("	Enter the national ID number:  ");
                         id=input.nextInt();
                        //-----------------------------
                         t=getTimeFormat(timeToPrint);                    
                        //-----------------------------                        
                    }break;
                    case 'S':
                    case 's':{ 
                        clinic="Surgery"; 
                        fee=3000;
                        timeToPrint=SVar;
                        if(SVar <= S_close)
                            available=true;
                        System.out.println("");
                        System.out.print("	Enter the name (first and last): ");
                        String firstName=input.next();
                        String lastName=input.next();
                         name=firstName+" "+lastName;
                        System.out.print("	Enter the national ID number:  ");
                         id=input.nextInt();
                        //-----------------------------
                         t=getTimeFormat(timeToPrint);                    
                        //-----------------------------                           
                    }break;
                    case 'D':
                    case 'd': {
                        clinic="Dentistry:"; 
                        fee=150;
                        timeToPrint=DVar;
                        if(DVar <= D_close)
                            available=true;
                        System.out.println("");
                        System.out.print("	Enter the name (first and last): ");
                        String firstName=input.next();
                        String lastName=input.next();
                         name=firstName+" "+lastName;
                        System.out.print("	Enter the national ID number:  ");
                         id=input.nextInt();
                        //-----------------------------
                         t=getTimeFormat(timeToPrint);                    
                        //-----------------------------                          
                    }break;
                }
                if(available==true){
                    System.out.println("	The appointment will be at "+t);
                    System.out.print("	Press 1 to confirm, 2 to cancel : ");
                    int conf=input.nextInt();
                    if(conf==1){
                        displayInfo(id,name,timeToPrint,clinic,fee);
                        System.out.println("");
                        System.out.println("---------------------------------------------------------------------------------------------------");
                        System.out.println("---------------------------Redirect to the main menu-----------------------------------------------");
                        System.out.println("");                        
                        if(bChoice=='I'||bChoice=='i'){
                            IVar+=60; //increment value 60 minutes 
                        }
                        else if(bChoice=='R'||bChoice=='r'){
                            RVar+=60; //increment value 60 minutes
                        }
                        else if(bChoice=='S'||bChoice=='s'){
                            SVar+=60; //increment value 60 minutes
                        }
                        else if(bChoice=='D'||bChoice=='d'){
                            DVar+=60; //increment value 60 minutes
                        }
                    }
                    else if(conf==2){
                        //cancel request
                    }
                    System.out.println("");
                }
                else{
                    System.out.println("");
                    System.out.println("\tSorry, Clinic is Closed.");
                    System.out.println("");
                }
            }
            else if(choice.equalsIgnoreCase("Add")){
                System.out.println("");
                char clinicCh=readAndVerify(); 
                String clinic="";
                if(clinicCh=='I'||clinicCh=='i'){
                     clinic="ICU"; 
                }
                else if(clinicCh=='R'||clinicCh=='r'){
                    clinic="RADIOLOGY"; 
                }
                else if(clinicCh=='S'||clinicCh=='s'){
                    clinic="Surgery";
                }
                else if(clinicCh=='D'||clinicCh=='d'){
                    clinic="DENTISTRY"; 
                }              
                System.out.println("");
                System.out.print("	Enter the name (first and last): ");
                String firstName=input.next();
                String lastName=input.next();
                String name=firstName+" "+lastName;
                int age,id;
                System.out.print("	Enter the national ID number:  ");
                id=input.nextInt();               
                System.out.print("	Enter your age: ");
                age=input.nextInt();
                System.out.print("	Enter your mobile number (###-###-####):  ");
                String phone=input.next();
                System.out.print("	Enter your weight in Kilogram: ");
                double weight,height;
                weight=input.nextDouble();
                System.out.print("	Enter your height in Centimeter: ");
                height=input.nextDouble();
                displayInfo(id,name,age,phone,clinic,weight,height);   
                System.out.println("---------------------------------------------------------------------------------------------------");
                System.out.println("---------------------------Redirect to the main menu-----------------------------------------------");                 
            }
            else if(choice.equalsIgnoreCase("Exit")){
                //close program
            }
            else
            {
                System.out.println("\n	Wrong Selection of Service Type!\n");
            }
        }
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
        printMsg("DepartmentMenu");
        System.out.print("Enter your Choice: ");
        choice=input.next().charAt(0);        
        while(choice!='I'&&choice!='i'&&choice!='R'&&choice!='r'&&choice!='S'&&choice!='s'&&choice!='D'&&choice!='d'){
            if(choice!='I'&&choice!='i'&&choice!='R'&&choice!='r'&&choice!='S'&&choice!='s'&&choice!='D'&&choice!='d'){
                System.out.println("");
                System.out.println("	Wrong Selection of clinic... try again!"); 
                System.out.println("");
                printMsg("DepartmentMenu");
                System.out.print("Enter your Choice: ");
                choice=input.next().charAt(0);                
            }
        }
        return choice;
    }
    public static void printMsg(String menu){
         if(menu.equals("DepartmentMenu")){
            System.out.println("	-------------------------------------------------");
            System.out.println("	DEPARTMENT: please select the correct department:");
            System.out.println("	-------------------------------------------------");
            System.out.println("	Enter I or i for ICU:");
            System.out.println("	Enter R or r for Radiology:");
            System.out.println("	Enter S or s for Surgery:");    
            System.out.println("	Enter D or d for Dentistry:"); 
        }
        else if(menu.equals("MainMenu")){
            displayMainMenu();
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
        String m=(minutes<9)?("0"+minutes):(""+minutes);
        String kind;
        if(hours>=12){
            if(hours!=12)
                hours=hours-12;
            kind="PM";
        }
        else{
            kind="AM";
        }
        String h=(hours<9)?("0"+hours):(""+hours);
        String tFormat;
        if(minutes==0)
            tFormat=h+" "+kind;
        else
            tFormat=h+":"+m+" "+kind;
        System.out.printf("Clinic                  : %-25s   Appointment Time           : %s%n",clinic,tFormat);
        System.out.printf("Appointment fee         : %d S.R",fee);
    }

    public static void displayInfo(int id, String name,  int age, String phone, String clinic, double weight, double height) {
        double BMIvalue=(weight/((height/100)*(height/100)));
        String bmi="";
        if(BMIvalue<=18.5){
            bmi="Underweight";
        }
        else if(BMIvalue>30.0)
                bmi="Obese";         
        else if(BMIvalue>18.5 && BMIvalue< 25.0){
            bmi="Normal";
        }
        else if(BMIvalue>=25.0 && BMIvalue<= 30.0){
            bmi="Overweight";
        }
        System.out.println("");
        System.out.println("");
        System.out.println("			-------------------------------------------------");
        System.out.println("			    Information Details for Adding Patient");
        System.out.println("			-------------------------------------------------");
        System.out.println("");
        System.out.printf("Name                    : %-26s  National ID Number         : %-7d%n",name.toUpperCase(),id);
        System.out.printf("Age                     : %-26d  Phone number               : %s%n",age,phone);
        System.out.printf("Clinic                  : %-26s  Weight                     : %.2f kg%n",clinic,weight);        
        System.out.printf("BMI                     : %-26s  Height                     : %.2f cm%n",bmi,height);       
    }

    public static String getTimeFormat(int time) {
        int hours=time/60;
        int minutes=time%60;
        String type;
        if(hours>=12){
            if(hours>12)
                hours=hours-12;
            type="PM";
        }
        else{
            //hours still has same value
            type="AM";
        }
        String m=(minutes>=9)?String.valueOf(minutes):("0"+minutes);
        String h=(hours>=9)?String.valueOf(hours):("0"+hours);
        String res=h+":"+m+" "+type;          
        return res;
    }
    
}