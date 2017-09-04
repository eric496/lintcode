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
arrInt[0] = 1; // initialize the first element
arrInt[1] = 2; // initialize the second element

// declare, create and initialize an array all together
int[] arrInt = new int[5]; // OR
int[] arrInt = new int[]{1,2,3,4,5}; // OR
int[] arrInt = {1,2,3,4,5};

// access to a value by its index in the array
arrInt[0]; // get the first element
arrInt[1]; // get the second element

// methods in java.util.Arrays class
Arrays.binarySearch(arrInt, 10); // binary search arrInt for target value = 10

