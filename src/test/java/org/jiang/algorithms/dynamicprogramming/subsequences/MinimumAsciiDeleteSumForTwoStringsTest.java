package org.jiang.algorithms.dynamicprogramming.subsequences;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumAsciiDeleteSumForTwoStringsTest {

    String s1;
    String s2;
    int result;

    MinimumAsciiDeleteSumForTwoStrings madsts = new MinimumAsciiDeleteSumForTwoStrings();

    @Test
    public void minimumDeleteSum() {
        s1 = "sea";
        s2 = "eat";
        result = madsts.minimumDeleteSum(s1, s2);
        System.out.println(result);

        s1 = "delete";
        s2 = "leet";
        result = madsts.minimumDeleteSum(s1, s2);
        System.out.println(result);

        s1 = "igijekdtywibepwonjbwykkqmrgmtybwhwjiqudxmnniskqjfbkpcxukrablqmwjndlhblxflgehddrvwfacarwkcpmcfqnajqfxyqwiugztocqzuikamtvmbjrypfqvzqiwooewpzcpwhdejmuahqtukistxgfafrymoaodtluaexucnndlnpeszdfsvfofdylcicrrevjggasrgdhwdgjwcchyanodmzmuqeupnpnsmdkcfszznklqjhjqaboikughrnxxggbfyjriuvdsusvmhiaszicfa";
        s2 = "ikhuivqorirphlzqgcruwirpewbjgrjtugwpnkbrdfufjsmgzzjespzdcdjcoioaqybciofdzbdieegetnogoibbwfielwungehetanktjqjrddkrnsxvdmehaeyrpzxrxkhlepdgpwhgpnaatkzbxbnopecfkxoekcdntjyrmmvppcxcgquhomcsltiqzqzmkloomvfayxhawlyqxnsbyskjtzxiyrsaobbnjpgzmetpqvscyycutdkpjpzfokvi";

        result = madsts.minimumDeleteSum(s1, s2);
        System.out.println(result);


    }
}