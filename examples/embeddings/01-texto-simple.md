# Codigo Ejemplo

Debemos preparar un entorno base (python) para entender un poco los conceptos relacionados con LLM. Para ello se sugiere crear un entorno aislado:

```sh
python3 -m venv /opt/llm
source /opt/llm/bin/activate
```

```py
%pip install -qU langchain-openai
```

## Acceso a servicio (token)

```py
import getpass
import os

os.environ["OPENAI_API_KEY"] = getpass.getpass()
```

## Embeddings

Usemos un modelo específico de OpenAI para realizar nuestro embedding.

```py
from langchain_openai import OpenAIEmbeddings

embeddings = OpenAIEmbeddings(model="text-embedding-3-large")
```

Lo siguiente es generar la representación del texto en tokens (embeddings) que consiste en un vector que representa, de forma numérica el contenido proporcionado.

### Para Query

```py
text = "This is a test document."
query_result = embeddings.embed_query(text)
```

Mostremos los primeros elementos del vector

```py
query_result[:5]
```

### Para documentos

```py
doc_result = embeddings.embed_documents([text])
doc_result[0][:5]
```


