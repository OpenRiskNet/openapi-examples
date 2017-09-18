# CPSign REST Service

## Overview 

CPSign is a modeling software delivering Conformal Prediction with Signatures Descriptors for cheminformatics. 

## Workflow

1. Upload a dataset in SDF format or a tab-delimited file with SMILES in the first column. This is done at the `/datasets` endpoint.
2. Upload a STANDARD or PRO license to the `/licenses` endpoint.
3. Train a model using any of the availiable algorithms in endponts:
    - `/acp/classification`
    - `/acp/regression`
    - `/tcp/classification`  
    Once started training a new model, the service will return a **task** that can be polled for completion of the training.
4. Poll the training for completion at the `/tasks/{id}` endpoint, once finished the service will give the uri of the built model.
5. Predict a new compound by sending a POST message to the uri given, which is a call to the `/models/{id}` endpoint.


## License

CPSign is a licensed product by Genetta Soft AB and requires having a license for training models and predicting new compounds. Licenses can be acquired by contacting Genetta Soft on email info@genettasoft.com.

