public class BinaryHeap
{
	// Data Members
	private int array[];
	private int arraySize;
	private int maxArraySize = 10;

	// Default Constructor
	public BinaryHeap()
	{
		this.maxArraySize = maxArraySize;
		this.arraySize = 0;
		this.array = new int[maxArraySize];
	}

	// Method to add a value to the binary heap.
	public void add(int value)
	{
		// Data Members For This Method
		int index;
		int parent;

		// Conditional to verify if the array is full.
		if (arraySize == array.length)
		{
			// Increases size of the array.
			growArray();
		}

		// Sets the value to the last position in the array and increments size.
		array[arraySize] = value;
		++arraySize;
		
		index = arraySize - 1;
		parent = (index - 1)/2;
			
		// Loops through until new value is in proper position in binary heap.
		while (array[index] < array[parent] && index > 0)
		{
			// Swaps values to pull value up in tree.
			swap(index, parent);
			index = parent;
			parent = (index - 1)/2;
		}
	}

	// Method to remove the minimum value from the binary heap.
	public int remove()
	{
		// Data Members  For This Method.
		int value = array[0];

		// Conditional to check if the array only has one item.
		if (arraySize == 1)
		{
			array[0] = array[arraySize - 1];
			--arraySize;
			shiftDown(0);
		}

		// Otherwise returns value.
		return value;
	}

	// Method to shift elements after the removal of a value.
	private void shiftDown(int parent)
	{
		// Data Members For This Method
		int minChild;
		int leftChild = parent * 2;
		boolean isLeaf = false;

		// Loops through until we find the leaf.
        while (isLeaf != true) 
        {
        	// Sets the minimum value to the left child of parent.
            minChild = leftChild;

            // Conditional to check if the value is a leaf.
            if (array[parent] <= array[minChild])
            {
            	// Breaks the loop.
            	isLeaf = true;
            }

			// Conditional to check if the value is greater than the next value.
            if ((minChild < arraySize) && (array[minChild] > array[minChild + 1]))
            {
            	// Increments minChild to next value.
                minChild += 1;
            }

            // Performs a swap of the parent value and currently set minChild.
            swap(parent, minChild);

            // Sets parent to minChild.
            parent = minChild;
        }
	}

	// Method to swap child and parent values
	private void swap(int child, int parent)
	{
		int temp = array[child];
        array[child] = array[parent];
        array[parent] = temp;
	}

	// A method to grow our array by doubling its size.
	public void growArray()
	{
		// Creates a new object to store our doubled array.
		int[] newArray = new int[array.length * 2];

		// Iterates over current array, adding items to the new doubled array.
		for (int i = 0; i < array.length; i++)
		{
			array[i] = newArray[i];
			i++;
		}

		// Returns the new array.
		array = newArray;
	}
}