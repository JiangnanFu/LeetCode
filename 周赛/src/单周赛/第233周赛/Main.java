package 单周赛.第233周赛;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 @author fujiangnan
 @create 2021-03-21-11-02
 @desc ...
 */
public class Main {

    public static void main(String[] args) {
        int[][] arr = {{7,1000000000,1},{15,3,0},{5,999999995,0},{5,1,1}};
        System.out.println(getNumberOfBacklogOrders(arr));
    }

    public static int getNumberOfBacklogOrders(int[][] orders) {
        List<Integer> buy = new LinkedList<>();
        List<Integer> sell = new LinkedList<>();

        if (orders.length == 0) {
            return 0;
        }

        for (int i=0; i<orders.length; ++i) {

                if (orders[i][2] == 0 && sell.size() == 0) {
                    for (int k=0; k<orders[i][1]; ++k) {
                        buy.add(orders[i][0]);
                        Collections.sort(buy);
                    }
                }

                if (orders[i][2] == 0 && sell.size() != 0) {
                    for (int k=0; k<orders[i][1]; ++k) {
                        if (sell.size() !=0 && orders[i][0] >= sell.get(0)) {
                            sell.remove(0);
                        } else {
                            buy.add(orders[i][0]);
                            Collections.sort(buy);
                        }
                    }
                }


                if (orders[i][2] == 1 && buy.size() == 0) {
                    for (int n=0; n<orders[i][1]; ++n) {
                        sell.add(orders[i][0]);
                        Collections.sort(sell);
                    }
                }


                if (orders[i][2] == 1 && buy.size() != 0) {
                    for (int k=0; k<orders[i][1]; ++k) {
                        if (buy.size() !=0 && orders[i][0] <= buy.get(0)) {
                            buy.remove(0);
                        } else {
                            sell.add(orders[i][0]);
                            Collections.sort(sell);
                        }
                    }
                }

        }

        return (buy.size() + sell.size()) % (10^9 + 7);
    }

}
