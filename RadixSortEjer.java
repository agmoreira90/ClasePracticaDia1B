package test;

import test.StringUtil;

import java.util.*;

public class RadixSortEjer {

    public static void radixSort(int[] arr) {

        String strArr[] = StringUtil.toStringArray(arr);
        int maxLength = StringUtil.maxLength(strArr);
        StringUtil.lNormalize(strArr, '0');
        for (int j = maxLength - 1; j >= 0; j--) {
            Map<String, ArrayList<String>> strMap = new HashMap<>();//hashmap
            for (int i = 0; i < strArr.length; i++) {
                boolean isAgregado = false;
                for (Map.Entry<String, ArrayList<String>> entry : strMap.entrySet()) {

                    if (entry.getKey().equals(String.valueOf(strArr[i].charAt(j)))){
                        isAgregado = true;
                        ArrayList<String> strArrAux = entry.getValue();
                        strArrAux.add(strArr[i]);
                        entry.setValue(strArrAux);
                    }
                }
                if (isAgregado == false) {
                    ArrayList<String> strArrAux = new ArrayList<>();
                    strArrAux.add(strArr[i]);
                    strMap.put(String.valueOf(strArr[i].charAt(j)), strArrAux);
                }

            }
            ArrayList<String> strArrAuxB = new ArrayList<String>();

            for (Map.Entry<String, ArrayList<String>> entry : strMap.entrySet()) {
                for (int k = 0; k < entry.getValue().size(); k++) {

                    strArrAuxB.add(entry.getValue().get(k));
                }
            }
//            System.out.println("============================");
            for (int k = 0; k < strArrAuxB.size(); k++) {
//                System.out.println(strArrAuxB.get(k));
                strArr[k] = strArrAuxB.get(k);
            }
//            System.out.println("============================");
        }
        for (
                int i = 0;
                i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

    }

    public static void main(String[] args) {
        int arr[] = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};
        radixSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? "," : ""));
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
}


