package com.example.retrofit;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.retrofit.dto.memberDto.JoinMemberRequest;
import com.example.retrofit.dto.memberDto.JoinMemberResponse;
import com.example.retrofit.service.MemberRetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textTest = findViewById(R.id.textTest);

        textTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MemberRetrofitService memberJoinService = CreateRetrofit.createRetrofit().create(MemberRetrofitService.class);
                JoinMemberRequest member = new JoinMemberRequest();
                Call<JoinMemberResponse> call = memberJoinService.joinMember(member);

                call.enqueue(new Callback<JoinMemberResponse>() {
                    @Override
                    public void onResponse(Call<JoinMemberResponse> call, Response<JoinMemberResponse> response) {
                        if(response.isSuccessful()){
                            JoinMemberResponse body = response.body();
                            textTest.setText(body.getUserId().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<JoinMemberResponse> call, Throwable t) {

                    }
                });


            }
        });
    }
}