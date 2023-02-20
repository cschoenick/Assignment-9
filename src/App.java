import java.util.*;

public class App{
    public static <E extends Comparable<E>> void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int arrayLength = scanner.nextInt();
        scanner.close();
        ArrayList<Double> a = createRandomArray(arrayLength, Double.class);
    
        
        System.out.println("Before Sorting:" + "\n" + a.toString());
        System.out.println("Sorted: " + isSorted(a) + "\n");
        mergeSort(a, 0, arrayLength);
        System.out.println("Merge Sort:\n" + a.toString());
        long start_time = System.currentTimeMillis() /1000;
        long end_time = System.currentTimeMillis() /1000 - start_time;
        System.out.println("Sorted: " + isSorted(a));
        System.out.println("Merge Sort time to complete: " + end_time + " seconds" + "\n");
       
        start_time = System.currentTimeMillis() /1000;
        bubbleSort(a);
        end_time = System.currentTimeMillis() /1000 - start_time;
        System.out.println("Bubble Sort:\n" + a.toString());
        System.out.println("Sorted: " + isSorted(a));
        System.out.println("Bubble Sort time to complete: " + end_time + " seconds");
    }
    public static <E> ArrayList<E> createRandomArray(Integer arrayLength, Class<E> elementType){
        Random random = new Random();
        ArrayList<E> a = new ArrayList<>(arrayLength);


        if (elementType == Integer.class) {
            for (int i = 0; i < arrayLength; i++) {
                Object arrayElement = random.nextInt(100);
                a.add((E) arrayElement);
            }
        } else if (elementType == Double.class) {
            for (int i = 0; i < arrayLength; i++) {
                Object arrayElement = random.nextDouble();
                a.add((E) arrayElement);
            }
        } else if (elementType == Float.class) {
            for (int i = 0; i < arrayLength; i++) {
                Object arrayElement = random.nextFloat();
                a.add((E) arrayElement);
            }
        } else if (elementType == String.class) {
            for (int i = 0; i < arrayLength; i++) {
                Object arrayElement = UUID.randomUUID().toString();
                a.add((E) arrayElement);
            }
        } else {
            throw new IllegalArgumentException("Invalid element type");
        }
        
        return a;
    }   
    

    public static <E extends Comparable<E>> boolean isSorted(ArrayList<E> array){
        for (int i=0; i < array.size() - 1; i++){
            if (array.get(i).compareTo(array.get(i + 1)) > 0)
            return false;
        }
        return true;
    }

    public static <E extends Comparable<E>> void mergeSort(ArrayList<E> a, int start, int end){
        if (end - start <= 1){
            return;
        }   
        
        int middle = (start + end) / 2;
        mergeSort(a, start, middle);
        mergeSort(a, middle, end);
        merge(a, start, middle, end);
        
    }

    public static <E extends Comparable<E>> void merge(ArrayList<E> a, int start, int middle, int end){
        int i = start;
        int j = middle;
        ArrayList<E> tempArray = new ArrayList<>();
        

        while (i < middle && j < end) {
            if (a.get(i).compareTo(a.get(j)) >= 0){
                tempArray.add(a.get(j));
                j++;
            } else {
                tempArray.add(a.get(i));
                i++;
            }
        }
        while ( i < middle){
            tempArray.add(a.get(i));
            i++;
        }
        while (j < end){
            tempArray.add(a.get(j));
            j++;
        }

        for (i = start; i < end; i++){
            a.set(i, tempArray.get(i - start));
        }
    }
    
    
    public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> array){
        for (int j = array.size() - 1; j >= 1; j--){
            for (int i=0; i < j; i++){
                if (array.get(i).compareTo(array.get(i+1)) > 0){
                E temp = array.get(i);
                array.set(i, array.get(i +1));
                array.set(i+1, temp);
                }
            }
        }
    } 
}