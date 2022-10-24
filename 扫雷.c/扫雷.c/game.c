#include"game.h" 
//void init(char board[AZ][SZ],int az,int sz,char set) {
//	int i = 0;
//	int j = 0;
//	for (i = 0; i < az; i++) {
//		for (j = 0; j < sz; j++) {
//			board[i][j] = set;
//		}
//	}
//
//}
void init(char board[AZQ][SZQ], int rows, int cols, char set)
{
	int i = 0;
	int j = 0;
	for (i = 0; i < rows; i++)
	{
		for (j = 0; j < cols; j++)
		{
			board[i][j] = set;
		}
	}
}
//void getmine(char board[AZQ][SZQ], int az, int sz) {
//	int count = 10;
//	while (count) {
//		int x = rand() %az +1;
//		int y = rand() %sz +1 ;
//		if (board[x][y] == '0')
//		{
//			board[x][y] = '1';
//			count--;
//
//		}
//	}
//	printf("%d", count);
//}
void SetMine(char board[AZQ][SZQ], int az, int sz)
{
	int count = EASY_COUNT;
	while (count)
	{
		int x = rand() %az  + 1;//1-9
		int y = rand() %sz + 1;//
		if (board[x][y] == '0')
		{
			board[x][y] = '1';
			count--;
		}
	}
}
int num(int i,int j,char mine[AZQ][SZQ]) {
	int z = 0;
	z = (mine[i - 1][j] + mine[i - 1][j + 1] +
		mine[i][j - 1] + mine[i][j + 1] +
		mine[i + 1][j + 1] + mine[i - 1][j - 1] +
		mine[i + 1][j - 1] + mine[i + 1][j])-8*'0';
	return z;
}
int back(int i,int j, int az, int sz,char mine[AZQ][SZQ], char show[AZQ][SZQ],int win) {

	if (mine[i][j] == '0') {
		int count = 0;
		count = num(i, j, mine);
		show[i][j] = count + '0';
		print(show, AZ, SZ);

		if (num(--i, j, mine) == 0) {
			back(i, j, az, sz, mine, show, win);
			return 1 + back(i, j, az, sz, mine, show, win);
		}
		 if (num(--i, --j, mine) == 0)
		 {
			 back(i, j, az, sz, mine, show, win);
			 return 1 + back(i, j, az, sz, mine, show, win);
		 }
		 if (num(--i, ++j, mine) == 0)//
		 {
			 back(i, j, az, sz, mine, show, win);
			 return 1 + back(i, j, az, sz, mine, show, win);
		 }
		 if (num(i, --j, mine)== 0)
		 {
			 back(i, j, az, sz, mine, show, win);
			 return 1 + back(i, j, az, sz, mine, show, win);
		 }
		 if (num(i, ++j, mine) == 0)
		 {
			 back(i, j, az, sz, mine, show, win);
			 return 1 + back(i, j, az, sz, mine, show, win);
		 }
		 if (num(++i, j, mine) == 0)//
		 {
			 back(i, j, az, sz, mine, show, win);
			 return 1 + back(i, j, az, sz, mine, show, win);
		 }
		 if (num(++i, ++j, mine) == 0)
		 {
			 back(i, j, az, sz, mine, show, win);
			 return 1 + back(i, j, az, sz, mine, show, win);
		 }
		 if (num(++i, --j, mine) == 0)
		 {
			 back(i, j, az, sz, mine, show, win);
			 return 1 + back(i, j, az, sz, mine, show, win);
		 }
	}
	return win;
}
void FindMine(char mine[AZQ][SZQ], char show[AZQ][SZQ], int az, int sz) {
	int i = 0; int j = 0;
	int win = 0;
	while (win <= az * sz - 10) {
		printf("请输入坐标\n");
		scanf_s("%d%d", &i, &j);
		if ((i > 0 && i <= az) && (j > 0 && j <= sz)) {
			if (mine[i][j] == '1') {
				printf("很遗憾，你被炸死了\n");
				print(mine, az, sz);
				break;
			}
			else
				back(i, j, az, sz, mine, show, win);
		}
		else
			printf("输入错误，请重新输入\n");
	}
	if (win > az * sz - 10)
		printf("恭喜你，挑战成功！！\n");
}
//if ((i > 0 && i <= az) && (j > 0 && j <= sz) ){
//	if (mine[i - 1][j - 1] == '1')
//		printf("很遗憾，你被炸死了\n");
//	else if (mine[i][j] = '0') {
//		int count = 0;
//			count = num(i, j, mine);
//			show[i][j] = count;
//			print(show, AZ, SZ);
//			win++;
//	}
//}
//else
//printf("输入错误，请重新输入\n");
	void print(char board[AZQ][SZQ], int az, int sz){
	int i = 0;
	int j = 0;
	//打印列号
	for (i = 0; i <= az; i++)
	{
		printf("%d ", i);
	}
	printf("\n");
	for (i = 1; i <=az; i++)
	{
		printf("%d ", i);
		for (j = 1; j <=sz; j++)
		{
			printf("%c ", board[i][j]);
		}
		printf("\n");
	}
}
//void print(char board[AZQ][SZQ], int az, int sz)
//{
//	int i = 0;
//	int j = 0;
//	//打印列号
//	for (i = 0; i <= az; i++)
//	{
//		printf("%d ", i);
//	}
//	printf("\n");
//	
//	}
//void print(char board[AZQ][SZQ], int az, int sz) {
//	/*int i = 0;
//	for (i = 0; i < SZQ - 1; i++)
//		printf("%d ", i);
//	printf("\n");
//	int z = 0; int j = 0; int k = 0;*/
//	/*for (z = 1; z <= az; z++)
//		printf("%d ", z);*/
//	/*for (j = 0; j < az; j++) {
//		for(k = 0; k < sz; k++) {*/
//			printf("%c", board[0][1]);
//		}
//	/*}*/
//		

//void DisplayBoard(char board[ROWS][COLS], int row, int col)
//{
//	int i = 0;
//	int j = 0;
//	//打印列号
//	for (i = 0; i <= col; i++)
//	{
//		printf("%d ", i);
//	}
//	printf("\n");
//	for (i = 1; i <= row; i++)
//	{
//		printf("%d ", i);
//		for (j = 1; j <= col; j++)
//		{
//			printf("%c ", board[i][j]);
//		}
//		printf("\n");
//	}
//}