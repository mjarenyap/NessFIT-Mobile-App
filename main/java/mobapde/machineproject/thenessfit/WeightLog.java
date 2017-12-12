package mobapde.machineproject.thenessfit;

public class WeightLog {
    public static final String TABLE_NAME = "weightlogs";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_MONTH = "month";
    public static final String COLUMN_DAY = "day";
    public static final String COLUMN_YEAR = "year";
    public static final String COLUMN_WEIGHT = "weight";

    private long id;
    private int month;
    private int day;
    private int year;
    private float weight;

    public WeightLog(){}

    public WeightLog(long id, int month, int day, int year, float weight) {
        this.id = id;
        this.month = month;
        this.day = day;
        this.year = year;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
