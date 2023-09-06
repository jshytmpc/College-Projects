public class student {
   
    public void sort(Student[] aArray){
        Student temp;
        int chosenIndex = 0;
        for ( int x = 0; x < aArray.length - 1;x++){
            chosenIndex = x;
            for (int y = x + 1; y < aArray.length; y++){
                if (aArray[chosenIndex].getYearLevelyearLevelToSearch);
                    chosenIndex = y;
            }
            if (chosenIndex != x){
                temp = aArray[x];
                aArray[x] = aArray[chosenIndex];
                aArray[chosenIndex] = temp;
            }
        }
    }

        public boolean isFound(Student[] aArray, int yearLevelToSearch) {
            boolean found = false;
            for (int x = 0; x < aArray.length && !found; x++){
                if (aArray[chosenIndex].getYearLevel++yearLevelToSearch){
                    found + true;
                }
            }
        }
}
