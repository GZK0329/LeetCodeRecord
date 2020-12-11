package com.gzk.leetcode861;

class Solution {
    public int matrixScore(int[][] A) {
        int len = A.length;
        int size = A[0].length;
        int sumHead = 0;
        for(int i = 0; i < len; ++i){
            if(A[i][0] == 1){
                sumHead++;
            }
            if(A[i][0] == 0){
                reverseRow(A, i);
            }
        }
        if(sumHead > ((len + 1) / 2)){
            for(int i = 0; i < len; ++i){
                if(A[i][0] == 0){
                    reverseRow(A, i);
                }
            }
        }else{
            reverseColumn(A, 0);
            for(int i = 0; i < len; ++i){
                if(A[i][0] == 0){
                    reverseRow(A, i);
                }
            }
        }
        //上述完成了第一列只有1
        //接下来只做列转换
        int sum = 0;
        for(int j = 1; j < size; ++j){
            sum = 0;
            for(int i = 0; i < len; ++i){
                if(A[i][j] == 0){
                    sum++;
                }
                if(sum > ((len + 1) / 2)){
                    reverseColumn(A, j);
                }
            }
            //j递增过了

        }
        int res = 0;
        for(int i = 0; i < len; ++i){
            for(int j = 0; j < size; ++j){
                if(A[i][j] == 1){
                    res += Math.pow(2,size - j - 1);
                }
            }
        }
        return res;

    }


    public void reverseRow(int[][] A, int row){
        for(int i = 0; i < A[0].length; ++i){
            if(A[row][i] == 1){
                A[row][i] = 0;
            }
            if(A[row][i] == 0){
                A[row][i] = 1;
            }
        }
    }

    public void reverseColumn(int[][] A, int column){
        for(int i = 0; i < A.length; ++i){
            if(A[i][column] == 1){
                A[i][column] = 0;
            }
            if(A[i][column] == 0){
                A[i][column] = 1;
            }
        }
    }
}
