package fourth_week_project;

public class Ghost_monster extends Monster_stage_2{
	String name = "고스트";
	String skill_name = "홀리기";
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
		System.out.println(this.name+"가 "+ this.skill_name +"를 사용했습니다.");
	}
}
