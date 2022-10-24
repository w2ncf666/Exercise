#define AZ 9
#define SZ 9
#define AZQ AZ+2
#define SZQ SZ+2
#include<stdio.h>
#define ROW 9
#define COL 9

#define ROWS ROW+2
#define COLS COL+2

#define EASY_COUNT 10

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
void init(char board[AZ][SZ],int az,int sz,char set);
void getmine(char mine, int az, int sz);
void print(char board[], int az, int sz);
void SetMine(char board[AZQ][SZQ], int row, int col);
void DisplayBoard(char board[ROWS][COLS], int row, int col);
void InitBoard(char board[ROWS][COLS], int rows, int cols, char set);
void DisplayBoard(char board[ROWS][COLS], int row, int col);
void SetMine(char board[ROWS][COLS], int row, int col);
void FindMine(char mine[AZQ][SZQ], char show[ROWS][COLS], int row, int col);

