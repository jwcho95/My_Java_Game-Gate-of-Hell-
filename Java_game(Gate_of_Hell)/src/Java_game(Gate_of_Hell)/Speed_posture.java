package fourth_week_project;

public class Speed_posture {
	String name = "신속 자세";
	int power_minus = 20;
	int defense_minus = 10;
	int speed_plus = 50;
	
	public void speed_skill(){ // 신속 자세 스킬
		System.out.println("현재 당신의 자세는 "+this.name+"입니다.");
		System.out.println(this.name+"의 스킬인 더블 어택를 사용하였습니다.\n");
	}
}
