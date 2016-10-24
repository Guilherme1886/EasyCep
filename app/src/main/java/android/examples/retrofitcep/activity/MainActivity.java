package android.examples.retrofitcep.activity;

import android.app.ProgressDialog;
import android.examples.retrofitcep.R;
import android.examples.retrofitcep.model.Cep;
import android.examples.retrofitcep.rest.ApiInterface;
import android.examples.retrofitcep.utils.Mask;
import android.examples.retrofitcep.utils.Utils;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    EditText cep_user;
    Button button_user;
    TextView cep, logradouro, complemento, bairro, localidade, uf;
    ApiInterface apiInterface;
    RestAdapter restAdapter;
    ProgressDialog progressDialog;
    TextWatcher cepMask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        getJson();
        configMask();


    }

    private void configMask() {
        cepMask = Mask.insert("#####-###", cep_user);
        cep_user.addTextChangedListener(cepMask);
    }

    private void getJson() {

        restAdapter = new RestAdapter.Builder().setEndpoint(ApiInterface.URL).build();

        apiInterface = restAdapter.create(ApiInterface.class);

        button_user.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String editTextCep = cep_user.getText().toString();

                if (editTextCep.length() <= 0) {

                    Utils.showSnack(MainActivity.this, "Preencha o CEP");

                } else {

                    getProgress();

                    apiInterface.getCep(editTextCep, new Callback<Cep>() {

                        @Override
                        public void success(Cep cepResponse, Response response) {

                            cep.setText(cepResponse.getCep());
                            logradouro.setText(cepResponse.getLogradouro());
                            complemento.setText(cepResponse.getComplemento());
                            bairro.setText(cepResponse.getBairro());
                            localidade.setText(cepResponse.getLocalidade());
                            uf.setText(cepResponse.getUf());

                            progressDialog.cancel();

                        }

                        @Override
                        public void failure(RetrofitError error) {

                            progressDialog.cancel();

                            if (error.getKind().equals(RetrofitError.Kind.NETWORK)) {
                                Utils.showSnack(MainActivity.this, "Não há conexão com a internet");
                            }


                        }
                    });
                }

                clearField();

            }


        });


    }

    private void clearField() {
        cep_user.setText("");
    }

    private ProgressDialog getProgress() {

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Consulta CEP");
        progressDialog.setMessage("Carregando Dados...");
        progressDialog.show();


        return progressDialog;
    }

    private void initViews() {
        cep = (TextView) findViewById(R.id.cep);
        logradouro = (TextView) findViewById(R.id.logradouro);
        complemento = (TextView) findViewById(R.id.complemento);
        bairro = (TextView) findViewById(R.id.bairro);
        localidade = (TextView) findViewById(R.id.localidade);
        uf = (TextView) findViewById(R.id.uf);
        cep_user = (EditText) findViewById(R.id.cep_user);
        button_user = (Button) findViewById(R.id.button_user);

    }


}
