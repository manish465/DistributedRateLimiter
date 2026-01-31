package com.manish.user.util;

import java.util.List;

public class NameUtils {
    public static Name getSeparatedNames(String name) {
        List<String> nameList = List.of(name.split(" "));

        if(nameList.size() == 1) return new Name(nameList.get(0), "");
        else if(nameList.size() == 2) return new Name(nameList.get(0), nameList.get(1));
        else {
            StringBuilder firstName = new StringBuilder();

            for(int i=0; i < nameList.size() - 1; i++) {
                firstName.append(nameList.get(i));
            }

            return new Name(
                    firstName.toString(),
                    nameList.get(nameList.size() - 1)
            );
        }
    }
}
