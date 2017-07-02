package android.examples.retrofitcep.activity

import android.Manifest
import android.app.ProgressDialog
import android.examples.retrofitcep.R
import android.examples.retrofitcep.rest.DataCEP
import android.examples.retrofitcep.utils.Mask
import android.examples.retrofitcep.utils.Utils
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextWatcher
import android.util.Log
import android.view.View
import io.vrinda.kotlinpermissions.PermissionCallBack
import io.vrinda.kotlinpermissions.PermissionsActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : PermissionsActivity() {

    private lateinit var progressDialog: ProgressDialog
    private var cepMask: TextWatcher? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configToolbar()
        configMask()
    }

    override fun onResume() {
        super.onResume()

        requestPermission()
    }

    private fun requestPermission() {

        val listPermissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)

        requestPermissions(listPermissions, object : PermissionCallBack {
            override fun permissionGranted() {
               // super.permissionGranted()
                Log.v("Call permissions", "Granted")
            }

            override fun permissionDenied() {
              //  super.permissionDenied()

                Log.v("Call permissions", "Denied")
            }
        })
    }

    private fun configToolbar() {
        setSupportActionBar(my_toolbar)
        supportActionBar?.title = "EasyCep"


    }

    fun buttonPesquisarCep(view: View) {

        getJson()
    }

    private fun configMask() {
        cepMask = Mask.insert("#####-###", cep_user)
        cep_user.addTextChangedListener(cepMask)
    }

    private fun getJson() {

        val callcep = Utils.apiService?.getCep(cep_user.text.toString())

        if (cep_user.text.isEmpty()) {

            Utils.showSnack(cep_user, "Preencha o CEP")

        } else {

            progressDialog()

            object : Thread() {
                override fun run() {
                    callcep?.enqueue(object : Callback<DataCEP> {
                        override fun onResponse(call: Call<DataCEP>?, response: Response<DataCEP>?) {

                            val r = response?.body()

                            if (response?.isSuccessful as Boolean) {

                                progressDialog.dismiss()

                                cep.text = r?.cep
                                logradouro.text = r?.logradouro
                                complemento.text = r?.complemento
                                bairro.text = r?.bairro
                                localidade.text = r?.localidade
                                uf.text = r?.uf


                                Utils.hideKeyboard(this@MainActivity)
                                clearField()


                            } else {

                                progressDialog.dismiss()

                                Utils.hideKeyboard(this@MainActivity)
                                Utils.showSnack(cep_user, "CEP não encontrado")
                                clearTextView()

                            }


                        }

                        override fun onFailure(call: Call<DataCEP>?, t: Throwable?) {

                        }

                    })
                }
            }.start()

        }


    }

    private fun clearTextView() {
        cep.text = ""
        logradouro.text = ""
        complemento.text = ""
        bairro.text = ""
        localidade.text = ""
        uf.text = ""
    }

    private fun clearField() {
        cep_user.setText("")
    }

    private fun progressDialog(): ProgressDialog {

        progressDialog = ProgressDialog(this@MainActivity)
        progressDialog.setTitle("Consulta CEP")
        progressDialog.setCancelable(false)
        progressDialog.setMessage("Carregando Dados...")
        progressDialog.show()


        return progressDialog

    }

    fun buttonVerNoMapa(view: View) = startActivity<MapaActivity>()


}
