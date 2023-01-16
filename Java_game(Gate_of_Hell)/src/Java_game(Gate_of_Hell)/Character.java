package fourth_week_project;

public class Character {
	/* 캐릭터의 특성, 캐릭터의 자세를 관리 */
	
	String name = "주인공";
	int health = 100; // 캐릭터 체력
	int mana = 100; // 캐릭터 마나
	int weight = 0; // 무게
	int power = 10; // 공격력
	int defense = 10; // 방어력
	int speed = 10; // 속도
	boolean equipped_shield = false; // 방패 착용 여부
	int money = 0;
	String ultimate_weapon = "없음"; // 궁극기에 사용할 아이템 이름
	int ultimate_count = 1; // 궁극기 사용 가능 횟수
	boolean posioned = false; // 중독 여부
	boolean burned = false;
	
	/* 2회차부터 증가하는 능력치 */
	int plus_power = 0;
	int plus_defense = 0;
	int plus_speed = 0;
	
	/* 착용한 무기 정보 */
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
	
	String posture_now = "기본 자세"; // 플레이어가 현재 사용하는 자세
	
	public void status(){
		if(power <= 0)
			power = 0;
		if(defense <= 0)
			defense = 0;
		if(speed <= 0)
			speed = 0;
		
		System.out.println("이름: "+this.name);
		System.out.println("체력: "+this.health+" / 100");
		System.out.println("마나: "+this.mana+" / 100");
		System.out.println("무게: "+this.weight+" / 100");
		System.out.println("공격력: "+this.power);
		System.out.println("방어력: "+this.defense);
		System.out.println("속도: "+this.speed);
		System.out.println("금화: "+ this.money+"개");
	}
}

