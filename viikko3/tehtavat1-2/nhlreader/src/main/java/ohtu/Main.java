package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        System.out.println("json-muotoinen data:");
        System.out.println(bodyText);

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);

        System.out.println("Oliot:");

        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                System.out.println(player.getName() + " team " + player.getTeam() + " goals " + player.getGoals() + " assists " + player.getAssists());
            }
        }
        Map<Player, Integer> taulukko = new HashMap<>();
        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                taulukko.put(player, Integer.valueOf(player.getAssists()) + Integer.valueOf(player.getGoals()));
            }
        }
        LinkedHashMap<Player, Integer> sortedMap = new LinkedHashMap<>();

        taulukko.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        System.out.println(sortedMap);

        for (Player player : sortedMap.keySet()) {
            if (player.getNationality().equals("FIN")) {
                System.out.println(player.getName() + " team " + player.getTeam() + " goals " + player.getGoals() + " + assists " + player.getAssists());

            }

        }
    }
}
