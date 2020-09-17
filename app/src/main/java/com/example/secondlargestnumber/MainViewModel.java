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

    public void addTheNumber(int number) {
        addNumbers.add(new AddNumber(number));
        mutableLiveData.setValue(addNumbers);
    }

    public static MutableLiveData<ArrayList<AddNumber>> getMutableLiveData() {
        return mutableLiveData;
    }

    public void clearTheLast() {
        if (!addNumbers.isEmpty()) {
            int lastIndex = addNumbers.size();
            addNumbers.remove(lastIndex - 1);
            mutableLiveData.setValue(addNumbers);
        }
    }

    public static int secondLargestNumber() {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        for (AddNumber an : addNumbers) {
            linkedHashSet.add(an.getNumber());
        }
        List<Integer> list = new ArrayList<>(linkedHashSet);
        Collections.sort(list);
        if (list.size() == 1) {
            return list.get(0);
        } else if (list.size() == 0) {
            return -202;
        }
        return list.get(list.size() - 2);
    }

}
