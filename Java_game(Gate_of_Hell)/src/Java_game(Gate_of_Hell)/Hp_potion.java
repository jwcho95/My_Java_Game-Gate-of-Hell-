package fourth_week_project;

public class Hp_potion extends Potion{
	String name = "체력 물약";
	Hp_potion(){
		this.hp = super.hp + 50;
		this.money = super.money;
		this.weight = 0;
	}
}
