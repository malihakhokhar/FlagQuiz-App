# Flag Quiz App

The **Flag Quiz App** is a fun and educational Android application that allows users to test their knowledge of world flags. Users are presented with flags and must select the correct country from multiple choices. The app uses an SQLite database to store country and flag data locally.

## 📱 Features

- 🌍 Quiz mode: Guess the country based on its flag.
- 📊 Score tracking: See how well you're doing.
- 🧠 Educational: Learn the names and flags of countries.
- 📦 Offline support with SQLite database.
- 🎨 Clean and user-friendly UI.

## 🛠️ Tech Stack

- **Language:** Kotlin  
- **Database:** SQLite (via SQLiteOpenHelper)  
- **UI:** XML layouts and Material Components  
- **Architecture:** MVVM (optional), or simple Activity/Fragment-based

## 🗃️ SQLite Database

The app uses a pre-populated SQLite database (`flags.db`) stored in the `assets` folder. The database contains:

- `flags` table with:
  - `id` (INTEGER PRIMARY KEY)
  - `country_name` (TEXT)
  - `flag_resource_name` (TEXT)

Example data:
| ID | Country Name | Flag Resource Name |
|----|--------------|--------------------|
| 1  | Canada       | flag_canada        |
| 2  | Japan        | flag_japan         |

## 📂 Project Structure
