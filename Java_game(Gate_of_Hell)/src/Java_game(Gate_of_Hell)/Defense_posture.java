package fourth_week_project;

public class Defense_posture extends Character {
	String name = "��� �ڼ�";
	int power_minus = 10;
	int defense_plus = 50;
	int speed_minus = 20;
	
	public void defense_skill(){ // ��� �ڼ� ��ų
		System.out.println("���� ����� �ڼ��� "+this.name+"�Դϴ�.");
		System.out.println(this.name+"�� ��ų�� �ٵ� ���ø� ����Ͽ����ϴ�.\n");
	}
}
