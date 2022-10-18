package andre.perdigao.cursoandroid.salaryinsweden

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var Salary = 0
    var Apartment = 0
    var Internet = 0
    var Electricity = 0
    var Food = 0
    var Transport = 0
    var Insurance = 0
    var Net = 0
    var Cost = 0
    var Rest = 0
    val Tax = 0.75


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

            Salary = editSalaryValue.text.toString().toInt()
            Apartment = editRentValue.text.toString().toInt()
            Electricity = editElectricityValue.text.toString().toInt()
            Internet = editInternetValue.text.toString().toInt()
            Food = editFoodValue.text.toString().toInt()
            Transport = editTransportValue.text.toString().toInt()
            Insurance = editInsuranceValue.text.toString().toInt()

            Net = (Salary * Tax).toInt()
            Cost = Apartment + Electricity + Internet + Food + Transport + Insurance
            Rest = Net - Cost

            txtNetSalaryValue.setText(Net.toString())
            txtLifeCostValue.setText(Cost.toString())
            txtRestValue.setText(Rest.toString())

            closeKeyboard(txtRestValue)


            Toast.makeText(this,"Calculating...",
            Toast.LENGTH_SHORT).show()

        }

        btnClear.setOnClickListener {

            Net = 0
            Cost = 0
            Rest = 0
            txtNetSalaryValue.setText("")
            txtLifeCostValue.setText("")
            txtRestValue.setText("")
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
}