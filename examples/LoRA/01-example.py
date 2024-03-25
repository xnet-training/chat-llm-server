from datasets import load_dataset
from random import randrange
import torch
from transformers import AutoTokenizer #, AutoModelForSeq2SeqLM, TrainingArguments, pipeline
#from peft import LoraConfig, prepare_model_for_kbit_training, get_peft_model, AutoPeftModelForCausaLM
#from trl import SFTTrainer
from huggingface_hub import login, notebook_login

print('Iniciando')
