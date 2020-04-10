public class NewSorting {
    public void newSorting(int[] A, int size) {
        if(A.length <= size) {
            quickSort(A, 0, A.length - 1);
            //The if statement below does error checking and has the method perform mergeSort if size is less than 1
        } else if (A.length > 1 ){
            int l = (A.length) / 2;
            int[] LS = new int[l];
            int [] RS = new int[A.length - l];
            //Populates LS and RS without a loop
            System.arraycopy(A, 0, LS, 0, l);
            System.arraycopy(A, l, RS, 0, A.length - l);
            newSorting(LS, size);
            newSorting(RS, size);
            int[] copy = mergeHalves(RS, LS);
            System.arraycopy(copy, 0, A, 0, A.length);
        }
    }

    public int[] mergeHalves(int [] RS, int[] LS) {
        int l = 0;
        int r = 0;
        int[] copy = new int[LS.length + RS.length];
        int i = 0;
        boolean done = false;

        while(!done) {
            //Out of the two halves get the smallest and put it in first
            if(LS[l] < RS[r]) {
                copy[i] = LS[l];
                i++;
                l++;
            } else {
                copy[i] = RS[r];
                i++;
                r++;
            }
            //If we are done with the left half and still have elements in the right half then copy the rest of
            //the right half's elements
            if(l == LS.length && r < RS.length) {
                System.arraycopy(RS, r, copy, i, RS.length - r);
                done = true;
            } else if(l < LS.length && r == RS.length) {//Same as above but just flipped around
                System.arraycopy(LS, l, copy, i,LS.length - l);
                done = true;
            }
        }
        return copy;
    }

    public void quickSort(int[] A, int start, int end) {
        if(start >= end) {//base case
            return;
        }
        int pivot = partition(A, start, end); //finds the index of the pivot point to split up the array
        quickSort(A,start, pivot);
        quickSort(A, pivot + 1, end);
    }

    public int partition(int[] A, int start, int h) {
        int pivot = A[start];
        int l = start + 1;
        boolean done = false;
        int temp;

        while(!done) {
            while(l < A.length && pivot > A[l]) {
                l++;
            }
            /*I had to add the <= in the case where you have a duplicate that makes up the array. In this case h
            still needs to move down but can't be equal to start.
             */
            while(h > start && pivot <= A[h]) {
                h--;
            }
            if(l >= h) {//You are done so swap the pivot with the element at index h
                temp = A[h];
                A[h] = pivot;
                A[start] = temp;
                done = true;
            } else {//you are not done and are partitioning the array
                temp = A[l];
                A[l] = A[h];
                A[h] = temp;
                l++;
                h--;
            }
        }
        return h; //return the index so that you can cut the array
    }
}

