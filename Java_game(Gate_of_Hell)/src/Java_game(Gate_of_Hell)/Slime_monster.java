package fourth_week_project;

public class Slime_monster extends Monster{
	String name = "������";
	String skill_name = "�ܴ�������";
	Slime_monster(){
		this.health = super.health + 100;
		this.max_health = super.max_health + 100;
		this.power = super.power;
		this.defense = super.defense;
		this.speed = super.speed;
		this.accuracy = super.accuracy + 20;
		this.skill_persent = super.skill_persent + 40;
		this.money = super.money;
	}
	
	public void skill() {
		System.out.println(this.name+"�� "+ this.skill_name +"�� ����߽��ϴ�.");
	}
}
