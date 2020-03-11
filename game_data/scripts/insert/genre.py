import mysql.connector
import json

class Genre:
    def __init__(self):
        with open('../json/genre.json') as f:
            self.data = json.load(f)

    def insertDB(self, connection):
        cursor = connection.cursor()


        sql_q = """ insert into genre
                    values
                    (%s, %s)"""
        val = []

        for item in self.data['genre']:
            val += [(item['id'],item['gname'])]

        cursor.executemany(sql_q,val)

        connection.commit()

        cursor.close()
