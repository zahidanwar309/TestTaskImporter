/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowdlab.taskimporter.activities.test;

import android.app.Activity;
import android.database.Cursor;
import android.test.ActivityInstrumentationTestCase2;
import com.crowdlab.taskimporter.activities.TaskListActivity;
import com.crowdlab.taskimporter.db.DatabaseHelper;
import com.crowdlab.taskimporter.db.TaskListDatabaseHelper;
import com.crowdlab.taskimporter.utils.Logger;
import org.json.JSONArray;
import org.junit.Test;

/**
 *
 * @author anwar
 */
public class TestTaskListActivity extends ActivityInstrumentationTestCase2<TaskListActivity> {

    private Activity activity;
    private TaskListDatabaseHelper dbHelper;
    private static final String json_text = "[\n"
            + "    {\n"
            + "        \"id\": 1,\n"
            + "        \"title\": \"This is a task\",\n"
            + "        \"questions\": [\n"
            + "            {\n"
            + "                \"id\": 1,\n"
            + "                \"title\": \"question title here\",\n"
            + "                \"summary\": \"question summary here\",\n"
            + "                \"options\": [\n"
            + "                    {\n"
            + "                        \"id\": 1,\n"
            + "                        \"type\": \"text\",\n"
            + "                        \"label\": \"option label here\"\n"
            + "                    }\n"
            + "                ]\n"
            + "            },\n"
            + "                  {\n"
            + "                \"id\": 2,\n"
            + "                \"title\": \"question title here\",\n"
            + "                \"summary\": \"question summary here\",\n"
            + "                \"options\": [\n"
            + "                    {\n"
            + "                        \"id\": 2,\n"
            + "                        \"type\": \"text\",\n"
            + "                        \"label\": \"option label here\"\n"
            + "                    }\n"
            + "                ]\n"
            + "            }\n"
            + "        ],\n"
            + "        \"hidden\": false\n"
            + "    },\n"
            + "        {\n"
            + "        \"id\": 2,\n"
            + "        \"title\": \"This is a task\",\n"
            + "        \"questions\": [\n"
            + "            {\n"
            + "                \"id\": 3,\n"
            + "                \"title\": \"question title here\",\n"
            + "                \"summary\": \"question summary here\",\n"
            + "                \"options\": [\n"
            + "                    {\n"
            + "                        \"id\": 3,\n"
            + "                        \"type\": \"text\",\n"
            + "                        \"label\": \"option label here\"\n"
            + "                    }\n"
            + "                ]\n"
            + "            }\n"
            + "        ],\n"
            + "        \"hidden\": false\n"
            + "    },\n"
            + "        {\n"
            + "        \"id\": 3,\n"
            + "        \"title\": \"This is a task\",\n"
            + "        \"questions\": [\n"
            + "            {\n"
            + "                \"id\": 4,\n"
            + "                \"title\": \"question title here\",\n"
            + "                \"summary\": \"question summary here\",\n"
            + "                \"options\": [\n"
            + "                    {\n"
            + "                        \"id\": 4,\n"
            + "                        \"type\": \"text\",\n"
            + "                        \"label\": \"option label here\"\n"
            + "                    }\n"
            + "                ]\n"
            + "            }\n"
            + "        ],\n"
            + "        \"hidden\": false\n"
            + "    },\n"
            + "        {\n"
            + "        \"id\": 4,\n"
            + "        \"title\": \"This is a task\",\n"
            + "        \"questions\": [\n"
            + "            {\n"
            + "                \"id\": 5,\n"
            + "                \"title\": \"question title here\",\n"
            + "                \"summary\": \"question summary here\",\n"
            + "                \"options\": [\n"
            + "                    {\n"
            + "                        \"id\": 5,\n"
            + "                        \"type\": \"text\",\n"
            + "                        \"label\": \"option label here\"\n"
            + "                    }\n"
            + "                ]\n"
            + "            },\n"
            + "                 {\n"
            + "                \"id\": 6,\n"
            + "                \"title\": \"question title here\",\n"
            + "                \"summary\": \"question summary here\",\n"
            + "                \"options\": [\n"
            + "                    {\n"
            + "                        \"id\": 6,\n"
            + "                        \"type\": \"text\",\n"
            + "                        \"label\": \"option label here\"\n"
            + "                    }\n"
            + "                ]\n"
            + "            },\n"
            + "                 {\n"
            + "                \"id\": 7,\n"
            + "                \"title\": \"question title here\",\n"
            + "                \"summary\": \"question summary here\",\n"
            + "                \"options\": [\n"
            + "                    {\n"
            + "                        \"id\": 7,\n"
            + "                        \"type\": \"text\",\n"
            + "                        \"label\": \"option label here\"\n"
            + "                    }\n"
            + "                ]\n"
            + "            }\n"
            + "        ],\n"
            + "        \"hidden\": false\n"
            + "    },\n"
            + "     {\n"
            + "        \"id\": 5,\n"
            + "        \"title\": \"This is a task\",\n"
            + "        \"questions\": [\n"
            + "            {\n"
            + "                \"id\": 8,\n"
            + "                \"title\": \"question title here\",\n"
            + "                \"summary\": \"question summary here\",\n"
            + "                \"options\": [\n"
            + "                    {\n"
            + "                        \"id\": 8,\n"
            + "                        \"type\": \"text\",\n"
            + "                        \"label\": \"option label here\"\n"
            + "                    }\n"
            + "                ]\n"
            + "            },\n"
            + "                 {\n"
            + "                \"id\": 9,\n"
            + "                \"title\": \"question title here\",\n"
            + "                \"summary\": \"question summary here\",\n"
            + "                \"options\": [\n"
            + "                    {\n"
            + "                        \"id\": 9,\n"
            + "                        \"type\": \"text\",\n"
            + "                        \"label\": \"option label here\"\n"
            + "                    }\n"
            + "                ]\n"
            + "            },\n"
            + "                 {\n"
            + "                \"id\": 10,\n"
            + "                \"title\": \"question title here\",\n"
            + "                \"summary\": \"question summary here\",\n"
            + "                \"options\": [\n"
            + "                    {\n"
            + "                        \"id\": 10,\n"
            + "                        \"type\": \"text\",\n"
            + "                        \"label\": \"option label here\"\n"
            + "                    }\n"
            + "                ]\n"
            + "            }\n"
            + "        ],\n"
            + "        \"hidden\": false\n"
            + "    }\n"
            + "]";

    public TestTaskListActivity() {
        super("com.crowdlab.taskimporter.activities", TaskListActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp(); //To change body of generated methods, choose Tools | Templates.

        activity = this.getActivity();

        if (activity != null) {

            //initialize db helper
            dbHelper = new TaskListDatabaseHelper(((TaskListActivity) activity).getDb());

        } else {
            Logger.d("The activity is null, cannot continue with test");
        }

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown(); //To change body of generated methods, choose Tools | Templates.
    }

    @Test
    public void testJsonData() throws Exception {

        if (dbHelper != null) {

            JSONArray arr = new JSONArray(json_text);
            assertNotNull(arr);
            assertEquals(true, dbHelper.clearJsonData());
            assertEquals(true, dbHelper.saveJsonData(arr));

            JSONArray savedJsonArr = dbHelper.getSavedJsonData();
            assertEquals(arr, savedJsonArr);

            assertEquals(true, dbHelper.clearJsonData());
        }
    }

    @Test
    public void testToInsertTasksQuestionAndOption() throws Exception {

        if (activity != null && dbHelper != null) {

            DatabaseHelper db = DatabaseHelper.getHelper(activity);

            assertEquals(true, dbHelper.insertTask(120, "This is test", 1));
            db.getWritableDatabase().execSQL("Delete from tblTask where task_id=120");

            assertEquals(true, dbHelper.insertTask(133, "This is test133", 0));
            db.getWritableDatabase().execSQL("Delete from tblTask where task_id=133");

            assertEquals(true, dbHelper.insertTask(40, "This is test", 1));
            db.getWritableDatabase().execSQL("Delete from tblTask where task_id=40");

            Cursor c = db.rawQuery("Select * from tblTask where task_id=120");
            assertFalse(c.moveToNext());
            c.close();
            c = db.rawQuery("Select * from tblTask where task_id=133");
            assertFalse(c.moveToNext());
            c.close();
            c = db.rawQuery("Select * from tblTask where task_id=40");
            assertFalse(c.moveToNext());
            c.close();

            assertEquals(true, dbHelper.insertQuestion(222, "This is question1", "Test summary1", 111));
            db.getWritableDatabase().execSQL("Delete from tblQuestion where question_id=222");

            assertEquals(true, dbHelper.insertQuestion(12, "This is question2", "Test summary2", 1));
            db.getWritableDatabase().execSQL("Delete from tblQuestion where question_id=12");

            assertEquals(true, dbHelper.insertQuestion(345678, "This is question3", "Test summary3", 111));
            db.getWritableDatabase().execSQL("Delete from tblQuestion where question_id=345678");

            c = db.rawQuery("Select * from tblQuestion where question_id=222");
            assertFalse(c.moveToNext());
            c.close();
            c = db.rawQuery("Select * from tblQuestion where question_id=12");
            assertFalse(c.moveToNext());
            c.close();
            c = db.rawQuery("Select * from tblQuestion where question_id=345678");
            assertFalse(c.moveToNext());
            c.close();

            assertEquals(true, dbHelper.insertOption(1234, "This is option type 1", "This test label", 22));
            db.getWritableDatabase().execSQL("Delete from tblOption where option_id=222");

            assertEquals(true, dbHelper.insertOption(67, "This is option type 2", "This test label2", 22));
            db.getWritableDatabase().execSQL("Delete from tblOption where option_id=67");

            assertEquals(true, dbHelper.insertOption(91, "This is option type 3", "This test label3", 887));
            db.getWritableDatabase().execSQL("Delete from tblOption where option_id=91");

            c = db.rawQuery("Select * from tblOption where option_id=1234");
            assertFalse(c.moveToNext());
            c.close();
            c = db.rawQuery("Select * from tblOption where option_id=67");
            assertFalse(c.moveToNext());
            c.close();
            c = db.rawQuery("Select * from tblOption where option_id=91");
            assertFalse(c.moveToNext());
            c.close();

        }
    }

    @Test
    public void testInsertTextWithInvalidCharacter() throws Exception {

        if (activity != null && dbHelper != null) {

            DatabaseHelper db = DatabaseHelper.getHelper(activity);

            assertEquals(false, dbHelper.insertTask(120, "This is test's", 1));

        }
    }

}
