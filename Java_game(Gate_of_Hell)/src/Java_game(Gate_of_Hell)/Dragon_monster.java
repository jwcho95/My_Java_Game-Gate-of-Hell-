package fourth_week_project;

public class Dragon_monster extends Monster_stage_3{
	String name = "�巡�� (������ �ٶ��� �����ϴ� ��)";
	String skill_name_1 = "�ٶ� Į��";
	String skill_name_2 = "������ ����̵�";
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
	
	public void skill_1() { // �ٶ� Į��
		System.out.println(this.name+"�� "+ this.skill_name_1 +"�� ����߽��ϴ�.");
		System.out.println("�ֺ��� �ٶ����� ������ �Ҵ��� Į���� ���ؼ� ���ƿԽ��ϴ�.");
		System.out.println("õ���� ��ȣ�� �հ� �ٶ��� ���Ƶ��ɴϴ�.");
	}
	
	public void skill_2() { // ������ ����̵�
		System.out.println(this.name+"�� "+ this.skill_name_1 +"�� ����߽��ϴ�.");
		System.out.println("������ �ִ� ������κ��� �ö���� �߰ſ� ������� ���̴��� ȸ������ ����Ű�� ���ƿԽ��ϴ�.");
		System.out.println("�߰ſ� ���⿡ ���� ��Ƴ��� �� �����ϴ�.");
	}
}
