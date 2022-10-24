
#define _CRT_SECURE_NO_WARNINGS

//1.模拟实现strncpy
//2.模拟实现strncat
//3.模拟实现strncmp

#include<stdio.h>
#include <string.h>
#include<assert.h>
#include<stdlib.h>
#define ROW 3
#define COL 5
//char* my_strncpy(char* a, char* b, size_t sum)
//{
//	for(int i=0;i<sum;i++)
//	*a++ = *b++;
//	return a;
//}
//char* my_strcat(char* a, const char* b)
//{
//	int i = 0;
//	char* ret = a;
//	for (i=0; a[i] != 0; i++);
//		for (int j = 0; b[j] != 0; j++)
//		{
//			a[i] = b[j];
//			i++;
//
//		}
//		a[i] = 0;
//	return ret;
//}
//int my_strncmp(const char* a, const char* b, size_t n)
//{
//	assert(a && b);
//	/*if (!n)
//		return 0;*/
//	while (--n&&!(*a - *b))
//	{
//	
//		a++;
//		b++;
//		
//	}
//	return *a - *b;
//}
//	
//int main()
//{
//	char a[30] = {"abcdfaaaaaadddddddd"};
//	char b[] = "abcdef";
//	//strncpy(a, b, 10);
//	//printf("%s\n", a);
//	//my_strncpy(a,b,5);
//	//printf("%s", a);
//	
//	printf("%d", my_strncmp(a, b,5));
//	return 0;
//
//}
//int compare(const void* a, const void* b)
//{
//	return *(char*)a> *(char*)b? 1: -1;
//}
//int *bubble(int arr[], int len)
//{
//	int j = 0;
//	for (j = 0; j < len - 1; j++)
//	{
//		for (int i=0; i < len-j-1; i++)
//		{
//			if (arr[i] > arr[i + 1])
//			{
//				int temp = arr[i];
//				arr[i] = arr[i + 1];
//				arr[i + 1] = temp;
//			}
//		}
//	}
//	return arr;
//}
//int main()
//{
//	/*char arr[] = { "acbfdehgji"};
//	int len = sizeof(arr);
//	int siz = sizeof(arr[0]);
//	qsort(arr, len, siz, compare);
//	for (int i = 0; i < len; i++)
//		printf("%c", arr[i]);*/
//	int arr[10]={ 9,8,7,6,5,4,3,2,1,0 };
//	bubble(arr, 10);
//	for (int i = 0; i < 10; i++)
//	{
//		printf("%d ", arr[i]);
//	}
//	return 0;
//}
//int romanToInt(char* s) {
//    int a[24];
//    a['I' - 'A'] = 1;
//    a['V' - 'A'] = 5;
//    a['X' - 'A'] = 10;
//    a['L' - 'A'] = 50;
//    a['C' - 'A'] = 100;
//    a['D' - 'A'] = 500;
//    a['M' - 'A'] = 1000;
//    int len = strlen(s);
//    int ret = 0;
//    int i = 0;
//    for ( i = 0; i < len - 1; i++)
//    {
//        if (a[s[i] - 'A'] >= a[s[i+1] - 'A'])
//            ret += a[s[i] - 'A'];
//        else
//            ret -= a[s[i] - 'A'];
//    }
//    ret += a[s[i] - 'A'];
//    return ret;
//}
//int main()
//{
//    char s[] = { "MCMXCIV" };
//    romanToInt(s);
//    printf("%d\n", romanToInt(s));
//	return 0;
//
//}
//char** fizzBuzz(int n, int* returnSize) {
//    *returnSize = n;
//    char** answer = malloc(n * sizeof(char*));
//    for (int i = 1; i <= n; i++)
//    {
//        if (i % 3 == 0 && i % 5 == 0)
//        {
//            answer[i - 1] = malloc(9 * sizeof(char));
//            answer[i - 1] = "FizzBuzz";
//        }
//        else if (i % 3 == 0)
//        {
//            answer[i - 1] = malloc(5 * sizeof(char));
//            answer[i - 1] = "Fizz";
//        }
//        else if (i % 5 == 0)
//        {
//            answer[i - 1] = malloc(5 * sizeof(char));
//            answer[i - 1] = "Buzz";
//        }
//        else
//        {
//            answer[i - 1] = malloc(5 * sizeof(char));
//            sprintf(answer[i - 1], "%d", i);
//        }
//
//        }
//        return answer;
//
//    }
//int main()
//{
//    printf(answer(5));
//    return 0;
//}

//void *copy_arr(double target1[5], double source[5], int n)
//{
//	for (int i = 0; i < n; i++)
//	{
//		target1[i] = source[i];
//	}
//	return 0;
//}
//void* copy_ptr(double *target2, double* source, int n)
//{
//	for (int i = 0; i < n; i++)
//	{
//		*target2 = *source;
//		target2++;
//		source++;
//	}
//	return 0;
//}
////void* copy_arr(double target1[5], double source[5], int n)
////{
////	for (int i = 0; i < n; i++)
////	{
////		target1[i] = source[i];
////	}
////}
//int main()
//{
//	/*float a[2] = { 10.8,1.2 };
//	int things[2][3] = { 1,2,3,4,5,6 };
//	int b[5] = { 1,2,3,4,5 };
//	things[1][2] = a[1];
//	int* c = b + 3;
//	int* d = b + 4;
//	printf("%d %d\n", *b,*(b+4));*/
//	double source[5] = { 1.1,2.2,3.3,4.4,5.5 };
//	double target1[5];
//	double target2[5];
//	double target3[5];
//	copy_arr(target1, source, 5);
//	copy_ptr(target2, source, 5);
//	//copy_ptrs(target3, source, source + 5);
//	for (int i = 0; i < 5; i++)
//		printf("%f ", target1[i]);
//	printf("\n");
//	for (int i = 0; i < 5; i++)
//		printf("%f ", target2[i]);
//	printf("\n");
//	/*for (int i = 0; i < 5; i++)
//		printf("%f ", target1[i]);
//	printf("\n");*/
//	return 0;
////}
//int get_max(const int* arr,int len)
//{
//	int max = *arr;
//	int i = 0;
//	while (i < len)
//	{
//		arr++;
//		if (*arr > max)
//			max = *arr;
//
//		i++;
//	}
//	return max;
//}
//float get_maxcount(const double source[10], int len)
//{
//	double max = source[0];
//	double min = source[0];
//	int mincount = 0;
//	int maxcount = 0;
//	int i = 0;
//	while (i < len)
//	{
//		if (source[i] > max)
//		{
//			max = source[i];
//
//			maxcount = i;
//		}
//		if (source[i] < min)
//		{
//			min = source[i];
//			mincount = i;
//		}
//		i++;
//	}
//	return (float)(max - min);
//}
//int main()
//{
//	int arr[] = { 1,2,5,4,9,3,7,8,10,25 };
//	double source[10] = { 1.1,2.2,3.3,7.8,4.4,5.5 };
//	int len = sizeof arr / sizeof arr[0];
//	//int max=get_max(arr,len);
//	float maxcount = get_maxcount(source, 6);
//	printf("maxcount=%f\n", maxcount);
//	return 0;
//}
 /*turn_down(double*ptr, int n)
{
	double temp = 0.0;
	for (int i = 0; i < n / 2; i++)
	{
		temp = *(ptr + i);
		*(ptr+i) = *(ptr+n-1-i);
		*(ptr + n - 1 - i) = temp;
	}
	

}*/
//sort(double arr[1], int n)
//{
//	double tmp = 0;
//	for (int i = 0; i < n-1; i++)
//	{
//		for (int j = 0; j < n - 1 - i; j++)
//		{
//			if (arr[j] < arr[j + 1])
//			{
//				tmp = arr[j];
//				arr[j] = arr[j + 1];
//				arr[j + 1] = tmp;
//			}
//		}
//	}
//}
//int main()
//{
//	double arr[10] = { 1.2,3.2,5.5,3.6,9.8,6.4,7.2,4.6,9.6,5.6 };
//	/*for (int i = 0; i < 10; i++)
//	{
//		printf("%f ", arr[i]);
//	}
//	printf("\n");*/
//	//turn_down(arr, 10);
//	sort(arr, 10);
//	for (int i = 0; i < 10; i++)
//	{
//		printf("%f ", arr[i]);
//	}
//	return 0;
//}
//copy_arr2(double* dest, double* source, int n)
//{
//	for (int i = 0; i < n; i++)
//	{
//		*(dest + i) = *(source + i);
//	}
//}
	//for (int i = 0; i < n; i++)
	//		{
	//			arr1[i] = arr2[i];
	//		}
//}
//copy_arr1(double(* dest)[4], double(*source)[4], int n)
//{for(int i=0;i<3;i++)
//	copy_arr2(*(dest+i), *(source+i), n);//等价于dest[i],source[i]
//}
//int main()
//{
//	double source[3][4] = {1.2, 5.3, 3.2, 5.5, 
//		                   1.6, 1.5, 5.5, 5.6, 
//		                    9.8, 7.5, 6.2, 8.9};
//	double arr[3][4] = { 0 };
//	copy_arr1(arr, source, 4);
//	for (int i = 0; i < 3; i++)
//	{
//		for (int j = 0; j < 4; j++)
//		{
//			printf("%f ", arr[i][j]);
//		}
//		printf("\n");
//	}
//	return 0;
//}
//move(int arr1[], int arr2[], int arr3[], int len)
//{
//	//int arr4[5] = { 0 };
//	for (int i = 0; i < len; i++)
//	{
//		arr3[i] = arr1[i] + arr2[i];
//	}
//}
//int main()
//{
//	//double arr1[7] = { 2.2,5.5,6.3,1.3,4.5,8.9,7.6 };
//	//double arr2[3] = { 0 };
//	//copy_arr2(arr2, &arr1[2], 3);
//	//for (int i = 0; i < 3; i++)
//		//printf("%f ", arr2[i]);
//	int arr3[5] = { 0 };
//	int arr1[5] = { 8,7,5,3,9 };
//	int arr2[5] = { 7,9,6,8,1 };
//	move(arr1, arr2, arr3, 5);
//	for (int i = 0; i < 5; i++)
//		printf("%d ", arr3[i]);
//	return 0;
//}
//double average2(const double arr[], int s)
//{
//	double average = 0;
//	double sum = 0;
//	for (int i = 0; i < s; i++)
//		sum += arr[i];
//	return average = sum / s;
//}
//average(const double(*arr)[2], int n)
//{
//	static double average[3] = { 0 };
//	for (int i = 0; i < n; i++)
//	{
//		double num=average2(*(arr + i), 2);
//		average[i] = num;
//		
//	}
//	
//}
//input_array(double (* arr)[COL], int n)
//{
//	for (int i = 0; i < n; i++)
//	{
//		for (int j = 0; j < COL; j++)
//			scanf("%lf", &arr[i][j]);
//	}
//}
//double A(const double arr[], int n)
//{
//	double b = 0;
//	double ret = 0;
//	for (int i = 0; i < n; i++)
//		ret += arr[i];
//	return b = (float)ret / n;
//}
// cacular(const double arr[][COL], int n,double average1[])
//{
//	for (int i = 0; i < n; i++)
//	{
//		average1[i]=A(arr[i], COL);
//	}
//}
//double B(const double arr[][COL], int n)
//{
//	double b = 0;
//	double ret = 0;
//	for(int i = 0; i < n; i++)
//	{
//		for (int j = 0; j < COL; j++)
//		{
//			ret += arr[i][j];
//		}
//	}
//	return b = ret / (ROW*COL);
//}
//double MAX(const double arr[][COL], int n)
//{
//	double ret = arr[0][0];
//	for (int i = 0; i < n; i++)
//	{
//		for (int j = 0; j < COL; j++)
//		{
//			if (arr[i][j] > ret)
//				ret = arr[i][j];
//		}
//	}
//	return ret;
//}
//int main()
//{
//	double arr[ROW][COL] = { 0 };
//	printf("请输入3组数字，每组数字都包含5个double类型的数\n");
//	input_array(arr, ROW);
//	int i = 0;
//	int j = 0;
//	double average1[COL] = { 0 };//每行的平均数
//	cacular(arr, ROW, average1);
//
//	
//	double average_all = 0;
//
//	 average_all = B(arr, ROW);
//	 double max=MAX(arr, ROW);
//	 //average(arr, 2);
// for ( i = 0; i < ROW; i++)
// {
//	 printf("%f ", average1[i]);
//		
// }
// printf("\n%lf\n%lf",average_all,max);
//	return 0;
//}

//init_arr(int(*arr)[COL],int row)
//{
//	printf("请声明一个3x5的二维数组\n");
//	for (int i = 0; i < row; i++)
//	{
//		for (int j = 0; j < COL; j++)
//		{
//			scanf("%d", *(arr + i) + j);
//		}
//    }
//}
//show(int(*arr)[COL], int row)
//{
//	for (int i = 0; i < row; i++)
//	{
//		for(int j = 0; j < COL; j++)
//		{
//			printf("%-2d ", *( * (arr + i) + j));
//		}
//		printf("\n");
//	}
//	printf("\n\n");
//}
//double_arr(int(*arr)[COL], int row)
//{
//	for (int i = 0; i < row; i++)
//	{
//		for (int j = 0; j < COL; j++)
//		{
//			(*(*(arr + i) + j)) *= 2;
//		}
//	}
//}
//int main()
//{
//
//	int arr[ROW][COL] = { 0 };
//	init_arr(arr, ROW);
//	printf("原始值：\n");
//	show(arr, ROW);
//	double_arr(arr, ROW);
//	printf("加倍值：\n");
//	show(arr, ROW);
//	return 0;
//
//}
//char* my_fgets(char arr[],int n)
//{
//	int i = 0;
//	char* ret = &arr[i];
//	
//	do
//	{
//		arr[i] = getchar();
//		
//		if (arr[i] == ' ' || arr[i] == '\t' || arr[i] == '\n')
//			continue;
//		ret = &arr[i];
//		do
//		{
//			i++;
//			arr[i] = getchar();
//			
//			if (arr[i] == ' ' || arr[i] == '\t' || arr[i] == '\n')
//				goto break1;
//		} while (arr[i] != EOF && i < n);
//	break1:break;
//	} while (arr[i]!=EOF && ++i<n);
//	arr[i] = '\0';
//	return ret;
//}
//char* find(char arr[], char dest)
//{
//	int i = 0;
//	while (arr[i] != '\0')
//	{
//		if (arr[i] == dest)
//			return &arr[i];
//		i++;
//	}
//	return NULL;
//}
//char * my_strncpy(char arr[], char source[],int n)
//{
//	int i = 0;
//
//	if (strlen(source) >= n)
//		return arr;
//	else
//	{
//		for (i = 0; i < n; i++)
//		{
//			arr[i] = source[i];
//
//}
//		arr[i] = '\0';
//	}
//	return arr;
//}
//char *string_in(char* a, char* b)
//{
//	int i = 0;
//	if (strlen(b) > strlen(a))
//		return	NULL;
//	else
//	{
//		while (a[i] != '\0')
//		{
//			int j = 0;
//			if (a[i] == b[j])
//			{
//				int k = i;
//				while (b[j] != '\0')
//				{
//					if (a[k++] != b[j++])
//						break;
//				}
//				if (b[j] == '\0')
//					return &a[i];
//			}
//			i++;
//		}
//		return NULL;
//	}
//}
//int main()
///*= */ {
//	char arr[50] = { 0 };
//	char source[80];
//	fgets(arr, 50, stdin);
//	fgets(source, 80, stdin);
//	printf("%p", string_in(arr, source));
//	//printf("%s", my_strn=0cpy(arr, source, 10));
//		//printf("请输入待检索的字符串\n");
//	//fgets(arr, 49, stdin);
//	//printf("请输入需要查找的字母,EOF结束。\n");
//	//dest = getchar();
//	//find(arr, dest);
//	//if (find!=NULL)
//	//{
//	//	printf("找到了，地址是%p", find);
//	//}
//	//else
//	//	printf("找不到\n");
//	////my_fgets(arr, 9);
//	//printf("%s", my_fgets(arr, 9));
//	return 0;
//}
//sort(char a[],int n)
//{
//	for (int i = 0; i < n;i++)
//	{
//		for (int j = 0; j < n - 1 - i; j++)
//		{
//			if (a[j] > a[j + 1])
//			{
//				char tmp = a[j + 1];
//				a[j + 1] = a[j];
//				a[j] = tmp;
//				
//			}
//		}
//	}
//}
//sortby_asc(char arr[][3], int n)
//{
//	char a[3][2];
//	for (int i = 0; i < n; i++)
//	{
//		a[i][0] = i;
//		a[i][1] = arr[i][0];
//	}
//	sort(a,3);
//
//}
//int main()
//{
//	char arr[3][80];
//	fgets(arr, 80, stdin);
//	
//	/*sortby_asc(arr,3);
//	for (int i = 0; i < 2; i++)
//	{
//		printf("%s", arr[i]);
//	}*/
//	int a[10];
//	a[0] = arr[0][0];
//	printf("%d", (int)'a');
//	
//	return 0;
//
//}
//int *make_array(int size,int n)
//{
//	int* arr = (int*)malloc(size * sizeof(int));
//	if (arr == NULL)
//		return NULL;
//	for (int i = 0; i < size; i++)
//	{
//		arr[i] = n;
//	}
//	return arr;
// }
//show_arr(int arr[],int n)
//{
//	for (int i = 0; i < n; i++)
//	{
//		printf("%d ", arr[i]);
//		if ((i + 1) % 8 == 0)
//			printf("\n");
//	}
//}
//int main()
//{/*
//	char a;
//	int i = 0;
//	while (i++ < 5)
//		printf("%d", i);*/
//
//	return 0;
//}  ....................        
//int main()
//{
//	int num;
//	printf("How many words will you put?\n");
//	scanf("%d", &num);
//	printf("Enter %d words now:\n",num);
//	char** ptr = (char**)malloc(num * sizeof(char*));
//	if (ptr == NULL)
//	return NULL;
//	for (int i = 0; i < num; i++)
//	{
//		char tmp[100];
//		scanf("%s", tmp);
//		int len = (int)strlen(tmp);
//		char* str = (char*)malloc((len+1) * sizeof(char));
//		if (str == NULL)
//		return NULL;
//		strcpy(str,tmp);
//		ptr[i] = str;
//	}
//	for (int j = 0; j < num; j++)
//	{
//		printf("%s\n", ptr[j]);
//	}
//	free(ptr);
//	printf("done\n");
//	
//	return 0;
//
//}
int main()
{
	typedef struct A
	{
		float coef;
		int expn;
		struct A* next;
	}A;
	A* head = (A*)malloc(sizeof(A));
	head->next = NULL;
	A* p = head;
	A* a = (A*)malloc(sizeof(A));
	a->coef = 7;
	a->expn = 0;
	a->next = NULL;
	p->next = a;
	p = a;
	
	return 0;
}