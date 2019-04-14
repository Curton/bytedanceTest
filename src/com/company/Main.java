package com.company;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static int minus = 0;
    public static boolean change = false;
    public static void main(String[] args) {
        ArrayList<String> row = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int[][] grid = new int[11][11];
        int rowN = 0;
        int colN = 0;

        while (in.hasNextLine()) {

            String temp = in.nextLine();
            if (temp.equals("")) {
                // System.out.println("finish read");
                break;
            } else {
                row.add(temp);
                // System.out.println(temp);
            }


        }


        for (int j = 0; j < row.size(); j++) {
            String[] string = row.get(j).split(" ");
            for (int k = 0; k < string.length; k++) {
                grid[j][k] = Integer.valueOf(string[k]);
                colN = string.length;
            }
            rowN++;
        }



        // check
        boolean ifbreak = false;
        for (int i = 0; i < rowN ; i++) {
            if(ifbreak){
                break;
            }

            for (int j = 0; j < colN ; j++) {
                // System.out.print(grid[i][ii]);
                if(i == 0 && j == 0) {
                    if(grid[i][j] == 2) {
                        grid[i][j+1] = grid[i][j+1] == 1 ? Change() : grid[i][j+1];
                        grid[i+1][j] = grid[i+1][j] == 1 ? Change() : grid[i+1][j];
                    }
                } else if(i == 0 && j != 0) {
                    if(grid[i][j] == 2) {
                        grid[i][j+1] = grid[i][j+1] == 1 ? Change() : grid[i][j+1];
                        grid[i][j-1] = grid[i][j-1] == 1 ? Change() : grid[i][j-1];
                        grid[i+1][j] = grid[i+1][j] == 1 ? Change() : grid[i+1][j];
                    }
                } else if(i != 0 && j == 0) {
                    if(grid[i][j] == 2) {
                        grid[i-1][j] = grid[i-1][j] == 1 ? Change() : grid[i-1][j];
                        grid[i][j+1] = grid[i][j+1] == 1 ? Change() : grid[i][j+1];
                        grid[i+1][j] = grid[i+1][j] == 1 ? Change() : grid[i+1][j];
                    }
                } else if(i != 0 && j != 0) {
                    if(grid[i][j] == 2) {
                        grid[i-1][j] = grid[i-1][j] == 1 ? Change() : grid[i-1][j];
                        grid[i][j+1] = grid[i][j+1] == 1 ? Change() : grid[i][j+1];
                        grid[i+1][j] = grid[i+1][j] == 1 ? Change() : grid[i+1][j];
                        grid[i][j-1] = grid[i][j-1] == 1 ? Change() : grid[i][j-1];
                    }
                }

                if(change) {
                    minus++;
                    change = false;
                }
                /*
                for (int m = 0; m < rowN ; m++) {
                    for (int n = 0; n < colN ; n++) {
                        if(n == colN - 1) {
                            System.out.println(grid[m][n]);
                        } else {
                            System.out.print(grid[m][n]);
                        }
                        //
                    }
                }
                */

                int count = 0;
                for (int m = 0; m < rowN ; m++) {
                    for (int n = 0; n < colN ; n++) {

                        if(grid[m][n] == 1) {
                            count ++;
                        }
                    }
                }

                if (count == 0) {
                    ifbreak = true;
                    // System.out.println("break in"+i+" "+j);
                    break;
                }

            }
        }
        /*
        for (int i = 0; i < rowN ; i++) {
            for (int j = 0; j < colN ; j++) {
                if(j == colN - 1) {
                    System.out.println(grid[i][j]);
                } else {
                    System.out.print(grid[i][j]);
                }
                //
            }
        }
        */
        int count = 0;
        for (int m = 0; m < rowN ; m++) {
            for (int n = 0; n < colN ; n++) {

                if(grid[m][n] == 1) {
                    count ++;
                }
            }
        }

        if (count != 0) {
            System.out.println(-1);
        } else {
            System.out.println(minus);
        }

    }

    public static int Change() {
        change = true;
        return 2;
    }
}
