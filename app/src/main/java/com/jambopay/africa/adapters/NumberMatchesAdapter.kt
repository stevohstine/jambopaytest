package com.jambopay.africa.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jambopay.africa.R
import com.jambopay.africa.models.ComparisonStorageDataModel

class NumberMatchesAdapter(val context: Context, val numberMatches: List<ComparisonStorageDataModel>) : RecyclerView.Adapter<NumberMatchesAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var currentMatch: ComparisonStorageDataModel? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {

            }
        }

        private val attemptNumber: TextView = itemView.findViewById(R.id.attemptNumber)
        private val userInputNumber: TextView = itemView.findViewById(R.id.userInputNumber)
        private val generatedNumber: TextView = itemView.findViewById(R.id.generatedNumber)
        private val timeSpan: TextView = itemView.findViewById(R.id.timeSpan)

        fun setUpRecyclerViewData(match: ComparisonStorageDataModel, pos: Int) {
            attemptNumber.text = "Attempt Number: ${match.attemptNumber}"
            userInputNumber.text = "User Input Number: ${match.userInput}"
            generatedNumber.text = "Generated Number: ${match.generatedNumber}"
            timeSpan.text = "Time Span: ${match.timeInMS}"

            this.currentMatch = match
            this.currentPosition = pos
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.number_matches_cardview, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val mNumber = numberMatches[position]
        holder.setUpRecyclerViewData(mNumber, position)
    }

    override fun getItemCount(): Int {
        return numberMatches.size
    }
}