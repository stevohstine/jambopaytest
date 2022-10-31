package com.jambopay.africa.activities

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jambopay.africa.R
import com.jambopay.africa.adapters.NumberMatchesAdapter
import com.jambopay.africa.models.ComparisonStorageDataModel


class MainActivity : AppCompatActivity() {

    var allMatches: MutableList<ComparisonStorageDataModel> = ArrayList()
    var listAttempts = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputNumberEditText: EditText = findViewById(R.id.input_number_editText)
        val trialsCountTextView: TextView = findViewById(R.id.trials_count_textView)
        val matchesCountTextView: TextView = findViewById(R.id.matches_count_textView)
        val submitButton: Button = findViewById(R.id.submit_button)
        val itemRecyclerView: RecyclerView = findViewById(R.id.itemRecyclerView)

        inputNumberEditText.requestFocus()


        submitButton.setOnClickListener {
            //get user input
            val userInputNumber = inputNumberEditText.text.toString().trim()
            //check if user input is valid
            if(userInputNumber.isEmpty()){
                inputNumberEditText.error = "Number is required"
                inputNumberEditText.requestFocus()
                return@setOnClickListener
            }
            else if(userInputNumber.toInt() > 5 || userInputNumber.toInt() < 0) {
                inputNumberEditText.error = "Number should be between 0 to 5"
                inputNumberEditText.requestFocus()
                return@setOnClickListener
            }

            listAttempts ++
            trialsCountTextView.text = "Total Trials: ${listAttempts.toString()}"
            //get current time
            val timeOnClick = System.currentTimeMillis()

            //generate a random number between 0-9
            val generatedRandomNumber = (0..5).random()

            //compare if the numbers match
            if (userInputNumber.toInt() == generatedRandomNumber){
                //get current time
                val timeAfterComparison = System.currentTimeMillis() - timeOnClick

                //save data to shared pref or room database
                var matchingData = ComparisonStorageDataModel(listAttempts,generatedRandomNumber,userInputNumber.toInt(),timeAfterComparison)

                //add data to the list
                allMatches.add(matchingData)

                //update Ui
                matchesCountTextView.text = "Total Matches: ${allMatches.count().toString()}"

                //toast
                Toast.makeText(this,"Correct!! Numbers Match",Toast.LENGTH_SHORT).show()

                if (allMatches.size > 0) {
                    val adapter = NumberMatchesAdapter(this, allMatches)
                    itemRecyclerView.adapter = adapter
                    itemRecyclerView.layoutManager = LinearLayoutManager(this)
                }
            }
            else{
                //toast
                Toast.makeText(this,"Numbers doesn't match",Toast.LENGTH_SHORT).show()
            }

        }

    }
}