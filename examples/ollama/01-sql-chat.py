#import snowflake.connector
import psycopg2
import json
import requests
import re

MODEL = 'orca-mini' #'mistral'

def get_connection(USER,PASSWORD,ACCOUNT,WAREHOUSE,DATABASE,SCHEMA):  
    #conn = psycopg2.connect(
    #  host = 127.0.0.1
    #  port = 5432
    #  user=USER,
    #  password=PASSWORD,
    #  )
    #return conn
    return None

def get_sql_response(model, modified_prompt, context):
    conn       = get_connection(USER="XX",PASSWORD="XX",ACCOUNT="XX",WAREHOUSE="XX",DATABASE="XX",SCHEMA="XX")
    #cursor     = conn.cursor()
    model_resp = generate(model, modified_prompt, context)
    match_data = re.match("(.*)'''sql:(.*)'''",model_resp)
    sql_query  = match_data.group(2).trim()
    print(f"SQL: {sql_query}")
    #try:
      # Execute a SQL query against Snowflake to get the current_version
    #  cursor.execute(sql_query)
    #  one_row = cursor.fetchone()
    #
    #  # Display the version information
    #  print(one_row[0])
    #finally:
    #  cursor.close()
    #  connection.close()
    print(f"Prompt: {modified_prompt} {context}")
    return [{'hours': 50.0}]

def generate(model, prompt, context):
    print(f"Model: {model}, Prompt: {prompt}, Cotext: {context}")
    r = requests.get('http://localhost:11434/api/generate',
                      json={
                          'model': model,
                          'prompt': prompt,
                          'context': context,
                      },
                      stream=False)
    print(r)
    body = r.json()
    print(body)
    # get response from the model
    response_part = r.get('response', '')
    print(response_part)
    if 'error' in r:
        raise Exception(body['error'])
    if r.get('done', False):
        return r.get['context']

def main():
    context = []
    while True:
        user_input = input("Enter a prompt: ")
        pre_prompt='''You are a BI Analyst, please write an SQL Query for user question as per the schema provided
        Schema:
          CREATE TABLE fct_horastrabajadas(
            producto varchar(20),
            proyecto varchar(60),
            subproyecto varchar(60),
            colaborador varchar(20),
            horas decimal(10,2),
            fecha_reporte date,
            issue_id int,
            issue_title varchar(200)
          )
        Question:  '''
        if not user_input:
            exit()
        print(user_input)
        modified_prompt = f"{pre_prompt} {user_input}"
        context = get_sql_response(MODEL, modified_prompt.rstrip(), context)
        print(context)

if __name__ == "__main__":
    main()
