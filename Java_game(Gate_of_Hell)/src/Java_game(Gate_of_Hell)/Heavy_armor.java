package fourth_week_project;

public class Heavy_armor extends Armor{
	String name = "³°Àº Áß°©";
	Heavy_armor(){
		this.defense = super.defense + 50;
		this.speed = super.speed - 20;
		this.weight = super.weight + 30;
	}
}
