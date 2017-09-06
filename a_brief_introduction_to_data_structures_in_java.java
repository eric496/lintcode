/*
Arrays
An array is a container object that holds a fixed number of values of a single type. After an array is created, its length is fixed and cannot be changed.
*/

// declare an array of various data types
int[] arrInt;
byte[] arrByte;
short[] arrShort;
long[] arrLong;
float[] arrFloat;
double[] arrDouble;
boolean[] arrBool;
char[] arrChar;
String[] arrString;

// instantiate an array of integers with the new operator
arrInt = new int[100];

// initialize an array
arrInt[0] = 1;        // initialize the first element
arrInt[1] = 2;        // initialize the second element

// declare, create and initialize an array all together
int[] arrInt = new int[5];
int[] arrInt = new int[]{1,2,3,4,5};
int[] arrInt = {1,2,3,4,5};

// access to a value by its index in the array
arrInt[0];        // get the first element
arrInt[1];        // get the second element

// methods in java.util.Arrays class

// sort arrInt in ascending order 
Arrays.sort(arrInt);
// sort arrInt by a index range: [0,5)
Arrays.sort(arrInt, 0, 5);

// find the index of 10 in arrInt using binary search algorithm
// notice the input array must be sorted in ascending order
// if the array contains multiple elements with the specified value, there is no guarantee which one will be found
// if the specified value is not found, return a negative number
Arrays.binarySearch(arrInt, 10);

// convert an array to string
// suppose arrInt is [1,2,3], the following line will convert arrInt to "[1, 2, 3]"
Arrays.toString(arrInt);

// copy the specified array and length
// truncate if given length is smaller than array length
// pad with 0s if given length is larger than array length
Arrays.copyOf(arrInt, 3); 
// copy subarray given start and end indices: [1,5)
Arrays.copyOfRange(arrInt, 1, 5);

// fill an array with specified value
Arrays.fill(arrInt, 10);
// fill subarray with specified value, provided the start and end indices: [1,5)
Arrays.fill(arrInt, 1, 5);

// convert an array to a list
// the list points to the original array
List<Integer> list = Arrays.asList(arrInt);
