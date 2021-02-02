package ohtu;

public class Player {

    private String name;
    private String nationality;
    private String team;
    private String assists;
    private String goals;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public void setAssists(String assists) {
        this.assists = assists;
    }

    public String getAssists() {
        return assists;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getGoals() {
        return goals;
    }

    @Override
    public String toString() {
        return name;
    }

}
