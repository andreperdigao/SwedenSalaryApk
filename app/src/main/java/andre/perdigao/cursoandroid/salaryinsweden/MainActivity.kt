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

    var salary = 0
    var apartment = 0
    var internet = 0
    var electricity = 0
    var food = 0
    var transport = 0
    var insurance = 0
    var net = 0
    var cost = 0
    var rest = 0
    val tax = 0.7618


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

        val txtNetSalaryValue =
            findViewById<TextView>(R.id.txtNetSalaryValue)

        val txtLifeCostValue =
            findViewById<TextView>(R.id.txtLifeCostValue)

        val txtRestValue =
            findViewById<TextView>(R.id.txtRestValue)

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

                txtNetSalaryValue.text = net.toString()
                txtLifeCostValue.text = cost.toString()
                txtRestValue.text = rest.toString()

                closeKeyboard(txtRestValue)


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
            txtNetSalaryValue.text = ""
            txtLifeCostValue.text = ""
            txtRestValue.text = ""
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