
package ohtu;

public class Player implements Comparable<Player>{
    private String name;
    private String team;
    private String nationality;
    private int goals;
    private int assists;
    

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public String getTeam() {
        return team;
    }

    public String getNationality() {
        return nationality;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }

    public int getPoints() {
        return assists+goals;
    }
    
    @Override
    public int compareTo(Player t) {
        if(getPoints() > t.getPoints()){
            return -1;
        }
        return 1;
    }
    
    

    @Override
    public String toString() {
        if(name.length() > 15){
            return name + "\t" + team + "\t" + assists + " + " + goals + " = " + getPoints();
        }
        return name + "\t\t" + team + "\t" + assists + " + " + goals + " = " + getPoints();
    }
      
}
