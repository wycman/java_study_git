package org.example;

public class BinarySearch {
    /**
     * 定义折半查找功能函数
     */
    public static int binarySearch(int[] arr, int target)
    {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right)
        {
            int mid = (left + right) / 2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        //表示未找到
        return -1;
    }
}
