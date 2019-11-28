public class ContiguousSum {

	public static void main(String[] args) {
		int arr[] = {5,15,-30,10,-5, 40,10};
		int contiguousArray[] = contig(arr);
		for (int x = 0; x<contiguousArray.length; x++) {
			System.out.println(contiguousArray[x]);
		}
	}
	static public int [] contig(int arr[]) {
		int finalArr[] = new int [arr.length];
		int maxContig[][] = new int[arr.length][2]; //this array holds in the the start of the max-contiguous subarray for that current element we are looking at. in the 0 we hold the total sum at that point, in the 1 we hold which position we started at
		maxContig[0][0] = arr[0];
		maxContig[0][1] = 0;
		int maxSoFar = arr[0];
		int maxHere = arr[0];
		int maxStart = 0;
		int currentStart = 0; 
		int arrayPos = 0;
		for (int x = 1; x <arr.length; x++) {
			if (maxHere + arr[x] < arr[x]) { //if we would be better off starting a new contiguous sub-array here then set maxHere to our current value, and set the starting for our maxcontig of this array to our current value
				maxContig[x][0] = arr[x];
				maxContig[x][1] = x;
				maxHere = arr[x];
				currentStart = x;
			}
			else { //otherwise we continue our contiguous sub-array
				maxHere += arr[x];
				maxContig[x][0] = maxHere;
				maxContig[x][1] = currentStart;
			}
			maxSoFar = Math.max(maxSoFar, maxHere); //set whichever to the new max
			if (maxSoFar == maxHere) {	//find out wherever our max contiguous array starts
				maxStart = currentStart;
			}
		}
		// go through one more time to find where the array max starts and ends at
		for (int x = maxStart; x<arr.length; x++) { //start at the beginning of our max contigous array
			if (maxSoFar == maxContig[x][0]) { //we have reached the end of our max contiguous array
				finalArr[arrayPos] = arr[x];
				arrayPos++;
				break;
			}
			else {
				finalArr[arrayPos] = arr[x];
				arrayPos++;
			}
		}
		return finalArr;
	}
}
