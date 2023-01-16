package fourth_week_project;

public class Mp_potion extends Potion{
	String name = "마나 물약";
	Mp_potion(){
		this.mp = super.mp + 50;
		this.money = super.money;
	}
}
