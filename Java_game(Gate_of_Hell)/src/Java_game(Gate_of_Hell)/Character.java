package fourth_week_project;

public class Character {
	/* ĳ������ Ư��, ĳ������ �ڼ��� ���� */
	
	String name = "���ΰ�";
	int health = 100; // ĳ���� ü��
	int mana = 100; // ĳ���� ����
	int weight = 0; // ����
	int power = 10; // ���ݷ�
	int defense = 10; // ����
	int speed = 10; // �ӵ�
	boolean equipped_shield = false; // ���� ���� ����
	int money = 0;
	String ultimate_weapon = "����"; // �ñر⿡ ����� ������ �̸�
	int ultimate_count = 1; // �ñر� ��� ���� Ƚ��
	boolean posioned = false; // �ߵ� ����
	boolean burned = false;
	
	/* 2ȸ������ �����ϴ� �ɷ�ġ */
	int plus_power = 0;
	int plus_defense = 0;
	int plus_speed = 0;
	
	/* ������ ���� ���� */
	int equiped_weapon_power = 0;
	int equiped_weapon_speed = 0;
	int equiped_weapon_weight = 0;
	
	int equiped_armor_defense = 0;
	int equiped_armor_speed = 0;
	int equiped_armor_weight = 0;
	
	int equiped_shoes_speed = 0;
	int equiped_shoes_weight = 0;
	
	int equiped_shield_defense = 0;
	int equiped_shield_speed = 0;
	int equiped_shield_weight = 0;
	
	String posture_now = "�⺻ �ڼ�"; // �÷��̾ ���� ����ϴ� �ڼ�
	
	public void status(){
		if(power <= 0)
			power = 0;
		if(defense <= 0)
			defense = 0;
		if(speed <= 0)
			speed = 0;
		
		System.out.println("�̸�: "+this.name);
		System.out.println("ü��: "+this.health+" / 100");
		System.out.println("����: "+this.mana+" / 100");
		System.out.println("����: "+this.weight+" / 100");
		System.out.println("���ݷ�: "+this.power);
		System.out.println("����: "+this.defense);
		System.out.println("�ӵ�: "+this.speed);
		System.out.println("��ȭ: "+ this.money+"��");
	}
}

