package fourth_week_project;

public class Speed_potion extends Potion{
	String name = "속도 물약";
	Speed_potion(){
		this.speed = super.speed + 50;
		this.money = super.money + 50;
	}
}
