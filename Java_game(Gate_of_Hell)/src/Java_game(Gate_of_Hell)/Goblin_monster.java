package fourth_week_project;

public class Goblin_monster extends Monster{
	String name = "고블린";
	String skill_name = "할퀴기";
	Goblin_monster(){
		this.health = super.health + 50;
		this.max_health = super.max_health + 50;
		this.power = super.power + 30;
		this.defense = super.defense + 10;
		this.speed = super.speed + 50;
		this.accuracy = super.accuracy + 10;
		this.skill_persent = super.skill_persent + 10;
		this.money = super.money;
	}
	
	public void skill() {
		System.out.println(this.name+"이 "+ this.skill_name +"를 사용했습니다.");
	}
}
