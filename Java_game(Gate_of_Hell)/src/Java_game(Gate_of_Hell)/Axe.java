package fourth_week_project;

public class Axe extends Weapon{
	String name = "³°Àº µµ³¢";
	Axe(){
		this.power = super.power + 50;
		this.speed = super.speed - 10;
		this.accuracy = super.accuracy + 10;
		this.weight = super.weight + 20;
	}
}
