package fourth_week_project;

public class Sword extends Weapon{
	String name = "³°Àº °Ë";
	Sword(){
		this.power = super.power + 30;
		this.speed = super.speed;
		this.accuracy = super.accuracy + 20;
		this.weight = super.weight + 10;
	}
}
