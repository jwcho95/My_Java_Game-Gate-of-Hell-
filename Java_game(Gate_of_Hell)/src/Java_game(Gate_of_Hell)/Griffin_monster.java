package fourth_week_project;

public class Griffin_monster extends Monster_stage_2{
	String name = "�׸���";
	String skill_name = "������ȭ";
	Griffin_monster(){
		this.health = super.health;
		this.max_health = super.max_health;
		this.power = super.power - 30;
		this.defense = super.defense;
		this.speed = super.speed + 100;
		this.accuracy = super.accuracy + 10;
		this.skill_persent = super.skill_persent;
		this.money = super.money;
	}
	
	public void skill() {
		System.out.println(this.name+"�� "+ this.skill_name +"�� ����߽��ϴ�.");
	}
}
