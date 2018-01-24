# UKN3a data set

## Source

This data comes from EU-ToxRisk project.

TODO: describe the origin of this dataset in more detail.

TODO: briefly describe the contents of this dataset

## Content

The original data is provided as an Excel spreadsheet that has been uploaded into
[Google Docs](https://drive.google.com/open?id=1wtS3ElEuOoqZ3Su8SgAv8fgnkpZJ_eTz).

It's also present as a [Google Sheet](https://docs.google.com/spreadsheets/d/1f5J4JUNRINohz9kJXy7g9UT2wxJA0fCWg_40PJkWE8E/edit#gid=1121551817) that also contains additional information on other workbooks.

Thomas Exner did some initial annotation of the data that can found in this [Google Sheet](https://docs.google.com/spreadsheets/d/1vDQIor_OaLcXYcBi5dpG8jsbZPM42ZvmUufgRiiMl_I/edit#gid=1362255788).

The data from the Excel sheet was exported to a tab separated text format file [ukn3a.tsv](ukn3a.tsv).
This tsv file provides the input for the work described here.

## Processing

The fist step was to convert the data to JSON so that it can be semantically annotated.
This is done with the [parser.groovy](parser.groovy) script that is described [here](../README.md).

**NOTE:** Run all commands from the data_examples directory.

The [flat-config.groovy](flat-config.groovy) configuration just specifies the data types on the fields that are not text types and generates a flat datastructure in JSON that is the equivalent of the original TSV file. It is now more parsable but does not contain any useful organisational  structure. It can be used like this:
```
groovy parser.groovy -c eadb/flat-config.groovy -m parse eadb/eadb.tsv > eadb/eadb-flat.json
```
A sample record looks like this:

```
   {
      "Sample ID": "41_1",
      "Method name": "UKN3a_NeuroTox_LUH_neurite_72h_d5",
      "Toxicity domain": "Neuro",
      "Information domain": "Cytotoxicity",
      "Date": "20161202",
      "Experiment ID": "20161202_EUTox_UKN3a72h_PlateI",
      "Organization abbreviation": "UKN",
      "Organisation full name": "University of Konstanz",
      "Name of PI": "Marcel Leist",
      "Person entering data": "Alice Krebs",
      "E-mail": "marcel.leist@uni-konstanz.de",
      "Compound": "Acrylamide",
      "Compound name of actual form used": "2-Propenamide; Acrylic acid amide",
      "CAS Number": "79-06-1",
      "SMILES": "NC(=O)C=C",
      "Supplier": "Sigma",
      "Order  number": "A3553",
      "Lot number": "n.a.",
      "Compound  form": "powder",
      "Storage temperature  of unsolved compound": "RT",
      "Stock solvent": "water",
      "Stock concentration": 4,
      "Stock concentration unit": "M",
      "Stock aliquot storage": "aliquots stored at -80°C",
      "Sample type": "test",
      "Organism": "human",
      "Organ": "brain",
      "Dimension": "2D",
      "Heterogeneity": "monoculture",
      "Dynamics": "differentiation",
      "Differentiation status": "9day differentiation",
      "Complexity": "cell",
      "Cell type": "cell line",
      "Cell name": "LUHMES",
      "Cell donor or lot": "SGJD working stock 2016",
      "Cell batch": "NA",
      "Cell passage": "< 16",
      "Sex": "female",
      "Contact inhibition": "yes",
      "Seeding density": "138000 cells/cm2",
      "Population doubling time": "18 h ",
      "Treatment modality": "single dose",
      "Dosage": "medium",
      "Dose maintenance": "single addition",
      "Exposure time": 72,
      "Exposure time unit": "h",
      "Treatment scheme": "NA",
      "Concentration": 3,
      "Concentration Unit": "-log(M)",
      "Plate format": "96-well",
      "Plate manufacturer": "Sarsted",
      "Cell pre-treatment": "NA",
      "Coating": "PLO, fibronectin",
      "Coating lot": "NA",
      "Medium": "Advanced DMEM/F-12",
      "Medium provider": "Thermo Fisher Scientific",
      "Medium lot": "NA",
      "% Serum": "NA",
      "Serum provider": "NA",
      "Serum lot": "NA",
      "Medium additive 1": "cAMP",
      "Additive 1 provider": "Sigma-Aldrich",
      "Additive 1 concentration": 100,
      "Additive 1 concentration unit": "mM",
      "Medium additive 2": "GDNF",
      "Additive 2 provider": "R&D Systems",
      "Additive 2 concentration": 20,
      "Additive 2 concentration unit": "µg/ml",
      "Medium additive 3": "tetracyclin",
      "Additive 3 provider": "Sigma-Aldrich",
      "Additive 3 concentration": 1,
      "Additive 3 concentration unit": "mg/ml",
      "Medium additive 4": "N2",
      "Additive 4 provider": "Invitrogen",
      "Additive 4 concentration": 100,
      "Additive 4 concentration unit": "x",
      "Medium additive 5": "glutamine",
      "Additive 5 provider": "Sigma-Aldrich",
      "Additive 5 concentration": 200,
      "Additive 5 concentration unit": "mM",
      "% DMSO": 0.1,
      "DMSO provider": "Sigma-Aldrich",
      "Platewise or stack": "Stack",
      "Group ID": "41",
      "Biological replicate": 1,
      "Technical replicates": 3,
      "Number of Endpoints": 2,
      "Endpoint 2/1 measure": "Hoechst staining/Co-staining Hoechst and Calcein",
      "Endpoint 2/1 definition": "viability",
      "Endpoint 2/1 type": "viability",
      "Endpoint 2/1 readout method": "image-based",
      "Endpoint 2/1 normalized": 0,
      "Endpoint 3 measure": "neurite area",
      "Endpoint 3 definition": "neurite area",
      "Endpoint 3 type": "functional readout",
      "Endpoint 3 readout method": "image-based",
      "Endpoint 3 normalized": 0.186508
    }
```
The full file is here: [ukn3a-flat.json](eadb-flat.json).

Further work is needed on how to further process this dataset.