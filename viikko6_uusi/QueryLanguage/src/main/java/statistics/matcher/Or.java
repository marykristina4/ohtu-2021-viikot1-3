/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.lang.reflect.Method;
import statistics.Player;

/**
 *
 * @author marye
 */
public class Or implements Matcher {


    private Matcher[] matchers;

    public Or(Matcher... matchers) {
        this.matchers = matchers;
    }

    @Override
    public boolean matches(Player p) {
        int i = 0;
        for (Matcher matcher : matchers) {
            if (!matcher.matches(p)) {
                i=i+1;
                
            }
        }
        if (i==matchers.length-1){
            return true;
        }
        if (i==matchers.length-2){
            return true;
        }

        return false;
    }
}
