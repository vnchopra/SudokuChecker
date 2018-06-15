import java.util.*;

public class SudokuChecker {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
       
        int[][] arr =
            {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
            };
       
        //A Sudoku checker needs to check the following:
        //Row must have unique values from 1 - 9
        //Column must have unique values from 1 - 9
        //Regions of 3x3 must have unique values from 1 - 9
       
        SudokuChecker scheck = new SudokuChecker();
//        System.out.println("============== Checking Rows ================");
//        boolean rowCheck = scheck.checkAllRowForUniquesInInputArray(arr);
//        System.out.println("============== Checking Columns =============");
//        boolean columnCheck = scheck.checkAllColumnsForUniquesInInputArray(arr);
        System.out.println("============== Checking Sections =============");
        boolean sectionsCheck = scheck.checkSectionForArray(arr);
       
//        if(!rowCheck || !columnCheck || !sectionsCheck)
        if(!sectionsCheck)
        {
            System.out.println("============== Soduku Check FAILED =============");
        }
        else
        {
            System.out.println("============== Soduku Check PASSED =============");
        }
    }
   
    private boolean checkAllRowForUniquesInInputArray(int[][] input_array)
    {
        boolean hasAllUniques = false;
       
        //this gets rows
        for(int i=0; i<input_array.length; i++)
        {
            //this gets array for that row
            hasAllUniques = this.hasAllUniquesForArray(input_array[i]);
            if(!hasAllUniques)
            {
                //return false immediately
                return hasAllUniques;
            }
        }
       
        return hasAllUniques;
    }
   
    private boolean checkAllColumnsForUniquesInInputArray(int[][] input_array)
    {
        boolean hasAllUniques = false;
        int [] columnArray = new int [9];
       
        for(int column=0; column < 9; column++)
        {
            for(int row=0; row < 9; row++)
            {
                columnArray[row] = input_array[row][column];
            }
           
            hasAllUniques = this.hasAllUniquesForArray(columnArray);
            if(!hasAllUniques)
            {
                //return false immediately
                return hasAllUniques;
            }
        }

       
        return hasAllUniques;
    }
   
    private boolean checkSectionForArray(int[][] input_array)
    {
        boolean hasAllUniques = false;
        int tracked_row_start = 0;
        int tracked_column_start = 0;
        int sectionRowSize = 3;
        int sectionColumnSize = 3;
        int checkArrayIndex = 0;
       
        int[] arrayForCheck = new int [9];
       
        //only does one section
        for(int row=tracked_row_start; row < tracked_row_start+2; row++)
        {
            for(int column=tracked_column_start; column < tracked_column_start+2; column++)
            {
                System.out.println("Section Value tracked_row_start: " + row);
                System.out.println("Section Value tracked_column_start: " + column);

                arrayForCheck[checkArrayIndex] = input_array[row][column];
                System.out.println("Section Value to Array: " + arrayForCheck[checkArrayIndex]);
                checkArrayIndex++;
                tracked_column_start = tracked_column_start + 1;
               
                
            }

            //reset column
            tracked_column_start = 0;
            //go to next row
            tracked_row_start = row+1;
        }
       
        hasAllUniques = this.hasAllUniquesForArray(arrayForCheck);
        if(!hasAllUniques)
        {
            //return false immediately
            return hasAllUniques;
        }
       
        return hasAllUniques;
    }
   
    private boolean hasAllUniquesForArray(int[] input_array)
    {
        Set<Integer> numbersFound = new HashSet<Integer>();
       
        for(int i= 0; i <input_array.length; i++)
        {
            System.out.println("hasAllUniquesForArray checking: " + input_array[i]);
            if(numbersFound.contains(input_array[i]))
            {
                System.out.println("hasAllUniquesForArray conclusion FALSE");
                return false;
            }
           
            numbersFound.add(input_array[i]);
        }
       
        System.out.println("hasAllUniquesForArray conclusion TRUE");
        return true;
    }

}