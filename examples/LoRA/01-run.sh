#!/usr/bin/env bash

export DNNL_VERBOSE=1
export ONEDNN_MAX_CPU_ISA=AVX512_CORE_BF16
python3 01-example.py
