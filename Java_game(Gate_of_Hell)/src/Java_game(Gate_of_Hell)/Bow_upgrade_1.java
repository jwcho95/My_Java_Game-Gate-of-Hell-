package fourth_week_project;

public class Bow_upgrade_1 extends Bow{
	String name = "강화된 활";
	Bow_upgrade_1(){
		this.power = super.power + 40;
		this.speed = super.speed + 40;
		this.accuracy = super.accuracy;
		this.weight = super.weight;
	}
}
