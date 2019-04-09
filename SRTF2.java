public class SRTF2 {
    
static class p
{
  int atime, btime, rtime, wtime, tatime;
};

public static void main(String[] args) {
   int n =4;
   p pr[] = new p[n];
   for(int i = 0 ; i < n ; i++){
        pr[i] = new p();            
   }
    pr[0].atime = 0 ;
   pr[0].btime = 5 ;
      pr[1].atime = 1 ;
   pr[1].btime =  3;
      pr[2].atime = 2 ;
   pr[2].btime = 3 ;
      pr[3].atime = 3 ;
   pr[3].btime = 1 ;
    //pr[4].atime = 4 ;
   //pr[4].btime = 5 ;
  for(int i=0; i<n; i++){
    pr[i].rtime = pr[i].btime;
  }
   
    int time=0, finished=0, minimum = Integer.MAX_VALUE, s =0;
    double avg_wtime=0, avg_tatime=0;
    boolean found = false;
    
    while (finished < n){
    for(int i=0; i<n; i++){
        if( (pr[i].atime <= time) && (pr[i].rtime >0) && (pr[i].rtime < minimum) ){
            minimum = pr[i].rtime;
            s = i;
            found = true;
        }
            
    }

    if(found==false){
        time++;
        //System.out.println("gg");
        continue;
    }

    minimum = --pr[s].rtime;
        //System.out.println("m"+minimum);
    if(pr[s].rtime == 0){
        minimum = Integer.MAX_VALUE;
        finished++;
        found = false;

        int endtime = time+1;

        pr[s].wtime = endtime - pr[s].atime - pr[s].btime;
        //pr[s].wtime = (pr[s].wtime<0 ? 0 : pr[s].wtime);

        pr[s].tatime = endtime - pr[s].atime;

        avg_wtime += pr[s].wtime;
        avg_tatime += pr[s].tatime;
        System.out.println("time:"+time);
    }

    time++;
      
    }
    System.out.println("Process\tWaiting Time\tTurnAround Time\n");
    
    for(int i=0; i<n; i++){
        System.out.printf("P%d\t%d\t\t%d\n", i+1, pr[i].wtime, pr[i].tatime);
    }
}

/*
4

0 8
1 4
2 9
3 5

*/

}
