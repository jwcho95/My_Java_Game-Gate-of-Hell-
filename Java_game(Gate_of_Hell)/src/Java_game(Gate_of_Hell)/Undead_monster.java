package fourth_week_project;

public class Undead_monster extends Monster{
	String name = "�𵥵�";
	String skill_name = "���Ա�";
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
		System.out.println(this.name+"�� "+ this.skill_name +"�� ����߽��ϴ�.");
	}
	public void pattern_1() {
		System.out.println(this.name + "�� �� �����⸦ ����Ϸ��� �մϴ�.");
	}
}
