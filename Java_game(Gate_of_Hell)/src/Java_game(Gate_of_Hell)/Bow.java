package fourth_week_project;

public class Bow extends Weapon{
	String name = "³°Àº È°";
	Bow(){
		this.power = super.power + 10;
		this.speed = super.speed + 10;
		this.accuracy = super.accuracy + 40;
		this.weight = super.weight;
	}
}
