# OLlama


## Ejecutar Servicio

```sh
docker compose -f docker-compose-ollama.yml up -d
```

## Usar modelo

```sh
docker compose -f docker-compose-ollama.yml exec -it ollama ollama run llama2
```

## Usando Modelo orca-mini

```sh
docker compose -f docker-compose-ollama.yml exec -it ollama ollama run orca-mini
```


```sh
curl http://localhost:11434/api/generate -d '{"model": "orca-mini", "prompt": "Why is the sky blue?"}'
```
