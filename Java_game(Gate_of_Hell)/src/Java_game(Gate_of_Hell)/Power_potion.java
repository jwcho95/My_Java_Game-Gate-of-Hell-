package fourth_week_project;

public class Power_potion extends Potion{
	String name = "공격력 물약";
	Power_potion(){
		this.power = super.power + 50;
		this.money = super.money + 50;
	}
}
