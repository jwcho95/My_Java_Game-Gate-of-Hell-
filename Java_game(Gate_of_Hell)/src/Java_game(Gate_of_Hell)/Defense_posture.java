package fourth_week_project;

public class Defense_posture extends Character {
	String name = "방어 자세";
	int power_minus = 10;
	int defense_plus = 50;
	int speed_minus = 20;
	
	public void defense_skill(){ // 방어 자세 스킬
		System.out.println("현재 당신의 자세는 "+this.name+"입니다.");
		System.out.println(this.name+"의 스킬인 바디 어택를 사용하였습니다.\n");
	}
}
