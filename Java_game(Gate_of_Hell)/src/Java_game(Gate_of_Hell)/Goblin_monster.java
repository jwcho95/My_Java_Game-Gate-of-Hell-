package fourth_week_project;

public class Goblin_monster extends Monster{
	String name = "���";
	String skill_name = "������";
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
		System.out.println(this.name+"�� "+ this.skill_name +"�� ����߽��ϴ�.");
	}
}
