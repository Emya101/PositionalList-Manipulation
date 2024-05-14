
Positional List Manipulations
Overview
This project demonstrates various operations on a positional list data structure implemented in Java. The PartB_Driver class tests the methods defined in the ArrayPositionalList class by performing operations such as removing consecutive duplicates and sorting a list of characters using the insertion sort algorithm.

Features
Positional List Operations: Utilizes custom implementations of positional lists to manage elements.
Duplicate Removal: Removes consecutive duplicate elements from a positional list.
Insertion Sort: Sorts a list of characters using the insertion sort algorithm.
Classes and Interfaces
Main Classes
PartB_Driver: Contains the main method to test the positional list operations.
ArrayPositionalList<E>: Implements a list data structure that supports positional access methods.
Position<E>: Represents a position in the list, storing an element and its index.
Interfaces
List<E>: A simplified version of the java.util.List interface.
Position<E>: Represents a position in the list.
PositionalList<E>: Represents a list with positional access methods.
Methods
PartB_Driver Class
main(String[] args)
Initializes a positional list of strings and adds elements to it.
Tests the method to remove consecutive duplicates.
Initializes a positional list of characters and adds elements to it.
Tests the method to perform insertion sort on the list of characters.
removeConsecutiveDuplicates(ArrayPositionalList<String> list)
Removes consecutive duplicate elements from the given positional list.
Returns the number of entries in the list after removing consecutive duplicates.
insertionSort(ArrayPositionalList<Character> list)
Sorts the given positional list of characters using the insertion sort algorithm.

Copy the various codes
javac PartB_Driver.java ArrayPositionalList.java Position.java PositionalList.java
Run the PartB_Driver class:

Observe the output to see the results of the positional list manipulations.

Example output:

Original positional list:
[harry, ron, tom, tom, tom, hermione]

Number of entries after call: 4

List with duplicates removed:
[harry, ron, tom, hermione]

Sorted characters using Insertion sort algorithm:
[A, A, B, C, E, E, G, L, M, M, R, S]

Emhenya Supreme 3132969
Based on "Data Structures and Algorithms in Java, Sixth Edition" by Goodrich et al.






