package sort;

public class SelectSort {
	public static void main(String[] args) {

		int[] array = {5,3,4,1,2};

		for(int i=0; i < array.length -1 ; i++){
			int minIndex = i;

			for(int j = i + 1; j < array.length; j++){
				if(array[j] < array[minIndex]){
					minIndex = j;
				}
			}
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}

		for (int i = 0; i<array.length ; i++){
			System.out.println(array[i]);
		}

	}
}
