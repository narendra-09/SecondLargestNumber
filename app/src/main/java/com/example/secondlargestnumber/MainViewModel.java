package com.example.secondlargestnumber;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class MainViewModel extends ViewModel {
    private static ArrayList<AddNumber> addNumbers = new ArrayList<>();
    private static MutableLiveData<ArrayList<AddNumber>> mutableLiveData = new MutableLiveData<>();


    public void addTheNumber(long number) {
        addNumbers.add(new AddNumber(number));
        mutableLiveData.setValue(addNumbers);
    }

    public static MutableLiveData<ArrayList<AddNumber>> getMutableLiveData() {
        return mutableLiveData;
    }

   /* public void clearTheLast() {
        if (!addNumbers.isEmpty()) {
            int lastIndex = addNumbers.size();
            addNumbers.remove(lastIndex - 1);
            mutableLiveData.setValue(addNumbers);
        }
    } */

    public static long secondLargestNumber() {
        LinkedHashSet<Long> linkedHashSet = new LinkedHashSet<>();
        for (AddNumber an : addNumbers) {
            linkedHashSet.add(an.getNumber());
        }
        List<Long> list = new ArrayList<>(linkedHashSet);
        Collections.sort(list);
        if (list.size() == 1) {
            return 1234567890123L;
        } else if (list.size() == 0) {
            return 123123123123123L;
        }
        return list.get(list.size() - 2);
    }

    public void clearThePosition(int position) {
        addNumbers.remove(position);
        mutableLiveData.setValue(addNumbers);
    }
}
