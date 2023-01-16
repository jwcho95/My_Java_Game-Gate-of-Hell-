package fourth_week_project;

public class Sword_upgrade_1 extends Sword{
	String name = "강화된 검";
	Sword_upgrade_1(){
		this.power = super.power + 50;
		this.speed = super.speed + 30;
		this.accuracy = super.accuracy;
		this.weight = super.weight;
	}
}
