class MergeSort {
    public static void main (String[] args){
        int[] array = { 10, 7, 8, 2, 5, 6 };
        
        System.out.print("Array sebelum merge-sort: ");
        for(int i = 0; i < array.length; ++i){
            System.out.print(array[i] + " ");
        }
        System.out.println();

        sort(array, 0, array.length - 1);

        System.out.print("Array setelah merge-sort: ");
        for(int i = 0; i < array.length; ++i){
            System.out.print(array[i] + " ");
        }

    }
    
    static void sort(int[] array, int left, int right){
        if(left < right) {
            int middle = (left + right)/2;
            
            sort(array, left, middle);
            sort(array, middle + 1, right);
            
            merge(array, left, middle, right);
        }
    }
    
    static void merge(int[] array, int left, int middle, int right){
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for(int i = 0; i < n1; ++i){
            leftArray[i] = array[left + i];
        }
        for(int j = 0; j < n2; ++j){
            rightArray[j] = array[middle + 1 + j];
        }

        int i = 0; int j = 0;
        int k = left;

        while(i < n1 && j < n2){
            if(leftArray[i] <= rightArray[j]){
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while(j < n2){
            array[k] = rightArray[j];
            j++;
            k++;
        }
        
    }

}