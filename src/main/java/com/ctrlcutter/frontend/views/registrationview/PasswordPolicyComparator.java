package com.ctrlcutter.frontend.views.registrationview;

import java.util.Comparator;
import java.util.HashMap;

public class PasswordPolicyComparator implements Comparator<PasswordPolicy> {

    private HashMap<PasswordPolicy, Integer> policyMap;

    public PasswordPolicyComparator() {
        this.policyMap = new HashMap<>();
        this.policyMap.put(PasswordPolicy.WEAK, 0);
        this.policyMap.put(PasswordPolicy.MODERATE, 1);
        this.policyMap.put(PasswordPolicy.STRONG, 2);
    }

    @Override
    public int compare(PasswordPolicy o1, PasswordPolicy o2) {

        int policyValue1 = this.policyMap.get(o1);
        int policyValue2 = this.policyMap.get(o2);

        int compareValue = policyValue1 - policyValue2;

        if (compareValue < 0) {
            compareValue = -1;
        }

        if (compareValue > 0) {
            compareValue = 1;
        }

        return compareValue;
    }
}
