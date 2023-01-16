package fourth_week_project;

public class Power_posture extends Character {
	String name = "공격 자세";
	int power_plus = 50;
	int defense_minus = 20;
	int speed_minus = 10;
	
	public void power_skill(){ // 공격자세 스킬
		System.out.println("현재 당신의 자세는 "+this.name+"입니다.");
		System.out.println(this.name+"의 스킬인 파워 어택를 사용하였습니다.\n");
	}
}
