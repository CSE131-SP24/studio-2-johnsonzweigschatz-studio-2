package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Starting amount?: ");
		double startAmount = in.nextDouble();
		System.out.print("Chance at winning (as a decimal): ");
		double winChance = in.nextDouble();
		System.out.print("Win limit: ");
		double winLimit = in.nextDouble();
		System.out.print("Number of simulations: ");
		int totalSimulations = in.nextInt();
	
		
		int dayStart = 1;
		int numRuins = 0;
		
		while(dayStart <= totalSimulations) {
			int plays = 0; 
			double dailyStartAmount = startAmount;
			while(dailyStartAmount < winLimit && dailyStartAmount > 0) {
				double randInt = Math.random(); 
				
				if (randInt <= winChance) {
					dailyStartAmount = dailyStartAmount + 1;
					plays = plays + 1;
				}
				
				else {
					dailyStartAmount = dailyStartAmount - 1;
					plays = plays + 1;
				}
			}
			
			System.out.println(dayStart);
			System.out.println(plays);
			if (dailyStartAmount == winLimit) {
				System.out.println("Today was a success!");
			}
			else if (dailyStartAmount == 0) {
				System.out.println("Today was a ruin!");
				numRuins += 1; 
			}
			dayStart = dayStart + 1;
		}
		System.out.println(100*numRuins/totalSimulations + "%");
	}	
}
