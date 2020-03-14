# CSC436_Game_Database

What you need
================
- Java jdk https://www.oracle.com/technetwork/java/javase/downloads/jdk13-downloads-5672538.html
- Maven https://maven.apache.org/download.cgi
 - download the maven binary and follow installation instructions https://maven.apache.org/install.html


To run the java program
========================
- go into the how to run folder and look at the text file or 

On Windows powershell
=======================
- be sure to be in the CSC436_Game_Database directory and run
 - & howtorun/run.ps1

On Bash
=======================
- be in CSC436_Game_Database directory and run
 - bash run.sh
 
 
# Create initial game database
- go to game_data/sql and execute the query in the sql file

python script to add data to database
========================
- go to game_data/scripts directory
- **pip install mysql-connector-python** to get the necessary library
- go to the config file and change the username and password to your own
- **python3 main.py** to run the scripts
