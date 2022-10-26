#define _CRT_SECURE_NO_WARNINGS 1
#include<stdlib.h>
#include<string.h>
#include<stdio.h>



void Initcontact(struct sum* con);
struct contact 
{
	char name[10];
	char adr[30];
	char sex[5];
	int age;
	char tel[15];
};
struct sum
{
	struct contact* data;
	int count;
	int siz;
 };
void addcontact(struct sum* con);
void showcontact(struct sum* con);
void delcontast(struct sum* con);
void changecontast(struct sum* con);
void savecontast(struct sum*con);
void searchcontast(struct sum*con);
void destroy(struct sum* con);