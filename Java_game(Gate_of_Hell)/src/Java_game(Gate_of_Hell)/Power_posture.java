package fourth_week_project;

public class Power_posture extends Character {
	String name = "���� �ڼ�";
	int power_plus = 50;
	int defense_minus = 20;
	int speed_minus = 10;
	
	public void power_skill(){ // �����ڼ� ��ų
		System.out.println("���� ����� �ڼ��� "+this.name+"�Դϴ�.");
		System.out.println(this.name+"�� ��ų�� �Ŀ� ���ø� ����Ͽ����ϴ�.\n");
	}
}
