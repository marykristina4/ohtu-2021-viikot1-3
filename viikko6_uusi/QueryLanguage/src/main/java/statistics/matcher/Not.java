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
public class Not implements Matcher {

    private Matcher matcher;

    public Not(Matcher matcher) {
        this.matcher = matcher;

    }

    @Override
    public boolean matches(Player p) {
        try {
            if (this.matcher.matches(p)){
                return false;
            }

            return true;

        } catch (Exception ex) {
            System.out.println(ex);
            throw new IllegalStateException("Player does not have field ");
        }

    }

}
