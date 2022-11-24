// 7348 Rajvardhan Singh Inda 
// 26/10/2022

package pack_7348_6;
import java.util.ArrayList;
public class LRU {
		public static void main(String[] args) {
			int capacity = 4;
			int arr[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
			ArrayList<Integer> s=new ArrayList<>(capacity);
			int count=0;
			int page_faults=0;
			for(int i:arr)
			{
				if(!s.contains(i))
				{
				if(s.size()==capacity)
				{
					s.remove(0);
					s.add(capacity-1,i);
				}
				else
					s.add(count,i);
					page_faults++;
					++count;
			
				}
				else
				{
					s.remove((Object)i);
					s.add(s.size(),i);		
				}
			
			}
			System.out.println("Total Pages : "+arr.length);
			System.out.println("Number of Faults : "+page_faults);
		}
	}
