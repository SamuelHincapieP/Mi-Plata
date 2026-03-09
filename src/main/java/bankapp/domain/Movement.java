package bankapp.domain;

import java.util.Date;
import java.util.List;

public class Movement {

    int movement;
    double monteMovement;
    Date dateMovement;
    String descriptionMovement;

    //constructores
    public Movement(int movement, double monteMovement, Date dateMovement, String descriptionMovement) {
        this.movement = movement;
        this.monteMovement = monteMovement;
        this.dateMovement = dateMovement;
        this.descriptionMovement = descriptionMovement;
    }

    // get y set
    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public double getMonteMovement() {
        return monteMovement;
    }

    public void setMonteMovement(double monteMovement) {
        this.monteMovement = monteMovement;
    }

    public Date getDateMovement() {
        return dateMovement;
    }

    public void setDateMovement(Date dateMovement) {
        this.dateMovement = dateMovement;
    }

    public String getDescriptionMovement() {
        return descriptionMovement;
    }

    public void setDescriptionMovement(String descriptionMovement) {
        this.descriptionMovement = descriptionMovement;
    }

    //metodos

    public <T> void createMovement(T movement){

    }

    public Movement createMovement(Movement movement){
        return movement;
    }

    public Movement updateMovement(Movement movement){
        return movement;
    }

    public List<Movement> getAllMovements(){
        return null;
    }

    public Movement getMovementById(int id, Movement movement){
        return null;
    }

    public void deleteMovement(int id){

    }
}
