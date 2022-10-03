/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.const.Layout.GRID
import com.example.dogglers.const.Layout.HORIZONTAL
import com.example.dogglers.const.Layout.VERTICAL
import com.example.dogglers.data.DataSource
import com.example.dogglers.model.Dog

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    // TODO: Initialize the data using the List found in data/DataSource
    val data: List<Dog> = DataSource.dogs
    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        // TODO: Declare and initialize all of the list item UI components
        val imageView: ImageView = view!!.findViewById(R.id.dog_image)
        val nameTextView: TextView = view!!.findViewById(R.id.dog_name)
        val ageTextView: TextView = view!!.findViewById(R.id.dog_age)
        val hobbiesTextView: TextView = view!!.findViewById(R.id.dog_hobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        // TODO: Use a conditional to determine the layout type and set it accordingly.
        //  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
        //  the vertical/horizontal list item should be used.
        var list_item: Int = 0

        when (layout) {
            Layout.VERTICAL, Layout.HORIZONTAL -> list_item = R.layout.vertical_horizontal_list_item
            Layout.GRID -> list_item = R.layout.grid_list_item
            else -> print("stop")
        }

        // TODO Inflate the layout
        val adapterLayout = LayoutInflater.from(parent.context).inflate(list_item, parent, false)

        // TODO: Null should not be passed into the view holder. This should be updated to reflect
        //  the inflated layout.
        return DogCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return data.size
    } // TODO: return the size of the data set instead of 0

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        // TODO: Get the data at the current position
        // TODO: Set the image resource for the current dog
        // TODO: Set the text for the current dog's name
        // TODO: Set the text for the current dog's age
        val item = data[position]
        val resources = context?.resources
        holder.imageView.setImageResource(item.imageResourceId)
        holder.nameTextView.text = resources?.getString(R.string.dog_name, item.name)
        holder.ageTextView.text = resources?.getString(R.string.dog_age,item.age)
        holder.hobbiesTextView.text = resources?.getString(R.string.dog_hobbies, item.hobbies)

        // TODO: Set the text for the current dog's hobbies by passing the hobbies to the
        //  R.string.dog_hobbies string constant.
        //  Passing an argument to the string resource looks like:
        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)
    }
}
