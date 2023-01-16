package fourth_week_project;

public class Monster_stage_2 extends Monster{
	String name = "스테이지 2의 괴물";
	Monster_stage_2(){
		this.health = super.health + 200;
		this.max_health = super.max_health + 200;
		this.power = super.power + 100;
		this.defense = super.defense + 100;
		this.speed = super.speed + 100;
		this.accuracy = super.accuracy + 20;
		this.skill_persent = super.skill_persent + 15;
		this.money = super.money + 50;
	}
}
