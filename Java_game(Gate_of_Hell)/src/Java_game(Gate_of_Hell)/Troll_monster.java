package fourth_week_project;

public class Troll_monster extends Monster_stage_2{
	String name = "트롤";
	String skill_name = "몸통 박치기";
	Troll_monster(){
		this.health = super.health;
		this.max_health = super.max_health;
		this.power = super.power + 10;
		this.defense = super.defense + 50;
		this.speed = super.speed - 30;
		this.accuracy = super.accuracy - 10;
		this.skill_persent = super.skill_persent - 10;
		this.money = super.money;
	}
	
	public void skill() {
		System.out.println(this.name+"이 "+ this.skill_name +"를 사용했습니다.");
	}
}
