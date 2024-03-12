package Music_Streaming_project;

import java.util.Scanner;


class Package_template {
	String name;
	int price;
	
	void printpackagename() {
		System.out.println("Package name= "+name);
	}
	
	void printpackageprice() {
		System.out.println("Package price= "+price+"$");
}
	void confirm() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Press 1 to confirm");
		
		int pck1 = scanner.nextInt();
        scanner.nextLine();

        switch (pck1) {
            case 1:
            	System.out.println("\nOpening payment portal...");
            	Payment.payment_process(price);
            	break;
	    }
        scanner.close();
    }
}
public class Package {
	
	
	public static void buy_package() {
		Package_template p1 = new Package_template();
		p1.name = "Budget (With ads)";
		p1.price = 5;
		
		Package_template p2 = new Package_template();
		p2.name = "Premium (Without ads)";
		p2.price = 10;
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("If you want to buy package with ads (Price: 5$) press 1 ");
		System.out.println("If you want to buy ad-free package (Price: 20$) press 2 ");
		
		int pck = scanner.nextInt();
        scanner.nextLine();

        switch (pck) {
            case 1:
            	System.out.println("Package Details:");
            	p1.printpackagename();
            	p1.printpackageprice();
            	p1.confirm();
            	break;
            
            case 2:
            	System.out.println("Package Details:");
            	p2.printpackagename();
            	p2.printpackageprice();
            	p2.confirm();
            	break;
            
	}
        	scanner.close();
}
}