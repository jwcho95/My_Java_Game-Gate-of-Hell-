package fourth_week_project;

public class Monster_stage_3 extends Monster_stage_2{
	String name = "�������� 3�� ����";
	Monster_stage_3(){
		this.health = super.health + 300;
		this.max_health = super.max_health + 300;
		this.power = super.power + 150;
		this.defense = super.defense + 150;
		this.speed = super.speed + 150;
		this.accuracy = super.accuracy + 20;
		this.skill_persent = super.skill_persent;
		this.money = super.money + 50;
	}
}
