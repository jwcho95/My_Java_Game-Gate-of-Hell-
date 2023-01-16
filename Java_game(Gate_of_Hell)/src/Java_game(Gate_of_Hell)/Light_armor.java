package fourth_week_project;

public class Light_armor extends Armor{
	String name = "³°Àº °æ°©";
	Light_armor(){
		this.defense = super.defense + 20;
		this.speed = super.speed + 10;
		this.weight = super.weight + 10;
	}
}
