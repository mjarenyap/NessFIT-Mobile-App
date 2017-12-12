package mobapde.machineproject.thenessfit;

public class Routine {
    public static final String TABLE_NAME = "routines";
    public static final String COLUMN_ID  = "_id";
    public static final String COLUMN_EXERCISE_ID = "exercise_id";
    public static final String COLUMN_DAY = "day";

    private long id;
    private long exercise_id;
    private int day;

    public Routine(){}

    public Routine(long id, long exercise_id, int day) {
        this.id = id;
        this.exercise_id = exercise_id;
        this.day = day;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(long exercise_id) {
        this.exercise_id = exercise_id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
