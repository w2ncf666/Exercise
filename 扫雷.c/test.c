#include"game.h" 
//void game() {
//	char mine[AZ][SZ] = { 0 };
//	char show[AZ][SZ] = { 0 };
//	init(show, AZ, SZ,'*');
//	init(mine, AZ, SZ, '0');
//	 //SetMine(mine,AZ,SZ);
//	print(show, AZ, SZ);
//}
void game()
{
	printf("扫雷\n");
	printf("游戏规则：以空格隔开输入横纵坐标，出现数字为周围的雷数\n");
	//雷的信息存储
	//1. 布置好的雷的信息
	char mine[ROWS][COLS] = { 0 };// 11 * 11
	//2. 排查出的雷的信息
	char show[ROWS][COLS] = { 0 };
	////初始化
	///*InitBoard(mine, ROWS, COLS, '0');
	//InitBoard(show, ROWS, COLS, '*');*/
	////打印棋盘
	////DisplayBoard(mine, ROW, COL);
	init(show, AZQ, SZQ, '*');
	init(mine, AZQ, SZQ, '0');
	print(show, AZ, SZ);
	////布置雷
	/*getmine(mine, AZ, SZ);*/
	SetMine(mine, AZ, SZ);
	FindMine(mine,show ,AZ, SZ);
	//DisplayBoard(mine, ROW, COL);
	//扫雷
	/*FindMine(mine, show, ROW, COL);*/
	
}
void menu() {
	printf("******************************\n");
	printf("*****1.play  0.exit***********\n");
	printf("******************************\n");
}
void test() {
	/*srand((unsigned int)time(NULL));*/
	int input = 0;
	do {
		
		menu();
		scanf_s("%d", &input);
		
		switch (input) {
		case 1:game(); 
			break;
	
		case 0:printf("退出游戏\n");
			break;
		default:printf("输入错误，请重新输入\n");
			break;
		}
	} while (input);
}
//do
//{
//	menu();
//	printf("请选择:>");
//	scanf_s("%d", &input);
//	switch (input)
//	{
//	case 1:
//		game();
//		break;
//	case 0:
//		printf("退出游戏\n");
//		break;
//	default:
//		printf("选择错误,重新选择!\n");
//		break;
//	}
//} while (input);
//}
int main() {
test();
	return 0;
}