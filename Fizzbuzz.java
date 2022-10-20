import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Fizzbuzz {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println();
       System.out.println("Welcome to BSS bank");
       System.out.println();
       System.out.println("*************************************************");
       System.out.println();
       System.out.println("Select from the options given below");
       System.out.println("1 : Existing account");
       System.out.println("2 : New account");
       System.out.println();
       System.out.println("*************************************************");
       System.out.println();
       System.out.print("Enter your choice : ");
       int opt = sc.nextInt();
       System.out.println();
       if(opt ==1){
        menu();
       }
       if(opt==2){
        newacc();
       }
    }
    static void newacc(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name : ");
        String name = sc.nextLine();
        System.out.print("Enter your Aadhar card number : ");
        String adharnum = sc.next();
        System.out.print("Enter DOB (ddmmyy) : ");
        String dob = sc.next();
        int max = 999999999;
        int min = 100000000;
        int b = (int)(Math.random()*(max-min+1)+min);  
        String acn = Integer.toString(b);
        System.out.println();
        System.out.println("Welcome "+name);
        System.out.println("Your account has been created successfully");
        System.out.println("Your new account number is: "+acn);
        System.out.print("Enter password : ");
        String pass = sc.next();
        System.out.print("Re-enter your password : ");
        String repass = sc.next();
        if(pass.equals(repass)){
        String check = acn+pass;
        System.out.print("How much do you want to deposit : ");
        String depo = sc.next();
        String anew = acn+"-"+depo;
        String aname = acn+"-"+name;
        
            File myfile = new File("name.txt");
            try {
                FileWriter fw = new FileWriter("name.txt",true);
                FileWriter fw1 = new FileWriter("ver.txt",true);
                FileWriter fw2 = new FileWriter("balance.txt",true);
                fw.write("\n"+aname);
                fw1.write("\n"+check);
                fw2.write("\n"+anew);
                fw.close();
                fw1.close();
                fw2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        System.out.println(depo + " has been deposited in your bank account");
            menu();
        }
        else{
            System.out.println("Password doesn't match");
        }  
    }
    static void menu(){
        Scanner sc = new Scanner(System.in);
        int men;
        System.out.println();
        System.out.println("*************************************************");
        System.out.println("Select from the options given below");
        System.out.println();
        System.out.println("1 : Check balance");
        System.out.println("2 : Withdraw money");
        System.out.println("3 : Deposit money");
        System.out.println("4 : Make Payment");
        System.out.println();
        System.out.println("*************************************************");
        System.out.print("\n");
        System.out.print("Enter your choice : ");
        men = sc.nextInt();
        System.out.println();
        if(men == 1 ){
            balance();
        }
        if(men == 2){
            withdraw();
        }
        if(men == 3){
            deposit();
        }
        if(men == 4){
            makepayment();
        }
    } 
    static void balance(){
        String acn,pass,check,check1; 
        String acn1="",pass1="";
        int flag = 0, ct=0;
        while(flag==0 && ct<3 ){
        File myfile = new File("ver.txt");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter account number: ");
        acn = sc.next();
        System.out.print("Enter password: ");
        pass = sc.next();
        check = acn+pass;
        try {
            Scanner obj = new Scanner(myfile);
            while(obj.hasNextLine()){
                String line = obj.nextLine();
                if(line.contains(check)){
                    flag=1;
                   acn1 = acn;
                   pass1 = pass;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(flag==0){
            System.out.println("Password or account number may be incorrect");
            System.out.println();
            ct++;
        }
        if(ct==3){
            System.out.println("Your account has been blocked for 24 hours");
        }
        }
        
        check1 = acn1+pass1;

        if(flag==1){
            System.out.println();
                System.out.print("Welcome,");
                welcome(acn1);
                System.out.println();
                File myfile1 = new File("balance.txt");
        try {
            Scanner obj1 = new Scanner(myfile1);
            System.out.print("Your current balance is : ");
            while(obj1.hasNextLine()){
                String line1 = obj1.nextLine();
                if(line1.contains(acn1)){
                    for(int i = 10 ; i <line1.length(); i++){
                        System.out.print(line1.charAt(i));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        }
    }   
    static void withdraw(){
        Scanner in = new Scanner(System.in);
        File myfile1 = new File("balance.txt");
        File myfile2 = new File("temp.txt");
        String acn,pass,check,check1; 
        String acn1="",pass1="";
        int flag = 0, ct=0;
        while(flag==0 && ct<3 ){
        File myfile = new File("ver.txt");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter account number : ");
        acn = sc.next();
        System.out.print("Enter password : ");
        pass = sc.next();
        check = acn+pass;
        try {
            Scanner obj = new Scanner(myfile);
            while(obj.hasNextLine()){
                String line = obj.nextLine();
                if(line.contains(check)){
                    flag=1;
                   acn1 = acn;
                   pass1 = pass;
                }
            }
            obj.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(flag==0){
            System.out.println("Password or account number may be incorrect");
            System.out.println();
            ct++;
        }
        if(ct==3){
            System.out.println("Your account has been blocked for 24 hours");
        }
        }
        
        check1 = acn1+pass1;
        
        int  withd , test2, test3 ;
        String  fina , conv;
               if(flag==1){
                try {
                    myfile2.createNewFile();
                } catch (IOException e1) {
                    
                    e1.printStackTrace();
                }
                System.out.println();
                System.out.print("Welcome, ");
                welcome(acn1);
                System.out.println();
                System.out.print("Enter amount to be withdrawn : ");
                withd = in.nextInt();
        try {
            Scanner obj1 = new Scanner(myfile1);
            while(obj1.hasNextLine()){
                String line = obj1.nextLine();
                if(line.contains(acn1)){
                String test1 = "" ;
                   for(int i = 10 ; i < line.length() ; i++ ){
                    String test = Character.toString(line.charAt(i));
                    test1 = test1 + test;        
                   }
                   
                test2 = Integer.parseInt(test1);
                if(withd>test2){
                    System.out.println("You can't withdraw more money than your balance");
                    break;
                }
                test3 = test2 - withd;
                conv = Integer.toString(test3);
                fina = acn1+"-"+conv;
                line = line.replaceAll(line,fina);
                System.out.println("Your updated Balance is : " +test3);
                if(test3<5000){
                System.out.println("Your balance has dropped below 5000 which is minimum amount ");
                    }
                }  
                FileWriter fw;
                try {
                    fw = new FileWriter("temp.txt",true);
                    fw.write(line+"\n");
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                       }
                       if(flag==0){
                        System.out.println("Invalid account number or password");
                       }
                       
                       obj1.close();  
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                 
            }
            myfile1.delete();
        File rename = new File("balance.txt");
        boolean flag1 = myfile2.renameTo(rename);  
        }  
          
    static void deposit(){
        File myfile1 = new File("balance.txt");
        File myfile2 = new File("temp.txt");
        int depo , test2, test3 ;
        String  fina , conv;
        String acn,pass,check,check1; 
        String acn1="",pass1="";
        int flag = 0, ct=0;
        Scanner in = new Scanner(System.in);
        while(flag==0 && ct<3 ){
        File myfile = new File("ver.txt");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter account number : ");
        acn = sc.next();
        System.out.print("Enter password : ");
        pass = sc.next();
        check = acn+pass;
        try {
            Scanner obj = new Scanner(myfile);
            while(obj.hasNextLine()){
                String line = obj.nextLine();
                if(line.contains(check)){
                    flag=1;
                   acn1 = acn;
                   pass1 = pass;
                }
            }
            obj.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(flag==0){
            System.out.println("Password or account number may be incorrect");
            System.out.println();
            ct++;
        }
        if(ct==3){
            System.out.println("Your account has been blocked for 24 hours");
        }
        }
        
        check1 = acn1+pass1;
                
               if(flag==1){
                System.out.println();
                System.out.print("Welcome, ");
                welcome(acn1);
                System.out.println();
                try {
                    myfile2.createNewFile();
                } catch (IOException e1) {
                    
                    e1.printStackTrace();
                }
                System.out.print("Enter amount to be Deposited : ");
                depo = in.nextInt();
        
        
        try {
            Scanner obj1 = new Scanner(myfile1);
            while(obj1.hasNextLine()){
                String line = obj1.nextLine();
                if(line.contains(acn1)){
                String test1 = "" ;
                   for(int i = 10 ; i < line.length() ; i++ ){
                    String test = Character.toString(line.charAt(i));
                    test1 = test1 + test;        
                   }
                   
                test2 = Integer.parseInt(test1);
                test3 = test2 + depo;
                conv = Integer.toString(test3);
                fina = acn1+"-"+conv;
                line = line.replaceAll(line,fina);
                System.out.println("Your updated Balance is : " +test3);
                }  
                
                FileWriter fw;
                try {
                    fw = new FileWriter("temp.txt",true);
                    fw.write(line+"\n");
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                       }
                       if(flag==0){
                        System.out.println("Invalid account number or password");
                       }
                       
                       obj1.close();  
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                 
            }
            myfile1.delete();
        File rename = new File("balance.txt");
        boolean flag1 = myfile2.renameTo(rename);  
             
        } 
    static void makepayment(){
        File myfile1 = new File("balance.txt");
        File myfile2 = new File("temp.txt");
        String acn,pass,acn2,supd,supd1,bal1,bal2,acn3 = "";
        int conv,conv1,upd,upd1,tra,tra1=0;
        int flag=0;
        try {
            myfile2.createNewFile();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
        String check1; 
        String acn1="",pass1="";
        int ct=0;
        while(flag==0 && ct<3 ){
        File myfile = new File("ver.txt");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter account number : ");
        acn = in.next();
        System.out.print("Enter password : ");
        pass = in.next();
        System.out.print("Enter account number to which you want to transfer : ");
        acn2 = in.next();
        System.out.print("Enter amount of money you want to transfer : ");
        tra = in.nextInt();
        String check = acn+pass;
        try {
            Scanner obj = new Scanner(myfile);
            while(obj.hasNextLine()){
                String line = obj.nextLine();
                if(line.contains(check)){
                    flag=1;
                   acn1 = acn;
                   pass1 = pass;
                   acn3 = acn2;
                   tra1 = tra;
                }
            }
            obj.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(flag==0){
            System.out.println("Password or account number may be incorrect");
            System.out.println();
            ct++;
        }
        if(ct==3){
            System.out.println("Your account has been blocked for 24 hours");
        }
        }
        
        check1 = acn1+pass1;
            
            if(flag==1){
                System.out.println();
                System.out.print("Welcome, ");
                welcome(acn1);
                System.out.println();
                int i,j; 
                Scanner obj1 = new Scanner(myfile1);
                while(obj1.hasNextLine()){
                String line1 = obj1.nextLine();
                if(line1.contains(acn1)){
                   String test = "";
                   for(i=10;i<line1.length();i++){
                    test = test+line1.charAt(i);
                   }
                   conv = Integer.parseInt(test);
                   upd = conv-tra1;
                   System.out.println("Your updated balance is : " +upd);
                   supd = Integer.toString(upd);
                   bal1 = acn1+"-"+supd;
                   line1 = line1.replaceAll(line1,bal1);
                }
                if(line1.contains(acn3)){
                    String testn = "";
                    for(j = 10 ; j< line1.length(); j++){
                        testn = testn + line1.charAt(j);
                    }
                    upd = Integer.parseInt(testn);
                    conv1 = upd + tra1;
                    supd1 = Integer.toString(conv1);
                    bal2 = acn3+"-"+supd1;
                    line1 = line1.replaceAll(line1,bal2);
                }       
                FileWriter fw;
                try {
                    fw = new FileWriter("temp.txt",true);
                    fw.write(line1+"\n");
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
               
               }
               obj1.close();
            }
            if(flag==0){
                System.out.println("Invalid account number or password");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        myfile1.delete();
        File rename = new File("balance.txt");
        boolean flag1 = myfile2.renameTo(rename);
    }
    static void welcome(String acn){
        File myfile = new File("name.txt");
        try {
            Scanner obj = new Scanner(myfile);
            while(obj.hasNextLine()){
                String line = obj.nextLine();
                if(line.contains(acn)){
                    for(int i = 10 ; i<line.length();i++){
                        System.out.print(line.charAt(i));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        }
    }
    }