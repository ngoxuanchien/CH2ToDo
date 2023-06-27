package com.example.chtodoandroidapp;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.chtodoandroidapp.model.StringHelper;
import com.example.chtodoandroidapp.model.Task;
import com.example.chtodoandroidapp.model.TaskAdapter;
import com.example.chtodoandroidapp.model.TokenManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TasksActivity extends AppCompatActivity {

    Button _addNewTaskBtn;

    TokenManager _tokenManager;

    RecyclerView _recyclerView;

    private final String url = StringHelper.url + "/api/v1/task/all";
    ArrayList<Task> _tasks;

    private ArrayList<Task> ParseJsonResponse(String response) {
        ArrayList<Task> result = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(response);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                result.add(Task.builder()
                        .id(jsonObject.getInt("id"))
                        .title(jsonObject.getString("title"))
                        .description(jsonObject.getString("description"))
                        .createDate(Date.valueOf(jsonObject.getString("createDate")))
                        .build());
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private void RequestTasks() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + _tokenManager.getToken());

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                response -> {
                    _tasks = ParseJsonResponse(String.valueOf(response));
                    TaskAdapter taskAdapter = TaskAdapter.builder().tasks(_tasks).build();
                    _recyclerView.setAdapter(taskAdapter);
                },
                error -> {
                    System.out.println(error.getMessage());
                    Toast.makeText(TasksActivity.this, "Has an error. Please try again", Toast.LENGTH_LONG).show();
                }
        ) {
            @Override
            public Map<String, String> getHeaders() {
                return headers;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(TasksActivity.this);
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        _tokenManager = new TokenManager(TasksActivity.this);

        _addNewTaskBtn = findViewById(R.id.add_new_task);
        _recyclerView = findViewById(R.id.recyclerview);
        _recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TaskAdapter taskAdapter = TaskAdapter.builder().tasks(new ArrayList<>()).build();
        _recyclerView.setAdapter(taskAdapter);
        RequestTasks();


        _addNewTaskBtn.setOnClickListener(view -> {
            Intent intent = new Intent(TasksActivity.this, AddTaskActivity.class);
            startActivity(intent);
            finish();
        });


    }

    public void goOut(View view) {
        Intent intent = new Intent(TasksActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void goToProfile(View view) {
        Intent intent = new Intent(TasksActivity.this, ProfileActivity.class);
        startActivity(intent);
        finish();
    }
}