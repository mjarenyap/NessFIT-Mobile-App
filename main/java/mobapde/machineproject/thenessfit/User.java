package mobapde.machineproject.thenessfit;

public class User {
    public static final String TABLE_NAME = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_FULLNAME = "fullname";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_WEIGHT = "weight";
    public static final String COLUMN_HEIGHT = "height";
    public static final String COLUMN_BMI = "bmi";
    public static final String COLUMN_TRAINING_LEVEL = "training_level";
    public static final String COLUMN_URI = "uri";

    private long id;
    private String fullname;
    private int age;
    private String gender;
    private float weight;
    private float height;
    private float bmi;
    private int training_level;
    private String uri;

    public User() {}

    public User(long id, String fullname, int age, String gender, float weight, float height, float bmi, int training_level, String uri) {
        this.id = id;
        this.fullname = fullname;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
        this.training_level = training_level;
        this.uri = uri;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getBmi() {
        return bmi;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }

    public int getTraining_level() {
        return training_level;
    }

    public void setTraining_level(int training_level) {
        this.training_level = training_level;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
