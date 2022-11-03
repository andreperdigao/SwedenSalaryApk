package andre.perdigao.cursoandroid.salaryinsweden

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private var salary = 0
    private var apartment = 0
    private var internet = 0
    private var electricity = 0
    private var food = 0
    private var transport = 0
    private var insurance = 0
    private var net = 0
    private var cost = 0
    private var rest = 0
    private val tax = 0.7618

    private val keyNet = "net"
    private val keyCost = "cost"
    private val keyRest = "rest"

    private var txtNetSalaryValue: TextView? = null
    private var txtLifeCostValue: TextView? = null
    private var txtRestValue: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editSalaryValue =
            findViewById<EditText>(R.id.editSalaryValue)

        val editRentValue =
            findViewById<EditText>(R.id.editRentValue)

        val editElectricityValue =
            findViewById<EditText>(R.id.editElectricityValue)

        val editInternetValue =
            findViewById<EditText>(R.id.editInternetValue)

        val editFoodValue =
            findViewById<EditText>(R.id.editFoodValue)

        val editTransportValue =
            findViewById<EditText>(R.id.editTransportValue)

        val editInsuranceValue =
            findViewById<EditText>(R.id.editInsuranceValue)

        txtNetSalaryValue =
            findViewById(R.id.txtNetSalaryValue)

        txtLifeCostValue =
            findViewById(R.id.txtLifeCostValue)

        txtRestValue =
            findViewById(R.id.txtRestValue)

        val btnCalculate =
            findViewById<Button>(R.id.btnCalculate)

        val btnClear =
            findViewById<Button>(R.id.btnClear)

        btnCalculate.setOnClickListener {

            if (editSalaryValue.text.toString().isEmpty()) {

                editSalaryValue.error = "Please insert salary!"
                editSalaryValue.requestFocus()
            }

            else if (editRentValue.text.toString().isEmpty()) {

                editRentValue.error = "Please insert Rent Cost!"
                editRentValue.requestFocus()
            }

            else if (editElectricityValue.text.toString().isEmpty()) {

                editElectricityValue.error = "Please insert Electricity Cost!"
                editElectricityValue.requestFocus()
            }

            else if (editInternetValue.text.toString().isEmpty()) {

                editInternetValue.error = "Please insert Broadband Cost!"
                editInternetValue.requestFocus()
            }

            else if (editFoodValue.text.toString().isEmpty()) {

                editFoodValue.error = "Please insert Food Cost!"
                editFoodValue.requestFocus()
            }

            else if (editTransportValue.text.toString().isEmpty()) {

                editTransportValue.error = "Please insert Transport Cost!"
                editTransportValue.requestFocus()
            }

            else if (editInsuranceValue.text.toString().isEmpty()) {

                editInsuranceValue.error = "Please insert Insurance Cost!"
                editInsuranceValue.requestFocus()
            }

            else {


                salary = editSalaryValue.text.toString().toInt()
                apartment = editRentValue.text.toString().toInt()
                electricity = editElectricityValue.text.toString().toInt()
                internet = editInternetValue.text.toString().toInt()
                food = editFoodValue.text.toString().toInt()
                transport = editTransportValue.text.toString().toInt()
                insurance = editInsuranceValue.text.toString().toInt()

                net = (salary * tax).toInt()
                cost = apartment + electricity + internet + food + transport + insurance
                rest = net - cost

                txtNetSalaryValue!!.text = net.toString()
                txtLifeCostValue!!.text = cost.toString()
                txtRestValue!!.text = rest.toString()

                closeKeyboard(txtRestValue!!)


                Toast.makeText(
                    this, "Calculating...",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

        btnClear.setOnClickListener {

            net = 0
            cost = 0
            rest = 0
            txtNetSalaryValue!!.text = ""
            txtLifeCostValue!!.text = ""
            txtRestValue!!.text = ""
            editElectricityValue.setText("")
            editRentValue.setText("")
            editFoodValue.setText("")
            editInternetValue.setText("")
            editInsuranceValue.setText("")
            editSalaryValue.setText("")
            editTransportValue.setText("")

            Toast.makeText(this,"Clear Success",
            Toast.LENGTH_SHORT).show()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(keyNet,net)
        outState.putInt(keyCost,cost)
        outState.putInt(keyRest,rest)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        net = savedInstanceState.getInt(keyNet,0)
        txtNetSalaryValue!!.text = net.toString()
        cost = savedInstanceState.getInt(keyCost,0)
        txtLifeCostValue!!.text = cost.toString()
        rest = savedInstanceState.getInt(keyRest,0)
        txtRestValue!!.text = rest.toString()

    }

    private fun closeKeyboard(view: View){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
        }

    }


    /***

    fun calculateEvent(view: View) {

        Toast.makeText(this,"Calculating...",
            Toast.LENGTH_SHORT).show()

    }

    fun clearEvent(view: View) {

        Toast.makeText(this,"Clear Success",
        Toast.LENGTH_SHORT).show()
    }
    ***/