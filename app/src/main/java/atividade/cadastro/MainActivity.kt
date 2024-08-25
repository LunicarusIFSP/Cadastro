package atividade.cadastro

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputNome:     EditText
    private lateinit var inputTelefone: EditText
    private lateinit var inputEmail:    EditText
    private lateinit var chkIngressarEmail: CheckBox
    private lateinit var rgSexo:            RadioGroup
    private lateinit var inputCidade:       EditText
    private lateinit var estado:            Spinner
    private lateinit var btnSalvar:         Button
    private lateinit var btnLimpar:         Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputNome = findViewById(R.id.inputNome)
        inputTelefone = findViewById(R.id.telefone)
        inputEmail = findViewById(R.id.email)
        chkIngressarEmail = findViewById(R.id.chkIngressarEmail)
        rgSexo = findViewById(R.id.rgSexo)
        inputCidade = findViewById(R.id.cidade)
        estado = findViewById(R.id.spinner)
        btnSalvar = findViewById(R.id.btnSalvar)
        btnLimpar = findViewById(R.id.btnLimpar)

        ArrayAdapter.createFromResource(
            this,
            R.array.listaUF,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            estado.adapter = adapter
        }
        btnSalvar.setOnClickListener {
            val nome = inputNome.text.toString()
            val telefone = inputTelefone.text.toString()
            val email = inputEmail.text.toString()
            val ingressarNoEmail = chkIngressarEmail.isChecked
            val sexoId = rgSexo.checkedRadioButtonId
            val sexo = findViewById<RadioButton>(sexoId)?.text.toString()
            val cidade = inputCidade.text.toString()
            val estado = estado.selectedItem.toString()

            val formulario = Formulario(nome,
                telefone, email,
                ingressarNoEmail,
                sexo,
                cidade,
                estado)
            Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show()
        }
        btnLimpar.setOnClickListener {
            inputNome.text.clear()
            inputTelefone.text.clear()
            inputEmail.text.clear()
            chkIngressarEmail.isChecked = false
            rgSexo.clearCheck()
            inputCidade.text.clear()
            estado.setSelection(0)
        }
    }
}