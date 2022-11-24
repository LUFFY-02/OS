import java.util.*;

class SJF{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no. of processes: ");
		int n = sc.nextInt();
		int[] pid = new int[n];	//process id
		int[] at = new int[n];	//arrival time
		int[] bt = new int[n];	//burst time
		int[] lbt = new int[n];	//left burst time
		int[] ct = new int[n];	//completion time
		int[] tat = new int[n]; //turn around time
		int[] wt = new int[n];	//waitng time
		int[] visited = new int[n];	//process is done or not
		int[] completed = new int[n];
		float avgtat = 0;
		float avgwt = 0;
		int st = 0;	//system time
		int count = 0;	//count of process completed
		System.out.println("Enter Time quantum: ");
		int tq = sc.nextInt();	//time quantum
		
		for(int i=0; i<n; i++){
			pid[i] = (i+1);
			System.out.print("\nEnter Process "+(i+1)+" arrival time: ");
			at[i] = sc.nextInt();
			System.out.print("\nEnter Process "+(i+1)+" burst time: ");
			bt[i] = sc.nextInt();
			lbt[i] = bt[i];
		}
		
		int t = 0;
		while(count < n){
			int curr = -1;
			int sbt = Integer.MAX_VALUE;	//smallest burst time
			for(int i=0; i<n; i++){
				if(at[i] <= t && completed[i] != 1 && sbt > lbt[i]){
					sbt = lbt[i];
					curr = i;
				}
			}
			if(curr != -1){
				if(lbt[curr] > tq){
					lbt[curr] -= tq;
					t += tq;
				}
				else{
					t = t + lbt[curr];
					ct[curr] = t;
					tat[curr] = ct[curr] - at[curr];
					wt[curr] = tat[curr] - bt[curr];
					avgtat += tat[curr];
					avgwt += wt[curr];
					completed[curr] = 1;
					count++;
				}
			}
			else{
				t++;
			}
		}
		
		System.out.println("\nPid\tAT\tBT\tCT\tTAT\tWT");
		for(int  i = 0 ; i< n;  i++){
			System.out.println(pid[i] + "  \t " + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + tat[i] + "\t"  + wt[i] ) ;
		}
		sc.close();
		System.out.println("\naverage waiting time: "+ (avgwt/n));     // printing average waiting time.
		System.out.println("average turnaround time:"+(avgtat/n));    // printing average turnaround time.
	}
}
