package com.example.flagquizapp.database

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.flagquizapp.model.FlagsModel
import com.techmania.flagquizwithsqlitedemo.DatabaseCopyHelper

class FlagsDao {

    // This function returns 10 random flag records from the database
    fun getRandomTenRecords(helper : DatabaseCopyHelper) : ArrayList<FlagsModel> {

        val recordList = ArrayList<FlagsModel>() // List to store the results
        val database : SQLiteDatabase = helper.writableDatabase // Access the database
        // Run SQL query to get 10 random rows from the 'flags' table
        val cursor : Cursor = database.rawQuery("SELECT * FROM flags ORDER BY RANDOM() LIMIT 10", null)

        // Get indexes of each column to read data from cursor
        val idIndex = cursor.getColumnIndex("flag_id")
        val countryNameIndex = cursor.getColumnIndex("country_name")
        val flagNameIndex = cursor.getColumnIndex("flag_name")

        // Loop through each row in the result
        while (cursor.moveToNext()) {

            // Create a FlagsModel object using the data from the current row
            val record = FlagsModel(
                cursor.getInt(idIndex),
                cursor.getString(countryNameIndex),
                cursor.getString(flagNameIndex)
            )

            // Add the object to the list
            recordList.add(record)

        }
        cursor.close() // Close the cursor to avoid memory leaks
        return recordList // Return the list of 10 random flag records
    }

    // This function returns 3 random flag records EXCLUDING the one with the given ID
    fun getRandomThreeRecords(helper: DatabaseCopyHelper, correctFlag: FlagsModel, id: Int) : ArrayList<FlagsModel> {

        val recordList = ArrayList<FlagsModel>() // List to store the results
        val database : SQLiteDatabase = helper.writableDatabase // Access the database
        // Run SQL query to get 3 random rows from the 'flags' table where ID is NOT equal to the given ID
        val cursor : Cursor = database.rawQuery(
            "SELECT * FROM flags WHERE flag_id != ? ORDER BY RANDOM() LIMIT 3",
            arrayOf(id.toString()) // ID to exclude
        )

        // Get indexes of each column
        val idIndex = cursor.getColumnIndex("flag_id")
        val countryNameIndex = cursor.getColumnIndex("country_name")
        val flagNameIndex = cursor.getColumnIndex("flag_name")

        // Loop through each result
        while (cursor.moveToNext()) {
            // Create a FlagsModel object
            val record = FlagsModel(
                cursor.getInt(idIndex),
                cursor.getString(countryNameIndex),
                cursor.getString(flagNameIndex)
            )
            // Add it to the list
            recordList.add(record)
        }

        cursor.close() // Close the cursor
        return recordList // Return the list of 3 random records (excluding one)
    }
}