package mobapde.machineproject.thenessfit;

public class Exercise {
    public static final String TABLE_NAME = "exercises";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_DIFFICULTY = "difficulty";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_CALORIE_BURN = "calorie_burn";
    public static final String COLUMN_URI = "uri";

    private long id;
    private String name;
    private String description;
    private int difficulty;
    private int category;
    private int calorie_burn;
    private String uri;

    public Exercise(){}

    public Exercise(long id, String name, String description, int difficulty, int category, int calorie_burn, String uri) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.category = category;
        this.calorie_burn = calorie_burn;
        this.uri = uri;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getCalorie_burn() {
        return calorie_burn;
    }

    public void setCalorie_burn(int calorie_burn) {
        this.calorie_burn = calorie_burn;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
