import mysql.connector
from insert.genre import Genre
from insert.platform import Platform

if __name__ == "__main__":
    connection = mysql.connector.connect(user='root', password='3Zbz6@H71#$IhhNY%',
                                    host='localhost',
                                    database='game_database')
    inGenre = Genre()
    inGenre.insertDB(connection)
    inPlatform = Platform()
    inPlatform.insertDB(connection)

    connection.close()