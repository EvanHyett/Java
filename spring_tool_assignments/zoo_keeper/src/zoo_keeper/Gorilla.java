package zoo_keeper;

public class Gorilla extends Mammal {

//	Constructor
	public Gorilla() {
		super();
		this.energyLevel = 100;
	}
	
//	Methods
		public int throwSomething() {
			this.energyLevel -= 5;
			System.out.println("Harambe has thrown something and lost 5 energy. -5 energy!");
			return energyLevel;
		}
		
		public int eatBananas() {
			this.energyLevel += 10;
			System.out.println("Harambe has devoured a banana and is fully satisfied. +10 energy!");
			return energyLevel;
		}
		
		public int climb() {
			this.energyLevel -= 10;
			System.out.println("Harambe has climbed a tree and has tired himself out. -10 energy!");
			return energyLevel;
		}
}
