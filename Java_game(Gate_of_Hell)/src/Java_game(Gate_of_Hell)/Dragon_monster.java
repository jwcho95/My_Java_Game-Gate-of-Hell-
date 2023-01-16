package fourth_week_project;

public class Dragon_monster extends Monster_stage_3{
	String name = "드래곤 (지옥의 바람을 관장하는 용)";
	String skill_name_1 = "바람 칼날";
	String skill_name_2 = "지옥불 토네이도";
	Dragon_monster(){
		this.health = super.health;
		this.max_health = super.max_health;
		this.power = super.power;
		this.defense = super.defense;
		this.speed = super.speed;
		this.accuracy = super.accuracy;
		this.skill_persent = super.skill_persent - 15;
		this.money = super.money;
	}
	
	public void skill_1() { // 바람 칼날
		System.out.println(this.name+"이 "+ this.skill_name_1 +"을 사용했습니다.");
		System.out.println("주변의 바람들이 빠르게 불더니 칼날로 변해서 날아왔습니다.");
		System.out.println("천사의 가호를 뚫고 바람이 날아들어옵니다.");
	}
	
	public void skill_2() { // 지옥불 토네이도
		System.out.println(this.name+"이 "+ this.skill_name_1 +"을 사용했습니다.");
		System.out.println("지옥에 있는 용암으로부터 올라오는 뜨거운 열기들이 모이더니 회오리를 일으키며 날아왔습니다.");
		System.out.println("뜨거운 열기에 몸이 녹아내릴 것 같습니다.");
	}
}
