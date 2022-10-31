#include<stdio.h>
#include<math.h>
int main()
{
	int i = 0;
	int count = 0;
	for (i = 100; i <= 200; i++)
	{
		//判读i是否为素数
		//素数判断的规则
		//1. 试除法
		//产生2->i-1
		int j = 0;
		for (j = 2; j < i; j++)
		{
			if (i % j == 0)
			{
				break;
			}
		}
		if (j == i)
		{
			count++;
			printf("%d ", i);
		}
	}
	printf("\ncount = %d\n", count);
	return 0;
}

//int main() {
//	int i = 101;
//	int z = 0;
//	int count = 0;
//	for(i=2;i<12;i++){
//		
//		for (z = 2; z <i; z++)
//		if (i % z == 0)
//				break;
//	} if (z == i) {
//		printf("%d ", i);
//		count++;
//	}
//}
//int primer(int x) {
//	int z = 2;
//	for (z=2; z < x; z++) {
//		if (x % z == 0)
//			return 0;
//		
//	}return 1;
//}
//int main() {
//	int count = 0;
//	int i = 101;
//	int a = primer(i);
//	for (i = 101; i <= 200; i ++)
//	{
//		if (a == 1) {
//			printf("%d ", i);
//			count++;
//		}
//	}printf("总数是%d\n", count);
//	return 0;
//}
////
//	}

//int p_primer(int x) {
//	int count = 0;
//	int n = 2; 
//	for (x = 101; x< 200; x += 2)
//	{
//		for (n = 2; n <= sqrt(x); n++)
//			if (x % n == 0)
//				break;
//		if (n > sqrt(0))
//			count++;
//	}return count;
//}
//
//int main() 
//	{
//	int i = 101; int a = p_primer(i);
//		printf("总数是%d\n", a);
//		return 0;
//	}
//int main()
//{
//	int i = 102;
//	int count = 0;
//	while (p_primer(i)) {
//		printf("%d", i);
//		count++;
//		if (i > 200)
//			break;
//	}printf("\n总数是%d", i);
//	return 0;
//}