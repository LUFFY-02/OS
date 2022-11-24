import java.util.*;

class FCFS{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no. of processes: ");
		int n = sc.nextInt();
		int[] pid = new int[n];	//process id
		int[] ar = new int[n];	//arrival time
		int[] bt = new int[n];	//burst time
		int[] ct = new int[n];	//completion time
		int[] tat = new int[n]; //turn around time
		int[] wt = new int[n];	//waitng time
		float avgtat = 0;
		float avgwt = 0;
		
		for(int i=0; i<n; i++){
			pid[i] = (i+1);
			System.out.print("\nEnter Process "+(i+1)+" arrival time: ");
			ar[i] = sc.nextInt();
			System.out.print("\nEnter Process "+(i+1)+" burst time: ");
			bt[i] = sc.nextInt();
		}
		
		for(int i=0; i<n; i++){
			for(int j=i+1; j<n; j++){
				if(ar[i]>ar[j]){
					int temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
					temp = bt[i];
					bt[i] = bt[j];
					bt[j] = temp;
					temp = pid[j];
					pid[j] = pid[j+1];
					pid[j+1] = temp;
				}
			}
		}
		
		for(int i=0; i<n; i++){
			if(i==0){
				ct[i] = ar[i]+bt[i];
			}
			else if(ar[i] > ct[i-1]){
				ct[i] = ar[i]+bt[i];
			}
			else{
				ct[i] = ct[i-i]+bt[i];
			}
			tat[i] = ct[i] - ar[i];
			wt[i] = tat[i] - bt[i];
			avgtat += tat[i];
			avgwt += wt[i];
		}
		System.out.println("\nPid\tAT\tBT\tCT\tTAT\tWT");
		for(int  i = 0 ; i< n;  i++){
			System.out.println(pid[i] + "  \t " + ar[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + tat[i] + "\t"  + wt[i] ) ;
		}
		sc.close();
		System.out.println("\naverage waiting time: "+ (avgwt/n));     // printing average waiting time.
		System.out.println("average turnaround time:"+(avgtat/n));    // printing average turnaround time.
	}
}
