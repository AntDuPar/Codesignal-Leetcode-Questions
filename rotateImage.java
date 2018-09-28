/*
Note: Try to solve this task in-place (with O(1) additional memory), since this is what you'll be asked to do during an interview.

You are given an n x n 2D matrix that represents an image. Rotate the image by 90 degrees (clockwise).

Example

For

a = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]
the output should be

rotateImage(a) =
    [[7, 4, 1],
     [8, 5, 2],
     [9, 6, 3]]
*/

int[][] rotateImage(int[][] a) {
    int[][] tmp = new int[a.length][a[0].length];
    for(int i = 0; i < a.length; i++){
        for(int j = 0; j < a[i].length; j++){
            tmp[i][j] = a[(a[j].length-1)-j][i];
        }
    }
    return tmp;
}
