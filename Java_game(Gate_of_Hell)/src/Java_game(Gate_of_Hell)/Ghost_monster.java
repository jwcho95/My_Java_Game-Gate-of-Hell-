package fourth_week_project;

public class Ghost_monster extends Monster_stage_2{
	String name = "��Ʈ";
	String skill_name = "Ȧ����";
	Ghost_monster(){
		this.health = super.health;
		this.max_health = super.max_health;
		this.power = super.power + 50;
		this.defense = super.defense + 10;
		this.speed = super.speed;
		this.accuracy = super.accuracy;
		this.skill_persent = super.skill_persent;
		this.money = super.money;
	}
	
	public void skill() {
		System.out.println(this.name+"�� "+ this.skill_name +"�� ����߽��ϴ�.");
	}
}
