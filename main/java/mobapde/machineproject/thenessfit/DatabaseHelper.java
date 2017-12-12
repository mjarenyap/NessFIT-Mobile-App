package mobapde.machineproject.thenessfit;

import android.app.backup.RestoreObserver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String SCHEMA = "nessfit";
    public static final int VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, SCHEMA, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        String createUserTableSQL = "CREATE TABLE " + User.TABLE_NAME + " ("
                + User.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + User.COLUMN_FULLNAME + " TEXT, "
                + User.COLUMN_AGE + " INTEGER, "
                + User.COLUMN_GENDER + " TEXT, "
                + User.COLUMN_HEIGHT + " INTEGER, "
                + User.COLUMN_WEIGHT + " INTEGER, "
                + User.COLUMN_BMI + " INTEGER, "
                + User.COLUMN_TRAINING_LEVEL + " INTEGER, "
                + User.COLUMN_URI + "TEXT "
                + ");";

        String createExerciseTableSQL = "CREATE TABLE " + Exercise.TABLE_NAME + "("
                + Exercise.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Exercise.COLUMN_NAME + " TEXT, "
                + Exercise.COLUMN_DESCRIPTION + " TEXT, "
                + Exercise.COLUMN_CATEGORY + " INTEGER, "
                + Exercise.COLUMN_DIFFICULTY + " INTEGER, "
                + Exercise.COLUMN_CALORIE_BURN + " INTEGER, "
                + Exercise.COLUMN_URI + " TEXT"
                + ");";

        String createRoutineTableSQL = "CREATE TABLE " + Routine.TABLE_NAME + "("
                + Routine.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Routine.COLUMN_EXERCISE_ID + " INTEGER, "
                + Routine.COLUMN_DAY + " TEXT"
                + ");";

        String createWeightLogTableSQL = "CREATE TABLE " + WeightLog.TABLE_NAME + "("
                + WeightLog.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + WeightLog.COLUMN_WEIGHT + " INTEGER, "
                + WeightLog.COLUMN_DAY + " INTEGER, "
                + WeightLog.COLUMN_MONTH + " INTEGER, "
                + WeightLog.COLUMN_YEAR + " INTEGER"
                + ");";

        db.execSQL(createUserTableSQL);
        db.execSQL(createExerciseTableSQL);
        db.execSQL(createRoutineTableSQL);
        db.execSQL(createWeightLogTableSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        //drop tables
        String dropUserTableSQL = "DROP TABLE IF EXISTS " + User.TABLE_NAME + ";";
        String dropExerciseTableSQL = "DROP TABLE IF EXISTS " + Exercise.TABLE_NAME + ";";
        String dropRoutineTableSQL = "DROP TABLE IF EXISTS " + Routine.TABLE_NAME + ";";
        String dropWeightLogTableSQL = "DROP TABLE IF EXISTS " + WeightLog.TABLE_NAME + ";";

        db.execSQL(dropUserTableSQL);
        db.execSQL(dropExerciseTableSQL);
        db.execSQL(dropRoutineTableSQL);
        db.execSQL(dropWeightLogTableSQL);

        //call onCreate()
        onCreate(db);
    }




    ////////User CRUD OPERATIONS////////
    public boolean addUser(User u){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(User.COLUMN_FULLNAME, u.getFullname());
        contentValues.put(User.COLUMN_AGE, u.getAge());
        contentValues.put(User.COLUMN_GENDER, u.getGender());
        contentValues.put(User.COLUMN_HEIGHT, u.getHeight());
        contentValues.put(User.COLUMN_WEIGHT, u.getWeight());
        contentValues.put(User.COLUMN_BMI, u.getBmi());
        contentValues.put(User.COLUMN_TRAINING_LEVEL, u.getTraining_level());
        contentValues.put(User.COLUMN_URI, u.getUri());

        long id = db.insert(User.TABLE_NAME, null, contentValues);
        return (id != -1);
    }

    public User retrieveUser(long currID){
        //initialize the fetchers
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(User.TABLE_NAME, null, User.COLUMN_ID + " =? ", new String[]{currID+""}, null, null, null);

        User u = null;
        if(c.moveToFirst()){
            u = new User();
            String fullname = c.getString(c.getColumnIndex(User.COLUMN_FULLNAME));
            int age = c.getInt(c.getColumnIndex(User.COLUMN_AGE));
            String gender = c.getString(c.getColumnIndex(User.COLUMN_GENDER));
            float height = c.getFloat(c.getColumnIndex(User.COLUMN_HEIGHT));
            float weight = c.getFloat(c.getColumnIndex(User.COLUMN_WEIGHT));
            float bmi = c.getFloat(c.getColumnIndex(User.COLUMN_BMI));
            int training_level = c.getInt(c.getColumnIndex(User.COLUMN_TRAINING_LEVEL));
            String uri = c.getString(c.getColumnIndex(User.COLUMN_URI));

            u.setId(currID);
            u.setFullname(fullname);
            u.setAge(age);
            u.setGender(gender);
            u.setHeight(height);
            u.setWeight(weight);
            u.setBmi(bmi);
            u.setTraining_level(training_level);
            u.setUri(uri);
        }

        c.close();
        db.close();
        return u;
    }

    public ArrayList<User> retrieveAllUsers(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(User.TABLE_NAME, null, null, null, null, null, null);

        ArrayList<User> users = null;
        if(c.moveToFirst()){
            users = new ArrayList<>();
            do{
                User u = new User();

                long id = c.getLong(c.getColumnIndex(User.COLUMN_ID));
                String fullname = c.getString(c.getColumnIndex(User.COLUMN_FULLNAME));
                int age = c.getInt(c.getColumnIndex(User.COLUMN_AGE));
                String gender = c.getString(c.getColumnIndex(User.COLUMN_GENDER));
                float height = c.getFloat(c.getColumnIndex(User.COLUMN_HEIGHT));
                float weight = c.getFloat(c.getColumnIndex(User.COLUMN_WEIGHT));
                float bmi = c.getFloat(c.getColumnIndex(User.COLUMN_BMI));
                int training_level = c.getInt(c.getColumnIndex(User.COLUMN_TRAINING_LEVEL));
                String uri = c.getString(c.getColumnIndex(User.COLUMN_URI));

                u.setId(id);
                u.setFullname(fullname);
                u.setAge(age);
                u.setGender(gender);
                u.setHeight(height);
                u.setWeight(weight);
                u.setBmi(bmi);
                u.setTraining_level(training_level);
                u.setUri(uri);

                users.add(u);

            }while(c.moveToNext());
        }

        db.close();
        c.close();
        return users;
    }

    public Cursor retrieveAllUsersCursor(){
        SQLiteDatabase db = getReadableDatabase();
        return db.query(User.TABLE_NAME, null,null,null,null,null,null);
    }

    public boolean updateUser(long currID, User u){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(User.COLUMN_FULLNAME, u.getFullname());
        contentValues.put(User.COLUMN_AGE, u.getAge());
        contentValues.put(User.COLUMN_GENDER, u.getGender());
        contentValues.put(User.COLUMN_HEIGHT, u.getHeight());
        contentValues.put(User.COLUMN_WEIGHT, u.getWeight());
        contentValues.put(User.COLUMN_BMI, u.getBmi());
        contentValues.put(User.COLUMN_TRAINING_LEVEL, u.getTraining_level());
        contentValues.put(User.COLUMN_URI, u.getUri());

        int rows = db.update(User.TABLE_NAME, contentValues, User.COLUMN_ID + "=?", new String[]{currID + ""});
        db.close();
        return rows > 0;
    }

    public boolean deleteUser(long currID){
        SQLiteDatabase db = getWritableDatabase();
        int rows = db.delete(User.TABLE_NAME, User.COLUMN_ID + "=?", new String[]{currID + ""});
        db.close();
        return rows > 0;
    }





    ////////Exercise CRUD OPERATIONS////////
    public boolean addExercise(Exercise e){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Exercise.COLUMN_NAME, e.getName());
        contentValues.put(Exercise.COLUMN_DESCRIPTION, e.getDescription());
        contentValues.put(Exercise.COLUMN_CATEGORY, e.getCategory());
        contentValues.put(Exercise.COLUMN_DIFFICULTY, e.getDifficulty());
        contentValues.put(Exercise.COLUMN_CALORIE_BURN, e.getCalorie_burn());
        contentValues.put(Exercise.COLUMN_URI, e.getUri());

        long id = db.insert(Exercise.TABLE_NAME, null, contentValues);
        return (id != -1);
    }

    public Exercise retrieveExercise(long currID){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(Exercise.TABLE_NAME, null, Exercise.COLUMN_ID + " =? ", new String[]{currID+""}, null, null, null);

        Exercise e = null;
        if(c.moveToFirst()){
            e = new Exercise();

            String name = c.getString(c.getColumnIndex(Exercise.COLUMN_NAME));
            String description = c.getString(c.getColumnIndex(Exercise.COLUMN_DESCRIPTION));
            int category = c.getInt(c.getColumnIndex(Exercise.COLUMN_CATEGORY));
            int difficulty = c.getInt(c.getColumnIndex(Exercise.COLUMN_DIFFICULTY));
            int calorie_burn = c.getInt(c.getColumnIndex(Exercise.COLUMN_CALORIE_BURN));
            String uri = c.getString(c.getColumnIndex(Exercise.COLUMN_URI));

            e.setId(currID);
            e.setName(name);
            e.setDescription(description);
            e.setCategory(category);
            e.setDifficulty(difficulty);
            e.setCalorie_burn(calorie_burn);
            e.setUri(uri);
        }

        c.close();
        db.close();
        return e;
    }

    public ArrayList<Exercise> retrieveAllExercises(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(Exercise.TABLE_NAME, null, null, null, null, null, null);

        ArrayList<Exercise> exercises = null;
        if(c.moveToFirst()){
            exercises = new ArrayList<>();
            do{
                Exercise e = new Exercise();

                long id = c.getLong(c.getColumnIndex(Exercise.COLUMN_ID));
                String name = c.getString(c.getColumnIndex(Exercise.COLUMN_NAME));
                String description = c.getString(c.getColumnIndex(Exercise.COLUMN_DESCRIPTION));
                int category = c.getInt(c.getColumnIndex(Exercise.COLUMN_CATEGORY));
                int difficulty = c.getInt(c.getColumnIndex(Exercise.COLUMN_DIFFICULTY));
                int calorie_burn = c.getInt(c.getColumnIndex(Exercise.COLUMN_CALORIE_BURN));
                String uri = c.getString(c.getColumnIndex(Exercise.COLUMN_URI));

                e.setId(id);
                e.setName(name);
                e.setDescription(description);
                e.setCategory(category);
                e.setDifficulty(difficulty);
                e.setCalorie_burn(calorie_burn);
                e.setUri(uri);

                exercises.add(e);

            }while(c.moveToNext());
        }

        db.close();
        c.close();
        return exercises;
    }

    public Cursor retrieveAllExercisesCursor(){
        SQLiteDatabase db = getReadableDatabase();
        return db.query(Exercise.TABLE_NAME, null,null,null,null,null,null);
    }

    public boolean updateExercise(long currID, Exercise e){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Exercise.COLUMN_NAME, e.getName());
        contentValues.put(Exercise.COLUMN_DESCRIPTION, e.getDescription());
        contentValues.put(Exercise.COLUMN_CATEGORY, e.getCategory());
        contentValues.put(Exercise.COLUMN_DIFFICULTY, e.getDifficulty());
        contentValues.put(Exercise.COLUMN_CALORIE_BURN, e.getCalorie_burn());
        contentValues.put(Exercise.COLUMN_URI, e.getUri());

        int rows = db.update(Exercise.TABLE_NAME, contentValues, Exercise.COLUMN_ID + "=?", new String[]{currID + ""});
        db.close();
        return rows > 0;
    }

    public boolean deleteExercise(long currID){
        SQLiteDatabase db = getWritableDatabase();
        int rows = db.delete(Exercise.TABLE_NAME, Exercise.COLUMN_ID + "=?", new String[]{currID + ""});
        db.close();
        return rows > 0;
    }





    ////////Routine CRUD OPERATIONS////////
    public boolean addRoutine(Routine r){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Routine.COLUMN_DAY, r.getDay());
        contentValues.put(Routine.COLUMN_EXERCISE_ID, r.getExercise_id());

        long id = db.insert(Routine.TABLE_NAME, null, contentValues);
        return (id != -1);
    }

    public Routine retrieveRoutine(long currID){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(Routine.TABLE_NAME, null, Routine.COLUMN_ID + " =? ", new String[]{currID+""}, null, null, null);

        Routine r = null;
        if(c.moveToFirst()){
            r = new Routine();

            int day = c.getInt(c.getColumnIndex(Routine.COLUMN_DAY));
            long exercise_id = c.getLong(c.getColumnIndex(Routine.COLUMN_EXERCISE_ID));

            r.setId(currID);
            r.setDay(day);
            r.setExercise_id(exercise_id);
        }

        c.close();
        db.close();
        return r;
    }

    public ArrayList<Routine> retrieveAllRoutines(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(Routine.TABLE_NAME, null, null, null, null, null, null);

        ArrayList<Routine> routines = null;
        if(c.moveToFirst()){
            routines = new ArrayList<>();
            do{
                Routine r = new Routine();

                long id = c.getLong(c.getColumnIndex(Routine.COLUMN_ID));
                int day = c.getInt(c.getColumnIndex(Routine.COLUMN_DAY));
                long exercise_id = c.getLong(c.getColumnIndex(Routine.COLUMN_EXERCISE_ID));

                r.setId(id);
                r.setDay(day);
                r.setExercise_id(exercise_id);

                routines.add(r);

            }while(c.moveToNext());
        }

        db.close();
        c.close();
        return routines;
    }

    public Cursor retrieveAllRoutinesCursor(){
        SQLiteDatabase db = getReadableDatabase();
        return db.query(Routine.TABLE_NAME, null,null,null,null,null,null);
    }

    public boolean updateRoutine(long currID, Routine r){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Routine.COLUMN_DAY, r.getDay());
        contentValues.put(Routine.COLUMN_EXERCISE_ID, r.getExercise_id());

        int rows = db.update(Routine.TABLE_NAME, contentValues, Routine.COLUMN_ID + "=?", new String[]{currID + ""});
        db.close();
        return rows > 0;
    }

    public boolean deleteRoutine(long currID){
        SQLiteDatabase db = getWritableDatabase();
        int rows = db.delete(Routine.TABLE_NAME, Routine.COLUMN_ID + "=?", new String[]{currID + ""});
        db.close();
        return rows > 0;
    }





    ////////WeightLog CRUD OPERATIONS////////
    public boolean addWeightLog(WeightLog w){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(WeightLog.COLUMN_WEIGHT, w.getWeight());
        contentValues.put(WeightLog.COLUMN_DAY, w.getDay());
        contentValues.put(WeightLog.COLUMN_MONTH, w.getMonth());
        contentValues.put(WeightLog.COLUMN_YEAR, w.getYear());

        long id = db.insert(WeightLog.TABLE_NAME, null, contentValues);
        return (id != -1);
    }

    public WeightLog retrieveWeightLog(long currID){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(WeightLog.TABLE_NAME, null, WeightLog.COLUMN_ID + " =? ", new String[]{currID+""}, null, null, null);

        WeightLog w = null;
        if(c.moveToFirst()){
            w = new WeightLog();

            float weight = c.getFloat(c.getColumnIndex(WeightLog.COLUMN_WEIGHT));
            int day = c.getInt(c.getColumnIndex(WeightLog.COLUMN_DAY));
            int month = c.getInt(c.getColumnIndex(WeightLog.COLUMN_MONTH));
            int year = c.getInt(c.getColumnIndex(WeightLog.COLUMN_YEAR));

            w.setId(currID);
            w.setWeight(weight);
            w.setDay(day);
            w.setMonth(month);
            w.setYear(year);
        }

        c.close();
        db.close();
        return w;
    }

    public ArrayList<WeightLog> retrieveAllWeightLogs(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(WeightLog.TABLE_NAME, null, null, null, null, null, null);

        ArrayList<WeightLog> weightLogs = null;
        if(c.moveToFirst()){
            weightLogs = new ArrayList<>();

            do{
                WeightLog w = new WeightLog();

                long id = c.getLong(c.getColumnIndex(WeightLog.COLUMN_ID));
                float weight = c.getFloat(c.getColumnIndex(WeightLog.COLUMN_WEIGHT));
                int day = c.getInt(c.getColumnIndex(WeightLog.COLUMN_DAY));
                int month = c.getInt(c.getColumnIndex(WeightLog.COLUMN_MONTH));
                int year = c.getInt(c.getColumnIndex(WeightLog.COLUMN_YEAR));

                w.setId(id);
                w.setWeight(weight);
                w.setDay(day);
                w.setMonth(month);
                w.setYear(year);

                weightLogs.add(w);

            }while(c.moveToNext());
        }

        db.close();
        c.close();
        return weightLogs;
    }

    public Cursor retrieveAllWeightLogsCursor(){

        SQLiteDatabase db = getReadableDatabase();
        return db.query(WeightLog.TABLE_NAME, null,null,null,null,null,null);
    }

    public boolean updateWeightLog(long currID, WeightLog w){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(WeightLog.COLUMN_WEIGHT, w.getWeight());
        contentValues.put(WeightLog.COLUMN_DAY, w.getDay());
        contentValues.put(WeightLog.COLUMN_MONTH, w.getMonth());
        contentValues.put(WeightLog.COLUMN_YEAR, w.getYear());

        int rows = db.update(WeightLog.TABLE_NAME, contentValues, WeightLog.COLUMN_ID + "=?", new String[]{currID + ""});
        db.close();
        return rows > 0;
    }

    public boolean deleteWeightLog(long currID){
        SQLiteDatabase db = getWritableDatabase();
        int rows = db.delete(WeightLog.TABLE_NAME, WeightLog.COLUMN_ID + "=?", new String[]{currID + ""});
        db.close();
        return rows > 0;
    }
}
