package fourth_week_project;

public class Undead_monster extends Monster{
	String name = "언데드";
	String skill_name = "뜯어먹기";
	Undead_monster(){
		this.health = super.health;
		this.max_health = super.max_health;
		this.power = super.power + 50;
		this.defense = super.defense;
		this.speed = super.speed + 30;
		this.accuracy = super.accuracy;
		this.skill_persent = super.skill_persent;
		this.money = super.money;
	}
	
	public void skill() {
		System.out.println(this.name+"가 "+ this.skill_name +"를 사용했습니다.");
	}
	public void pattern_1() {
		System.out.println(this.name + "가 돌 던지기를 사용하려고 합니다.");
	}
}
