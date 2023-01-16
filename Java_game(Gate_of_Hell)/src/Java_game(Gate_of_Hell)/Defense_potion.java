package fourth_week_project;

public class Defense_potion extends Potion{
	String name = "방어력 물약";
	Defense_potion(){
		this.defense = super.defense + 50;
		this.money = super.money + 50;
	}
}
