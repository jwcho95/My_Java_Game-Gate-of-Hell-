package fourth_week_project;

public class Axe_upgrade_2 extends Axe_upgrade_1{
	String name = "������ ���� ���Ͼ�";
	Axe_upgrade_2(){
		this.power = super.power + 120;
		this.speed = super.speed + 20;
		this.accuracy = super.accuracy + 20;
		this.weight = super.weight;
	}
	
	public void skill() {
		System.out.println("������ �ñؿ����� ��׳���ũ�� �����Ͽ����ϴ�.");
	}
}
