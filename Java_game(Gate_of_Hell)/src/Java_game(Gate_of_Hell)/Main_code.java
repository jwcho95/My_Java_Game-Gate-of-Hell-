package fourth_week_project;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.HashSet;
import java.awt.*;
import javax.swing.*;

public class Fourth_week_project extends Thread{
	/* 
	 목차 
	 1. 각종 변수들
	 2. 메인 메소드
	 3. 게임 진행에 사용되는 다양한 메소드
		 
	 */
	
	
	
	
	
	/* 1. 각종 변수들 */
	
	/* 시스템에 대한 변수 */
	static Scanner sc = new Scanner(System.in);
	static Scanner player_num = new Scanner(System.in);
	static Random rand = new Random(System.currentTimeMillis());
	static int thread_num = 1000; // 사용되는 쓰레드의 개수
	
	
	/* 플레이어에 대한 변수 */
	static int choice = 0; // 플레이어의 선택
	static int skill_choice = 0; // 자세에 따른 스킬 선택
	static int damage = 0; // 플레이어와 몬스터가 받는 데미지;
	static Character player = new Character(); // 플레이어
	static ArrayList<String> player_equipped_item = new ArrayList<String>(); // 플레이어가 가지고 있는 장비 아이템
	static ArrayList<String> player_potion = new ArrayList<String>(); // 플레이어가 가지고 있는 물약 아이템
	static Power_posture power_posture = new Power_posture(); // 공격 자세
	static Defense_posture defense_posture = new Defense_posture(); // 방어 자세
	static Speed_posture speed_posture = new Speed_posture(); // 신속 자세
	static int original_power = 0; // 자세 변경 전 공격력
	static int original_defense = 0; // 자세 변경 전 방어력
	static int original_speed = 0; // 자세 변경 전 속도
	static int played = 0; // 다시 시작하기를 체크하기 위한 변수
	static boolean player_turn = true; // 플레이어의 턴을 체크
	static boolean run = false; // 도망쳤는지를 확인
	static int reward = 0; // 전투 후 보상
	static int event_num = 6; // 이벤트의 개수
	static boolean stage_1_clear = false; // 스테이지 1 클리어 여부
	static boolean stage_2_clear = false; // 스테이지 2 클리어 여부
	static String buffer = new String(); // 입력값의 나머지를 받는 버퍼
	static boolean check_fight = false; // 전투인지 아닌지 체크
	static boolean check_finished = false; // 이야기가 끝났음을 확인하고 쓰레드 종료를 위한 변수
	static int poison_count = 0; // 독 쓰레드 사용 확인
	static int burn_count = 0; // 화상 쓰레드 사용 확인
	static int ex_event_num = 0; // 이벤트 중복 방지를 위한 변수
		
	/* 몬스터에 대한 변수 */
	static int monster_num = 3; // 몬스터의 개수
	static Monster monster = new Monster();
	static Undead_monster undead = new Undead_monster(); // 언데드
	static Slime_monster slime = new Slime_monster(); // 슬라임
	static Goblin_monster goblin = new Goblin_monster(); // 고블린
	static Ghost_monster ghost = new Ghost_monster(); // 고스트
	static Troll_monster troll = new Troll_monster(); // 트롤
	static Griffin_monster griffin = new Griffin_monster(); // 그리핀
	static Dragon_monster dragon = new Dragon_monster(); // 드래곤
	static int help_baby_monster = 0; // 괴물을 도와주는 이벤트를 위한 변수 : 0은 기본, 1은 도와준 것, 2는 도와주지 않은 것
	static int dragon_played = 0; // 보스전 텍스트 속도를 위한 변수
		
	/* 물약에 대한 변수 */
	static boolean use_potion = false; // 물약 사용여부
	static Hp_potion hp_potion = new Hp_potion(); // 체력 물약
	static Mp_potion mp_potion = new Mp_potion(); // 마나 물약
	static Power_potion power_potion = new Power_potion(); // 공격력 물약
	static Defense_potion defense_potion = new Defense_potion(); // 방어력 물약
	static Speed_potion speed_potion = new Speed_potion(); // 속도 물약
	static Antidote antidote = new Antidote(); // 해독제
	static Antipyrotic antipyrotic = new Antipyrotic(); // 화상 치료제
	
	/* 장비에 대한 변수 */
	static Sword sword = new Sword(); // 기본 검
	static Sword_upgrade_1 sword_upgrade_1 = new Sword_upgrade_1(); // 검 강화 1단계
	static Sword_upgrade_2 sword_upgrade_2 = new Sword_upgrade_2(); // 검 강화 2단계
	static Bow bow = new Bow(); // 기본 활
	static Bow_upgrade_1 bow_upgrade_1 = new Bow_upgrade_1(); // 활 강화 1단계
	static Bow_upgrade_2 bow_upgrade_2 = new Bow_upgrade_2(); // 활 강화 2단계
	static Axe axe = new Axe(); // 기본 도끼
	static Axe_upgrade_1 axe_upgrade_1 = new Axe_upgrade_1(); // 도끼 강화 1단계
	static Axe_upgrade_2 axe_upgrade_2 = new Axe_upgrade_2(); // 도끼 강화 2단계
	static Light_armor light_armor = new Light_armor(); // 기본 경갑
	static Light_armor_upgrade_1 light_armor_upgrade_1 = new Light_armor_upgrade_1(); // 경갑 강화 1단계
	static Light_armor_upgrade_2 light_armor_upgrade_2 = new Light_armor_upgrade_2(); // 경갑 강화 2단계
	static Heavy_armor heavy_armor = new Heavy_armor(); // 기본 중갑
	static Heavy_armor_upgrade_1 heavy_armor_upgrade_1 = new Heavy_armor_upgrade_1(); // 중갑 강화 1단계
	static Heavy_armor_upgrade_2 heavy_armor_upgrade_2 = new Heavy_armor_upgrade_2(); // 중갑 강화 2단계
	static Shoes shoes = new Shoes(); // 기본 신발
	static Shoes_upgrade_1 shoes_upgrade_1 = new Shoes_upgrade_1(); // 신발 강화 1단계
	static Shoes_upgrade_2 shoes_upgrade_2 = new Shoes_upgrade_2(); // 신발 강화 2단계
	static Shield shield = new Shield(); // 기본 방패
	static Shield_upgrade_1 shield_upgrade_1 = new Shield_upgrade_1(); // 방패 강화 1단계
	static Shield_upgrade_2 shield_upgrade_2 = new Shield_upgrade_2(); // 방패 강화 2단계
	
	/* 쓰레드 객체 생성 */
	static Monster_fight_thread[] monster_fight_thread = new Monster_fight_thread[thread_num]; // 몬스터 전투 쓰레드
	static Player_fight_thread[] player_fight_thread = new Player_fight_thread[thread_num]; // 플레이어 전투 쓰레드
	static Poison[] poison = new Poison[1000]; // 독 쓰레드
	static Burn[] burn = new Burn[1000]; // 독 쓰레드
	static int meet_monster = 0; // 몬스터 스레드를 계속 돌리기 위한 변수
	
	/* 이미지 객체 생성 */
	static Base_Image castle_image = new Base_Image(); // 성 이미지
	static Undead_image undead_image = new Undead_image(); // 언데드 이미지
	static Slime_image slime_image = new Slime_image(); // 슬라임 이미지
	static Goblin_image goblin_image = new Goblin_image(); // 고블린 이미지
	static Ghost_image ghost_image = new Ghost_image(); // 고스트 이미지
	static Troll_image troll_image = new Troll_image(); // 트롤 이미지
	static Griffin_image griffin_image = new Griffin_image(); // 그리핀 이미지
	static Dragon_image dragon_image = new Dragon_image(); // 드래곤 이미지
	static Bonfire_image bonfire_image = new Bonfire_image(); // 로딩중 이미지
	static Volcano_image volcano_image = new Volcano_image(); // 화산 이미지
	static Monster_village_image monster_village_image = new Monster_village_image(); // 괴물들의 마을 이미지
	static Hell_gate_image hell_gate_image = new Hell_gate_image(); // 트루 엔딩 이미지
	static Hell_gate_2_image hell_gate_2_image = new Hell_gate_2_image(); // 노말 엔딩 이미지
	
	
	
	
	/* 2. 메인 메소드 */
		
	public static void main(String[] args) {
		castle_image.setVisible(true);
		
		/* 게임 스토리 */
		System.out.println("◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇");
		System.out.println();
		make_slow(2);
		System.out.println("한 왕국이 있었다.");
		make_slow(0);
		System.out.println("왕국은 예로부터 성 지하에 있는 문을 지키며 살아왔었다.");
		make_slow(0);
		System.out.println("어느 누구도 그 안에 들어가본 적이 없으며 그 안에 무엇이 있는지도 몰랐다.");
		make_slow(0);
		System.out.println("그저 왕국 대대로 내려오는 기록에 따르면 그 문이 열리는 순간이 왕국의 마지막 날이라고만 기록되어있을 뿐이다.\n");
		make_slow(0);
		System.out.println("이 왕국에서 뛰어난 기사로서 뛰어난 공을 세우는 당신은 그 공적을 인정받아 이 문을 지키라는 명을 받고 일을 하고 있었다.");
		make_slow(0);
		System.out.println("그러나 매번 뛰어난 공적을 세웠던 당신을 시기한 사람들은 문을 열었다는 죄목으로 당신을 죽이려고 하였다.");
		make_slow(0);
		System.out.println("당신과 당신의 부하들은 그들이 준 물을 마시고 잠들었으며 문은 그렇게 열리고 말았다.\n");
		make_slow(0);
		System.out.println("그저 이상한 예언일 뿐이라고 생각했던 사람들은 문을 여는 것이 어떤 의미인지 몰랐다.");
		make_slow(0);
		System.out.println("문이 열리는 순간 그 안에 살고있던 괴물들이 세상 밖으로 나오기 시작했다.");
		make_slow(0);
		System.out.println("괴물들은 세상 밖으로 나와서 닥치는대로 학살을 하기 시작했다.");
		make_slow(0);
		System.out.println("문 안에서 느껴지는 뜨거운 열기에 순간적으로 정신이 든 당신은 문을 닫아보려고 노력했다.\n");
		make_slow(0);
		System.out.println("문은 안에서 나오는 바람 때문에 닫히질 않았고 바람이 오는 곳을 따라 시선을 돌려보니 저 멀리 바람을 내뿜는 용이 있었다.");
		make_slow(0);
		System.out.println("당신은 저 괴물을 없애고 문을 닫기로 결심하였다.");
		make_slow(2);
		System.out.println();
		System.out.println("◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇\n");
		make_slow(0);
		castle_image.setVisible(false);
		player_potion.add(hp_potion.name);
		LoopStart: while(true) {
			/* 게임을 시작하는 선택지 */
			while(true) {
				if(played == 0) {
					System.out.println("게임을 시작하시겠습니까?\n[1. 예]  [2. 아니오]");
					
				}else {
					player_init();
					System.out.println("게임을 다시 시작하시겠습니까?\n[1. 예]  [2. 아니오]");
				}
				choice = sc.nextInt();
				make_slow(2);
				if(choice == 1) {
					System.out.println("당신은 지옥문을 천천히 들어갔습니다.\n");
					make_slow(0);
					if(played == 0) { // 1회차
						while(true) {
							System.out.print("플레이어의 이름을 입력해주세요(공백 없이 입력해주세요): ");
							player.name = sc.next();
							buffer = sc.nextLine();
							if(player.name.length() > 5) {
								System.out.println("이름이 너무 깁니다. 다시 입력해주세요.\n");
								continue;
							}else break;
						}
					}else if(played == 1){ // 2회차
						System.out.println("죽을 때마다 원하고자 하는 능력치을 한 번 강화할 수 있습니다.");
						make_slow(2);
						System.out.println("선택한 능력치는 50이 올라갑니다.");
						make_slow(2);
						System.out.println("어떤 능력치를 강화하실 건가요?\n[1. 공격력]\n[2. 방어력]\n[3. 속도]\n[4. 강화하지 않는다.]");
						choice = sc.nextInt();
						if(choice == 1) {
							System.out.println("=====================");
							System.out.println("공격력이 강화되었습니다.");
							System.out.println("=====================\n");
							player.plus_power += 50;
						}else if(choice == 2) {
							System.out.println("=====================");
							System.out.println("방어력이 강화되었습니다.");
							System.out.println("=====================\n");
							player.plus_defense += 50;
						}else if(choice == 3) {
							System.out.println("=====================");
							System.out.println("속도가 강화되었습니다.");
							System.out.println("=====================\n");
							player.plus_speed += 50;
						}else {
							System.out.println("=====================");
							System.out.println("아무것도 강화하지 않았습니다.");
							System.out.println("=====================\n");
						}
					}else { // 다회차
						System.out.println("원하고자 하는 능력치을 한 번 강화할 수 있습니다.");
						make_slow(2);
						System.out.println("어떤 능력치를 강화하실 건가요?\n[1. 공격력]\n[2. 방어력]\n[3. 속도]\n[4. 강화하지 않는다.]");
						choice = sc.nextInt();
						if(choice == 1) {
							System.out.println("공격력이 강화되었습니다.\n");
							player.plus_power += 50;
						}else if(choice == 2) {
							System.out.println("방어력이 강화되었습니다.\n");
							player.plus_defense += 50;
						}else if(choice == 3) {
							System.out.println("속도가 강화되었습니다.\n");
							player.plus_speed += 50;
						}else {
							System.out.println("아무것도 강화하지 않았습니다.\n");
						}
					}
					break;
				}else if(choice == 2) {
					System.out.println("지옥의 괴물들은 빠른 속도로 왕국을 점령해갔고 그렇게 왕국은 멸망하였습니다.");
					make_slow(0);
					System.out.println("\"당신이 왕국의 백성들을 죽였어...\"");
					make_slow(0);
					System.out.println("The End");
					System.exit(0);
				}else {
					System.out.print("그런 선택지는 없습니다.\n\n");
					continue;
				}
			}
			System.out.println();
			player.power = 10 + player.plus_power;
			player.defense = 10 + player.plus_defense;
			player.speed = 10 + player.plus_speed;
			
			make_slow(1);
			check_status();
			make_slow(1);
			
			/* 튜토리얼 */
			System.out.println();
			if(played == 0) {
				System.out.println("당신은 지금부터 총 3개의 스테이지를 클리어해야합니다.");
				make_slow(1);
				System.out.println("캐릭터에게는 3가지의 자세가 있습니다.");
				make_slow(1);
				System.out.println("자세에 따라 스킬, 공격력, 방어력 그리고 속도가 달라집니다.");
				make_slow(1);
				System.out.println("알맞은 자세를 이용해서 적을 물리치세요.\n");
				make_slow(1);
			}
			played++;
			
			while(true) {
				System.out.println("당신의 행동을 선택해주세요.\n[1. 장비 점검하기]  [2. 출발하기]");
				choice = sc.nextInt();
				make_slow(2);
				if(choice == 1) {
					System.out.println("무기부터 점검하겠습니다.\n");
					make_slow(2);
					System.out.println("사용하실 무기를 선택해주세요.\n[1. 검]  [2. 활]  [3. 도끼]  [4. 선택하지 않는다.]");
					choice = sc.nextInt();
					if(choice == 1) { // 검 착용
						System.out.println("==============================");
						System.out.println(sword.name+"을 착용하였습니다.");
						System.out.println("==============================\n");
						sword.equipped = true;
						player_equipped_item.add(0,sword.name);
						player.power += sword.power;
						player.speed += sword.speed;
						player.weight += sword.weight;
						player.equiped_weapon_power = sword.power;
						player.equiped_weapon_speed = sword.speed;
						player.equiped_weapon_weight = sword.weight;
					}else if(choice == 2) { // 활 착용
						System.out.println("==============================");
						System.out.println(bow.name+"을 착용하였습니다.");
						System.out.println("==============================\n");
						bow.equipped = true;
						player_equipped_item.add(0,bow.name);
						player.power += bow.power;
						player.speed += bow.speed;
						player.weight += bow.weight;
						player.equiped_weapon_power = bow.power;
						player.equiped_weapon_speed = bow.speed;
						player.equiped_weapon_weight = bow.weight;
					}else if(choice == 3) { // 도끼 착용
						System.out.println("==============================");
						System.out.println(axe.name+"를 착용하였습니다.");
						System.out.println("==============================\n");
						axe.equipped = true;
						player_equipped_item.add(0,axe.name);
						player.power += axe.power;
						player.speed += axe.speed;
						player.weight += axe.weight;
						player.equiped_weapon_power = axe.power;
						player.equiped_weapon_speed = axe.speed;
						player.equiped_weapon_weight = axe.weight;
					}else {
						System.out.println("==============================");
						System.out.println("아무 무기도 선택하지 않았습니다.");
						System.out.println("==============================\n");
						player_equipped_item.add(0, "무기 없음");
					}
					make_slow(2);
					System.out.println("방어구도 점검하겠습니다.\n");
					make_slow(2);
					System.out.println("사용하실 방어구를 선택해주세요.\n[1. 경갑]  [2. 중갑]  [3. 선택하지 않는다.]");
					choice = sc.nextInt();
					if(choice == 1) { // 경갑 착용
						System.out.println("==============================");
						System.out.println(light_armor.name+"을 착용하였습니다.");
						System.out.println("==============================\n");
						light_armor.equipped = true;
						player_equipped_item.add(1,light_armor.name);
						player.defense += light_armor.defense;
						player.speed += light_armor.speed;
						player.weight += light_armor.weight;
						player.equiped_armor_defense = light_armor.defense;
						player.equiped_armor_speed = light_armor.speed;
						player.equiped_armor_weight = light_armor.weight;
					}else if(choice == 2) { // 중갑 착용
						System.out.println("==============================");
						System.out.println(heavy_armor.name+"을 착용하였습니다.");
						System.out.println("==============================\n");
						heavy_armor.equipped = true;
						player_equipped_item.add(1, heavy_armor.name);
						player.defense += heavy_armor.defense;
						player.speed += heavy_armor.speed;
						player.weight += heavy_armor.weight;
						player.equiped_armor_defense = heavy_armor.defense;
						player.equiped_armor_speed = heavy_armor.speed;
						player.equiped_armor_weight = heavy_armor.weight;
					}else {
						System.out.println("==============================");
						System.out.println("아무 방어구도 선택하지 않았습니다.");
						System.out.println("==============================\n");
						player_equipped_item.add(1, "갑옷 없음");
					}
					make_slow(2);
					System.out.println("신발을 착용하시겠습니까?\n[1. 예]  [2. 아니오]");
					choice = sc.nextInt();
					if(choice == 1) { // 신발 착용
						System.out.println("==============================");
						System.out.println(shoes.name+"을 착용하였습니다.");
						System.out.println("==============================\n");
						shoes.equipped = true;
						player_equipped_item.add(2, shoes.name);
						player.speed += shoes.speed;
						player.weight += shoes.weight;
						player.equiped_shoes_speed = shoes.speed;
						player.equiped_shoes_weight = shoes.weight;
					}else {
						System.out.println("==============================");
						System.out.println("당신은 신발없이 진행하기로 선택하였습니다.");
						System.out.println("==============================\n");
						player_equipped_item.add(2, "신발 없음");
					}
					make_slow(2);
					System.out.println("마지막으로 방패를 착용할지 선택해주세요.\n[1. 예]  [2. 아니오]");
					choice = sc.nextInt();
					if(choice == 1) { // 방패 착용
						System.out.println("==============================");
						System.out.println(shield.name+"를 착용하였습니다.");
						System.out.println("==============================\n");
						shield.equipped = true;
						player_equipped_item.add(3, shield.name);
						player.equipped_shield = true;
						player.defense += shield.defense;
						player.speed += shield.speed;
						player.weight += shield.weight;
						player.equiped_shield_defense = shield.defense;
						player.equiped_shield_speed = shield.speed;
						player.equiped_shield_weight = shield.weight;
					}else {
						System.out.println("==============================");
						System.out.println("당신은 방패없이 진행하기로 선택했습니다.");
						System.out.println("==============================\n");
						player_equipped_item.add(3, "방패 없음");
					}
					make_slow(1);
					System.out.println("장비 점검을 마친 당신은 괴물들을 향해 앞으로 나아갔습니다.\n");
					break;
				}else {
					System.out.println("당신은 괴물들을 향해 앞으로 나아갔습니다.\n");
					break;
				}
			}
			make_slow(0);
			loading();
			make_slow(0);
			
			/* 1 스테이지 */
			check_status();
			event_or_fight(rand.nextInt(2)+1);
			if(check_dead()) {
				System.out.println("당신은 앞으로 나아가던 중 힘이 다했습니다.");
				make_slow(2);
				System.out.println("죽어가는 그 찰나에 당신을 가엽게 여긴 신이 시간을 문이 열린 순간으로 되돌려주었습니다.\n");
				make_slow(0);
				continue LoopStart;
			}
			check_status();
			event_or_fight(rand.nextInt(2)+1);
			if(check_dead()) {
				System.out.println("당신은 앞으로 나아가던 중 힘이 다했습니다.");
				make_slow(2);
				System.out.println("죽어가는 그 찰나에 당신을 가엽게 여긴 신이 시간을 문이 열린 순간으로 되돌려주었습니다.\n");
				make_slow(0);
				continue LoopStart;
			}
			check_status();
			event_or_fight(rand.nextInt(2)+1);
			if(check_dead()) {
				System.out.println("당신은 앞으로 나아가던 중 힘이 다했습니다.");
				make_slow(2);
				System.out.println("죽어가는 그 찰나에 당신을 가엽게 여긴 신이 시간을 문이 열린 순간으로 되돌려주었습니다.\n");
				make_slow(0);
				continue LoopStart;
			}
			check_status();
			make_slow(1);
			stage_break_time();
			
			
			
			/* 2 스테이지 */
			check_status();
			event_or_fight(rand.nextInt(2)+1);
			if(check_dead()) {
				System.out.println("당신은 앞으로 나아가던 중 힘이 다했습니다.");
				make_slow(2);
				System.out.println("죽어가는 그 찰나에 당신을 가엽게 여긴 신이 시간을 문이 열린 순간으로 되돌려주었습니다.\n");
				make_slow(0);
				continue LoopStart;
			}
			check_status();
			event_or_fight(rand.nextInt(2)+1);
			if(check_dead()) {
				System.out.println("당신은 앞으로 나아가던 중 힘이 다했습니다.");
				make_slow(2);
				System.out.println("죽어가는 그 찰나에 당신을 가엽게 여긴 신이 시간을 문이 열린 순간으로 되돌려주었습니다.\n");
				make_slow(0);
				continue LoopStart;
			}
			check_status();
			event_or_fight(rand.nextInt(2)+1);
			if(check_dead()) {
				System.out.println("당신은 앞으로 나아가던 중 힘이 다했습니다.");
				make_slow(2);
				System.out.println("죽어가는 그 찰나에 당신을 가엽게 여긴 신이 시간을 문이 열린 순간으로 되돌려주었습니다.\n");
				make_slow(0);
				continue LoopStart;
			}
			check_status();
			make_slow(1);
			stage_break_time();
			
			
			
			/* 3 스테이지 */
			check_status();
			event_or_fight(rand.nextInt(2)+1);
			if(check_dead()) {
				System.out.println("당신은 앞으로 나아가던 중 힘이 다했습니다.");
				make_slow(2);
				System.out.println("죽어가는 그 찰나에 당신을 가엽게 여긴 신이 시간을 문이 열린 순간으로 되돌려주었습니다.\n");
				make_slow(0);
				continue LoopStart;
			}else {
				check_finished = true;
				if(help_baby_monster == 1) {
					for(int i = 0; i < 50; i++) {
						System.out.println();
					}
					make_slow(0);
					System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★\n");
					make_slow(2);
					System.out.println("오랜 접전 끝에 당신이 마지막 공격을 가하려고 할 때 아까 구해주었던 새끼 괴물들이 당신 앞을 가로막았습니다.");
					make_slow(0);
					System.out.println("아까 구해주었던 괴물들이 이 용의 새끼들이었나봅니다.");
					make_slow(0);
					System.out.println("새끼 괴물들과 용은 잠시동안 알 수 없는 언어로 대화를 하기 시작했습니다.");
					make_slow(0);
					System.out.println("대화가 끝나자 용은 잠시 당신을 바라보다가 고개를 숙이며 감사를 표했습니다.");
					make_slow(0);
					System.out.println("그와 동시에 용은 바람을 일으키는 것을 멈추었습니다.");
					make_slow(0);
					System.out.println("용이 바람을 멈추자 수호 천사가 당신의 곁으로 가까이 왔습니다.");
					make_slow(0);
					System.out.println("천사는 용에게 지옥의 문을 닫고 더 이상 지옥의 괴물들이 지상에 나오지 못하게 해달라고 부탁하였습니다.");
					make_slow(0);
					System.out.println("천사의 말을 알아들은 용은 끄덕이더니 그들과 함께 지옥문 앞으로 갔습니다.");
					make_slow(0);
					System.out.println("문 앞에서 용은 지상을 향해 크게 울부 짖었고 이윽고 수 많은 괴물들이 지옥으로 들어오기 시작했습니다.");
					make_slow(0);
					System.out.println("당신은 용에게 감사의 인사를 한 후 문을 닫았습니다.");
					make_slow(0);
					hell_gate_image.setVisible(true);
					System.out.println("문은 닫히자마자 희미해지면서 사라져버렸습니다.");
					make_slow(0);
					System.out.println("이 기쁜 소식을 전하러 왕에게 갔지만 성 안의 사람들은 이미 모두 괴물에게 죽어버렸습니다.");
					make_slow(0);
					System.out.println("성 안에서는 당신만이 살아남았기에 왕국의 혼란을 진정시켜야했고 훌륭하게 해내었습니다.");
					make_slow(0);
					System.out.println("백성들은 이런 당신을 추대하여 새로운 왕으로 올렸습니다.");
					make_slow(0);
					System.out.println("왕국의 왕으로서 왕국을 평화롭게 다스리는 것이 이제 당신의 임무입니다.\n");
					make_slow(2);
					System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★\n");
					make_slow(0);
					System.out.println("True End");
					System.exit(0);
				}else {
					for(int i = 0; i < 50; i++) {
						System.out.println();
					}
					make_slow(0);
					System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★\n");
					make_slow(2);
					System.out.println("오랜 접전 끝에 당신의 마지막 공격으로 괴성을 질렀습니다.");
					make_slow(0);
					System.out.println("그 소리에 지옥의 땅들이 진동했고 용은 이내 화산의 용암 속으로 떨어졌습니다.");
					make_slow(0);
					System.out.println("용이 사라지자 화산을 감싸던 거센 바람들은 사라졌고 천사의 가호 또한 천천히 사라졌습니다.");
					make_slow(0);
					System.out.println("당신은 천사의 가호가 사라지기 전에 서둘러 지옥문까지 날아갔습니다.");
					make_slow(0);
					System.out.println("그리고 문을 굳게 닫았습니다.");
					make_slow(0);
					hell_gate_2_image.setVisible(true);
					System.out.println("문이 닫히자 문에 쓰여있던 문자들이 빛을 내면서 \"철컥\"소리를 내었습니다.");
					make_slow(0);
					System.out.println("성 밖을 나가보니 꽤 많은 피해가 있었지만 왕국의 병사들이 괴물들을 대부분 정리하였습니다.");
					make_slow(0);
					System.out.println("당신은 왕에게 이 모든 사실들을 보고하였고 문을 연 자들을 처벌하려 하였습니다.");
					make_slow(0);
					System.out.println("그러나 이미 그들은 문에서 나온 괴물들에 의해 죽어있었습니다.");
					make_slow(0);
					System.out.println("왕은 문을 닫아준 것에 감사해하며 당신에게 계속하여 문을 지켜줄 것을 부탁하였습니다.");
					make_slow(0);
					System.out.println("그렇게 당신은 오늘도 문을 지킵니다.");
					make_slow(0);
					System.out.println("그 문이 언제 다시 열릴지도 모르며...\n");
					make_slow(2);
					System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★\n");
					make_slow(0);
					System.out.println("The End");
					System.exit(0);
				}
			}
			break;
		}
	}
	
	
	
	
	
	/* 3. 게임 진행에 사용되는 다양한 메소드 */
	
	public static void player_init() { // 플레이어의 스탯을 초기화해주는 메소드
		player.health = 100;
		player.mana = 100;
		player.weight = 0;
		player.equipped_shield = false;
		player.money = 0;
		player_equipped_item.clear();
		player_potion.clear();
		player_potion.add(hp_potion.name);
		stage_1_clear = false;
		stage_2_clear = false;
		sword.equipped = false;
		sword_upgrade_1.equipped = false;
		sword_upgrade_2.equipped = false;
		bow.equipped = false;
		bow_upgrade_1.equipped = false;
		bow_upgrade_2.equipped = false;
		axe.equipped = false;
		axe_upgrade_1.equipped = false;
		axe_upgrade_2.equipped = false;
		light_armor.equipped = false;
		light_armor_upgrade_1.equipped = false;
		light_armor_upgrade_2.equipped = false;
		heavy_armor.equipped = false;
		heavy_armor_upgrade_1.equipped = false;
		heavy_armor_upgrade_2.equipped = false;
		shoes.equipped = false;
		shoes_upgrade_1.equipped = false;
		shoes_upgrade_2.equipped = false;
		shield.equipped = false;
		shield_upgrade_1.equipped = false;
		shield_upgrade_2.equipped = false;
		help_baby_monster = 0;
		player.ultimate_weapon = "없음";
		player.ultimate_count = 1;
		ex_event_num = 0;
	}
	
	
	
	public static void choice_posture() { // 자세 변경 메소드
		original_power = player.power;
		original_defense = player.defense;
		original_speed = player.speed;
		
		while(true) {
			System.out.println("=========================================");
			System.out.println();
			System.out.println("자세를 선택해주세요.\n\n[1. 공격 자세 : 공격력을 증가시켜주는 자세]\n[2. 방어 자세 : 받는 데미지를 줄여주는 자세]\n[3. 신속 자세 : 행동 속도를 높여주는 자세]");
			System.out.println();
			System.out.println("=========================================");
			choice = sc.nextInt();
			if(choice == 1) {
				System.out.println("==================================");
				System.out.println(power_posture.name+"를 선택하였습니다.");
				System.out.println("==================================\n");
				skill_choice = choice;
				player.posture_now = power_posture.name;
				break;
			}else if(choice == 2) {
				System.out.println("==================================");
				System.out.println(defense_posture.name+"를 선택하였습니다.");
				System.out.println("==================================\n");
				skill_choice = choice;
				player.posture_now = defense_posture.name;
				break;
			}else if(choice == 3) {
				System.out.println("==================================");
				System.out.println(speed_posture.name+"를 선택하였습니다.");
				System.out.println("==================================\n");
				skill_choice = choice;
				player.posture_now = speed_posture.name;
				break;
			}else if(choice == 1004) { // 치트
				System.out.println("==================================");
				System.out.println("무적을 선택하였습니다.");
				System.out.println("==================================\n");
				player.posture_now = "무적";
				break;
			}else 
				System.out.println("그런 자세는 없습니다.\n");
		}
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void change_posture(int posture_num) { // 자세에 따른 버프를 주는 메소드
		switch(posture_num) {
		case 1: // 공격 자세
			player.power += power_posture.power_plus;
			player.defense -= power_posture.defense_minus;
			player.speed -= power_posture.speed_minus;
			if(player.defense <= 0)
				player.defense = 0;
			if(player.speed <= 0)
				player.speed = 0;
			break;
		case 2: // 방어 자세
			player.power -= defense_posture.power_minus;
			player.defense += defense_posture.defense_plus;
			player.speed -= defense_posture.speed_minus;
			if(player.power <= 0)
				player.power = 0;
			if(player.speed <= 0)
				player.speed = 0;
			break;
		case 1004: // 치트
			player.power = 1000;
			player.defense = 1000;
			player.speed = 1000;
			break;
		default: // 신속 자세
			player.power -= speed_posture.power_minus;
			player.defense -= speed_posture.defense_minus;
			player.speed += speed_posture.speed_plus;
			if(player.defense <= 0)
				player.defense = 0;
			if(player.power <= 0)
				player.power = 0;
			break;
		}
	}
	

	

	public static void return_posture() { // 자세를 되돌리는 메소드
		player.power = original_power;
		player.defense = original_defense;
		player.speed = original_speed;
	}

	

	
	public static void unequip_item(int num) { // 장비를 해제하는 메소드
		if(num == 0) {
			player_equipped_item.remove(num);
			player.power -= player.equiped_weapon_power;
			player.speed -= player.equiped_weapon_speed;
			player.weight -= player.equiped_weapon_weight;
		}else if(num == 1) {
			player_equipped_item.remove(num);
			player.defense -= player.equiped_armor_defense;
			player.speed -= player.equiped_armor_speed;
			player.weight -= player.equiped_armor_weight;
		}else if(num == 2) {
			player_equipped_item.remove(num);
			player.speed -= player.equiped_shoes_speed;
			player.weight -= player.equiped_shoes_weight;
		}else {
			player_equipped_item.remove(num);
			player.defense -= player.equiped_shield_defense;
			player.speed -= player.equiped_shield_speed;
			player.weight -= player.equiped_shield_weight;
		}
	}
	


	public static void use_skill(int skill_num) { // 자세 스킬을 사용하는 메소드
		switch(skill_num) {
		case 1:
			player.mana -= 20;
			damage = player.power * 2 - monster.defense;
			if(damage < 0) {
				damage = 5;
				monster.health -= damage;
			}else monster.health -= damage;
			System.out.println("["+power_posture.name+"의 스킬인 파워 어택을 사용했습니다.]\n");
			break;
		case 2:
			player.mana -= 20;
			damage = player.defense * 2 - monster.defense;
			if(damage < 0) {
				damage = 5;
				monster.health -= damage;
			}else monster.health -= damage;
			System.out.println("["+defense_posture.name+"의 스킬인 바디 어택을 사용했습니다.]\n");
			break;
		default:
			player.mana -= 20;
			damage = player.speed * 2 - monster.defense;
			if(damage < 0) {
				damage = 5;
				monster.health -= damage;
			}else monster.health -= damage;
			System.out.println("["+speed_posture.name+"의 스킬인 더블 어택을 사용했습니다.]\n");
			break;
		}
	}
	


	public static void check_status() { // 현재 상태를 체크해주는 메소드
		System.out.println("---------------- 현재 상태 ----------------");
		player.status();
		System.out.print("현재 가지고 있는 장비: ");
		for(int i = 0; i < player_equipped_item.size(); i++) {
			System.out.print(player_equipped_item.get(i));
			if(i != player_equipped_item.size() - 1)
				System.out.print(", ");
		}
		System.out.println();
		Collections.sort(player_potion);
		System.out.print("현재 가지고 있는 물약: ");
		for(int i = 0; i < player_potion.size(); i++) {
			System.out.print(player_potion.get(i));
			if(i != player_potion.size() - 1)
				System.out.print(", ");
		}
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println();
	}
	


	public static void event_or_fight(int num) { // 스테이지에서 이벤트와 전투를 선택함
		if(stage_2_clear&&stage_1_clear) { // 3 스테이지
			make_slow(1);
			choice_monster(rand.nextInt(monster_num)+1);
			fight();
		}else {
			if(num == 1) { // 이벤트
				make_slow(1);
				event(rand.nextInt(event_num)+1);
			}else { // 몬스터와 전투
				make_slow(1);
				choice_monster(rand.nextInt(monster_num)+1);
				fight();
			}
		}
	}
	
	
	
	public static void choice_monster(int monster_num) { // 몬스터 선택 메소드
		int speed = 0;
		if(stage_2_clear&&stage_1_clear) {
			if(dragon_played >= 1) {
				speed = 2;
			}
			dragon_played++;
			make_slow(speed);
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
			System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆\n");
			System.out.println("                " + dragon.name+"\n");
			System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★\n");
			dragon_image.setVisible(true);
			make_slow(speed);
			System.out.println("천사의 가호를 받으며 바람들을 헤쳐나가다보니 어느새 화산 꼭대기에 도착하게 되었습니다.");
			make_slow(speed);
			System.out.println("그 위에는 지옥문을 닫지 못하게 하는 용이 바람을 일으키고 있었습니다.");
			make_slow(speed);
			System.out.println("용의 크기는 멀리서 볼 때와는 다르게 너무나도 컸습니다.");
			make_slow(speed);
			System.out.println("그럼에도 당신은 물러설 수 없었습니다.");
			make_slow(speed);
			System.out.println("문을 닫지 못한다면 왕국은 멸망의 길을 피할 수 없기 때문입니다.");
			make_slow(speed);
			System.out.println("압도적인 크기에 두려움이 몸을 감싸기 시작했지만 자세를 가다듬고 용을 바라보았습니다.");
			make_slow(speed);
			System.out.println("그 순간 천사의 가호의 힘으로 몸이 떠오르기 시작하더니 어느새 용의 앞까지 도착하였습니다.");
			make_slow(speed);
			System.out.println("용은 흔들리지 않는 눈으로 당신을 바라보며 이내 공격을 시작했습니다.\n");
			make_slow(speed);
			dragon_image.setVisible(false);
			monster.name = dragon.name;
			monster.health = dragon.health;
			monster.max_health = dragon.max_health;
			monster.power = dragon.power;
			monster.defense = dragon.defense;
			monster.speed = dragon.speed;
			monster.accuracy = dragon.accuracy;
			monster.money = dragon.money;
		}else if(stage_1_clear) {
			if(monster_num == 1) { // 고스트
				System.out.println(ghost.name+"를 만났습니다.\n");
				ghost_image.setVisible(true);
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				System.out.println();
				System.out.println("                             " + ghost.name);
				System.out.println();
				System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★\n");
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				ghost_image.setVisible(false);
				monster.name = ghost.name;
				monster.health = ghost.health;
				monster.max_health = ghost.max_health;
				monster.power = ghost.power;
				monster.defense = ghost.defense;
				monster.speed = ghost.speed;
				monster.accuracy = ghost.accuracy;
				monster.money = ghost.money;
			}else if(monster_num == 2) { // 트롤
				System.out.println(troll.name+"를 만났습니다.\n");
				troll_image.setVisible(true);
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				System.out.println();
				System.out.println("                             " + troll.name);
				System.out.println();
				System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★\n");
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				troll_image.setVisible(false);
				monster.name = troll.name;
				monster.health = troll.health;
				monster.max_health = troll.max_health;
				monster.power = troll.power;
				monster.defense = troll.defense;
				monster.speed = troll.speed;
				monster.accuracy = troll.accuracy;
				monster.money = troll.money;
			}else { // 그리핀
				System.out.println(griffin.name+"를 만났습니다.\n");
				griffin_image.setVisible(true);
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				System.out.println();
				System.out.println("                             " + griffin.name);
				System.out.println();
				System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★\n");
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				griffin_image.setVisible(false);
				monster.name = griffin.name;
				monster.health = griffin.health;
				monster.max_health = griffin.max_health;
				monster.power = griffin.power;
				monster.defense = griffin.defense;
				monster.speed = griffin.speed;
				monster.accuracy = griffin.accuracy;
				monster.money = griffin.money;
			}
		}else {
			if(monster_num == 1) { // 언데드
				System.out.println(undead.name+"를 만났습니다.\n");
				undead_image.setVisible(true);
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				System.out.println();
				System.out.println("                             " + undead.name);
				System.out.println();
				System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★\n");
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				undead_image.setVisible(false);
				monster.name = undead.name;
				monster.health = undead.health;
				monster.max_health = undead.max_health;
				monster.power = undead.power;
				monster.defense = undead.defense;
				monster.speed = undead.speed;
				monster.accuracy = undead.accuracy;
				monster.money = undead.money;
			}else if(monster_num == 2) { // 고블린
				System.out.println(goblin.name+"를 만났습니다.\n");
				goblin_image.setVisible(true);
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				System.out.println();
				System.out.println("                             " + goblin.name);
				System.out.println();
				System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★\n");
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				goblin_image.setVisible(false);
				monster.name = goblin.name;
				monster.health = goblin.health;
				monster.max_health = goblin.max_health;
				monster.power = goblin.power;
				monster.defense = goblin.defense;
				monster.speed = goblin.speed;
				monster.accuracy = goblin.accuracy;
				monster.money = goblin.money;
			}else { // 슬라임
				System.out.println(slime.name+"를 만났습니다.\n");
				slime_image.setVisible(true);
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				System.out.println();
				System.out.println("                             " + slime.name);
				System.out.println();
				System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★\n");
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				slime_image.setVisible(false);
				monster.name = slime.name;
				monster.health = slime.health;
				monster.max_health = slime.max_health;
				monster.power = slime.power;
				monster.defense = slime.defense;
				monster.speed = slime.speed;
				monster.accuracy = slime.accuracy;
				monster.money = slime.money;
			}
		}
		
		if(help_baby_monster == 2) { // 괴물을 돕는 이벤트로 인한 몬스터 버프
			monster.power += 20;
		}
	}

	


	public static void choice_potion(String potion_name) { // 물약 선택 메소드
		if(potion_name.equals(hp_potion.name)) { // 체력 물약
			use_potion = true;
			if(player.health + hp_potion.hp >= 100)
				player.health = 100;
			else player.health += hp_potion.hp;
			player_potion.remove(hp_potion.name);
			player.weight -= hp_potion.weight;
			System.out.println(hp_potion.name+"을 사용했습니다.");
			System.out.println("체력이 "+hp_potion.hp+"만큼 회복되었습니다.\n");
		}else if(potion_name.equals(mp_potion.name)) { // 마나 물약
			use_potion = true;
			if(player.mana + mp_potion.mp >= 100)
				player.mana = 100;
			else player.mana += mp_potion.mp;
			player_potion.remove(mp_potion.name);
			player.weight -= mp_potion.weight;
			System.out.println(mp_potion.name+"을 사용했습니다.");
			System.out.println("마나가 "+mp_potion.mp+"만큼 회복되었습니다.\n");
		}else if(potion_name.equals(power_potion.name)) { // 공격력 물약
			use_potion = true;
			player.power += power_potion.power;
			player_potion.remove(power_potion.name);
			player.weight -= power_potion.weight;
			System.out.println(power_potion.name+"을 사용했습니다.");
			System.out.println("공격력이 "+power_potion.power+" 상승했습니다.\n");
		}else if(potion_name.equals(defense_potion.name)) { // 방어력 물약
			use_potion = true;
			player.defense += defense_potion.defense;
			player_potion.remove(defense_potion.name);
			player.weight -= defense_potion.weight;
			System.out.println(defense_potion.name+"을 사용했습니다.");
			System.out.println("방어력이 "+defense_potion.defense+" 상승했습니다.\n");
		}else if(potion_name.equals(speed_potion.name)) { // 속도 물약
			use_potion = true;
			player.speed += speed_potion.speed;
			player_potion.remove(speed_potion.name);
			player.weight -= speed_potion.weight;
			System.out.println(speed_potion.name+"을 사용했습니다.");
			System.out.println("속도가 "+speed_potion.speed+" 상승했습니다.\n");
		}else {
			System.out.println("그런 물약은 없습니다.");
		}
	}
	
	
	
		
	public static void fight() { // 전투
		choice_posture();
		change_posture(choice);
		if(player_potion.isEmpty() == false) {
			while(true) {
				System.out.print("현재 가지고 있는 물약: ");
				for(int i = 0; i < player_potion.size(); i++) {
					System.out.print(player_potion.get(i));
					if(i != player_potion.size() - 1)
						System.out.print(", ");
				}
				System.out.println();
				System.out.println("전투 전 사용하실 물약을 선택해주세요.");
				HashSet<String> potion_list_temp = new HashSet<String>(player_potion); // 물약 선택시 중복 제거를 위한 변수
				ArrayList<String> potion_list = new ArrayList<String>(potion_list_temp);
				Collections.sort(potion_list);
				
				for(int i = 0; i < potion_list.size(); i++) {
					System.out.println("["+(i+1)+". "+potion_list.get(i)+"]");
				}
				System.out.println("[0. 그만하기]");
				choice = sc.nextInt();
				if(choice == 0) {
					System.out.println();
					break;
				}else if(choice <= potion_list.size()) {
					choice_potion(potion_list.get(choice - 1));
					continue;
				}
				else {
					System.out.println("물약을 다시 선택해주세요.\n"); 
					continue;
				}
			}
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		monster_fight_thread[meet_monster] = new Monster_fight_thread();
		player_fight_thread[meet_monster] = new Player_fight_thread();
		check_fight = true;
		monster_fight_thread[meet_monster].start();
		player_fight_thread[meet_monster].start();
		
		try {
			monster_fight_thread[meet_monster].join();
		}catch(Exception e) {
				e.printStackTrace();
		}

		if(monster.health <= 0) {
			if(monster.name.equals(dragon.name)) {
				make_slow(2);
				System.out.println(monster.name+"이(가) 죽었습니다.\n");
			}else {
				reward = rand.nextInt(monster.money) + 1;
				make_slow(2);
				System.out.println(monster.name+"이(가) 죽었습니다.");
				make_slow(2);
				System.out.println("보상으로 금화 "+reward+"개를 얻었습니다.\n");
				player.money += reward;
			}
		}
		check_fight = false;
		meet_monster++;
		return_posture();
		if(monster.name.equals(dragon.name) && monster.health <= 0) {
			check_finished = true;
		}
		monster.health = monster.max_health;
		run = false;
		if(player.burned && player_potion.contains(antipyrotic.name) && check_finished == false) {
			System.out.println("화상 치료제를 사용할까요? \n[1. 예]  [2. 아니오]");
			choice = sc.nextInt();
			if(choice == 1) {
				System.out.println("["+antipyrotic.name+"를 사용하였습니다.]\n");
				player_potion.remove(antipyrotic.name);
				player.burned = false;
			}
		}else if(player.posioned && player_potion.contains(antidote.name) && check_finished == false) {
			System.out.println("해독제를 사용할까요? \n[1. 예]  [2. 아니오]");
			choice = sc.nextInt();
			if(choice == 1) {
				System.out.println("["+antidote.name+"를 사용하였습니다.]\n");
				player_potion.remove(antidote.name);
				player.posioned = false;
			}
		}
		make_slow(1);
	}
	
	
	
	
	public static void player_fight() { // 플레이어의 전투 행동
		int can_run = 40; // 도망칠 수 있는 확률
		while(true) {
			System.out.println("어떤 행동을 하시겠습니까?");
			System.out.println("1. 공격하기\n2. 스킬 사용하기(마나 20 소모)\n3. 물약 사용하기\n4. 도망치기");
			choice = sc.nextInt();
			if(choice == 1) {
					System.out.println(monster.name+"을(를) 공격했습니다.\n");
					damage = player.power - monster.defense;
					if(damage < 0) {
						damage = 1;
						monster.health -= damage;
					}
					else monster.health -= damage;
					System.out.println(monster.name+"에게 "+damage+"만큼의 피해를 입혔습니다.\n");
					player_turn = false;
					break;
				
			}else if(choice == 2) {
				System.out.println("스킬을 선택해주세요.");
				if(player.equipped_shield) { // 방패를 착용한 경우
					System.out.println("1. 방패 스킬 (마나 10 소모)");
					System.out.println("2. 자세 스킬 (마나 20 소모)");
					if((sword_upgrade_2.equipped || axe_upgrade_2.equipped || bow_upgrade_2.equipped || shield_upgrade_2.equipped) && player.ultimate_count == 1) {
						System.out.println("3. 궁극기(마나 30 소모, 단 한 번만 사용 가능합니다.)");
					}
					System.out.println("0. 뒤로");
					choice = sc.nextInt();
					if(choice == 0) {
						System.out.println();
						continue;
					}else if(choice == 3 && (sword_upgrade_2.equipped || axe_upgrade_2.equipped || bow_upgrade_2.equipped || shield_upgrade_2.equipped) && player.ultimate_count == 1){ // 궁극기 사용
						if(player.mana < 30) {
							System.out.println("스킬을 사용할 마나가 부족합니다.\n");
							continue;
						}else {
							if(shield_upgrade_2.equipped) { // 방패의 궁극기 포함
								System.out.println("궁극기를 선택해주세요.\n1. 무기의 궁극기\n2. 방패의 궁극기\n0. 뒤로");
								choice = sc.nextInt();
								if(choice == 0) {
									System.out.println();
									continue;
								}else if(choice == 1) { // 무기의 궁극기
									if(player.ultimate_weapon.equals(sword_upgrade_2.name)) { // 검의 궁극기
										sword_upgrade_2.skill();
										System.out.println(monster.name+"에게 "+sword_upgrade_2.skill_damage+"만큼의 피해를 입혔습니다!\n");
										monster.health -= sword_upgrade_2.skill_damage;
									}else if(player.ultimate_weapon.equals(bow_upgrade_2.name)) { // 활의 궁극기
										bow_upgrade_2.skill();
										System.out.println(monster.name+"에게 "+bow_upgrade_2.skill_damage+"만큼의 피해를 입혔습니다!\n");
										monster.health -= bow_upgrade_2.skill_damage;
									}else { // 도끼의 궁극기
										axe_upgrade_2.skill();
										System.out.println(monster.name+"에게 "+axe_upgrade_2.skill_damage+"만큼의 피해를 입혔습니다!\n");
										monster.health -= axe_upgrade_2.skill_damage;
									}
									player.mana -= 30;
									player.ultimate_count--;
									player_turn = false;
									break;
								}else { // 방패의 궁극기
									shield_upgrade_2.skill();
									player.defense += shield_upgrade_2.damage;
									player.mana -= 30;
									player.ultimate_count--;
									player_turn = false;
									break;
								}
							}else { // 방패는 강화 2단계가 아닐 경우
								if(player.ultimate_weapon.equals(sword_upgrade_2.name)) { // 검의 궁극기
									sword_upgrade_2.skill();
									System.out.println(monster.name+"에게 "+sword_upgrade_2.skill_damage+"만큼의 피해를 입혔습니다!\n");
									monster.health -= sword_upgrade_2.skill_damage;
								}else if(player.ultimate_weapon.equals(bow_upgrade_2.name)) { // 활의 궁극기
									bow_upgrade_2.skill();
									System.out.println(monster.name+"에게 "+bow_upgrade_2.skill_damage+"만큼의 피해를 입혔습니다!\n");
									monster.health -= bow_upgrade_2.skill_damage;
								}else { // 도끼의 궁극기
									axe_upgrade_2.skill();
									System.out.println(monster.name+"에게 "+axe_upgrade_2.skill_damage+"만큼의 피해를 입혔습니다!\n");
									monster.health -= axe_upgrade_2.skill_damage;
								}
								player.mana -= 30;
								player.ultimate_count--;
								player_turn = false;
								break;
							}
						}
					}else if(choice == 1) {
						if(player.mana < 10) {
							System.out.println("스킬을 사용할 마나가 부족합니다.\n");
							continue;
						}else {
							
						}
					}else if(choice == 2){
						if(player.mana < 20) {
							System.out.println("스킬을 사용할 마나가 부족합니다.\n");
							continue;
						}else {
								use_skill(skill_choice);
								player_turn = false;
								break;
							
						}
					}else {
						System.out.println("스킬을 다시 선택해주십시오.\n");
						continue;
					}
				}else {
					System.out.println("1. 자세 스킬 (마나 20 소모)");
					if((sword_upgrade_2.equipped || axe_upgrade_2.equipped || bow_upgrade_2.equipped || shield_upgrade_2.equipped) && player.ultimate_count == 1) {
						System.out.println("2. 궁극기(마나 30 소모, 단 한 번만 사용 가능합니다.)");
					}
					System.out.println("0. 뒤로");
					choice = sc.nextInt();
					if(choice == 0) {
						System.out.println();
						continue;
					}else if(choice == 2 && (sword_upgrade_2.equipped || axe_upgrade_2.equipped || bow_upgrade_2.equipped) && player.ultimate_count == 1) { // 궁극기 사용
						if(player.mana < 30) {
							System.out.println("스킬을 사용할 마나가 부족합니다.\n");
							continue;
						}else {
							if(player.ultimate_weapon.equals(sword_upgrade_2.name)) { // 검의 궁극기
								sword_upgrade_2.skill();
								System.out.println(monster.name+"에게 "+sword_upgrade_2.skill_damage+"만큼의 피해를 입혔습니다!\n");
								monster.health -= sword_upgrade_2.skill_damage;
							}else if(player.ultimate_weapon.equals(bow_upgrade_2.name)) { // 활의 궁극기
								bow_upgrade_2.skill();
								System.out.println(monster.name+"에게 "+bow_upgrade_2.skill_damage+"만큼의 피해를 입혔습니다!\n");
								monster.health -= bow_upgrade_2.skill_damage;
							}else { // 도끼의 궁극기
								axe_upgrade_2.skill();
								System.out.println(monster.name+"에게 "+axe_upgrade_2.skill_damage+"만큼의 피해를 입혔습니다!\n");
								monster.health -= axe_upgrade_2.skill_damage;
							}
							player.mana -= 30;
							player.ultimate_count--;
							player_turn = false;
							break;
						}
					}else if(choice == 1) {
						if(player.mana < 20) {
							System.out.println("스킬을 사용할 마나가 부족합니다.\n");
							continue;
						}else {
								use_skill(skill_choice);
								player_turn = false;
								break;
							
						}
					}else {
						System.out.println("스킬을 다시 선택해주십시오.\n");
						continue;
					}
				}
			}else if(choice == 3) { // 물약 사용하기
				if(player_potion.size() == 0) {
					System.out.println("현재 가지고 있는 물약이 없습니다.\n");
					continue;
				}else {
					System.out.print("현재 가지고 있는 물약: ");
					for(int i = 0; i < player_potion.size(); i++) {
						System.out.print(player_potion.get(i));
						if(i != player_potion.size() - 1)
							System.out.print(", ");
					}
					System.out.println();
					System.out.println("사용하고 싶은 물약을 선택해주세요.");
					
					HashSet<String> potion_list_temp = new HashSet<String>(player_potion); // 물약 선택시 중복 제거를 위한 변수
					ArrayList<String> potion_list = new ArrayList<String>(potion_list_temp);
					Collections.sort(potion_list);
					
					for(int i = 0; i < potion_list.size(); i++) {
						System.out.println((i+1)+". "+potion_list.get(i));
					}
					System.out.println("0. 뒤로");
					choice = sc.nextInt();
					if(choice == 0) {
						System.out.println();
						continue;
					}else if(choice <= potion_list.size())
						choice_potion(potion_list.get(choice - 1));
					else {
						System.out.println("물약을 다시 선택해주세요.\n"); 
						continue;
					}
					
					if(use_potion) {
						use_potion = false;
						player_turn = false;
						break;
					}else continue;
					
				}
			}else {
				if(monster.name.equals(dragon.name)) {
					System.out.println("도망치려고 뒤로 돌아선 순간 용의 발에 강하게 맞았습니다.");
					System.out.println("체력이 99만큼 떨어졌습니다.\n");
					player.health -= 99;
					if(player.health < 0) {
						player.health = 0;
						break;
					}
					continue;
				}else if(rand.nextInt(100) >= can_run) {
					System.out.println(monster.name+"(으)로부터 도망쳤습니다.\n");
					run = true;
					break;
				}else {
					System.out.println("도망치지 못했습니다.\n");
					player_turn = false;
					break;
				}
			}
		}
	}
	
	
	
	
	public static void monster_fight() { // 몬스터의 전투 행동
		if(rand.nextInt(100) < monster.accuracy) {
			if(rand.nextInt(100) < monster.skill_persent) { // 몬스터가 스킬을 사용
				monster_skill(monster.name);
			}else { // 몬스터의 일반 공격
				damage = monster.power - player.defense;
				if(damage < 0) {
					damage = 1;
					player.health -= damage;
				}else player.health -= damage;
				System.out.println(monster.name + "이(가) 공격했습니다.");
				System.out.println(damage+"만큼의 피해를 입었습니다.\n");
			}
		}else {
			System.out.println(monster.name + "의 공격이 빗나갔습니다.\n");
		}
		player_turn = true;
	}
	
	
	
	
	public static void monster_skill(String monster_name) { // 몬스터 스킬
		int skill_num = 0; // 드래곤의 스킬 선택을 위한 변수
		
		if(monster_name.equals(undead.name)) { // 언데드
			undead.skill();
			damage = undead.power/2*3 - player.defense;
			if(damage < 0) {
				damage = 2;
				player.health -= damage;
			}else player.health -= damage;
			System.out.println(damage+"만큼의 피해를 입었습니다.\n");
		}else if(monster_name.equals(slime.name)) { // 슬라임
			slime.skill();
			damage = 10;
			monster.defense += damage;
			System.out.println(slime.name+"의 방어력이 "+damage+" 증가했습니다.\n");
		}else if(monster_name.equals(goblin.name)) { // 고블린
			goblin.skill();
			damage = monster.speed/4*3 - player.defense;
			if(damage < 0) {
				damage = 2;
				player.health -= damage;
			}else player.health -= damage;
			System.out.println(damage+"만큼의 피해를 입었습니다.\n");
		}else if(monster_name.equals(ghost.name)) { // 고스트
			ghost.skill();
			damage = player.power/2;
			player.health -= damage;
			System.out.println(ghost.name+"에게 홀려서 자기 자신을 공격했습니다.\n");
		}else if(monster_name.equals(troll.name)) { // 트롤
			troll.skill();
			damage = monster.defense/4*3 - player.defense;
			if(damage < 0) {
				damage = 2;
				player.health -= damage;
			}else player.health -= damage;
			System.out.println(damage+"만큼의 피해를 입었습니다.\n");
		}else if(monster_name.equals(griffin.name)) { // 그리핀
			griffin.skill();
			damage = monster.speed - player.defense;
			if(damage < 0) {
				damage = 2;
				player.health -= damage;
			}else player.health -= damage;
			System.out.println(damage+"만큼의 피해를 입었습니다.\n");
		}else { // 드래곤
			skill_num = rand.nextInt(2) + 1;
			if(skill_num == 1) {
				dragon.skill_1();
				damage = monster.power/2*(rand.nextInt(3)+1) - player.defense;
				if(damage < 0) {
					damage = 2;
					player.health -= damage;
				}else player.health -= damage;
				System.out.println(damage+"만큼의 피해를 입었습니다.\n");
			}else {
				dragon.skill_2();
				damage = (monster.power + monster.speed) / (rand.nextInt(3)+1) - player.defense;
				if(damage < 0) {
					damage = 2;
					player.health -= damage;
				}else player.health -= damage;
				System.out.println(damage+"만큼의 피해를 입었습니다.\n");
			}
		}
	}
	
	
	
	
	public static void print_fight() { // 전투 상황을 보여줌
		/*if(player_turn) {
			if(player.health < 0) {
				player.health = 0;
			}
			if(monster.health < 0) {
				monster.health = 0;
			}
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
			System.out.println();
			System.out.printf("현재 턴: %s\n", player.name);
			System.out.printf("다음 턴:                                                   %s\n", monster.name);
			System.out.println();
			System.out.printf("체력: %3d / 100                                     체력: %3d / %3d\n", player.health, monster.health, monster.max_health);
			System.out.printf("마나: %3d / 100\n", player.mana);
			System.out.printf("공격력: %3d                                        공격력: %3d\n", player.power, monster.power);
			System.out.printf("방어력: %3d                                        방어력: %3d\n", player.defense, monster.defense);
			System.out.printf("속도:  %3d                                         속도: %3d\n", player.speed, monster.speed);
			System.out.println("현재 자세: "+player.posture_now);
			System.out.println();
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
			System.out.println();			
		}else {
			if(player.health < 0) {
				player.health = 0;
			}
			if(monster.health < 0) {
				monster.health = 0;
			}
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
			System.out.println();
			System.out.printf("현재 턴:                                                   %s\n", monster.name);
			System.out.printf("다음 턴: %s\n", player.name);
			System.out.println();
			System.out.printf("체력: %3d / 100                                     체력: %3d / %3d\n", player.health, monster.health, monster.max_health);
			System.out.printf("마나: %3d / 100\n", player.mana);
			System.out.printf("공격력: %3d                                        공격력: %3d\n", player.power, monster.power);
			System.out.printf("방어력: %3d                                        방어력: %3d\n", player.defense, monster.defense);
			System.out.printf("속도:  %3d                                         속도: %3d\n", player.speed, monster.speed);
			System.out.println("현재 자세: "+player.posture_now);
			System.out.println();
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
			System.out.println();
		}*/
		
		if(player.health < 0) {
			player.health = 0;
		}
		if(monster.health < 0) {
			monster.health = 0;
		}
		System.out.println("=====================================================================");
		System.out.println();
		System.out.println("<"+player.name+">");
		System.out.print("체력: ");
		for(int i = 0; i < player.health/10; i++) {
			System.out.print("♥ ");
		}
		System.out.printf(" (%d / 100)", player.health);
		System.out.println();
		System.out.print("마나: ");
		for(int i = 0; i < player.mana/20; i++) {
			System.out.print("◆ ");
		}
		System.out.printf(" (%d / 100)", player.mana);
		System.out.println();
		System.out.println("현재 자세: "+player.posture_now);
		System.out.print("현재 가지고 있는 장비: ");
		for(int i = 0; i < player_equipped_item.size(); i++) {
			System.out.print(player_equipped_item.get(i));
			if(i != player_equipped_item.size() - 1)
				System.out.print(", ");
		}
		System.out.println();
		Collections.sort(player_potion);
		System.out.print("현재 가지고 있는 물약: ");
		for(int i = 0; i < player_potion.size(); i++) {
			System.out.print(player_potion.get(i));
			if(i != player_potion.size() - 1)
				System.out.print(", ");
		}
		System.out.println("\n");
		System.out.println("<"+monster.name+">");
		System.out.print("체력: ");
		for(int i = 0; i < monster.health/20; i++) {
			System.out.print("♥ ");
		}
		System.out.printf(" (%d / %d)\n\n", monster.health, monster.max_health);
		System.out.println("=====================================================================");
		System.out.println();
		System.out.println("플레이어의 행동을 적절한 타이밍에 누르세요.\n[1. 공격하기], [2. 스킬 사용하기], [3. 회피하기], [4. 막기], [5. 체력 물약 먹기], [6. 마나 물약 먹기], [7. 해독제 및 화상 치료제 먹기]\n");
	}
	
	
	
	public static void event(int num) { // 이벤트
		int random_num = 0; // 결과에 대한 랜덤 변수
		
		make_slow(1);
		if(num == 1 && ex_event_num != 1) { // 빛나는 액체 이벤트
			System.out.println("◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇");
			System.out.println();
			make_slow(2);
			System.out.println("당신은 지옥 한 가운데에서 괴물들과 싸웠던 전사들의 전초기지를 발견하였습니다.");
			make_slow(2);
			System.out.println("황폐한 기지 가운데 빛이 흘러나오길래 당신은 빛을 향해 다가갔습니다.");
			make_slow(2);
			System.out.println("놀랍게도 빛이 흘러나오는 곳은 어느 병사의 시체 위에 놓여있던 유리병 속 액체였습니다.");
			make_slow(2);
			System.out.println("유리병 속 액체는 영롱한 빛을 내뿜으며 당신이 마셔주기를 바라고 있습니다.");
			make_slow(2);
			System.out.println();
			System.out.println("◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇\n");
			make_slow(1);
			System.out.println("마시겠습니까? \n[1. 예]  [2. 아니오]");
			choice = sc.nextInt();
			make_slow(2);
			if(choice == 1) { // 빛나는 액체 이벤트
				random_num = rand.nextInt(10)+1;
				if(random_num < 5) { // 좋은 결과
					System.out.println("빛나는 액체를 들이킨 당신은 몸에서 힘이 나는 것이 느껴졌습니다.");
					make_slow(2);
					System.out.println("당신의 체력과 마나가 가득찼습니다.\n");
					make_slow(1);
					player.health = 100;
					player.mana = 100;
				}else {
					System.out.println("빛나는 액체를 들이킨 당신은 몸 안에서 무엇인가 잘못되는 것을 느꼈습니다.");
					make_slow(2);
					System.out.println("괴로워하면서 주저앉을 때 저 멀리서 웃고 있는 꼬마 괴물들의 모습이 보였습니다.");
					make_slow(2);
					System.out.println("당신의 체력이 20이 줄어들었습니다.\n");
					make_slow(1);
					player.health -= 20;
				}
			}else {
				System.out.println("\'무엇인지도 모르는 액체를 함부로 마시면 안되지.\'");
				make_slow(2);
				System.out.println("이렇게 생각한 당신은 액체에서 나오는 빛을 무시하고 다시 앞으로 나아갔습니다.\n");
				make_slow(1);
			}
			ex_event_num = 1;
		}else if(num == 2 && ex_event_num != 2) { // 날아온 돌 이벤트
			System.out.println("◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇");
			System.out.println();
			make_slow(2);
			System.out.println("용을 향해 나아가던 중 갑자기 옆에서 돌이 날아와 머리를 맞췄습니다.");
			make_slow(2);
			System.out.println("안 그래도 힘든데 엄한 곳에서 돌이 날아오니 짜증이 올라왔습니다.");
			make_slow(2);
			System.out.println("화가 난 당신은 돌이 날아온 곳으로 쫓아갈까 고민을 하였습니다. ");
			make_slow(2);
			System.out.println();
			System.out.println("◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇\n");
			make_slow(1);
			System.out.println("쫓아가시겠습니까?\n[1. 예]  [2. 아니오]");
			choice = sc.nextInt();
			make_slow(2);
			if(choice == 1) {
				random_num = rand.nextInt(100);
				System.out.println("돌이 날아온 곳으로 달려가던 중 주변에서 괴물들이 튀어나와 공격을 하였습니다.");
				make_slow(2);
				System.out.println("아무래도 함정에 빠진 것 같습니다.");
				make_slow(2);
				if(random_num < 30) {
					System.out.println("갑작스러운 전투였지만 차분히 싸운 당신은 괴물들을 모두 물리쳤습니다.");
					make_slow(2);
					System.out.println("괴물과의 전투에서 적절한 방어 방법을 알아내었습니다.");
					make_slow(2);
					System.out.println("방어력이 50 증가했습니다.\n");
					make_slow(1);
					player.defense += 50;
				}else {
					System.out.println("한참의 전투 끝에 겨우 도망쳤습니다.");
					make_slow(2);
					System.out.println("하지만 도망치던 도중 큰 부상을 입었습니다.");
					make_slow(2);
					System.out.println("체력이 30 줄었습니다.\n");
					make_slow(1);
					player.health -= 30;
				}
			}else {
				System.out.println("\"어서 빨리 바람을 멈춰야하는데 이런 곳에 신경쓸 수 없지.\"");
				make_slow(2);
				System.out.println("올라오는 화를 참고 용을 바라보며 나아갔습니다.\n");
				make_slow(1);
			}
			ex_event_num = 2;
		}else if(num == 3 && ex_event_num != 3){ // 괴물들의 마을
			System.out.println("◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇");
			System.out.println();
			make_slow(2);
			System.out.println("불타고 있는 마을이 눈 앞에 보입니다.");
			make_slow(2);
			System.out.println("가까이 다가가니 마을에는 아무도 없는 것 같습니다.");
			make_slow(2);
			System.out.println("당신은 혹시나 쓸만한 물건이 있지 않을까 하여 마을 곳곳을 둘러보았습니다.");
			make_slow(2);
			System.out.println("우연히 한 집에 들어가보니 귀해보이는 상자가 있었습니다.");
			make_slow(2);
			System.out.println("상자를 열면 귀한 것이 있을 것 같습니다.");
			make_slow(2);
			System.out.println();
			System.out.println("◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇\n");
			make_slow(1);
			System.out.println("상자를 여시겠습니까?\n[1. 예]  [2. 아니오]");
			choice = sc.nextInt();
			make_slow(2);
			if(choice == 1) {
				random_num = rand.nextInt(100);
				if(random_num < 60) {
					System.out.println("상자를 천천히 열어보니 안에는 수 많은 금화가 있었습니다.");
					make_slow(2);
					System.out.println("좋은 기분으로 금화들을 주머니에 넣었습니다.");
					make_slow(2);
					System.out.println("금화 100개를 얻었습니다.\n");
					make_slow(1);
					player.money += 100;
				}else if(random_num < 90) {
					System.out.println("상자를 열어 보았지만 아무런 물건도 없었습니다.");
					make_slow(2);
					System.out.println("실망한 마음으로 마을을 떠났습니다.\n");
					make_slow(1);
				}else {
					System.out.println("상자를 천천히 열어보니 안에 응축되어 있던 저주가 나왔습니다.");
					make_slow(2);
					System.out.println("저주에 맞은 당신은 고통스럽게 주저앉았습니다.");
					make_slow(2);
					System.out.println("공격력, 방어력, 속도가 각각 10씩 줄어듭니다.\n");
					make_slow(1);
					player.power -= 10;
					player.defense -= 10;
					player.speed -= 10;
					if(player.power < 0)
						player.power = 0;
					if(player.defense < 0)
						player.defense = 0;
					if(player.speed < 0)
						player.speed = 0;
				}
			}else {
				System.out.println("누구의 상자인지는 몰라도 건들지 않는 것이 좋을 것이라 판단했습니다.");
				make_slow(2);
				System.out.println("상자를 내버려두고 마을을 나왔습니다.\n");
				make_slow(1);
			}
			ex_event_num = 3;
		}else if(num == 4 && ex_event_num != 4) { // 괴물의 알
			System.out.println("◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇");
			System.out.println();
			make_slow(2);
			System.out.println("한참을 걸어가던 당신은 배가 고파지기 시작했습니다.");
			make_slow(2);
			System.out.println("먹을 것이 없나 둘러보다가 저 멀리 알처럼 보이는 것이 있어서 다가갔습니다.");
			make_slow(2);
			System.out.println("알의 크기가 공룡알과 같이 크고 색깔도 보라색을 띄고 있는 것으로 보아 괴물의 알인 것 같습니다.");
			make_slow(2);
			System.out.println("괴물의 알이라 어떤 일이 벌어질지 모릅니다.");
			make_slow(2);
			System.out.println();
			System.out.println("◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇\n");
			make_slow(1);
			System.out.println("알을 먹을까요?\n[1. 예]  [2. 아니오]");
			choice = sc.nextInt();
			make_slow(2);
			if(choice == 1) {
				random_num = rand.nextInt(100);
				if(random_num < 60) {
					System.out.println("괴물의 알이라 걱정을 하면서 요리를 했는데 맛이 나쁘지 않았습니다.");
					make_slow(2);
					System.out.println("그러나 얼마지나지 않아 속이 뒤집어지는 것 같은 느낌이 들며 먹은 것을 전부 토해내었습니다.");
					make_slow(2);
					System.out.println("한참을 게우고 나니 기운이 빠지고 무엇보다 마력이 소진된 것을 느꼈습니다.");
					make_slow(2);
					System.out.println("마나가 20 줄어듭니다.\n");
					make_slow(1);
					player.mana -= 20;
					if(player.mana < 0)
						player.mana = 0;	
				}else {
					System.out.println("괴물의 알이라 걱정을 하면서 요리를 했는데 맛도 괜찮고 무엇보다 먹으면서 마력이 충만해지는 것을 느꼈습니다.");
					make_slow(2);
					System.out.println("마나가 가득 찼습니다.\n");
					make_slow(1);
					player.mana = 100;
				}
			}else {
				random_num = rand.nextInt(100);
				System.out.println("어떤 일이 벌어질지 모르기에 먹지 않고 지나치기로 하였습니다.");
				make_slow(2);
				if(random_num < 80) {
					System.out.println("허기를 달래지 못해서 체력이 10 떨어졌습니다.\n");
					player.health -= 10;
				}else {
					System.out.println("배가 고파 주머니를 뒤져보니 먹지 않은 육포가 있어서 그것으로 허기를 달랬습니다.\n");
				}
				make_slow(1);
			}
			ex_event_num = 4;
		}else if(num == 5 && help_baby_monster == 0) { // 괴물을 돕는 이벤트
			random_num = rand.nextInt(50)+1;
			System.out.println("새끼 괴물을 만났습니다.");
			make_slow(1);
			while(true) {
				System.out.println("자세를 선택해주세요.\n\n[1. 공격 자세 : 공격력을 증가시켜주는 자세]\n[2. 방어 자세 : 받는 데미지를 줄여주는 자세]\n[3. 신속 자세 : 행동 속도를 높여주는 자세]\n[4. 자세를 취하지 않기]");
				choice = sc.nextInt();
				make_slow(2);
				if(choice == 1) {
					System.out.printf("당신은 %s를 취하고 힘차게 새끼 괴물을 죽였습니다.\n", power_posture.name);
					make_slow(2);
					System.out.println("새끼 괴물이 죽었습니다.");
					make_slow(2);
					System.out.println("보상으로 금화 "+random_num+"개를 얻었습니다.");
					make_slow(2);
					System.out.println("새끼 괴물의 죽음으로 모든 괴물들이 분노하였습니다.");
					make_slow(2);
					System.out.println("앞으로 모든 괴물들의 공격력이 20씩 오릅니다.\n");
					make_slow(1);
					help_baby_monster = 2;
					break;
				}else if(choice == 2) {
					System.out.printf("당신은 %s를 취하고 천천히 새끼 괴물을 죽였습니다.\n", defense_posture.name);
					make_slow(2);
					System.out.println("새끼 괴물이 죽었습니다.");
					make_slow(2);
					System.out.println("보상으로 금화 "+random_num+"개를 얻었습니다.");
					make_slow(2);
					System.out.println("새끼 괴물의 죽음으로 모든 괴물들이 분노하였습니다.");
					make_slow(2);
					System.out.println("앞으로 모든 괴물들의 공격력이 20씩 오릅니다.\n");
					make_slow(1);
					help_baby_monster = 2;
					break;
				}else if(choice == 3) {
					System.out.printf("당신은 %s를 취하고 빠르게 새끼 괴물을 죽였습니다.\n", speed_posture.name);
					make_slow(2);
					System.out.println("새끼 괴물이 죽었습니다.");
					make_slow(2);
					System.out.println("보상으로 금화 "+random_num+"개를 얻었습니다.");
					make_slow(2);
					System.out.println("새끼 괴물의 죽음으로 모든 괴물들이 분노하였습니다.");
					make_slow(2);
					System.out.println("앞으로 모든 괴물들의 공격력이 20씩 오릅니다.\n");
					make_slow(1);
					help_baby_monster = 2;
					break;
				}else if(choice == 4) {
					System.out.println("◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇");
					System.out.println();
					make_slow(2);
					System.out.println("자세를 취하지 않고 가만히 서서 새끼 괴물을 바라보니 그 괴물은 마치 자신을 따라오라는 듯한 행동을 하였습니다.");
					make_slow(2);
					System.out.println("그 행동이 매우 급해보여 당신은 괴물을 따라가 보았습니다.");
					make_slow(2);
					System.out.println("도착한 곳에는 절벽이 있었고 새끼 괴물과 크기와 생김새가 같아보이는 괴물이 아슬아슬하게 매달려 있었습니다.");
					make_slow(2);
					System.out.println("괴물은 도와달라는 듯한 표정을 짓고 있었습니다.");
					System.out.println();
					System.out.println("◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇\n");
					make_slow(1);
					System.out.println("도와줄까요?\n[1. 예]  [2. 아니오]");
					choice = sc.nextInt();
					make_slow(2);
					if(choice == 1) {
						System.out.println("\"저 괴물이 성장하면 더욱 많은 사람들을 죽일 수 있어.\"");
						make_slow(2);
						System.out.println("\"그렇다고 외면할 수는 없어.\"");
						make_slow(2);
						System.out.println("당신은 절벽에 매달려 있는 괴물을 도와주었습니다.");
						make_slow(2);
						System.out.println("새끼 괴물들은 고맙다는 듯한 행동을 하며 저 멀리 사라졌습니다.");
						make_slow(2);
						System.out.println("새끼 괴물이 떨어지기 전에 빠르게 잡았기에 속도가 30 올랐습니다.\n");
						make_slow(1);
						player.speed += 30;
						help_baby_monster = 1;
						break;
					}else {
						System.out.println("\"저 괴물이 성장하면 더욱 많은 사람들을 죽일 수 있어.\"");
						make_slow(2);
						System.out.println("상황은 안타까웠지만 당신은 왕국의 미래를 위해서 뒤돌아섰습니다.");
						make_slow(2);
						System.out.println("새끼 괴물의 죽음으로 모든 괴물들이 분노하였습니다.");
						make_slow(2);
						System.out.println("앞으로 모든 괴물들의 공격력이 20씩 오릅니다.\n");
						make_slow(1);
						help_baby_monster = 2;
						break;
					}
				}else {
					System.out.println("다시 선택해주세요.\n");
					continue;
				}
			}
		}else if(num == 6 && ex_event_num != 6) { // 물 소환 이벤트
			random_num = rand.nextInt(100);
			System.out.println("◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇");
			System.out.println();
			make_slow(2);
			System.out.println("지옥의 용암들의 열기 속을 헤쳐나가고 있는 당신");
			make_slow(2);
			System.out.println("너무나 더워서 목이 매우 마르기 시작했습니다.");
			make_slow(2);
			System.out.println("물통의 물은 이미 없어진지 오래입니다.");
			make_slow(2);
			System.out.println("물 없이 더 이상 나아가기는 힘들듯 합니다.");
			make_slow(2);
			System.out.println("그런 당신은 어릴적 마법교사가 가르쳐준 물 소환마법이 생각납니다.");
			make_slow(2);
			System.out.println("재능이 없어 할 줄 아는 마법이 물 소환과 신체 강화밖에 없지만 지금은 절실합니다.");
			make_slow(2);
			System.out.println("그래서 공기 중의 수분을 모아 물을 소환하는 마법을 시도해보기로 했습니다.");
			make_slow(2);
			System.out.println();
			System.out.println("◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇\n");
			make_slow(1);
			System.out.println("얼마만큼의 물을 소환할까요?\n[1. 가득]  [2. 반만]  [3. 소환하지 않는다.]");
			choice = sc.nextInt();
			if(choice == 1) {
				System.out.println("물을 가득 소환한 당신은 물을 마시고 정신을 차렸습니다.");
				make_slow(2);
				System.out.println("어릴 때 더 열심히 공부해볼껄 이라는 후회가 생겼지만 그래도 물이 생긴 것에 감사했습니다.");
				make_slow(2);
				System.out.println("정신을 차리면서 체력이 50만큼 회복되었습니다.");
				make_slow(2);
				System.out.println("그러나 미숙한 마법으로 물을 소환하면서 마력을 전부 사용해버렸습니다.\n");
				make_slow(1);
				player.health += 50;
				player.mana = 0;
				if(player.health > 100)
					player.health = 100;
			}else if(choice == 2) {
				if(random_num < 50) {
					System.out.println("물을 반 정도 소환한 당신은 물을 마시고 정신을 차렸습니다.");
					make_slow(2);
					System.out.println("어릴 때 더 열심히 공부해볼껄 이라는 후회가 생겼지만 그래도 물이 생긴 것에 감사했습니다.");
					make_slow(2);
					System.out.println("정신을 차리면서 체력이 50만큼 회복되었습니다.");
					make_slow(2);
					System.out.println("그리고 물을 소환하면서 마력이 20만큼 소모되었습니다.\n");
					make_slow(1);
					player.health += 50;
					player.mana -= 20;
					if(player.health > 100)
						player.health = 100;
					if(player.mana < 0)
						player.mana = 0;
				}else {
					System.out.println("물을 반 정도 소환한 당신은 물을 마시고 정신을 차렸습니다.");
					make_slow(2);
					System.out.println("어릴 때 더 열심히 공부해볼껄 이라는 후회가 생겼지만 그래도 물이 생긴 것에 감사했습니다.");
					make_slow(2);
					System.out.println("그러나 미숙한 마법으로 물을 소환하면서 마력을 전부 사용해버렸습니다.\n");
					make_slow(1);
					player.mana = 0;
				}
			}else {
				System.out.println("정신력으로 버티기로 한 당신은 묵묵히 앞으로 걸어갔습니다.");
				make_slow(2);
				System.out.println("그렇지만 정신력으로는 한계가 있습니다.");
				make_slow(2);
				System.out.println("극심한 갈증으로 인해 체력이 50만큼 떨어집니다.");
				make_slow(1);
				player.health -= 50;
				if(player.health < 0)
					player.health = 0;
			}
			ex_event_num = 6;
		}else { // 괴물들의 마을
			System.out.println("◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇");
			System.out.println();
			make_slow(2);
			System.out.println("불타고 있는 마을이 눈 앞에 보입니다.");
			make_slow(2);
			System.out.println("가까이 다가가니 마을에는 아무도 없는 것 같습니다.");
			make_slow(2);
			System.out.println("당신은 혹시나 쓸만한 물건이 있지 않을까 하여 마을 곳곳을 둘러보았습니다.");
			make_slow(2);
			System.out.println("우연히 한 집에 들어가보니 귀해보이는 상자가 있었습니다.");
			make_slow(2);
			System.out.println("상자를 열면 귀한 것이 있을 것 같습니다.");
			make_slow(2);
			System.out.println();
			System.out.println("◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇\n");
			make_slow(1);
			System.out.println("상자를 여시겠습니까?\n[1. 예]  [2. 아니오]");
			choice = sc.nextInt();
			make_slow(2);
			if(choice == 1) {
				random_num = rand.nextInt(100);
				if(random_num < 60) {
					System.out.println("상자를 천천히 열어보니 안에는 수 많은 금화가 있었습니다.");
					make_slow(2);
					System.out.println("좋은 기분으로 금화들을 주머니에 넣었습니다.");
					make_slow(2);
					System.out.println("금화 100개를 얻었습니다.\n");
					make_slow(1);
					player.money += 100;
				}else if(random_num < 90) {
					System.out.println("상자를 열어 보았지만 아무런 물건도 없었습니다.");
					make_slow(2);
					System.out.println("실망한 마음으로 마을을 떠났습니다.\n");
					make_slow(1);
				}else {
					System.out.println("상자를 천천히 열어보니 안에 응축되어 있던 저주가 나왔습니다.");
					make_slow(2);
					System.out.println("저주에 맞은 당신은 고통스럽게 주저앉았습니다.");
					make_slow(2);
					System.out.println("공격력, 방어력, 속도가 각각 10씩 줄어듭니다.\n");
					make_slow(1);
					player.power -= 10;
					player.defense -= 10;
					player.speed -= 10;
					if(player.power < 0)
						player.power = 0;
					if(player.defense < 0)
						player.defense = 0;
					if(player.speed < 0)
						player.speed = 0;
				}
			}else {
				System.out.println("누구의 상자인지는 몰라도 건들지 않는 것이 좋을 것이라 판단했습니다.");
				make_slow(2);
				System.out.println("상자를 내버려두고 마을을 나왔습니다.\n");
				make_slow(1);
			}
		}
	}
	
	
	
	public static void stage_break_time() { // 스테이지 중간 단계
		if(stage_1_clear) { // 두 번째 휴식시간
			make_slow(2);
			System.out.println("=================================");
			make_slow(2);
			System.out.println("2 스테이지를 클리어하셨습니다.");
			make_slow(2);
			System.out.println("클리어 보상으로 체력 물약이 추가되었습니다.");
			make_slow(2);
			player_potion.add(hp_potion.name);
			System.out.println("=================================\n");
			make_slow(0);
			loading();
			make_slow(2);
			System.out.println("◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆\n");
			stage_2_clear = true;
			make_slow(2);
			volcano_image.setVisible(true);
			System.out.println("한참을 걸어온 당신은 화산에서부터 불어오는 강한 바람에 눈을 뜨기가 힘들었습니다.");
			make_slow(0);
			System.out.println("용에게 가까이 왔음을 느꼈지만 바람이 너무 강해서 앞으로 나아갈 수 없었습니다.");
			make_slow(0);
			System.out.println("당신은 하는 수 없이 주변에 있는 동굴로 들어가 바람이 잠잠해지기를 기다리기로 했습니다.");
			make_slow(0);
			System.out.println("그 때 동굴 안 쪽에서 빛이 나며 목소리가 들려왔습니다.");
			make_slow(0);
			System.out.println("\"저는 당신의 수호천사입니다. 용을 막기 위해서 도움을 드리려고 여기까지 왔습니다.\"");
			make_slow(0);
			System.out.println("\"이 앞에서부터는 더 이상 도와드릴 수 없습니다. 마지막 준비를 단단히 하시길 바랍니다.\"\n");
			make_slow(2);
			System.out.println("◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆");
			System.out.println();
			make_slow(0);
			volcano_image.setVisible(false);
			System.out.println("어떤 행동을 하시겠습니까?(한번 선택하면 되돌아갈 수 없습니다.)");
			System.out.println("[1. 강화하기]  [2. 물약상점 이용하기]  [3. 휴식하기]");
			choice = sc.nextInt();
			if(choice == 1) {
				System.out.println("-------------------------------------------------------------\n");
				make_slow(2);
				System.out.println("\"제가 가진 모든 힘을 쏟아부어 장비를 강화시켜드리겠습니다.\"");
				make_slow(0);
				System.out.println("수호천사는 당신의 장비를 바라보며 눈을 감기 시작했습니다.");
				make_slow(0);
				System.out.println("그 순간 천사의 몸에서 강한 빛이 뿜어져 나오며 당신을 감싸기 시작했습니다.\n");
				make_slow(2);
				System.out.println("-------------------------------------------------------------");
				System.out.println();
				make_slow(0);
				upgrade_weapon();
			}else if(choice == 2) {
				System.out.println("수호천사는 조용히 눈을 감기 시작했습니다.");
				make_slow(2);
				System.out.println("그와 함께 여러 물건들이 눈 앞에 나타났습니다.");
				make_slow(2);
				System.out.println("\"공짜로 드리고 싶지만 다른 곳의 물건을 일시적으로 순간이동 시킨 것이기에 정당한 값을 지불하셔야 합니다.\"");
				make_slow(2);
				System.out.println("물건의 구성이 낯익은 것을 보니 아마 괴물들의 마을의 물약상점인듯 싶다.\n");
				make_slow(1);
				while(true) {
					System.out.println("--------------------------------------");
					System.out.println("    목록                           가격   ");
					System.out.printf("1. %s                       %3d개\n", mp_potion.name, mp_potion.money);
					System.out.printf("2. %s                         %3d개\n", antidote.name, antidote.money);
					System.out.printf("3. %s                     %3d개\n", antipyrotic.name, antipyrotic.money);
					System.out.printf("4. %s                      %3d개\n", power_potion.name, power_potion.money);
					System.out.printf("5. %s                      %3d개\n", defense_potion.name, defense_potion.money);
					System.out.printf("6. %s                       %3d개\n", speed_potion.name, speed_potion.money);
					System.out.println("--------------------------------------");
					System.out.println("현재 가지고 있는 금화: "+player.money+"개");
					System.out.println("현재 무게: "+player.weight+" / 100");
					Collections.sort(player_potion);
					System.out.print("현재 가지고 있는 물약: ");
					for(int i = 0; i < player_potion.size(); i++) {
						System.out.print(player_potion.get(i));
						if(i != player_potion.size() - 1)
							System.out.print(", ");
					}
					System.out.println();
					System.out.println("어떤 물약을 구매하시겠습니까? (그만 두시려면 0을 눌러주세요)");
					choice = sc.nextInt();
					if(choice == 0) {
						System.out.println("\"이 정도면 충분하지.\"");
						make_slow(2);
						System.out.println("물약상점을 나왔습니다.\n");
						make_slow(2);
						break;
					}else if(choice <= 3) {
						if(player.money < 50) {
							System.out.println("물약을 구매할 금화가 부족합니다.\n");
							continue;
						}else if(player.weight >= 100){
							System.out.println("더 이상 무거워서 들 수 없습니다.\n");
							continue;
						}else {
							buy_potion(choice);
							continue;
						}
					}else if(choice <= 6){
						if(player.money < 100) {
							System.out.println("물약을 구매할 금화가 부족합니다.\n");
							continue;
						}else if(player.weight >= 100){
							System.out.println("더 이상 무거워서 들 수 없습니다.\n");
							continue;
						}else {
							buy_potion(choice);
							continue;
						}
					}else {
						System.out.println("번호를 다시 입력해주세요.\n");
						continue;
					}
				}
			}else {
				System.out.println("수호천사는 당신을 바라보며 눈을 감기 시작했습니다.");
				make_slow(2);
				System.out.println("천사의 몸에서 뿜어져 나오는 강렬한 빛은 당신을 감싸기 시작했고 이내 몸의 모든 상처가 회복되는 것을 느꼈습니다.");
				make_slow(2);
				System.out.println("체력과 마나가 가득 찼습니다.\n");
				player.health = 100;
				player.mana = 100;
				make_slow(1);
			}
			System.out.println("◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇\n");
			make_slow(2);
			System.out.println("모든 준비를 끝마치고 용을 향해 가려는 순간 천사가 당신을 붙잡았습니다.");
			make_slow(0);
			System.out.println("\"이대로 간다면 강한 바람 때문에 앞으로 나아갈 수 없을 것입니다.\"");
			make_slow(0);
			System.out.println("\"제가 바람을 막는 가호를 드리겠습니다.\"");
			make_slow(0);
			System.out.println("천사의 가호가 당신을 감싸더니 주변의 바람들이 당신을 피해가기 시작했습니다.");
			make_slow(0);
			System.out.println("\"오래 버티지는 못하지만 이게 저의 최선입니다. 부디 승리하시길 빕니다.\"");
			make_slow(0);
			System.out.println("말을 마친 천사는 이내 사라졌고 당신은 최후의 전투를 위해 동굴에서 용에게 나아갔습니다.\n");
			make_slow(2);
			System.out.println("◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇");
			make_slow(0);
			loading();
			make_slow(0);
		}else { // 첫 번째 휴식시간
			make_slow(2);
			System.out.println("=================================");
			make_slow(2);
			System.out.println("1 스테이지를 클리어하셨습니다.");
			make_slow(2);
			System.out.println("클리어 보상으로 체력 물약이 추가되었습니다.");
			make_slow(2);
			player_potion.add(hp_potion.name);
			System.out.println("=================================\n");
			make_slow(0);
			loading();
			make_slow(2);
			System.out.println("◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆\n");
			stage_1_clear = true;
			make_slow(2);
			monster_village_image.setVisible(true);
			System.out.println("고단한 당신 앞에 괴물들의 마을이 나타났습니다.");
			make_slow(0);
			System.out.println("경계하며 가까이 다가가니 놀랍게도 괴물들 사이에 한 노파가 있었습니다.");
			make_slow(0);
			System.out.println("그녀는 당신을 공격하려는 괴물들을 멈춰세우고 이렇게 말했습니다.");
			make_slow(0);
			System.out.println("\"여기 있는 괴물들은 저 바람을 내뿜는 용 때문에 불만이 많지. 그대가 용을 없애준다면 우리가 최선을 다해 도와주겠네\"\n");
			make_slow(2);
			System.out.println("◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆");
			make_slow(1);
			monster_village_image.setVisible(false);
			System.out.println();
			System.out.println("당신은 이곳에서 한 가지의 행동을 선택할 수 있습니다.");
			make_slow(2);
			System.out.println("어떤 행동을 하시겠습니까?(한번 선택하면 되돌아갈 수 없습니다.)");
			make_slow(2);
			System.out.println("[1. 강화하기]  [2. 물약상점 이용하기]  [3. 휴식하기]");
			
			choice = sc.nextInt();
			make_slow(1);
			System.out.println();
			if(choice == 1) {
				System.out.println("-------------------------------------------------------------\n");
				make_slow(2);
				System.out.println("장비를 강화하고자하는 당신은 노파에게 대장간의 위치를 물어보았습니다.");
				make_slow(2);
				System.out.println("노파가 알려준 곳을 가보니 눈이 하나인 괴물이 망치를 두들기고 있는 것을 보았습니다.");
				make_slow(2);
				System.out.println("가까이 다가가니 알 수 없는 언어로 뭐라고 하더니 장비를 달라고 손을 내밀었습니다.");
				make_slow(2);
				System.out.println("왠지 믿음직스럽지 않지만 달리 방법이 없어서 장비를 건네주기로 하였습니다.\n");
				make_slow(2);
				System.out.println("-------------------------------------------------------------");
				System.out.println();
				upgrade_weapon();
			}else if(choice == 2) {
				System.out.println("노파의 도움으로 마을에 있는 물약상점에 도착했습니다.");
				make_slow(1);
				while(true) {
					System.out.println("--------------------------------------");
					System.out.println("    목록                           가격   ");
					System.out.printf("1. %s                       %3d개\n", mp_potion.name, mp_potion.money);
					System.out.printf("2. %s                         %3d개\n", antidote.name, antidote.money);
					System.out.printf("3. %s                     %3d개\n", antipyrotic.name, antipyrotic.money);
					System.out.printf("4. %s                      %3d개\n", power_potion.name, power_potion.money);
					System.out.printf("5. %s                      %3d개\n", defense_potion.name, defense_potion.money);
					System.out.printf("6. %s                       %3d개\n", speed_potion.name, speed_potion.money);
					System.out.println("--------------------------------------");
					System.out.println("현재 가지고 있는 금화: "+player.money+"개");
					System.out.println("현재 무게: "+player.weight+" / 100");
					Collections.sort(player_potion);
					System.out.print("현재 가지고 있는 물약: ");
					for(int i = 0; i < player_potion.size(); i++) {
						System.out.print(player_potion.get(i));
						if(i != player_potion.size() - 1)
							System.out.print(", ");
					}
					System.out.println();
					System.out.println("어떤 물약을 구매하시겠습니까? (그만 두시려면 0을 눌러주세요)");
					choice = sc.nextInt();
					if(choice == 0) {
						System.out.println("\"이 정도면 충분하지.\"");
						make_slow(2);
						System.out.println("물약상점을 나왔습니다.\n");
						make_slow(2);
						break;
					}else if(choice <= 3) {
						if(player.money < 50) {
							System.out.println("물약을 구매할 금화가 부족합니다.\n");
							continue;
						}else if(player.weight >= 100){
							System.out.println("더 이상 무거워서 들 수 없습니다.\n");
							continue;
						}else {
							buy_potion(choice);
							continue;
						}
					}else if(choice <= 6){
						if(player.money < 100) {
							System.out.println("물약을 구매할 금화가 부족합니다.\n");
							continue;
						}else if(player.weight >= 100){
							System.out.println("더 이상 무거워서 들 수 없습니다.\n");
							continue;
						}else {
							buy_potion(choice);
							continue;
						}
					}else {
						System.out.println("번호를 다시 입력해주세요.\n");
						continue;
					}
				}
			}else {
				System.out.println("너무나 고단했던 당신은 마을에 있는 여관에서 쉬기로 하였습니다.");
				make_slow(2);
				System.out.println("체력과 마나가 가득 찼습니다.\n");
				make_slow(1);
				player.health = 100;
				player.mana = 100;
			}
			System.out.println("마을에서 모든 일을 마친 당신은 다시 용을 향해서 나아갔습니다.\n");
			make_slow(0);
			loading();
			make_slow(0);
		}
	}

	
	
	public static void upgrade_weapon() { // 무기 강화
		ArrayList<String> upgrade_list = new ArrayList<String>();
		int upgrade_count = 0; // 강화 가능 횟수
		int item_num = 5; // 장비 번호 (0은 무기, 1은 방어구, 2는 신발, 3은 방패)
		
		if(sword.equipped || bow.equipped || axe.equipped)
			upgrade_list.add("무기");
		
		if(light_armor.equipped || heavy_armor.equipped)
			upgrade_list.add("방어구");
		
		if(shoes.equipped)
			upgrade_list.add("신발");
		
		if(shield.equipped)
			upgrade_list.add("방패");
		
		upgrade_count = upgrade_list.size() - 1;
		if(upgrade_count <= 0)
			upgrade_count = 1;
		
		if(upgrade_list.size() > 0) {
			while(true) {
				if(upgrade_count > 0) {
					System.out.printf("강화할 수 있는 횟수가 %d번 남았습니다.\n", upgrade_count);
					System.out.println("어떤 장비를 강화하시겠습니까?");
					for(int i = 0; i < upgrade_list.size(); i++) {
						System.out.printf("[%d. %s]\n", i+1, upgrade_list.get(i));
					}
					System.out.println("0. 그만둔다.");
					choice = sc.nextInt();
				}else {
					System.out.println("강화 횟수를 모두 사용하였습니다.\n");
					make_slow(2);
					System.out.println("강화를 마칩니다.\n");
					make_slow(1);
					upgrade_list.clear();
					break;
				}
				
				if(choice == 0) {
					System.out.println("강화를 모두 마쳤습니다.\n");
					make_slow(1);
					upgrade_list.clear();
					break;
				}else if(choice <= upgrade_list.size()){
					if(upgrade_list.get(choice - 1).equals("무기")){ // 무기 강화
						System.out.println("무기를 강화합니다.");
						System.out.println("\"뚝딱 뚝딱 뚝딱 뚝딱\"");
						make_slow(2);
						upgrade_list.remove("무기");
						item_num = 0;
						if(sword.equipped) { // 검 강화
							if(sword_upgrade_1.equipped) { // 검 강화 1단계를 강화
								System.out.printf("[%s이 %s로 강화되었습니다.]\n\n", sword_upgrade_1.name, sword_upgrade_2.name);
								player.ultimate_weapon = sword_upgrade_2.name;
								unequip_item(item_num);
								sword_upgrade_2.equipped = true;
								player_equipped_item.add(item_num,sword_upgrade_2.name);
								player.power += sword_upgrade_2.power;
								player.speed += sword_upgrade_2.speed;
								player.weight += sword_upgrade_2.weight;
								player.equiped_weapon_power = sword_upgrade_2.power;
								player.equiped_weapon_speed = sword_upgrade_2.speed;
								player.equiped_weapon_weight = sword_upgrade_2.weight;
								upgrade_count--;
							}else { // 기본 검 강화
								System.out.printf("[%s이 %s으로 강화되었습니다.]\n\n", sword.name, sword_upgrade_1.name);
								unequip_item(item_num);
								sword_upgrade_1.equipped = true;
								player_equipped_item.add(item_num,sword_upgrade_1.name);
								player.power += sword_upgrade_1.power;
								player.speed += sword_upgrade_1.speed;
								player.weight += sword_upgrade_1.weight;
								player.equiped_weapon_power = sword_upgrade_1.power;
								player.equiped_weapon_speed = sword_upgrade_1.speed;
								player.equiped_weapon_weight = sword_upgrade_1.weight;
								upgrade_count--;
							}
						}else if(bow.equipped) { // 활 강화
							if(bow_upgrade_1.equipped) { // 활 1단계 강화를 강화
								System.out.printf("[%s이 %s로 강화되었습니다.]\n\n", bow_upgrade_1.name, bow_upgrade_2.name);
								player.ultimate_weapon = bow_upgrade_2.name;
								unequip_item(item_num);
								bow_upgrade_2.equipped = true;
								player_equipped_item.add(item_num,bow_upgrade_2.name);
								player.power += bow_upgrade_2.power;
								player.speed += bow_upgrade_2.speed;
								player.weight += bow_upgrade_2.weight;
								player.equiped_weapon_power = bow_upgrade_2.power;
								player.equiped_weapon_speed = bow_upgrade_2.speed;
								player.equiped_weapon_weight = bow_upgrade_2.weight;
								upgrade_count--;
							}else { // 기본 활 강화
								System.out.printf("[%s이 %s로 강화되었습니다.]\n\n", bow.name, bow_upgrade_1.name);
								unequip_item(item_num);
								bow_upgrade_1.equipped = true;
								player_equipped_item.add(item_num,bow_upgrade_1.name);
								player.power += bow_upgrade_1.power;
								player.speed += bow_upgrade_1.speed;
								player.weight += bow_upgrade_1.weight;
								player.equiped_weapon_power = bow_upgrade_1.power;
								player.equiped_weapon_speed = bow_upgrade_1.speed;
								player.equiped_weapon_weight = bow_upgrade_1.weight;
								upgrade_count--;
							}
						}else { // 도끼 강화
							if(axe_upgrade_1.equipped) { // 도끼 1단계를 강화
								System.out.printf("[%s가 %s로 강화되었습니다.]\n\n", axe_upgrade_1.name, axe_upgrade_2.name);
								player.ultimate_weapon = axe_upgrade_2.name;
								unequip_item(item_num);
								axe_upgrade_2.equipped = true;
								player_equipped_item.add(item_num,axe_upgrade_2.name);
								player.power += axe_upgrade_2.power;
								player.speed += axe_upgrade_2.speed;
								player.weight += axe_upgrade_2.weight;
								player.equiped_weapon_power = axe_upgrade_2.power;
								player.equiped_weapon_speed = axe_upgrade_2.speed;
								player.equiped_weapon_weight = axe_upgrade_2.weight;
								upgrade_count--;
							}else { // 기본 도끼 강화
								System.out.printf("[%s가 %s로 강화되었습니다.]\n\n", axe.name, axe_upgrade_1.name);
								unequip_item(item_num);
								axe_upgrade_1.equipped = true;
								player_equipped_item.add(item_num,axe_upgrade_1.name);
								player.power += axe_upgrade_1.power;
								player.speed += axe_upgrade_1.speed;
								player.weight += axe_upgrade_1.weight;
								player.equiped_weapon_power = axe_upgrade_1.power;
								player.equiped_weapon_speed = axe_upgrade_1.speed;
								player.equiped_weapon_weight = axe_upgrade_1.weight;
								upgrade_count--;
							}
						}
						
					}else if(upgrade_list.get(choice - 1).equals("방어구")) { // 방어구 강화
						System.out.println("방어구를 강화합니다.");
						System.out.println("\"뚝딱 뚝딱 뚝딱 뚝딱\"");
						make_slow(2);
						upgrade_list.remove("방어구");
						item_num = 1;
						if(light_armor.equipped) { // 경갑 착용
							if(light_armor_upgrade_1.equipped) { // 경갑 1단계를 강화
								System.out.printf("[%s이 %s으로 강화되었습니다.]\n\n", light_armor_upgrade_1.name, light_armor_upgrade_2.name);
								unequip_item(item_num);
								light_armor_upgrade_2.equipped = true;
								player_equipped_item.add(item_num,light_armor_upgrade_2.name);
								player.defense += light_armor_upgrade_2.defense;
								player.speed += light_armor_upgrade_2.speed;
								player.weight += light_armor_upgrade_2.weight;
								player.equiped_armor_defense = light_armor_upgrade_2.defense;
								player.equiped_armor_speed = light_armor_upgrade_2.speed;
								player.equiped_armor_weight = light_armor_upgrade_2.weight;
								upgrade_count--;
							}else { // 기본 경갑 강화
								System.out.printf("[%s이 %s으로 강화되었습니다.]\n\n", light_armor.name, light_armor_upgrade_1.name);
								unequip_item(item_num);
								light_armor_upgrade_1.equipped = true;
								player_equipped_item.add(item_num,light_armor_upgrade_1.name);
								player.defense += light_armor_upgrade_1.defense;
								player.speed += light_armor_upgrade_1.speed;
								player.weight += light_armor_upgrade_1.weight;
								player.equiped_armor_defense = light_armor_upgrade_1.defense;
								player.equiped_armor_speed = light_armor_upgrade_1.speed;
								player.equiped_armor_weight = light_armor_upgrade_1.weight;
								upgrade_count--;
							}
						}else { // 중갑 착용
							if(heavy_armor_upgrade_1.equipped) { // 중갑 1단계를 강화
								System.out.printf("[%s이 %s으로 강화되었습니다.]\n\n", heavy_armor_upgrade_1.name, heavy_armor_upgrade_2.name);
								unequip_item(item_num);
								heavy_armor_upgrade_2.equipped = true;
								player_equipped_item.add(item_num, heavy_armor_upgrade_2.name);
								player.defense += heavy_armor_upgrade_2.defense;
								player.speed += heavy_armor_upgrade_2.speed;
								player.weight += heavy_armor_upgrade_2.weight;
								player.equiped_armor_defense = heavy_armor_upgrade_2.defense;
								player.equiped_armor_speed = heavy_armor_upgrade_2.speed;
								player.equiped_armor_weight = heavy_armor_upgrade_2.weight;
								upgrade_count--;
							}else { // 기본 중갑 강화
								System.out.printf("[%s이 %s으로 강화되었습니다.]\n\n", heavy_armor.name, heavy_armor_upgrade_1.name);
								unequip_item(item_num);
								heavy_armor_upgrade_1.equipped = true;
								player_equipped_item.add(item_num, heavy_armor_upgrade_1.name);
								player.defense += heavy_armor_upgrade_1.defense;
								player.speed += heavy_armor_upgrade_1.speed;
								player.weight += heavy_armor_upgrade_1.weight;
								player.equiped_armor_defense = heavy_armor_upgrade_1.defense;
								player.equiped_armor_speed = heavy_armor_upgrade_1.speed;
								player.equiped_armor_weight = heavy_armor_upgrade_1.weight;
								upgrade_count--;
							}
						}
					}else if(upgrade_list.get(choice - 1).equals("신발")) { // 신발 강화
						System.out.println("신발을 강화합니다.");
						System.out.println("\"뚝딱 뚝딱 뚝딱 뚝딱\"");
						make_slow(2);
						upgrade_list.remove("신발");
						item_num = 2;
						if(shoes_upgrade_1.equipped) { // 신발 1단계를 강화
							System.out.printf("[%s이 %s로 강화되었습니다.]\n\n", shoes_upgrade_1.name, shoes_upgrade_2.name);
							unequip_item(item_num);
							shoes_upgrade_2.equipped = true;
							player_equipped_item.add(item_num, shoes_upgrade_2.name);
							player.speed += shoes_upgrade_2.speed;
							player.weight += shoes_upgrade_2.weight;
							player.equiped_shoes_speed = shoes_upgrade_2.speed;
							player.equiped_shoes_weight = shoes_upgrade_2.weight;
							upgrade_count--;
						}else { // 기본 신발 강화
							System.out.printf("[%s이 %s로 강화되었습니다.]\n\n", shoes.name, shoes_upgrade_1.name);
							unequip_item(item_num);
							shoes_upgrade_1.equipped = true;
							player_equipped_item.add(item_num, shoes_upgrade_1.name);
							player.speed += shoes_upgrade_1.speed;
							player.weight += shoes_upgrade_1.weight;
							player.equiped_shoes_speed = shoes_upgrade_1.speed;
							player.equiped_shoes_weight = shoes_upgrade_1.weight;
							upgrade_count--;
						}
						
					}else if(upgrade_list.get(choice - 1).equals("방패")) { // 방패 강화
						System.out.println("방패를 강화합니다.");
						System.out.println("\"뚝딱 뚝딱 뚝딱 뚝딱\"");
						make_slow(2);
						upgrade_list.remove("방패");
						item_num = 3;
						if(shield_upgrade_1.equipped) { // 방패 1단계를 강화
							System.out.printf("[%s가 %s로 강화되었습니다.]\n\n", shield_upgrade_1.name, shield_upgrade_2.name);
							unequip_item(item_num);
							shield_upgrade_2.equipped = true;
							player_equipped_item.add(item_num, shield_upgrade_2.name);
							player.defense += shield_upgrade_2.defense;
							player.speed += shield_upgrade_2.speed;
							player.weight += shield_upgrade_2.weight;
							player.equiped_shield_defense = shield_upgrade_2.defense;
							player.equiped_shield_speed = shield_upgrade_2.speed;
							player.equiped_shield_weight = shield_upgrade_2.weight;
							upgrade_count--;
						}else { // 기본 방패를 강화
							System.out.printf("[%s가 %s로 강화되었습니다.]\n\n", shield.name, shield_upgrade_1.name);
							unequip_item(item_num);
							shield_upgrade_1.equipped = true;
							player_equipped_item.add(item_num, shield_upgrade_1.name);
							player.defense += shield_upgrade_1.defense;
							player.speed += shield_upgrade_1.speed;
							player.weight += shield_upgrade_1.weight;
							player.equiped_shield_defense = shield_upgrade_1.defense;
							player.equiped_shield_speed = shield_upgrade_1.speed;
							player.equiped_shield_weight = shield_upgrade_1.weight;
							upgrade_count--;
						}
					}else {
						System.out.println("그런 장비는 없습니다.\n");
						continue;
					}
				}else {
					System.out.println("다시 선택해주세요.\n");
					continue;
				}
			}
		}else {
			System.out.println("강화를 하려고 했으나 강화할 수 있는 장비가 없습니다.");
			make_slow(2);
			System.out.println("강화를 마칩니다.\n");
			make_slow(1);
		}
		
	}

	
	
	public static void buy_potion(int num) { // 물약 구매
		if(num == 1) { // 마나 물약 구매
			System.out.println("["+mp_potion.name+"을 구매했습니다.]\n");
			player_potion.add(mp_potion.name);
			player.money -= mp_potion.money;
			player.weight += mp_potion.weight;
		}else if(num == 2) { // 해독제 구매
			System.out.println("["+antidote.name+"를 구매했습니다.]\n");
			player_potion.add(antidote.name);
			player.money -= antidote.money;
			player.weight += antidote.weight;
		}else if(num ==3) { // 화상 치료제 구매
			System.out.println("["+antipyrotic.name+"을 구매했습니다.]\n");
			player_potion.add(antipyrotic.name);
			player.money -= antipyrotic.money;
			player.weight += antipyrotic.weight;
		}else if(num == 4) { // 공격력 물약 구매
			System.out.println("["+power_potion.name+"을 구매했습니다.]\n");
			player_potion.add(power_potion.name);
			player.money -= power_potion.money;
			player.weight += power_potion.weight;
		}else if(num == 5) { // 방어력 물약 구매
			System.out.println("["+defense_potion.name+"을 구매했습니다.]\n");
			player_potion.add(defense_potion.name);
			player.money -= defense_potion.money;
			player.weight += defense_potion.weight;
		}else { // 속도 물약 구매
			System.out.println("["+speed_potion.name+"을 구매했습니다.]\n");
			player_potion.add(speed_potion.name);
			player.money -= speed_potion.money;
			player.weight += speed_potion.weight;
		}
	}
		
	
	
	public static boolean check_dead() { // 캐릭터의 죽음을 확인
		if(player.health <= 0)
			return true;
		else return false;
	}
	
	
	
	public static void make_slow(int num) { // 속도를 늦춰주는 메소드
		if(num == 0) { // 스토리 속도
			try {
				Thread.sleep(2000);
			}catch(Exception e) {
				
			}
		}else if(num == 1) { // 일반적인 속도
			try {
				Thread.sleep(2000);
			}catch(Exception e) {
				
			}
		}else { // 선택했을 때의 속도
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				
			}
		}
	}

	
			
	static class Player_fight_thread extends Thread{ // 플레이어 전투 쓰레드
		private int choice = 0;
		int speed = player.speed*2;
		
		public void run() {
			try {
				if(speed > 1000) {
					speed = 1000;
				}
				while(player.health > 0 && monster.health > 0 && check_fight) {
					choice = player_num.nextInt();
					if(check_fight == false) {
						if(choice == 1) {
							System.out.println("다음 게임을 시작합니다.\n계속 하시려면 1을 눌러주세요.\n게임을 지금이라도 그만 두시려면 다른 숫자를 눌러주세요.");
							break;
						}else {
							System.out.println("지옥의 괴물들은 빠른 속도로 왕국을 점령해갔고 그렇게 왕국은 멸망하였습니다.");
							make_slow(0);
							System.out.println("\"당신이 왕국의 백성들을 죽였어...\"");
							make_slow(0);
							System.out.println("The End");
							System.exit(0);
						}
					}
					if(choice == 1) { // 공격하기
						if(monster.health < 0 || player.health < 0) 
							break;
						System.out.println("["+monster.name+"을(를) 공격했습니다.]\n");
						damage = player.power - monster.defense;
						if(damage < 0) {
							damage = 5;
							monster.health -= damage;
						}
						else monster.health -= damage;
						Thread.sleep(1000 - speed);
						if(monster.health < 0 || player.health < 0)
							break;
					}else if(choice == 2) { // 스킬 사용
						if(monster.health < 0 || player.health < 0) 
							break;
						if(player.mana >= 20) {
							use_skill(skill_choice);
							Thread.sleep(3000 - speed);
						}else {
							System.out.println("[스킬을 사용할 마나가 없습니다.]\n");
							Thread.sleep(1000 - speed);
						}
						if(monster.health < 0 || player.health < 0)
							break;
					}else if(choice == 3) { // 회피
						if(monster.health < 0 || player.health < 0) 
							break;
						System.out.println("[회피 동작을 취했습니다.]\n");
						Thread.sleep(2000);
						if(monster.health < 0 || player.health < 0) 
							break;
					}else if(choice == 5) { // 체력 물약 사용
						if(monster.health < 0 || player.health < 0) 
							break;
						if(player_potion.contains(hp_potion.name)) {
							System.out.println("["+hp_potion.name + "을 사용하였습니다.]\n");
							player_potion.remove(hp_potion.name);
							player.health += hp_potion.hp;
							if(player.health > 100)
								player.health = 100;
						}else System.out.println("["+hp_potion.name + "이 없습니다.]\n");
						Thread.sleep(1000 - speed);
						if(monster.health < 0 || player.health < 0) 
							break;
					}else if(choice == 6) { // 마나 물약 사용
						if(monster.health < 0 || player.health < 0) 
							break;
						if(player_potion.contains(mp_potion.name)) {
							System.out.println("["+mp_potion.name+"을 사용하였습니다.]\n");
							player_potion.remove(mp_potion.name);
							player.mana += mp_potion.mp;
							if(player.mana > 100)
								player.mana = 100;
						}else System.out.println("["+mp_potion.name + "이 없습니다.]\n");
						Thread.sleep(1000 - speed);
						if(monster.health < 0 || player.health < 0) 
							break;
					}else if(choice == 7) { // 해독제 및 화상 치료제
						if(monster.health < 0 || player.health < 0) 
							break;
						if(player_potion.contains(antidote.name) && player.posioned) { // 해독제
							System.out.println("["+antidote.name+"를 사용하였습니다.]\n");
							player_potion.remove(antidote.name);
							player.posioned = false;
						}else if(player_potion.contains(antipyrotic.name) && player.burned) { // 화상 치료제
							System.out.println("["+antipyrotic.name+"를 사용하였습니다.]\n");
							player_potion.remove(antipyrotic.name);
							player.burned = false;
						}else if(player.posioned) {
							if(player_potion.contains(antidote.name))
								System.out.println("[다시 사용해주세요.]\n");
							else System.out.println("["+antidote.name+"가 없습니다.]\n");
						}else if(player.burned) {
							if(player_potion.contains(antipyrotic.name))
								System.out.println("[다시 사용해주세요.]\n");
							else System.out.println("["+antipyrotic.name+"가 없습니다.]\n");
						}else {
							System.out.println("[물약을 사용할 필요가 없습니다.]\n");
						}
						Thread.sleep(1000 - speed);
						if(monster.health < 0 || player.health < 0) 
							break;
					}else{
						if(choice == 4 && player.equipped_shield) {
							if(monster.health < 0 || player.health < 0) 
								break;
							System.out.println("[방패를 들어 막았습니다.]\n");
							Thread.sleep(3000);
							if(monster.health < 0 || player.health < 0)
								break;
						}else if(choice == 4){
							if(monster.health < 0 || player.health < 0)
								break;
							System.out.println("[방패가 없습니다.]\n");
							Thread.sleep(1000 - speed);
							if(monster.health < 0 || player.health < 0)
								break;
						}
					}
					choice = 0;
					Thread.sleep(1000);
					if(monster.health < 0 || player.health < 0)
						break;
				}
			}catch(Exception e) {
				
			}
		}
	}
	
	
	
	static class Monster_fight_thread extends Thread{ // 몬스터 전투 쓰레드
		int random_num = 0;
		int ex_pattern_num = 0; // 패턴 중복을 줄이기 위한 변수
		
		public void run() {
			try {
					print_fight();
					Thread.sleep(10000);
					while(monster.health > 0 && player.health > 0) {
						random_num = rand.nextInt(100);
						if(monster.name.equals(undead.name)) { // 언데드
							if(random_num < 20 && ex_pattern_num != 1) { // 패턴 1
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								System.out.println(monster.name + "가 물어뜯기를 사용합니다.");
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								Thread.sleep(2000);
								for(int i = 7; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 1;
							}else if(random_num < 60 && ex_pattern_num != 2){ // 패턴 2
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								System.out.println(monster.name + "가 찍기를 사용합니다.");
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								Thread.sleep(2000);
								for(int i = 3; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 2;
							}else { // 패턴 3
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								System.out.println(monster.name + "가 달려듭니다.");
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								Thread.sleep(2000);
								for(int i = 5; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 3;
							}
						}else if(monster.name.equals(goblin.name)) { // 고블린
							if(random_num < 20 && ex_pattern_num != 1) { // 패턴 1
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								System.out.println(monster.name + "이 할퀴기를 사용합니다.");
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								Thread.sleep(2000);
								for(int i = 4; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 1;
							}else if(random_num < 80 && ex_pattern_num != 2) { // 패턴 2
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								System.out.println(monster.name + "이 칼을 휘두릅니다.");
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								Thread.sleep(2000);
								for(int i = 5; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}	
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 2;
							}else { // 패턴 3
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								System.out.println(monster.name + "이 칼을 던졌습니다.");
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								Thread.sleep(2000);
								for(int i = 2; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 3;
							}
						}else if(monster.name.equals(slime.name)){ // 슬라임
							if(random_num < 40 && ex_pattern_num != 1) { // 패턴 1
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								System.out.println(monster.name + "이 공격합니다.");
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								Thread.sleep(2000);
								for(int i = 5; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 1;
							}else if(random_num < 80 && player.posioned == false && ex_pattern_num != 2) { // 패턴 2
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								System.out.println(monster.name + "이 독을 뿌립니다.");
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								Thread.sleep(2000);
								for(int i = 3; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("독에 중독되었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
									player.posioned = true;
									poison[poison_count] = new Poison();
									poison[poison_count].start();
								}
								ex_pattern_num = 2;
							}else { // 패턴 3
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								System.out.println(monster.name + "이 몸을 부풀리며 날아옵니다.");
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								Thread.sleep(2000);
								for(int i = 8; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 3;
							}
						}else if(monster.name.equals(ghost.name)) { // 고스트
							if(random_num < 10 && ex_pattern_num != 1) { // 패턴 1
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								System.out.println(monster.name + "가 영혼의 힘을 쏩니다.");
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								Thread.sleep(2000);
								for(int i = 2; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								for(int i = 3; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								for(int i = 2; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 1;
							}else if(random_num < 40 && ex_pattern_num != 2) { // 패턴 2
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								System.out.println(monster.name + "가 홀리기를 사용합니다.");
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								Thread.sleep(2000);
								for(int i = 4; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 2;
							}else { // 패턴 3
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								System.out.println(monster.name + "가 기를 모아 공격합니다.");
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								Thread.sleep(2000);
								for(int i = 6; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 3;
							}
						}else if(monster.name.equals(troll.name)) { // 트롤
							if(random_num < 20 && ex_pattern_num != 1) { // 패턴 1
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								System.out.println(monster.name + "이 밟기를 시전합니다.");
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								Thread.sleep(2000);
								for(int i = 3; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								for(int i = 3; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 1;
							}else if(random_num < 50 && ex_pattern_num != 2) { // 패턴 2
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								System.out.println(monster.name + "이 돌을 집어 던집니다.");
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								Thread.sleep(2000);
								for(int i = 7; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 2;
							}else { // 패턴 3
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								System.out.println(monster.name + "이 주먹을 휘두릅니다.");
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								Thread.sleep(2000);
								for(int i = 4; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 3;
							}
						}else if(monster.name.equals(griffin.name)) { // 그리핀
							if(random_num < 20 && ex_pattern_num != 1) { // 패턴 1
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								System.out.println(monster.name + "이 바람을 일으킵니다.");
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								Thread.sleep(2000);
								for(int i = 4; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 1;
							}else if(random_num < 50 && ex_pattern_num != 2) { // 패턴 2
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								System.out.println(monster.name + "이 부리로 쫍니다.");
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								Thread.sleep(2000);
								for(int i = 3; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								for(int i = 2; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								for(int i = 4; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 2;
							}else { // 패턴 3
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								System.out.println(monster.name + "이 뒷발길질을 합니다.");
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								Thread.sleep(2000);
								for(int i = 5; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 3;
							}
						}else { // 드래곤
							if(monster.health/monster.max_health * 100 <= 30) { // 체력이 30프로 이하
								random_num -= 20;
							}
							if(random_num < 10 && ex_pattern_num != 1) { // 패턴 1
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								System.out.println(monster.name + "이 지옥불로 주변을 감쌉니다.");
								System.out.println("지옥에 있는 용암으로부터 올라오는 뜨거운 열기들이 모이더니 회오리를 일으키며 날아왔습니다.");
								System.out.println("뜨거운 열기에 몸이 녹아내릴 것 같습니다.");
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								Thread.sleep(3000);
								for(int i = 2; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								for(int i = 4; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								for(int i = 2; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								for(int i = 5; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 1;
							}else if(random_num < 40 && player.burned == false && ex_pattern_num != 2) { // 패턴 2
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								System.out.println(monster.name + "이 불을 내뿜습니다.");
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								Thread.sleep(2000);
								for(int i = 3; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("화상을 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
									player.burned = true;
									burn[burn_count] = new Burn();
									burn[burn_count].start();
								}
								ex_pattern_num = 2;
							}else if(random_num < 60 && ex_pattern_num != 3) { // 패턴 3
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								System.out.println(monster.name + "이 바람칼날을 날립니다.");
								System.out.println("주변의 바람들이 빠르게 불더니 칼날로 변해서 날아왔습니다.");
								System.out.println("천사의 가호를 뚫고 바람이 날아들어옵니다.");
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								Thread.sleep(3000);
								for(int i = 2; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								for(int i = 5; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 3;
							}else { // 기본 패턴
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								System.out.println(monster.name + "이 날개를 휘두릅니다.");
								System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
								Thread.sleep(2000);
								for(int i = 4; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								for(int i = 2; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								for(int i = 3; i > 0; i--) {
									System.out.printf("남은 시간 : %d초\n", i);
									Thread.sleep(1000);
									if(monster.health <= 0)
										break;
								}
								System.out.println();
								if(player_fight_thread[meet_monster].choice == 3) {
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 피했습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else if(player_fight_thread[meet_monster].choice == 4 && player.equipped_shield){
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println("공격을 막았습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}else {
									if(monster.health <= 0)
										break;
									damage = monster.power - player.defense;
									if(damage < 0) {
										damage = 5;
										player.health -= damage;
									}else player.health -= damage;
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
									System.out.println(damage+"만큼의 피해를 입었습니다.");
									System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●\n");
									Thread.sleep(1000);
								}
								ex_pattern_num = 4;
							}
						}
						print_fight();
						Thread.sleep(2000);
						if(monster.health < 0 || player.health < 0)
							player_fight_thread[meet_monster].interrupt();
					}
			}catch(Exception e) {
				Thread.interrupted();
			}
		}
	}
	
	
	
	static class Poison extends Thread{ // 독 쓰레드
		public void run() {
			try {
				Thread.sleep(2000);
				for(int i = 0; i < 10; i++) {
					if(player.posioned == false) {
						System.out.println("                                    (독이 치유되었습니다.)");
						break;
					}
					System.out.println("                                    (독 때문에 피가 1씩 줄어듭니다.)");
					player.health -= 1;
					Thread.sleep(3000);
					if(player.health <= 0) {
						player.posioned = false;
						break;
					}
				}
				poison_count += 1;
				player.posioned = false;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	
	
	static class Burn extends Thread{ // 화상 쓰레드

		public void run() {
			try {
				Thread.sleep(2000);
				for(int i = 0; i < 10; i++) {
					if(check_finished)
						break;
					if(player.burned == false) {
						System.out.println("                                    (화상이 치유되었습니다.)");
						break;
					}
					System.out.println("                                    (화상 때문에 피가 2씩 줄어듭니다.)");
					player.health -= 2;
					Thread.sleep(3000);
					if(player.health <= 0) {
						player.burned = false;
						break;
					}
				}
				burn_count += 1;
				player.burned = false;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	
	
	static public void loading() { // 로딩
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println("로딩중 [                                      ]");
		bonfire_image.setVisible(true);
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println("로딩중 [■■■■■■■■                              ]");
		try {
			Thread.sleep(1500);
		}catch(Exception e) {
			e.printStackTrace();
		}
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println("로딩중 [■■■■■■■■■■■■■■■■■■                    ]");
		try {
			Thread.sleep(2000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println("로딩중 [■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■      ]");
		try {
			Thread.sleep(500);
		}catch(Exception e) {
			e.printStackTrace();
		}
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println("로딩중 [■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■]");
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		bonfire_image.setVisible(false);
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
}
