package by.mt.onliner.utils;

import java.util.ArrayList;

public class ComparisionHelper {
    public static boolean compare(ArrayList<String> arrayExpected,ArrayList<String> arrayActual){
        if (arrayExpected.size()!=arrayActual.size()){
            return false;
        }
        for (int i=0;i<arrayExpected.size();i++){
            if (!arrayActual.get(i).contains(arrayExpected.get(i))){
                return false;
            }
        }
        return true;
    }
}