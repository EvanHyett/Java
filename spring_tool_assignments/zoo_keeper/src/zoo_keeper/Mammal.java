package zoo_keeper;

public class Mammal {

//	Member Attributes
	public int energyLevel;
	
//	Constructor
	public Mammal() {
		this.energyLevel = 100;
	}

//	Methods
	public int displayEnergy() {
		System.out.printf("Energy Level:" + energyLevel + "\n");
		return energyLevel;
	}
	
}
