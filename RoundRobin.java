package os;
import java.util.*;

public class RoundRobin {
    
    static void findWaitingTime(int processes[], int n, int bt[], int wt[], int quantum) { 
        int rem_bt[] = new int[n]; 
        System.arraycopy(bt, 0, rem_bt, 0, n); 
        int t = 0;
        while(true) { 
            boolean done = true; 
            for (int i = 0 ; i < n; i++) 
            { 
                if (rem_bt[i] > 0) 
                { 
                    done = false; 
       
                    if (rem_bt[i] > quantum) 
                    { 
                        t += quantum; 
                        rem_bt[i] -= quantum; 
                    } 
                    else
                    { 
                        t = t + rem_bt[i]; 
                        wt[i] = t - bt[i]; 
                        rem_bt[i] = 0; 
                    } 
                } 
            } 
            if (done == true) 
              break; 
        } 
    } 
    static void findTurnAroundTime(int processes[], int n,int bt[], int wt[], int tat[]) 
    { 
        for (int i = 0; i < n ; i++) 
            tat[i] = bt[i] + wt[i]; 
    } 
    public static void findAvgTime(int process[] ,int n ,int bt[] ,int quantum){
        int wt[] = new int[n], tat[] = new int[n]; 
        int total_wt = 0, total_tat = 0;         
        findWaitingTime(process, n, bt, wt, quantum); 
        findTurnAroundTime(process, n, bt, wt, tat);         
    }
    public static void main(String[] args) {
        int process[] = {1,2,3};
        int n = process.length;
        int burst_time[] = {10,5,8};
        int quantum = 4 ;
        findAvgTime(process,n,burst_time,quantum);
    }
}
