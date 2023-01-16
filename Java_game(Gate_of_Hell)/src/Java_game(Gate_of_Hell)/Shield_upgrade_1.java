package fourth_week_project;

public class Shield_upgrade_1 extends Shield{
	String name = "튼튼한 방패";
	Shield_upgrade_1(){
		this.defense = super.defense + 20;
		this.speed = super.speed - 10;
		this.weight = super.weight;
	}
}
