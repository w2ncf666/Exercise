#include<stdio.h>

int removeDuplicates(int* nums, int numsSize) {
        for (int i = 0; i < numsSize; i++)
        {
            int count = 0;
            for (int j = i + 1; j < numsSize; j++)
            {
                if (nums[i] != nums[j])
                    break;
                else {
                    count++;
                    if (j + 1 == numsSize)
                        break;
                    else if (nums[i] != nums[j + 1])
                    {
                        for (int k = i + 1; k < numsSize - count; k++)
                            nums[k] = nums[k + count];
                        break;
                    }
                }
            }
            numsSize -= count;
        }
    return numsSize;
}
void rotate(int* nums, int numsSize, int k) {
    int arr[7];
    int i = 0;
    for (; i < numsSize; i++)
        arr[(i + k) % numsSize] = nums[i];
    for (; i < numsSize; i++)
        nums[i] = arr[i];
}
int main()
{
    int arr[] = { 1,2,3,4,5,6,7};
    rotate(arr, 7, 3);
  // int a=removeDuplicates(arr,sizeof(arr)/sizeof(arr[0]));
   for (int i = 0; i < 7; i++)
       printf("%d", arr[i]);
    return 0;
}