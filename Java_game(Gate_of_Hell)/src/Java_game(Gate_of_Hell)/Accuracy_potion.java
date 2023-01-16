package fourth_week_project;

public class Accuracy_potion extends Potion{
	String name = "명중률 물약";
	Accuracy_potion(){
		this.accuracy = super.accuracy + 20;
		this.money = super.money + 50;
	}
}
