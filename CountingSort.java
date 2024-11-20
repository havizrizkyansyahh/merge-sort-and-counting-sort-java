public class CountingSort {
    public static void main(String[] args){
        int[] array = { 4, 1, 3, 2, 1, 2 };
        
        System.out.print("Array sebelum counting sort: ");
        for(int i = 0; i < array.length; ++i){
            System.out.print(array[i] + " ");
        }
        System.out.println();

        sort(array);

        System.out.print("Array setelah counting sort: ");
        for(int i = 0; i < array.length; ++i){
            System.out.print(array[i] + " ");
        }
    }

    static void sort(int[] array){
        int n = array.length;
        int[] output = new int[n];

        int maxNumberInArray = array[0];
        for(int i = 0; i < n; ++i){
            if(maxNumberInArray < array[i]){
                maxNumberInArray = array[i];
            }
        }

        int[] count = new int[maxNumberInArray + 1];

        for(int i = 0; i < count.length; ++i){
            count[i] = 0;
        }
        for(int i = 0; i < n; ++i){
            ++count[array[i]];
        }

        for(int i = 1; i <= count.length - 1; ++i){
            count[i] += count[i - 1];
        }

        for(int i = 0; i < n; ++i){
            output[count[array[i]] - 1] = array[i];
            --count[array[i]];
        }

        for(int i = 0; i < n; ++i){
            array[i] = output[i];
        }
    }
}
