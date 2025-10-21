import java.util.ArrayList;


public class NumSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        ROUND 1 tests
        */
        
        // Create a random int array of a given length, low and high end of range
        int[] randArray = randArray(15, 0, 100);
        
        // Create a random Integer ArrayList of given length, low and high range
        ArrayList<Integer> randArrL = randArrL(8, 5, 50);
        
        // How many similar elements are in a given array and ArrayList
        System.out.print("There are this many similar elements: ");
        System.out.println(compareNums(randArray, randArrL));
        
        // printPretty takes an int array and prints it out nicely
        printPretty(randArray);
        // printPretty takes an Integer ArrayList and prints it out nicely
        printPretty(randArrL);
        
        /*
        ROUND 2 tests
        */
        
        // shuffle randomizes an int array (then calls printPretty)
        shuffle(randArray);
        
        // shuffle randomizes an Integer ArrayList (then calls printPretty)
        shuffle(randArrL);
        
        // divide all numbers by two
        divByTwo(randArray);
        divByTwo(randArrL);
        
        //sumArray
        sumArray(randArray);
        sumArray(randArrL);
        
    }
    /*
    ROUND 1 code
    */
    
    // TODO: randArray
    public static int[] randArray(int length, int low, int high) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int rand = (int)(Math.random() * (high - low + 1)) + low;
            result[i] = rand;
        }
        return result;
    }
    
    // TODO: randArrL
    public static ArrayList<Integer> randArrL(int length, int low, int high){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < length; i++){
            int rand = (int)(Math.random() * (high - low + 1)) + low;
            result.add(rand);
        }
        return result;
    }
    
    
    // TODO: compareNums
    public static int compareNums(int[] array, ArrayList<Integer> arraylist){
        int count = 0;
        int smallestlength = 0;
        if(arraylist.size() < array.length) smallestlength = arraylist.size();
        else smallestlength = array.length;

        for(int i = 0; i < smallestlength; i++){
            if(arraylist.get(i) == array[i]) count++; 
        }
    return count;
    }
    
    
    // TODO: prettyPretty (overloaded)
    public static void printPretty(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println("The number at position " + i + " is " + arr[i]);
        }

    }
    /*
    ROUND 2 code
    */
    public static void printPretty(ArrayList<Integer> arr){
        for(int i = 0; i < arr.size(); i++){
        System.out.println("The number at position " + i + " is " + arr.get(i));
    }
}
    // TODO: shuffle array
    public static int[] shuffle(int[] arr){
        int random = 0;
        int [] tempArray = {1, 1, 1};
        int [] shuffledArray = {};
        for(int i = 1; i < (arr.length -1); i++){
            //pick random index location
            random = (int)((Math.random() * arr.length-1) + 1);
            
            //copy arr[random] to a temp location
            tempArray[0] = arr[random];
            //move arr[i] to arr[random]
            arr[random] = arr[i];
            //move temp to arr[i]
            arr[i] = tempArray[0];
        }
        
        System.out.println("");
        System.out.println("shuffle for int[]:");
        printPretty(arr);    
        return arr;    
    } 
    
    // TODO: shuffle ArrayList
    public static ArrayList<Integer> shuffle(ArrayList<Integer> arr){
        int newNum = 0;
        int random = 0;
        ArrayList<Integer> tempArray = new ArrayList<>();
        for(int i = 1; i < (arr.size() -1); i++){
            //pick random index location
            random = (int)((Math.random() * arr.size()-1) + 1);
            
            //copy arr[random] to a temp location
            tempArray.add(arr.get(random));
            //move arr[i] to arr[random]
            arr.set(random, arr.get(i));
            //move temp to arr[i]
            newNum = tempArray.get(0);
            tempArray.remove(0);
            arr.set(i, newNum);
        }
        System.out.println("");
        System.out.println("shuffle for ArrayList<>:");
        printPretty(arr);
        return arr;
    }
    // TODO: divByTwo (overloaded)
    public static int[] divByTwo(int[] arr){
        int[] newArr = new int[arr.length];
        for(int i = 0; i < arr.length - 1; i++){
            newArr[i] = (arr[i]/2);
        }
        
        System.out.println("");
        System.out.println("divByTwo for int[]:");       
        printPretty(newArr);
        return newArr;
    }
    //Second part (The Overload)
    public static ArrayList<Integer> divByTwo(ArrayList<Integer> arr){
        ArrayList<Integer> newArr = new ArrayList<>();
        for(int num : arr){
            newArr.add(num/2);
        }
        
        System.out.println("");
        System.out.println("divByTwo for ArrayList<>:");
        printPretty(newArr);
        return newArr;
    }
    
    // TODO: sumArray (overloaded)
    public static int sumArray(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum+=arr[i];
        }
        System.out.println("The sum of the array is: " + sum); 
        return sum;
    }

    public static int sumArray(ArrayList<Integer> arr){
        int sum = 0;
        for(int num : arr){
            sum += num;
        }
        System.out.println("The sum of the array is: " + sum); 
        return sum;
    }
}